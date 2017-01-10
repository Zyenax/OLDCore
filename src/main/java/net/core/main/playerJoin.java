package net.core.main;

import net.core.main.handlers.playerNameHandler;
import net.core.main.ranks.SQLRanks;
import net.core.main.ranks.setTabListName;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerJoin implements Listener{
	
	private main plugin;
	public playerJoin(main listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e){
		final Player p = (Player) e.getPlayer();
		e.setJoinMessage("");
		if(SQLRanks.getRank(p) == null){
			SQLRanks.setRank(p, "DEFAULT");
		}
		SQLRanks.loadPlayer(p);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
    		public void run() {
    			playerNameHandler.setName(p);
    			setTabListName.setTab(p);
    		}
    	}, 4);
		
		
	}
}
