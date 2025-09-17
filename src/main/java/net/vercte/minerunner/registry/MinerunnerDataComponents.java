package net.vercte.minerunner.registry;

import com.mojang.serialization.codecs.PrimitiveCodec;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vercte.minerunner.Minerunner;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class MinerunnerDataComponents {
    public static final DeferredRegister.DataComponents REGISTRAR = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Minerunner.ID);

    public static final Supplier<DataComponentType<Float>> VALUE = REGISTRAR.registerComponentType("value", b -> b
            .persistent(PrimitiveCodec.FLOAT)
            .networkSynchronized(ByteBufCodecs.FLOAT)
            .cacheEncoding()
    );

    public static void modifyComponents(ModifyDefaultComponentsEvent event) {
        //event.getAllItems().forEach(i -> event.modify(i, setValue(0)));

        event.modify(Items.POISONOUS_POTATO, setValue(-0.25f));
        event.modify(Items.DIAMOND, setValue(4));
        event.modify(Items.DIAMOND_BLOCK, setValue(36));
    }

    private static Consumer<DataComponentPatch.Builder> setValue(float value) {
        return b -> b.set(MinerunnerDataComponents.VALUE.get(), value);
    }

    public static void register(IEventBus bus) { REGISTRAR.register(bus); }
}
