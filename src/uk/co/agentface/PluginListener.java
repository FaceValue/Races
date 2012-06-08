package uk.co.agentface;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

class PluginListener implements Listener {
	private main Main;
	public PluginListener(main main) {
		Main = main;
	}
	public Map<Player, String> PlayerRaces = Main.PlayerRaces;
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event) {
		if(!PlayerRaces.containsKey(event.getPlayer())){
			PlayerRaces.put(event.getPlayer(), "Human");
		}
	}
}
