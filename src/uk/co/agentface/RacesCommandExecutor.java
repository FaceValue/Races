package uk.co.agentface;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RacesCommandExecutor implements CommandExecutor {
	private main Main;
	public RacesCommandExecutor(main main) {
		this.Main = main;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		Player player = null;
		if (sender instanceof Player) {
			player = (Player) sender;
		}
		if(cmd.getName().equalsIgnoreCase("races")){ 
			if (player == null){
				sender.sendMessage("Console commands are not yet supported. Please login to use the commands.");
			} else {
				if(commandLabel.equalsIgnoreCase("?")){
					showHelp(sender);
				}
				else if(commandLabel.equalsIgnoreCase("restart")){
					Main.restart();
				}
			}
			return true;
		} 
		return false; 
	}
	public boolean permCheck(CommandSender sender, String perm){
		if(sender.hasPermission(perm)){
			return true;
		} else {
			sender.sendMessage("You lack the" + perm + "permission required for this action.");
			return false;
		}
	}
	public void showHelp (CommandSender sender){
		String msg = "Races Help is not yet implemented";
		if (sender instanceof Player){	
			if(permCheck(sender, "races.help")){
				sender.sendMessage(msg);
			}
		} else {
			sender.sendMessage(msg);
		}
	}
}
