package com.wylarel.simplebackpacks;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import com.wylarel.simplebackpacks.commands.BackPackCommand;

public class Main extends JavaPlugin {
    public Map <String, Inventory> backpacks = new HashMap<String, Inventory>();

	@Override
	public void onEnable() {
		saveDefaultConfig();
		System.out.println("Simple Backpacks started");
		getCommand("backpack").setExecutor(new BackPackCommand(this));
		//getServer().getPluginManager().registerEvents(new ExampleListener(this), this);
		BackpackActions.main = this;
		FileManager.main = this;
		
		backpacks = FileManager.loadBackpacksContent();
	}
	
	@Override
	public void onDisable() {
		System.out.println("Simple Backpacks stopped");
		FileManager.saveBackpacksContent(backpacks);
	}
}
	