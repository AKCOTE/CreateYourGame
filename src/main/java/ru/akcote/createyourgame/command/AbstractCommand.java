package ru.akcote.createyourgame.command;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;

public abstract class AbstractCommand implements CommandExecutor, TabCompleter {

    private Plugin plugin;

    public AbstractCommand(Plugin plugin, String commandName) {
        this.plugin = plugin;
        PluginCommand command = plugin.getServer().getPluginCommand(commandName);
        command.setExecutor(this);
        if (hasTabComplete()) {
            command.setTabCompleter(this);
        }
    }

    public abstract void execute(CommandSender sender, Command cmd, String s, String[] args);
    public List<String> complete() {
        return null;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            if (isOnlyForPlayers()) {
                sender.sendMessage("Эта команда только для игроков.");
                return true;
            }
        }
        try {
            execute(sender, cmd, s, args);
        } catch (Exception e) {
            sender.sendMessage("Произошла какая-то ошибка при выполнении команды. Посмотрите консоль.");
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            if (isOnlyForPlayers()) {
                sender.sendMessage("Эта команда только для игроков.");
                return null;
            }
        }
        try {
            return complete();
        } catch (Exception e) {
            sender.sendMessage("Произошла какая-то ошибка при TAB. Посмотрите консоль.");
        }
        return null;
    }

    public boolean isOnlyForPlayers() {
        return false;
    }

    public boolean hasTabComplete() {
        return false;
    }
}
