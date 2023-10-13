package ir.sayandevelopment.sayanvanish.mixin

import net.minecraft.server.MinecraftServer
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Mixin(MinecraftServer::class)
class SayanVanishMixin {
    @Inject(at = [At("HEAD")], method = ["loadWorld"])
    private fun init(info: CallbackInfo) {

    }
}