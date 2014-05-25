package com.eamondo2;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
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
	
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e){
		Player p = e.getPlayer();
		ItemStack h = e.getItemInHand();
		ItemMeta meta = null;
		
		boolean match = false;
		if (h.getType().equals(Material.IRON_BLOCK)){
			p.sendMessage("DEBUG");
			
				meta = h.getItemMeta();
				if (meta.hasDisplayName()){
					String compareTo = "TeslaCoil";
					if (meta.getDisplayName().equalsIgnoreCase(compareTo)){
						match = true;
						p.sendMessage("Correct block found");
					}	
				}
		}
		if (!match){
			return;
		}
		
		
				
		
	}
	void enableRecipe(){
		ItemStack stack = new ItemStack(Material.IRON_BLOCK);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("TeslaCoil");
		
		meta.setLore(Arrays.asList("A box of parts", "With which to build a TeslaCoil"));
		stack.setItemMeta(meta);
		ShapedRecipe recipe = new ShapedRecipe(stack);
		recipe.shape("#@#", "@$@", " _ ");
		recipe.setIngredient('#', Material.IRON_BLOCK);
		recipe.setIngredient('@', Material.REDSTONE_COMPARATOR);
		recipe.setIngredient('$', Material.QUARTZ_BLOCK);
		recipe.setIngredient('_', Material.PISTON_BASE);
		Bukkit.getServer().addRecipe(recipe);	
	}
	
	
	
	
	
	
}
