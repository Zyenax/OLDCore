package net.core.main.commands;

import net.core.main.main;
import net.core.main.ranks.SQLRanks;
import net.core.main.utils.util;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class rankCommand extends BukkitCommand {
	
	@SuppressWarnings("unused")
	private main plugin;

	public rankCommand(String string, String description) {
		super(string);
		this.description = description;
	}
	
	
  //im here
	//ok
	
	//just go through the plugin and look at things then if you need help ask me in skype and tell me the class
	//your in
	
	
	public boolean execute(CommandSender sender, String alias, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			Player target = Bukkit.getServer().getPlayer(args[1]);
			
			if (alias.equalsIgnoreCase("rank")){
				if(SQLRanks.getRank(p).equals("OWNER") || SQLRanks.getRank(p).equals("ADMIN") || p.isOp()){
				if(args.length >= 4 || args.length < 1 || args.equals(null)){
					p.sendMessage(util.color("&e&lUSAGE&8&l: &c/rank set [player] [rank]"));
				}else if(args[0].equalsIgnoreCase("set")){
					if(target != null){
						if(args[2].equalsIgnoreCase("owner")){
							SQLRanks.setRank(target, "OWNER");
							target.sendMessage(util.color("&cYour rank has been set to &eOWNER"));
							
						}else if(args[2].equalsIgnoreCase("admin")){
							SQLRanks.setRank(target, "ADMIN");
							target.sendMessage(util.color("&cYour rank has been set to &eADMIN"));
							
						}else if(args[2].equalsIgnoreCase("youtube")){
							SQLRanks.setRank(target, "YOUTUBE");
							target.sendMessage(util.color("&cYour rank has been set to &eYOUTUBE"));
							
						}else if(args[2].equalsIgnoreCase("twitch")){
							SQLRanks.setRank(target, "TWITCH");
							target.sendMessage(util.color("&cYour rank has been set to &eTWITCH"));
							
						}else if(args[2].equalsIgnoreCase("dev")){
							SQLRanks.setRank(target, "DEV");
							target.sendMessage(util.color("&cYour rank has been set to &eDEV"));
							
						}else if(args[2].equalsIgnoreCase("jrdev")){
							SQLRanks.setRank(target, "JRDEV");
							target.sendMessage(util.color("&cYour rank has been set to &eJR.DEV"));
							
						}else if(args[2].equalsIgnoreCase("srmod")){
							SQLRanks.setRank(target, "SRMOD");
							target.sendMessage(util.color("&cYour rank has been set to &eSR.MOD"));
							
						}else if(args[2].equalsIgnoreCase("mod")){
							SQLRanks.setRank(target, "MOD");
							target.sendMessage(util.color("&cYour rank has been set to &eMOD"));
							
						}else if(args[2].equalsIgnoreCase("helper")){
							SQLRanks.setRank(target, "HELPER");
							target.sendMessage(util.color("&cYour rank has been set to &eHELPER"));
							
						}else if(args[2].equalsIgnoreCase("headbuilder")){
							SQLRanks.setRank(target, "HBUILDER");
							target.sendMessage(util.color("&cYour rank has been set to &eHEAD-BUILDER"));
							
						}else if(args[2].equalsIgnoreCase("builder")){
							SQLRanks.setRank(target, "BUILDER");
							target.sendMessage(util.color("&cYour rank has been set to &eBUILDER"));
							
						}else if(args[2].equalsIgnoreCase("donor1")){
							SQLRanks.setRank(target, "DONOR1");
							target.sendMessage(util.color("&cYour rank has been set to &e✪"));
							
						}else if(args[2].equalsIgnoreCase("donor2")){
							SQLRanks.setRank(target, "DONOR2");
							target.sendMessage(util.color("&cYour rank has been set to &e✪✪"));
							
						}else if(args[2].equalsIgnoreCase("donor3")){
							SQLRanks.setRank(target, "DONOR3");
							target.sendMessage(util.color("&cYour rank has been set to &e✪✪✪"));
							
						}else if(args[2].equalsIgnoreCase("default")){
							SQLRanks.setRank(target, "DEFAULT");
							target.sendMessage(util.color("&cYour rank has been set to &eDEFAULT"));
							
						}
					}else{
						p.sendMessage(util.color("&e&lUSAGE&8&l: &c/rank set [player] [rank]"));
					}
				}else{
					p.sendMessage(util.color("&e&lUSAGE&8&l: &c/rank set [player] [rank]"));
				}
				}else{
					p.sendMessage(util.color("&cYou dont have permission to do that!"));
				}
			}
			
			
		}
		return true;
	}
}

