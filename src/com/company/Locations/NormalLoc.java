package com.company.Locations;

import com.company.Player;

public abstract class NormalLoc extends Location{
    public NormalLoc(Player player, String name) {
        super(player, name);
    }

    @Override
    boolean onLocation(){
        return true;
    }

}
