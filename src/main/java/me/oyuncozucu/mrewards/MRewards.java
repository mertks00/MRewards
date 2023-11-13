package me.oyuncozucu.mrewards;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MRewards extends JavaPlugin {

    private static MRewards instance;

    public static MRewards getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        instance = this;

        getCommand("reward").setExecutor(new RewardCommand());

        Bukkit.getPluginManager().registerEvents(new RewardListener(), this);

    }

}
