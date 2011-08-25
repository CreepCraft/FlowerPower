package troll.coding.FlowerPower;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class EListener extends EntityListener{
	@SuppressWarnings("unused")
	private FlowerPower plugin;
	
	public EListener(FlowerPower plugin) {
		this.plugin = plugin;

	}

	
	@Override
	public void onExplosionPrime(ExplosionPrimeEvent event){		
			

		Entity ExplosionCause = event.getEntity();
		
		
		
		if (event.isCancelled() == true){
			
			return;
			
		}else{
		
		
		if (ExplosionCause instanceof Creeper){
			
		return;
			
		}else{
			
			event.setCancelled(true); //start trolling the shit out of the player!
		}
		
		
	}
	}
	
}
