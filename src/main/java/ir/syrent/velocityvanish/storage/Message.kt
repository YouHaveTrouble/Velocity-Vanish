package ir.syrent.velocityvanish.storage

enum class Message(val path: String) {
    RAW_PREFIX("general.raw_prefix"),
    PREFIX("general.prefix"),
    CONSOLE_PREFIX("general.console_prefix"),
    SUCCESSFUL_PREFIX("general.successful_prefix"),
    WARN_PREFIX("general.warn_prefix"),
    ERROR_PREFIX("general.error_prefix"),
    ONLY_PLAYERS("general.only_players"),
    VALID_PARAMS("general.valid_parameters"),
    UNKNOWN_MESSAGE("general.unknown_message"),
    NO_PERMISSION("command.no_permission"),
    VANISH_USAGE("command.vanish.usage"),
    VANISH_USE("command.vanish.use"),
    VANISH_ACTIONBAR("vanish.actionbar"),
    EMPTY("");
}