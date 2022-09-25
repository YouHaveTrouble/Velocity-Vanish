package ir.syrent.velocityvanish.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import ir.syrent.velocityvanish.BuildConstants;
import me.mohamad82.ruom.VRUoMPlugin;
import org.slf4j.Logger;

@Plugin(
        id = "velocityvanish",
        name = "VelocityVanish",
        version = BuildConstants.VERSION,
        description = "Advanced vanish system",
        url = "syrent.ir",
        authors = {"Syrent"}
)
public class VelocityVanish extends VRUoMPlugin {

    @Inject
    public VelocityVanish(ProxyServer server, Logger logger) {
        super(server, logger);
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {

    }
}
