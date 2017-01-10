package net.core.main.handlers;

import java.util.ArrayList;
import java.util.List;

import net.core.main.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chatMention implements Listener {
	@SuppressWarnings("unused")
	private main plugin;

	public chatMention(main hub) {
		this.plugin = hub;
	}
	
	public static String chatColor = "&7";
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		String msg = e.getMessage();

		String[] messages = msg.split(" ");
		List<String> players = new ArrayList<String>();
		for (Player p : Bukkit.getOnlinePlayers()) {
			players.add(p.getName());
		}

		for (String s : messages) {
			if (players.contains(s)) {
				e.setMessage(e.getMessage().replace(
						s,
						ChatColor.translateAlternateColorCodes('&', "&a@" + s
								+ chatColor)));
				Bukkit.getPlayerExact(s).playSound(
						Bukkit.getPlayerExact(s).getLocation(),
						Sound.ENTITY_ITEM_PICKUP, Integer.MAX_VALUE, Integer.MAX_VALUE);
			}
		}
	}

}
