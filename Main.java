package me.SwapMe;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
  
	public Logger log;
	@Override
	public void onEnable(){
		log.warning("SwapMe on");
	}
	@Override
	public void onDisable(){
		log.info("SwapMe off");
	}
	
	@EventHandler
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[]args){
	if(sender instanceof ConsoleCommandSender)return false;//Blocking console commands
	else{
		//swap
		if(cmd.getName().equalsIgnoreCase("Swap")){
			if(args.length < 1) return false;
			else{
				if(this.getServer().getPlayer(args[0]) != null && this.getServer().getPlayer(args[1]) != null){
					Player pl1 = this.getServer().getPlayer(args[0]);
					Player pl2 = this.getServer().getPlayer(args[1]);
					Player host = (Player) sender;
					Functions.Swapplayers(pl1, pl2, host);
					return true;
				}
				else{
					Player pl = (Player) sender;
					pl.sendMessage(ChatColor.AQUA + "[SwapMe]The player you've selected isn't online");
				}
			}
		}
		//Clear potions
		
		if(cmd.getName().equalsIgnoreCase("clearpots") || cmd.getName().equalsIgnoreCase("clrpots")){
			if(args.length < 1){//if no args, then apply to sender
			Player pl = (Player) sender;
			Functions.clearpotions(pl);
			pl.sendMessage(ChatColor.AQUA +"[SwapMe]Potions cleared");
			return true;
			}
			else{//if args are present, apply to the args player
			if(this.getServer().getPlayer(args[0]) != null){//if the player in args is existing
				Player sder = (Player) sender;
				Player pl = this.getServer().getPlayer(args[0]);
				Functions.clearpotions(pl);
				pl.sendMessage(ChatColor.AQUA +"[SwapMe]The player " + sder.getName() + " cleared all your potions");
				return true;
			}
			else {//if ths player in args isn't existing, send a message to the sender
			Player pl = (Player) sender;
			pl.sendMessage(ChatColor.AQUA +"[SwapMe]The player you've selected isn't online");
			return true;
			}
				
			
			}
			
		}
		//heal
		if(label.equalsIgnoreCase("heal")){
			if(args.length < 1){
				Player pl = (Player) sender;
				pl.setHealth(20);
				pl.setFoodLevel(20);
				return true;
			}
			else{
				if(this.getServer().getPlayer(args[0]) != null){
					Player pl = this.getServer().getPlayer(args[0]);
					pl.setHealth(20);
					pl.setFoodLevel(20);
					return true;
				}
				else{
					sender.sendMessage("Player not existing");
					return false;
				}
			}
			
		}
		
		else return false;
	}
	}

}
