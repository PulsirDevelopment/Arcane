package net.pulsir.arcane.command.adapter;

import net.pulsir.arcane.command.Command;
import net.pulsir.arcane.command.completer.ICompleter;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CommandAdapter implements CommandExecutor, TabCompleter {

    private final List<Command> commands;
    private final ICompleter completer;

    public CommandAdapter(List<Command> commands, ICompleter completer){
        this.commands = commands;
        this.completer = completer;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, org.bukkit.command.@NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (args.length > 0) {
            for (Command cmd : commands) {
                if (args[0].equalsIgnoreCase(cmd.getName())) {
                    cmd.execute(commandSender, args);
                }
            }
        } else {
            for (Command cmd : commands) {
                if (cmd.allow()) {
                    if (cmd.permissible() && commandSender.hasPermission(cmd.permission())) {
                        commandSender.sendMessage(cmd.getUsage());
                    } else {
                        commandSender.sendMessage(cmd.getUsage());
                    }
                }
            }
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return new ArrayList<>();
    }
}