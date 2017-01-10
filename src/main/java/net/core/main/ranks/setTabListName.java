package net.core.main.ranks;

import net.core.main.main;
import net.core.main.utils.util;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class setTabListName implements Listener{
	
	@SuppressWarnings("unused")
	private main plugin;
	public setTabListName(main listener) {
		this.plugin = listener;		
	}
	
	public static void setTab(Player p){
		if(SQLRanks.getRank(p).equals("OWNER")){
			p.setPlayerListName(util.color("&c&l" + SQLRanks.getRank(p) + " &c" + p.getName()));
		}else if(SQLRanks.getRank(p).equals("ADMIN")){
			p.setPlayerListName(util.color("&c&l" + SQLRanks.getRank(p) + " &c" + p.getName()));
		}else if(SQLRanks.getRank(p).equals("YOUTUBE")){
			p.setPlayerListName(util.color("&c&l" + SQLRanks.getRank(p) + " &c" + p.getName()));
		}else if(SQLRanks.getRank(p).equals("TWITCH")){
			p.setPlayerListName(util.color("&5&l" + SQLRanks.getRank(p) + " &5" + p.getName()));
		}else if(SQLRanks.getRank(p).equals("DEV")){
			p.setPlayerListName(util.color("&6&l" + SQLRanks.getRank(p) + " &6" + p.getName()));
		}else if(SQLRanks.getRank(p).equals("JRDEV")){
			p.setPlayerListName(util.color("&6&l" + SQLRanks.getRank(p) + " &6" + p.getName()));
		}else if(SQLRanks.getRank(p).equals("SRMOD")){
			p.setPlayerListName(util.color("&e&l" + SQLRanks.getRank(p) + " &e" + p.getName()));
		}else if(SQLRanks.getRank(p).equals("MOD")){
			p.setPlayerListName(util.color("&e&l" + SQLRanks.getRank(p) +  " &e" + p.getName()));
		}else if(SQLRanks.getRank(p).equals("HELPER")){
			p.setPlayerListName(util.color("&b&l" + SQLRanks.getRank(p) +  " &b" + p.getName()));
		}else if(SQLRanks.getRank(p).equals("HBUILDER")){
			p.setPlayerListName(util.color("&9&l" + SQLRanks.getRank(p) +  " &9" + p.getName()));
		}else if(SQLRanks.getRank(p).equals("BUILDER")){
			p.setPlayerListName(util.color("&9&l" + SQLRanks.getRank(p) +  " &9" + p.getName()));
		}else if(SQLRanks.getRank(p).equals("DONOR1")){
			p.setPlayerListName(util.color("&e✪ " + p.getName()));
		}else if(SQLRanks.getRank(p).equals("DONOR2")){
			p.setPlayerListName(util.color("&a✪✪ " + p.getName()));
		}else if(SQLRanks.getRank(p).equals("DONOR3")){
			p.setPlayerListName(util.color("&b✪✪✪ " + p.getName()));
		}else if(SQLRanks.getRank(p).equals("DEFAULT")){
			p.setPlayerListName(util.color("&7" + p.getName()));
		}
	}
}
