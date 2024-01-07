package net.fhu.basicflight.item;

import net.fhu.basicflight.BasicFlight;
import net.fhu.basicflight.item.custom.FlightItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BasicFlight.MOD_ID);

    public static final RegistryObject<Item> RING = ITEMS.register("ring",
            () -> new FlightItem(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}