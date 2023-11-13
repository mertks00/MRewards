package me.oyuncozucu.mrewards;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class RewardManager {

    public void giveReward(Player player) {

        UUID uuid = player.getUniqueId();
        Date now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

        if(!MRewards.getInstance().getConfig().contains("fields." + uuid.toString())) {
            RewardUtils.giveRewardItem(player);
            MRewards.getInstance().getConfig().set("fields." + uuid + ".date", dateFormat.format(now));
            MRewards.getInstance().saveConfig();
            return;
        }

        String configDate = MRewards.getInstance().getConfig().getString("fields." + uuid + ".date");
        Date date = null;
        try {
            date = dateFormat.parse(configDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long dateDifference = (now.getTime() - date.getTime()) / (1000 * 60 * 60);

        if(dateDifference < 24) {
            player.sendMessage(ChatColor.RED + "Geçen Zaman: " + dateDifference);
            return;
        }

        if(dateDifference >= 24) {
            now = new Date();
            RewardUtils.giveRewardItem(player);
            MRewards.getInstance().getConfig().set("fields." + uuid + ".date", dateFormat.format(now));
            MRewards.getInstance().saveConfig();
        }
    }
}
