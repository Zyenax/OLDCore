package net.core.main.handlers;

import net.core.main.ranks.SQLRanks;
import net.core.main.utils.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class playerNameHandler {
	
	@SuppressWarnings("deprecation")
	private static void setTag(Player player, String tag)
	  {
	    Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
	    Team team = board.getTeam(player.getName());
	    if (team == null) {
	      team = board.registerNewTeam(player.getName());
	    }
	    team.setPrefix(tag);
	    team.addPlayer(player);
	    for (Player players : Bukkit.getOnlinePlayers()) {
	      players.setScoreboard(board);
	    }
	  }
	
	
	public static void setName(Player p){
		if(SQLRanks.getRank(p).equals("OWNER")){
			setTag(p, util.color("&c&lOWNER " + "&c"));
		}else if(SQLRanks.getRank(p).equals("ADMIN")){
			setTag(p, util.color("&c&lADMIN " + "&c"));
		}else if(SQLRanks.getRank(p).equals("YOUTUBE")){
			setTag(p, util.color("&c&lYT " + "&c"));
		}else if(SQLRanks.getRank(p).equals("TWITCH")){
			setTag(p, util.color("&5&lTWITCH " + "&5"));
		}else if(SQLRanks.getRank(p).equals("DEV")){
			setTag(p, util.color("&6&lDEV " + "&6"));
		}else if(SQLRanks.getRank(p).equals("JRDEV")){
			setTag(p, util.color("&6&lJRDEV " + "&6"));
		}else if(SQLRanks.getRank(p).equals("SRMOD")){
			setTag(p, util.color("&e&lSRMOD " + "&e"));
		}else if(SQLRanks.getRank(p).equals("MOD")){
			setTag(p, util.color("&e&lMOD " + "&e"));
		}else if(SQLRanks.getRank(p).equals("HELPER")){
			setTag(p, util.color("&b&lHELPER " + "&b"));
		}else if(SQLRanks.getRank(p).equals("HBUILDER")){
			setTag(p, util.color("&9&lHBUILDER " + "&9"));
		}else if(SQLRanks.getRank(p).equals("BUILDER")){
			setTag(p, util.color("&9&lBUILDER " + "&9"));
		}else if(SQLRanks.getRank(p).equals("DONOR1")){
			setTag(p, util.color("&e&l✪ " + "&e"));
		}else if(SQLRanks.getRank(p).equals("DONOR2")){
			setTag(p, util.color("&a&l✪✪ " + "&a"));
		}else if(SQLRanks.getRank(p).equals("DONOR3")){
			setTag(p, util.color("&b&l✪✪✪ " + "&b"));
		}else if(SQLRanks.getRank(p).equals("DEFAULT")){
			setTag(p, util.color("&7"));
		}
	}

}
