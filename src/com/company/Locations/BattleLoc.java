package com.company.Locations;

import com.company.Player;

public abstract class BattleLoc extends Location {
    public BattleLoc(Player player, String name) {
        super(player, name);
    }
    @Override
    public boolean onLocation(){
        return true;
    }
}
