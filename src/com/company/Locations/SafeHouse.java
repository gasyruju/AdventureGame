package com.company.Locations;

import com.company.Player;

public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation(){
        System.out.println("You're at safe !");
        System.out.println("You health restored !");
        this.getPlayer().setHealth(this.getPlayer().getDefHealth());
        return true;
    }
}
