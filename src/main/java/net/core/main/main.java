package net.core.main;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.sql.PreparedStatement;

import net.core.main.SQL.SQL;
import net.core.main.bungee.bungeeUtil;
import net.core.main.commands.changeServerCommand;
import net.core.main.commands.rankCommand;
import net.core.main.handlers.chatMention;
import net.core.main.handlers.scoreBoardHandler;
import net.core.main.ranks.SQLRanks;
import net.core.main.ranks.rankChatHandler;
import net.core.main.ranks.setTabListName;
import net.core.main.utils.hashMapStorage;
import net.core.main.utils.packets;
import net.core.main.utils.util;
import net.core.main.utils.worldManager;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.v1_10_R1.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class main extends JavaPlugin implements Listener, PluginMessageListener{
	
	public static String GetServer;
	public static String[] serverList;
	public static String[] playerList;
	public static SQL mysql;
	private static main instance;
	
	public void onEnable(){
		loadClasses();
		loadCommands();
		loadBungee();
		instance = this;
	    connectMySQL();
	    for(Player p : Bukkit.getOnlinePlayers()){
			SQLRanks.loadPlayer(p);
		}
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(util.color("&e[&cCore&e] &aHas been enabled!"));
	}
	
	public void onDisable(){
		SQLRanks.onDisableSavePlayer();
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(util.color("&e[&cCore&e] &cHas been disabled!"));
		mysql.close();
	}

	public static main getInstance(){
	     return instance;
	}

	public SQL getMySQL(){
	     return mysql;
	}
	
	public void connectMySQL() {
		// IPADDRESS, PORT, DATABASE, USERNAME, PASSWORD
	     mysql = new SQL("127.0.0.1", "3306", "PlayerStats", "Blxd", "password");
	     PreparedStatement statement = mysql.prepareStatement("CREATE TABLE IF NOT EXISTS Ranks(UUID varchar(36) NOT NULL, name VARCHAR(16) NOT NULL, RANK VARCHAR(45) NOT NULL, PRIMARY KEY(UUID))");
	     //USED TO CREATE TABLES FOR INFORMATION
	     mysql.update(statement);
	}
	
	public void loadBungee(){
		Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this,"BungeeCord");
	    Bukkit.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
	}
	
	public void loadClasses(){
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new playerJoin(this), this);
		pm.registerEvents(new playerQuit(this), this);
		pm.registerEvents(new bungeeUtil(this), this);
		pm.registerEvents(new chatMention(this), this);
		pm.registerEvents(new scoreBoardHandler(this), this);
		pm.registerEvents(new rankChatHandler(this), this);
		pm.registerEvents(new setTabListName(this), this);
		pm.registerEvents(new hashMapStorage(this), this);
		pm.registerEvents(new packets(this), this);
		pm.registerEvents(new util(this), this);
		pm.registerEvents(new worldManager(this), this);
	}
	
	public void loadCommands(){
		((CraftServer) this.getServer()).getCommandMap().register("lobby", new changeServerCommand("lobby", "Used to warp back to our lobby server!"));
		((CraftServer) this.getServer()).getCommandMap().register("buildteam", new changeServerCommand("buildteam", "Used to go to our build teams server!"));
		((CraftServer) this.getServer()).getCommandMap().register("build", new changeServerCommand("build", "Used to go to our build teams server!"));
		((CraftServer) this.getServer()).getCommandMap().register("hub", new changeServerCommand("hub", "Used to warp back to our hub server!"));
		((CraftServer) this.getServer()).getCommandMap().register("developer", new changeServerCommand("developer", "Used to join the developers server!"));
		((CraftServer) this.getServer()).getCommandMap().register("dev", new changeServerCommand("dev", "Used to join the developers server!"));
		((CraftServer) this.getServer()).getCommandMap().register("factions", new changeServerCommand("factions", "Used to join the factions server!"));
		((CraftServer) this.getServer()).getCommandMap().register("fac", new changeServerCommand("fac", "Used to join the factions server!"));
		((CraftServer) this.getServer()).getCommandMap().register("rank", new rankCommand("rank", "Used to change your rank on the server!"));
		((CraftServer) this.getServer()).getCommandMap().register("ranklist", new changeServerCommand("ranklist", "Used to change your rank on the server!"));
	}
	
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
	    if (!channel.equals("BungeeCord")) {
	      return;
	    }
	    try{
	    	DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
		    String subchannel = in.readUTF();
	    if (subchannel.equals("PlayerCount")) {
	    	String PlayerCountServer = in.readUTF();
	    	Integer playercount = in.readInt();
	    	hashMapStorage.PlayerCount.remove(PlayerCountServer);
	    	hashMapStorage.PlayerCount.put(PlayerCountServer, playercount);
        } else if (subchannel.equals("GetServers")) {
        	serverList = in.readUTF().split(", ");
        } else if (subchannel.equals("PlayerList")) {
        	playerList = in.readUTF().split(", ");
        } else if (subchannel.equals("GetServer")) {
            // Example: GetServer subchannel
        	GetServer = in.readUTF();
        }
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
	  }
}
