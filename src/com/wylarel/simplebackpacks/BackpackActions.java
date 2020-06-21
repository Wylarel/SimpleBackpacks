package com.wylarel.simplebackpacks;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class BackpackActions {
	public static Main main;
	
	public static void OpenBackpack(Player p) {
		if(main.getConfig().getBoolean("teamchest.chest.sound"))
		{
			p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 0.5f, 1f);
		}
		
		Inventory gui = main.backpacks.get(p.getUniqueId().toString());
		if(gui == null)
		{
			gui = Bukkit.createInventory((InventoryHolder) null, main.getConfig().getInt("backpack.slots"), main.getConfig().getString("backpack.gui_name"));
			main.backpacks.put(p.getUniqueId().toString(), gui);
		}
		
		p.openInventory(gui);
	}
}
