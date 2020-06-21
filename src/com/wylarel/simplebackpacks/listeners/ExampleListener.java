package com.wylarel.simplebackpacks.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import com.wylarel.simplebackpacks.Main;

public class ExampleListener implements Listener {
	@SuppressWarnings("unused")
	private Main main;
	
	public ExampleListener(Main main) {
		this.main = main;
	}

	@EventHandler
	public void ProjectileLaunchEvent(ProjectileLaunchEvent e) {
	}
}
