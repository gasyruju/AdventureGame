package com.company.Locations;

import com.company.Monsters;
import com.company.Player;

import java.util.Random;

public class Cave extends BattleLoc{

    Random rand = new Random();

    public Cave(Player player) {
        super(player, "Cave");
    }

    @Override
    public boolean onLocation(){
        if (!this.getPlayer().getMeat().isCollected()){
            int selMons = rand.nextInt(1,5);
            for (int x = 0; x < selMons; x++) {

                System.out.println("---" + (x + 1) + ". Zombie ---");

                Monsters monster = this.getPlayer().generateMonster(1);

                this.getPlayer().combat(this.getPlayer(), monster);

                if (this.getPlayer().getHealth() > 0) {
                    if (this.getPlayer().isCoward()) {
                        return true;
                    }
                } else if (this.getPlayer().getHealth() <= 0) {
                    return false;
                }
            }

            this.getPlayer().getInventory()[0].setCollected(true);
            this.getPlayer().printInventory();
        }
        return true;
    }

}
