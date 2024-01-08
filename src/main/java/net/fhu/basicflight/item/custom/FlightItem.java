package net.fhu.basicflight.item.custom;

import net.fhu.basicflight.BasicFlight;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Mod.EventBusSubscriber(modid = BasicFlight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FlightItem extends Item {
    public FlightItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));

    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("Tooltip.basicflight.flightitem.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
