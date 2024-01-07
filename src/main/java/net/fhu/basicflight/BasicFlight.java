package net.fhu.basicflight;

import com.mojang.logging.LogUtils;
import net.fhu.basicflight.registrys.CreativeTabRegistry;
import net.fhu.basicflight.registrys.ItemRegistry;
import net.minecraftforge.common.CreativeModeTabRegistry;
import net.minecraftforge.common.MinecraftForge;
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

}
