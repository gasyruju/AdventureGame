package com.company.Locations;

import com.company.Monsters;
import com.company.Player;

import java.awt.image.AffineTransformOp;
import java.util.Random;

public class Forest extends BattleLoc{

    Random rand = new Random();

    public Forest(Player player) {
        super(player, "Forest");

    }

    @Override
    public boolean onLocation(){
        if (!this.getPlayer().getWood().isCollected()){
            int selMons = rand.nextInt(2,4);
            for (int x = 0; x < selMons; x++){

                System.out.println("---" + (x+1) + ". Bear ---");

                Monsters monster = this.getPlayer().generateMonster(3);

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

            this.getPlayer().getInventory()[2].setCollected(true);
            this.getPlayer().printInventory();
        }
        return true;
    }
}
