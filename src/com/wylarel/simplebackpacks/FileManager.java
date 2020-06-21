package com.wylarel.simplebackpacks;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class FileManager {
    static File backpacksDataFile = new File("plugins/BackpackPlus", "data.yml");
    static FileConfiguration backpacksData = YamlConfiguration.loadConfiguration(backpacksDataFile);
    public static Main main;
    
	public static Map<String, Inventory> loadBackpacksContent() {
		Map<String, Inventory> inv = new HashMap<String, Inventory>();
		List<String> players = new ArrayList<String>();
		if(backpacksData.getConfigurationSection("data") != null)
			players.addAll(backpacksData.getConfigurationSection("data").getKeys(false));
				
		for (int i = 0; i < players.size(); i++) {
			@SuppressWarnings("unchecked")
			List<ItemStack> items = (List<ItemStack>) backpacksData.get("data." + players.get(i) + ".list");
			
			Inventory currentInv = Bukkit.createInventory((InventoryHolder) null, main.getConfig().getInt("backpack.slots"), main.getConfig().getString("backpack.gui_name"));

			for (int y = 0; y < currentInv.getSize(); y++) {
				if(items.size() > y)
					currentInv.setItem(y, items.get(y));
			}
			
			inv.put(players.get(i), currentInv);
		}
		
		System.out.println("The Backpacks loaded");
		return inv;
	}
	
	public static void saveBackpacksContent(Map<String,Inventory> inv) {
		List<String> keys = new ArrayList<String>();
		keys.addAll(inv.keySet());
		
		for (int i = 0; i < keys.size(); i++) {
			Inventory currentInv = inv.get(keys.get(i));
			
			ItemStack[] list = currentInv.getContents();
			
			backpacksData.set("data." + keys.get(i) + ".list", list);
			try {
				backpacksData.save(backpacksDataFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("The Backpacks saved");
	}
}
