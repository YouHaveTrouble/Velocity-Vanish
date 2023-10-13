package ir.syrent.sayanvanish

import java.util.*

interface PlayerFactory {
    fun createVPlayer(uuid: UUID, name: String): VPlayer
}

class PaperPlayerFactory : PlayerFactory {
    override fun createVPlayer(uuid: UUID, name: String): VPlayer {
        return VPlayer(uuid, name)
    }
}

class FabricPlayerFactory : PlayerFactory {
    override fun createVPlayer(uuid: UUID, name: String): VPlayer {
        return VPlayer(uuid, name)
    }
}

class VelocityPlayerFactory : PlayerFactory {
    override fun createVPlayer(uuid: UUID, name: String): VPlayer {
        return VPlayer(uuid, name)
    }
}

//class PluginModule {
//    val playerFactory: PlayerFactory = SpigotPlayerFactory() // or FabricPlayerFactory(), BungeeCordPlayerFactory()
//    val playerService: PlayerService = PlayerServiceImpl(playerFactory)
//}