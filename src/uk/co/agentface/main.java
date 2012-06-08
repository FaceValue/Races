package uk.co.agentface;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


class main extends JavaPlugin {
	Logger log = this.getLogger();
	Boolean isEnabled;
	Boolean isRunning;
	Exception thrown;
	private RacesCommandExecutor CommandExecutor;
	public Map<Player, String> PlayerRaces = new HashMap<Player, String>();
	public void onEnable(){ 
		if (isEnabled == true){
			getServer().getPluginManager().registerEvents(new PluginListener(this), this);
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
		try{
			SLAPI.save(PlayerRaces, "Races/playerdata");
		} catch(Exception e){
    		System.out.println("Exception : "+ e.getMessage());
    	}
		isRunning = false;
		log.info("Races has successfully shut down.");
	}
	public boolean restart(){
		if(true){
			this.onDisable();
			this.onEnable();
			log.info("Races has successfully rebooted.");
			return true;
		} else {
			return false;
		}
	}
}
