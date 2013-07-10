package me.SwapMe;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Functions {
  //Swapplayers
	public static void Swapplayers(Player pl1, Player pl2,Player host){
		PotionEffect invis = new PotionEffect(PotionEffectType.INVISIBILITY, 99999,1);
		PotionEffect resist = new PotionEffect(PotionEffectType.REGENERATION, 10,5);
		
		host.addPotionEffect(invis);
		host.teleport(pl1);
		host.sendMessage(ChatColor.AQUA +"Teleporting you to pl1");
		
		pl1.sendMessage(ChatColor.AQUA + "Swapping");
		pl1.addPotionEffect(resist);
		pl1.teleport(pl2);
		
		pl2.sendMessage(ChatColor.AQUA +"Swapping");
		pl2.addPotionEffect(resist);
		pl2.teleport(host);
	}
	//Clearallpotions
	public static void clearpotions(Player pl){
		pl.getActivePotionEffects().clear();
		pl.removePotionEffect(PotionEffectType.INVISIBILITY);
		pl.removePotionEffect(PotionEffectType.REGENERATION);
		pl.removePotionEffect(PotionEffectType.BLINDNESS);
		pl.removePotionEffect(PotionEffectType.CONFUSION);
		pl.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
		pl.removePotionEffect(PotionEffectType.FAST_DIGGING);
		pl.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
		pl.removePotionEffect(PotionEffectType.HARM);
		pl.removePotionEffect(PotionEffectType.HEAL);
		pl.removePotionEffect(PotionEffectType.HUNGER);
		pl.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		pl.removePotionEffect(PotionEffectType.JUMP);
		pl.removePotionEffect(PotionEffectType.NIGHT_VISION);
		pl.removePotionEffect(PotionEffectType.POISON);
		pl.removePotionEffect(PotionEffectType.SLOW);
		pl.removePotionEffect(PotionEffectType.SLOW_DIGGING);
		pl.removePotionEffect(PotionEffectType.SPEED);
		pl.removePotionEffect(PotionEffectType.WATER_BREATHING);
		pl.removePotionEffect(PotionEffectType.WEAKNESS);
		pl.removePotionEffect(PotionEffectType.WITHER);
		
	}
	
	
}
