package net.fhu.basicflight.item.custom;

import net.fhu.basicflight.BasicFlight;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BasicFlight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FlightItem extends Item {
    public FlightItem() {
        super(new Item.Properties().stacksTo(1));

    }

}
