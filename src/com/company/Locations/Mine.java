package com.company.Locations;

import com.company.Monsters;
import com.company.Player;

import java.util.Random;

public class Mine extends BattleLoc{

    public Mine(Player player) {
        super(player, "Mine");
    }

    Random rand = new Random();

    @Override
    public boolean onLocation() {
        if (!this.getPlayer().getSpecItem().isCollected()){
            int selMons = rand.nextInt(2,8);
            for (int x = 0; x < selMons; x++) {

                System.out.println("---" + (x + 1) + ". Bat ---");

                Monsters monster = this.getPlayer().generateMonster(4);

                this.getPlayer().combat(this.getPlayer(), monster);

                if (this.getPlayer().getHealth() > 0) {
                    if (this.getPlayer().isCoward()) {
                        return true;
                    }
                } else if (this.getPlayer().getHealth() <= 0) {
                    return false;
                }
            }

            this.getPlayer().getInventory()[3].setCollected(true);
            this.getPlayer().specialItemChance();
            this.getPlayer().printInventory();
        }
        else {
            System.out.println("--- You Already Clear This Area ---");
            System.out.println();
        }
        return true;
    }
}
