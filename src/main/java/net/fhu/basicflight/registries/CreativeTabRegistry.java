package net.fhu.basicflight.registries;

import net.fhu.basicflight.BasicFlight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BasicFlight.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ANGEL_RING_TAB = CREATIVE_MODE_TAB_REGISTRY.register("basic_flight_tab", () -> CreativeModeTab.builder()
            .title(Component.literal("Basic Flight"))
            .icon(() -> new ItemStack(ItemRegistry.RING.get().asItem()))
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .displayItems((featureFlags, output) -> {
                output.accept(ItemRegistry.RING.get());

            })
            .build()
    );

    public static void init() {
        CREATIVE_MODE_TAB_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}

