package net.core.main.ranks;

import net.core.main.main;
import net.core.main.handlers.chatMention;
import net.core.main.utils.util;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class rankChatHandler implements Listener{
	
	@SuppressWarnings("unused")
	private main plugin;
	public rankChatHandler(main listener) {
		this.plugin = listener;		
	}
	
	
	//RANK CHAT HANDLER DO NOT TOUCH
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player p = (Player) e.getPlayer();
		if(SQLRanks.getRank(p).equals("OWNER")){
			e.setFormat(util.color(" &c&l" + SQLRanks.getRank(p) + " &c" + e.getPlayer().getName() + " " + chatMention.chatColor + e.getMessage()));
		}else if(SQLRanks.getRank(p).equals("ADMIN")){
			e.setFormat(util.color(" &c&l" + SQLRanks.getRank(p) + " &c" + e.getPlayer().getName() + " " + chatMention.chatColor + e.getMessage()));
		}else if(SQLRanks.getRank(p).equals("YOUTUBE")){
			e.setFormat(util.color(" &c&l" + SQLRanks.getRank(p) + " &c" + e.getPlayer().getName() + " " + chatMention.chatColor + e.getMessage()));
		}else if(SQLRanks.getRank(p).equals("TWITCH")){
			e.setFormat(util.color(" &5&l" + SQLRanks.getRank(p) + " &5" + e.getPlayer().getName() + " " + chatMention.chatColor + e.getMessage()));
		}else if(SQLRanks.getRank(p).equals("DEV")){
			e.setFormat(util.color(" &6&l" + SQLRanks.getRank(p) + " &6" + e.getPlayer().getName() + " " + chatMention.chatColor + e.getMessage()));
		}else if(SQLRanks.getRank(p).equals("JRDEV")){
			e.setFormat(util.color(" &6&l" + SQLRanks.getRank(p) + " &6" + e.getPlayer().getName() + " " + chatMention.chatColor + e.getMessage()));
		}else if(SQLRanks.getRank(p).equals("SRMOD")){
			e.setFormat(util.color(" &e&l" + SQLRanks.getRank(p) + " &e" + e.getPlayer().getName() + " " + chatMention.chatColor + e.getMessage()));
		}else if(SQLRanks.getRank(p).equals("MOD")){
			e.setFormat(util.color(" &e&l" + SQLRanks.getRank(p) +  " &e" + e.getPlayer().getName() + " " + chatMention.chatColor + e.getMessage()));
		}else if(SQLRanks.getRank(p).equals("HELPER")){
			e.setFormat(util.color(" &b&l" + SQLRanks.getRank(p) +  " &b" + e.getPlayer().getName() + " " + chatMention.chatColor + e.getMessage()));
		}else if(SQLRanks.getRank(p).equals("HBUILDER")){
			e.setFormat(util.color(" &9&l" + SQLRanks.getRank(p) +  " &9" + e.getPlayer().getName() + " " + chatMention.chatColor + e.getMessage()));
		}else if(SQLRanks.getRank(p).equals("BUILDER")){
			e.setFormat(util.color(" &9&l" + SQLRanks.getRank(p) +  " &9" + e.getPlayer().getName() + " " + chatMention.chatColor + e.getMessage()));
		}else if(SQLRanks.getRank(p).equals("DONOR1")){
			e.setFormat(util.color(" &e✪ " + e.getPlayer().getName() + " " + chatMention.chatColor + e.getMessage()));
		}else if(SQLRanks.getRank(p).equals("DONOR2")){
			e.setFormat(util.color(" &a✪✪ " + e.getPlayer().getName() + " " + chatMention.chatColor + e.getMessage()));
		}else if(SQLRanks.getRank(p).equals("DONOR3")){
			e.setFormat(util.color(" &b✪✪✪ " + e.getPlayer().getName() + " " + chatMention.chatColor + e.getMessage()));
		}else if(SQLRanks.getRank(p).equals("DEFAULT")){
			e.setFormat(util.color(" &8" + e.getPlayer().getName() + " &8" + e.getMessage()));
		}
	}
	
}
