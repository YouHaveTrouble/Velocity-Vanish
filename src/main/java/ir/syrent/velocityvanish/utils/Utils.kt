package ir.syrent.velocityvanish.utils

import ir.syrent.velocityvanish.core.VanishManager
import ir.syrent.velocityvanish.ruom.Ruom
import org.bukkit.entity.Player

object Utils {
    fun sendVanishActionbar(player: Player) {
        if (VanishManager.getVanishPlayer(player.uniqueId).isVanish && player.hasPermission("velocityvanish.admin.actiobar")) {
            Ruom.runSync({
            }, 0, 20)
        }
    }
}