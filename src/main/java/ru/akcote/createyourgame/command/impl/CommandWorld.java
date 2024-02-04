package ru.akcote.createyourgame.command.impl;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import ru.akcote.createyourgame.command.AbstractCommand;

import java.util.Arrays;
import java.util.List;

public class CommandWorld extends AbstractCommand {
    public CommandWorld(Plugin plugin, String commandName) {
        super(plugin, commandName);
    }

    @Override
    public void execute(CommandSender sender, Command cmd, String s, String[] args) {
        sender.sendMessage("HI");
    }

    @Override
    public List<String> complete() {
        return Arrays.asList("ab","bc","ac");
    }

    @Override
    public boolean isOnlyForPlayers() {
        return true;
    }

    @Override
    public boolean hasTabComplete() {
        return true;
    }
}
