package net.vercte.minerunner.registry;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class MinerunnerRegistries {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, MinerunnerDimensionTypes::bootstrap);

}
