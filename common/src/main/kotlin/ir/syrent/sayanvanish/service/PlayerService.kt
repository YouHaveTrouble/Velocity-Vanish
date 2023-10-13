package ir.syrent.sayanvanish.service

import ir.syrent.sayanvanish.VPlayer
import net.kyori.adventure.text.Component

interface PlayerService {

    fun sendMessage(player: VPlayer, component: Component)

}