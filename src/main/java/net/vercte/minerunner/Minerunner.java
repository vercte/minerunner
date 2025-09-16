package net.vercte.minerunner;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(Minerunner.ID)
public class Minerunner {
    public static final String ID = "minerunner";

    // deprecated to prevent any uses slipping through in the end
    @Deprecated
    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogUtils.getLogger();

    public Minerunner(IEventBus modEventBus, ModContainer modContainer) {

    }
}
