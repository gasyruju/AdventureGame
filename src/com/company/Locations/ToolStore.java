package com.company.Locations;

import com.company.Inventory.Armor;
import com.company.Inventory.Items;
import com.company.Inventory.Weapons;
import com.company.Player;

import java.util.Scanner;
import java.util.SortedMap;

public class ToolStore extends NormalLoc{

    Scanner scan = new Scanner(System.in);

    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    Weapons sword = new Weapons(1, "Sword", 2, 25);
    Weapons gun = new Weapons(2, "Gun", 3, 35);
    Weapons rifle = new Weapons(3, "Rifle", 7, 45);

    Weapons[] weapons = {sword, gun, rifle};


    Armor leather = new Armor(1, "Leather Armor", 1, 15);
    Armor chain = new Armor(2, "Chain Armor", 3, 25);
    Armor gold = new Armor(3, "Gold Armor ", 5, 40);

    Armor[] armors = {leather, chain, gold};

    @Override
    public boolean onLocation(){
        System.out.println("--- Welcome to Store ---");

        while (true){

            printPage();
            int selPage = scan.nextInt();

            if (selPage == 1){
                printWeapons();
                int selWeapon = scan.nextInt();

                if (selWeapon == 1){
                    if (this.getPlayer().getWeapon() == sword){
                        System.out.println("--- You already have this weapon ---");
                    }
                    else if (this.getPlayer().getMoney() < sword.getPrice()){
                        System.out.println("--- Insufficient Balance ---");
                    }
                    else{
                        this.getPlayer().buyWeapon(sword);
                        if (this.getPlayer().getWeapon() == sword){
                            break;
                        }
                    }

                }
                else if (selWeapon == 2){
                    if (this.getPlayer().getWeapon() == gun){
                        System.out.println("--- You already have this weapon ---");
                    }
                    else if (this.getPlayer().getMoney() < gun.getPrice()){
                        System.out.println("--- Insufficient Balance ---");
                    }
                    else{
                        this.getPlayer().buyWeapon(gun);
                        if (this.getPlayer().getWeapon() != gun){
                            break;
                        }

                    }
                }
                else if (selWeapon == 3){
                    if (this.getPlayer().getWeapon() == rifle){
                        System.out.println("--- You already have this weapon ---");
                    }
                    else if (this.getPlayer().getMoney() < rifle.getPrice()){
                        System.out.println("--- Insufficient Balance ---");
                    }
                    else{
                        this.getPlayer().buyWeapon(rifle);
                        if (this.getPlayer().getWeapon() == rifle){
                            break;
                        }
                    }
                }
                else if (selWeapon == 4){
                    break;
                }
            }
            else if (selPage == 2){
                printArmors();
                int selArmor = scan.nextInt();

                if (selArmor == 1){
                    if (this.getPlayer().getArmor() == leather){
                        System.out.println("--- You already have this Armor ---");
                    }
                    else if (this.getPlayer().getMoney() < leather.getPrice()){
                        System.out.println("--- Insufficient Balance ---");
                    }
                    else{
                        this.getPlayer().buyArmor(leather);
                        if (this.getPlayer().getArmor() == leather){
                            break;
                        }
                    }

                }
                else if (selArmor == 2){
                    if (this.getPlayer().getArmor() == chain){
                        System.out.println("--- You already have this Armor ---");
                    }
                    else if (this.getPlayer().getMoney() < chain.getPrice()){
                        System.out.println("--- Insufficient Balance ---");
                    }
                    else{
                        this.getPlayer().buyArmor(chain);
                        if (this.getPlayer().getArmor() != chain){
                            break;
                        }

                    }
                }
                else if (selArmor == 3){
                    if (this.getPlayer().getArmor() == gold){
                        System.out.println("--- You already have this Armor ---");
                    }
                    else if (this.getPlayer().getMoney() < gold.getPrice()){
                        System.out.println("--- Insufficient Balance ---");
                    }
                    else{
                        this.getPlayer().buyArmor(gold);
                        if (this.getPlayer().getArmor() == gold){
                            break;
                        }
                    }
                }
                else if (selArmor == 4){
                    break;
                }
            }
            else {
                return true;
            }
        }
        return true;
    }

    public void printWeapons(){
        for (Weapons x : weapons){
            System.out.println(x.getId() + " - " +
                    x.getName() + " \t\tDamage: " +
                    x.getDamage() + " \t\tPrice: " +
                    x.getPrice());
        }
        System.out.println("4 - EXIT");
    }

    public void printArmors(){
        for (Armor x : armors){
            System.out.println(x.getId() + " - " +
                    x.getName() + " \t\tBlock: " +
                    x.getBlock() + " \t\tPrice: " +
                    x.getPrice());
        }
        System.out.println("4 - EXIT");
    }


    public void printPage(){
        System.out.println(1 + " - Weapons");
        System.out.println(2 + " - Armors");
        System.out.println(3 + " - EXIT");
    }

}
