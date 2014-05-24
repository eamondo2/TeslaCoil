package com.eamondo2;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class TeslaCoil extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable(){
		enableRecipe();
		Bukkit.getServer().getPluginManager().registerEvents(this,  this);
		
	}
	@Override
	public void onDisable(){
		
		
	}
	
	void enableRecipe(){
		
		
		
		
	}
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e){
		Player p = e.getPlayer();
		ItemStack h = e.getItemInHand();
		ItemMeta meta = null;
		if (h.hasItemMeta()){
			meta = h.getItemMeta();
		}
		String dispName = "Dirt";
		if (meta.getDisplayName().equals(dispName)){
			p.sendMessage("DEBUG");
			
		}
				
		
	}
	
	
	
	
	
	
	
}
