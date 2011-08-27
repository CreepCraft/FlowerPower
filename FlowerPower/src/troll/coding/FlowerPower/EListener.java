package troll.coding.FlowerPower;

import java.util.List;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class EListener extends EntityListener{
	
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
		
		List<Entity> entt = ExplosionCause.getNearbyEntities(10, 10, 10);
		
		
		
		while (y < 30){ //Checks nearby entities, saves them into a list and loops through 25 entities (should be enough) /Pencil
		
			p = entt.get(y);
			
			if (p instanceof Player){
				
				y = 31;
			}else{
				
				y++;
			}
		} //end Entity check code
		
		
		final Entity pl = p;
		
		if (ExplosionCause instanceof Creeper){
			
			if (event.isCancelled() == true){
				
				return;
				
			}else{ 
				
				return;}
			
		}else{
			
			event.setCancelled(true); 
			
			final Entity squid = world.spawnCreature(loc, CreatureType.SQUID);
			
			p.getWorld().playEffect(loc, Effect.SMOKE, 31, 30);
			
			p.setPassenger(squid);
			SpawnFlowers.spawnFlowers(1, ExplosionCause.getWorld(), loc);
			
			final Location locc = p.getLocation();
			
			
			pl.teleport(locc.add(0, 1, 0));
			p.getWorld().playEffect(loc, Effect.SMOKE, 31, 30);
			
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() { //ugly but working (at least for me?) delayed squid pulling the player up. Also implemented the smoke effect, not quite satisfied yet tho :/ 

			    public void run() {

			    	pl.teleport(locc.add(0, 2, 0));
					pl.getWorld().playEffect(locc.add(0, 2, 0), Effect.SMOKE, 31, 30);
			    	
			    	plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {

					    	pl.teleport(locc.add(0, 3, 0));
							pl.getWorld().playEffect(locc.add(0, 3, 0), Effect.SMOKE, 31, 30);
					    	
					    	plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

							    public void run() {

							    	pl.teleport(locc.add(0, 4, 0));
									pl.getWorld().playEffect(locc.add(0, 4, 0), Effect.SMOKE, 31, 30);
							    	
							    	plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

									    public void run() {

									    	pl.teleport(locc.add(0, 5, 0));
											pl.getWorld().playEffect(locc.add(0, 5, 0), Effect.SMOKE, 31, 30);
											
									    	plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

											    public void run() {

											    	pl.teleport(locc.add(0, 6, 0));
													pl.getWorld().playEffect(locc.add(0, 6, 0), Effect.SMOKE, 31, 30);
											    	
											    	plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

													    public void run() {

													    	pl.teleport(locc.add(0, 7, 0));
															pl.getWorld().playEffect(locc.add(0, 7, 0), Effect.SMOKE, 31, 30);
													    	
													    	plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

															    public void run() {

															    	pl.teleport(locc.add(0, 8, 0));
																	pl.getWorld().playEffect(locc.add(0, 8, 0), Effect.SMOKE, 31, 30);
																	
															    	plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

																	    public void run() {

																	    	squid.remove(); //removes the squid and finishes the delayed task :)
																	    	
																	    	
																	    }
																	}, 5L);
															    }
															}, 5L);
															
													    }
													}, 5L);
													
											    }
											}, 5L);
											
									    }
									}, 5L);
									
							    }
							}, 5L);
							
					    }
					}, 5L);
					
			    	
			    	
			    }
			}, 2L);
			
		
			
	}
			
			
			
								
			
			
			
			
			
		}
			
		
}
		
		
		
	
	

