package net.fhu.basicflight;

import com.mojang.logging.LogUtils;
import net.fhu.basicflight.registries.CreativeTabRegistry;
import net.fhu.basicflight.registries.ItemRegistry;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.CreativeModeTabRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.extensions.IForgeItem;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
@Mod("basicflight")
public class BasicFlight {
    public static final String MOD_ID = "basicflight";
    private static final Logger LOGGER = LogUtils.getLogger();

    public BasicFlight()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this :: commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(CreativeModeTabRegistry.class);

        ItemRegistry.init();
        CreativeTabRegistry.init();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
    boolean compatChecker = false;
    private void startFlying(Player player) {
        player.getAbilities().mayfly = true;
        player.onUpdateAbilities();
    }
    private void stopFlying(Player player) {
        player.getAbilities().mayfly = false;
        player.getAbilities().flying = false;
        player.onUpdateAbilities();
    }
    // you could probably get away by running the event in a separate flighthandler class by using modeventbus/forgeeventbus
    // but i dont wanna do that cause this is easier
    @SubscribeEvent
    public void FlightCheck(TickEvent.PlayerTickEvent event) {
        Inventory inv = event.player.getInventory();
        IForgeItem ring = ItemRegistry.RING.get();
        boolean ShouldFly = inv.contains(new ItemStack((ItemLike) ring));
        if (ShouldFly) {
            this.startFlying(event.player);
            if(!compatChecker) {
                this.compatChecker =true;
            }
        } else if (compatChecker && !event.player.isCreative()) {
            this.compatChecker = false;
            this.stopFlying(event.player);

        }

    }

}
