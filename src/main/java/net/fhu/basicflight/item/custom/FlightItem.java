package net.fhu.basicflight.item.custom;

import net.fhu.basicflight.BasicFlight;
import net.fhu.basicflight.registrys.ItemRegistry;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.extensions.IForgeItem;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BasicFlight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FlightItem extends Item {
    public FlightItem() {
        super(new Item.Properties().stacksTo(1));

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
