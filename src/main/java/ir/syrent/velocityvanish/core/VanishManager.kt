package ir.syrent.velocityvanish.core

import java.util.UUID

object VanishManager {

    val vanishPlayers = mutableMapOf<UUID, VPlayer>()

    fun getVanishPlayer(uuid: UUID): VPlayer {
        return vanishPlayers[uuid]!!
    }
}