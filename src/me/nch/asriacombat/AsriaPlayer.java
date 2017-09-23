package me.nch.asriacombat;

import me.nch.asriacombat.utils.ChatUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class AsriaPlayer {

    private final String UUID;

    private int health;
    private Location lastLocation;

    public AsriaPlayer(String UUID, int health) {
        this.UUID = UUID;
        this.health = health;
    }

    public boolean locationCheck(Location l) {
        if (lastLocation != null) {
            return l.getX() == lastLocation.getX() && l.getY() == lastLocation.getY() &&
                    l.getZ() == lastLocation.getZ() && l.getWorld().getName() == lastLocation.getWorld().getName();

        }
        return false;
    }

    public String getUUID() {
        return UUID;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        Player p = AsriaCombat.getPlayerFromUUID(UUID);
        if (p != null) {
            if (health >= 20) {
                p.setFoodLevel(20);
                this.health = 20;
                return;
            } else if (health <= 0) {
                //TODO Do something when someone loses all their health?
                this.health = 0;
                p.setFoodLevel(0);
                return;
            }
            p.setFoodLevel(health);
            this.health = health;
        }
        //TODO Handle when a player runs out of health.
    }

    public Location getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(Location lastLocation) {
        this.lastLocation = lastLocation;
    }
}