package troll.coding.FlowerPower;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FlowerPower extends JavaPlugin{
	
	
	private final EListener entityListener = new EListener(this);
	public static final Logger log = Logger.getLogger("Minecraft");	
	

	@Override
	public void onDisable() {
		log.info("FlowerPower" + "version" + getDescription().getVersion()
				+ " by iPhysX, iPencil & Kohle" + " disabled!");
		
	}

	@Override
	public void onEnable() {
		
		log.info("FlowerPower" + "version" + getDescription().getVersion()
				+ " by iPhysX, iPencil & Kohle" + " enabled!");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.EXPLOSION_PRIME, entityListener,
				Event.Priority.Highest, this); //Because I wasn't cool enough to actually make an ANTI TNT plugin, does this also call when TNT explodes? I'm not 100% sure edit: NVM! :)
	}

}
