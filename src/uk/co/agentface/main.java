package uk.co.agentface;

import java.util.logging.Logger;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


class main extends JavaPlugin {
	Logger log = this.getLogger();
	Boolean isEnabled;
	Boolean isRunning;
	private RacesCommandExecutor CommandExecutor;
	public void onEnable(){ 
		if (isEnabled == true){
			getServer().getPluginManager().registerEvents(new PluginListener(), this);
			CommandExecutor = new RacesCommandExecutor(this);
			getCommand("races").setExecutor(CommandExecutor);
			isRunning = true;
			log.info("Races started up successfully.");
		}
		else{
		log.info("Races has been disabled in config.");
		}
	}
	 
	public void onDisable(){ 
		isRunning = false;
		log.info("Races has successfully shut down.");
	}
	public static boolean reload(){
		if(true){
			return true;
		} else {
			return false;
		}
	}
}
