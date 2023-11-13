package me.oyuncozucu.mrewards;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Random;

public class RewardUtils {

    public static void openRewardMenu(Player player) {

        Inventory menu = Bukkit.createInventory(player, 27,"Hediye");

        ItemStack reward = new ItemStack(Material.ENDER_CHEST);
        ItemMeta rewardMeta = reward.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "24 saat 'te bir alınabilir.");
        rewardMeta.setLore(lore);
        rewardMeta.setDisplayName(ChatColor.YELLOW + "Almak için tıkla!");
        reward.setItemMeta(rewardMeta);

        menu.setItem(13, reward);

        player.openInventory(menu);

    }

    public static void giveRewardItem(Player player) {

        ItemStack[] rewards = {new ItemStack(Material.STONE), new ItemStack(Material.DIAMOND), new ItemStack(Material.COAL)};

        int index = new Random().nextInt(rewards.length);

        ItemStack reward = rewards[index];

        player.getInventory().addItem(reward);

    }

}
