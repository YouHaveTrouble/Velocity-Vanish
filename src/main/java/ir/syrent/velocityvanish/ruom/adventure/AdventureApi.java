package ir.syrent.velocityvanish.ruom.adventure;

import ir.syrent.velocityvanish.ruom.Ruom;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;

public class AdventureApi {

    private static BukkitAudiences adventure;

    public static BukkitAudiences get() {
        return adventure;
    }

    public static void initialize() {
        if (adventure == null)
            adventure = BukkitAudiences.create(Ruom.getPlugin());
    }

}
