package com.company.Locations;

import com.company.Monsters;
import com.company.Player;

import java.util.Random;

public class River extends BattleLoc{

    Random rand = new Random();

    public River(Player player) {
        super(player, "River");
    }

    @Override
    public boolean onLocation(){
        if (!this.getPlayer().getWater().isCollected()){
            int selMons = rand.nextInt(2,5);
            for (int x = 0; x < selMons; x++){

                System.out.println("---" + (x+1) + ". Snake ---");

                Monsters monster = this.getPlayer().generateMonster(2);

                this.getPlayer().combat(this.getPlayer(), monster);

                if (this.getPlayer().getHealth() > 0){
                    if (this.getPlayer().isCoward()){
                        return true;
                    }
                }
                else if (this.getPlayer().getHealth() <= 0){
                    return false;
                }
            }
            this.getPlayer().getInventory()[1].setCollected(true);
            this.getPlayer().printInventory();
        }
        return true;
    }

}
