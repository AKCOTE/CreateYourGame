package ru.akcote.createyourgame;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import ru.akcote.createyourgame.command.impl.CommandWorld;

public class Main extends JavaPlugin {

    @Getter
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new EventsListener(this), this);
        new CommandWorld(this, "world");
        getLogger().info("Successful loading!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling...");
        //TODO
    }

}
