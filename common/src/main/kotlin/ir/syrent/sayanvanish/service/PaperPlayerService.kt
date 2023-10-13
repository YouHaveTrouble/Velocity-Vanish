package ir.syrent.sayanvanish.service

import ir.syrent.sayanvanish.VPlayer
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.Bukkit

class PaperPlayerService : PlayerService {

    override fun sendMessage(player: VPlayer, component: Component) {
        Bukkit.getPlayer(player.uniqueId)?.sendMessage(component)
    }

}