package net.vercte.minerunner.content.gameplay;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.vercte.minerunner.registry.MinerunnerDataComponents;

import java.util.function.Consumer;

public class ItemValue {


    @SuppressWarnings("DataFlowIssue")
    public static void addToTooltip(Consumer<Component> tooltipAdder, ItemStack stack) {
        if(!stack.has(MinerunnerDataComponents.VALUE)) return;

        float value = stack.get(MinerunnerDataComponents.VALUE.get());
        int count = stack.getCount();

        Component valueSubComponent = Component.literal(String.valueOf(value * count))
                .withStyle(value < 0 ? ChatFormatting.RED : ChatFormatting.WHITE);

        Component valueTooltip = Component.translatable("interface.minerunner.item_value")
                .withStyle(ChatFormatting.GOLD)
                .append(valueSubComponent);

        Component descriptionTooltip = Component.translatable("interface.minerunner.cash_in")
                .withStyle(ChatFormatting.GRAY);

        tooltipAdder.accept(valueTooltip);
        tooltipAdder.accept(descriptionTooltip);
    }
}
