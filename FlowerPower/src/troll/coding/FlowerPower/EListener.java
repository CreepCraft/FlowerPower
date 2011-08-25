package troll.coding.FlowerPower;

import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class EListener extends EntityListener{
	private FlowerPower plugin;
	
	public EListener(FlowerPower plugin) {
		this.plugin = plugin;

	}

	
	public void onExplosionPrime(ExplosionPrimeEvent event){		
			
plugin.getServer().broadcastMessage("explosion!");


			event.setRadius(0);
		
	}
	
	
}
