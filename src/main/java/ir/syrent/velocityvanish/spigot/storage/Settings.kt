package ir.syrent.velocityvanish.spigot.storage

import com.cryptomorin.xseries.XSound
import ir.syrent.velocityvanish.spigot.configuration.YamlConfig
import ir.syrent.velocityvanish.spigot.ruom.Ruom
import ir.syrent.velocityvanish.utils.TextReplacement
import org.bukkit.Sound
import org.bukkit.configuration.file.FileConfiguration
import java.io.File
import java.nio.file.Files
import java.time.LocalDate

object Settings {

    const val latestSettingsConfigVersion = 2

    lateinit var settings: YamlConfig
    lateinit var language: YamlConfig
    private lateinit var settingsConfig: FileConfiguration
    private lateinit var languageConfig: FileConfiguration

    private val messages = mutableMapOf<Message, String>()

    var settingsConfigVersion = 1

    lateinit var defaultLanguage: String
    var velocitySupport = false
    var showDependencySuggestions = true
    var bstats = true

    lateinit var commandSound: Sound
    lateinit var vanishSound: Sound
    lateinit var unVanishSound: Sound

    var actionbar = true
    var remember = false
    var seeAsSpectator = true

    init {
        load()
    }

    fun load() {
        settings = YamlConfig(Ruom.getPlugin().dataFolder, "settings.yml")
        settingsConfig = settings.config

        settingsConfigVersion = settingsConfig.getInt("config_version", 1)

        if (settingsConfigVersion < latestSettingsConfigVersion) {
            val settingsFile = File(Ruom.getPlugin().dataFolder, "settings.yml")
            val backupFile = File(Ruom.getPlugin().dataFolder, "settings.yml-bak-${LocalDate.now()}")
            if (backupFile.exists()) backupFile.delete()
            Files.copy(settingsFile.toPath(), backupFile.toPath())
            settingsFile.delete()
            settings = YamlConfig(Ruom.getPlugin().dataFolder, "settings.yml")
            settingsConfig = settings.config
        }

        defaultLanguage = settingsConfig.getString("default_language") ?: "en_US"
        velocitySupport = settingsConfig.getBoolean("velocity_support")
        showDependencySuggestions = settingsConfig.getBoolean("show_dependency_suggestions")
        bstats = settingsConfig.getBoolean("bstats")

        commandSound = XSound.valueOf(settingsConfig.getString("sounds.command") ?: "ENTITY_EXPERIENCE_ORB_PICKUP").parseSound()!!
        vanishSound = XSound.valueOf(settingsConfig.getString("sounds.vanish") ?: "ENTITY_EXPERIENCE_ORB_PICKUP").parseSound()!!
        unVanishSound = XSound.valueOf(settingsConfig.getString("sounds.unvanish") ?: "ENTITY_EXPERIENCE_ORB_PICKUP").parseSound()!!

        actionbar = settingsConfig.getBoolean("vanish.actionbar")
        remember = settingsConfig.getBoolean("vanish.remember")
        seeAsSpectator = settingsConfig.getBoolean("vanish.see_as_spectator")

        language = YamlConfig(Ruom.getPlugin().dataFolder, "languages/$defaultLanguage.yml")
        languageConfig = language.config

        messages.apply {
            this.clear()
            for (message in Message.values()) {
                if (message == Message.EMPTY) {
                    this[message] = ""
                    continue
                }

                this[message] = languageConfig.getString(message.path) ?: languageConfig.getString(Message.UNKNOWN_MESSAGE.path) ?: "Cannot find message: ${message.name}"
            }
        }

        settings.saveConfig()
        settings.reloadConfig()
        language.saveConfig()
        language.reloadConfig()
    }


    fun formatMessage(message: String, vararg replacements: TextReplacement): String {
        var formattedMessage = message
            .replace("\$prefix", getMessage(Message.PREFIX))
            .replace("\$successful_prefix", getMessage(Message.SUCCESSFUL_PREFIX))
            .replace("\$warn_prefix", getMessage(Message.WARN_PREFIX))
            .replace("\$error_prefix", getMessage(Message.ERROR_PREFIX))
        for (replacement in replacements) {
            formattedMessage = formattedMessage.replace("\$${replacement.from}", replacement.to)
        }
        return formattedMessage
    }

    fun formatMessage(message: Message, vararg replacements: TextReplacement): String {
        return formatMessage(getMessage(message), *replacements)
    }

    fun formatMessage(messages: List<String>, vararg replacements: TextReplacement): List<String> {
        val messageList = mutableListOf<String>()
        for (message in messages) {
            messageList.add(formatMessage(message, *replacements))
        }

        return messageList
    }

    private fun getMessage(message: Message): String {
        return messages[message] ?: messages[Message.UNKNOWN_MESSAGE]?.replace(
            "\$error_prefix",
            messages[Message.ERROR_PREFIX] ?: ""
        ) ?: "Unknown message ($message)"
    }

    fun getConsolePrefix(): String {
        return getMessage(Message.CONSOLE_PREFIX)
    }
}