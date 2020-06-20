package com.wylarel.backpacksplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.wylarel.backpacksplus.BackpackActions;
import com.wylarel.backpacksplus.Main;

@SuppressWarnings("unused")
public class BackPackCommand implements CommandExecutor {
	private Main main;

	public BackPackCommand(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(!sender.hasPermission("backpackcommand.use") || !(sender instanceof Player)) return false;
		BackpackActions.OpenBackpack((Player) sender);
		return true;
	}
}
