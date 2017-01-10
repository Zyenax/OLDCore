package net.core.main.commands;

import net.core.main.main;
import net.core.main.bungee.bungeeUtil;
import net.core.main.ranks.SQLRanks;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class changeServerCommand extends BukkitCommand {
	
	@SuppressWarnings("unused")
	private main plugin;

	public changeServerCommand(String string, String description) {
		super(string);
		this.description = description;
	}

	public boolean execute(CommandSender sender, String alias, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			
			if (alias.equalsIgnoreCase("hub") || alias.equalsIgnoreCase("lobby")) {
				if (args.length >= 2 || args.length < 1 || args.equals(null)) {
					bungeeUtil.sendToServer(p, "Lobby");
				}
			}
			if (alias.equalsIgnoreCase("factions") || alias.equalsIgnoreCase("fac")) {
				if (args.length >= 2 || args.length < 1 || args.equals(null)) {
					bungeeUtil.sendToServer(p, "Factions");
				}
			}
			
			if (alias.equalsIgnoreCase("dev") || alias.equalsIgnoreCase("developer")) {
				if (args.length >= 2 || args.length < 1 || args.equals(null)) {
					bungeeUtil.sendToServer(p, "Developer");
				}
			}
			
			if (alias.equalsIgnoreCase("buildteam") || alias.equalsIgnoreCase("build")) {
				if (args.length >= 2 || args.length < 1 || args.equals(null)) {
					bungeeUtil.sendToServer(p, "BuildTeam");
				}
			}
			
			if (alias.equalsIgnoreCase("ranklist")) {
				if (args.length >= 2 || args.length < 1 || args.equals(null)) {
					p.sendMessage("Your rank is " + SQLRanks.getRank(p));
				}
			}
			
		}
		return true;
	}
}
