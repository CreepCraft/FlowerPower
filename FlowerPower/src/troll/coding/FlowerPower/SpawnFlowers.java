package troll.coding.FlowerPower;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class SpawnFlowers
	{

		private void spawnFlowers(Player player, int radius, World world, Location loc) {
			
			Block b;
			int blocks = 0;
			double x1 = Math.round(loc.getX() - radius), y1 = Math.round(loc.getY() - radius), z1 = Math.round(loc.getZ() - radius), x2 = Math.round(loc.getX() + radius), y2 = Math.round(loc.getY() + radius), z2 = Math.round(loc.getZ() + radius);

			for (int x = 0; (x1 + x) <= x2; x++) {
				for (int y = 0; (y1 + y) <= y2; y++) {
					for (int z = 0; (z1 + z) <= z2; z++) {

						if (world.getBlockTypeIdAt(new Location(world, x1 + x, y1 + y, z1 + z)) == 2 && world.getBlockTypeIdAt(new Location(world, x1 + x, (y1 + y) + 1, z1 + z)) == 0) {
							world.getBlockAt(new Location(world, x1 + x, (y1 + y) + 1, z1 + z)).setTypeId(28);
							blocks++;
						}
					}
				}
			}
		}

	}
