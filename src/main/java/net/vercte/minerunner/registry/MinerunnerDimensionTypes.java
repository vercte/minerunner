package net.vercte.minerunner.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.dimension.DimensionType;
import net.vercte.minerunner.Minerunner;

import java.util.Optional;
import java.util.OptionalLong;

public class MinerunnerDimensionTypes {
    public static final ResourceKey<DimensionType> HUB = register("hub");
    public static final ResourceLocation HUB_EFFECTS = Minerunner.at("hub");

    public static void bootstrap(BootstrapContext<DimensionType> context) {
        context.register(
                MinerunnerDimensionTypes.HUB,
                new DimensionType(
                        OptionalLong.of(18000L),
                        false,
                        false,
                        false,
                        false,
                        1.0,
                        true,
                        false,
                        0,
                        256,
                        256,
                        BlockTags.INFINIBURN_OVERWORLD,
                        MinerunnerDimensionTypes.HUB_EFFECTS,
                        0.4F,
                        Optional.empty(),
                        new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 0)
                )
        );
    }

    private static ResourceKey<DimensionType> register(String id) {
        return ResourceKey.create(Registries.DIMENSION_TYPE, Minerunner.at(id));
    }
}
