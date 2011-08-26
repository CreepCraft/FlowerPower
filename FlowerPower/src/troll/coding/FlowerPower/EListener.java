package troll.coding.FlowerPower;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
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
			


	
		int y = 0;
		
		Entity ExplosionCause = event.getEntity();
		
		Location loc = ExplosionCause.getLocation();
		
		World world = ExplosionCause.getWorld();
		
		Entity p = null;
		int up = 0;
		
		List<Entity> entt = ExplosionCause.getNearbyEntities(5, 5, 5);
		
		
		
		while (y < 25){
		
			p = entt.get(y);
			
			if (p instanceof Player){
				
				y = 26;
			}else{
				
				y++;
			}
		}
		
		
		
		if (event.isCancelled() == true){
			
			return;
			
		}else{
		
		
		if (ExplosionCause instanceof Creeper){
			
		return;
			
		}else{
			
			event.setCancelled(true); 
			
			Entity squid = world.spawnCreature(loc, CreatureType.SQUID);
			
			
			p.setPassenger(squid);
			SpawnFlowers.spawnFlowers((Player) event.getEntity(), 10, p.getWorld(), p.getLocation());
			
			Location locc = p.getLocation();
			
			
			
			for (up = 0; up > 10; up++) {
				
			locc.setY(y+2);
			}
			
			
			
			
			
			
			
			
		}
		
		
		}
		
		
	}
	}
	

