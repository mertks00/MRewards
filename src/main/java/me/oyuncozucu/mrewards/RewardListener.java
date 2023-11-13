package me.oyuncozucu.mrewards;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class RewardListener implements Listener {

    @EventHandler
    public void onRewardMenuClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equalsIgnoreCase("Hediye")) {
            e.setCancelled(true);
            switch (e.getCurrentItem().getType()) {
                case ENDER_CHEST:
                    RewardManager rewardManager = new RewardManager();
                    rewardManager.giveReward(player);
                    player.closeInventory();
                    break;
            }
        }

    }

}
