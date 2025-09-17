package net.vercte.minerunner;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.vercte.minerunner.registry.MinerunnerDataComponents;
import org.slf4j.Logger;

@Mod(Minerunner.ID)
public class Minerunner {
    public static final String ID = "minerunner";

    // deprecated to prevent any uses slipping through in the end
    @Deprecated
    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogUtils.getLogger();

    public Minerunner(IEventBus modEventBus, ModContainer modContainer) {
        MinerunnerDataComponents.register(modEventBus);

        modEventBus.addListener(MinerunnerDataComponents::modifyComponents);
    }

    public static ResourceLocation at(String path) {
        return ResourceLocation.fromNamespaceAndPath(ID, path);
    }
}
