package xyz.rootdev.welcome;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Commands {
    private Welcome plugin;
    Commands(Welcome p) { this.plugin = p;}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("welcome")) {
            if (!sender.hasPermission("welcome.welcome")) {
                sender.sendMessage("§cYou do not have permissions to use this command");
                return true;
            }

            if (args.length == 0) {
                sender.sendMessage("§cUsage: §a/welcome <playername>");
                return true;
            }
            Bukkit.getServer().broadcastMessage(this.plugin.getConfig().getString("welcomeMessage").replace("&", "§").replace("%player%", args[0]));
            return true;
        }
        return true;
    }
}
