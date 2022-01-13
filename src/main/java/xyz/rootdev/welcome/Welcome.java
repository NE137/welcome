package xyz.rootdev.welcome;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Welcome extends JavaPlugin {

    public Commands commands = null;
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.commands = new Commands(this);
        this.saveDefaultConfig();
        config.addDefault("welcomeMessage", "Welcome message here");
        config.options().copyDefaults(true);
        saveConfig();
        this.getCommand("welcome").setExecutor(this.commands);
    }

//    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//        return this.commands.onCommand(sender, command, label, args);
//    }
}
