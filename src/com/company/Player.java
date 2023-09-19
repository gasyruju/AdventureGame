package com.company;

import com.company.Chars.Archer;
import com.company.Chars.GameChars;
import com.company.Chars.Knight;
import com.company.Chars.Samurai;
import com.company.Inventory.Armor;
import com.company.Inventory.Items;
import com.company.Inventory.Weapons;

import java.util.Random;
import java.util.Scanner;

public class Player {
    int damage;
    int defDamage;
    int health;
    int defHealth;
    int money;
    int block;
    boolean coward = false;
    String name;
    String charName;
    Weapons weapon = new Weapons(0, "Fist", 0, 0);
    Armor armor = new Armor(0, "N/A", 0, 0);
    public Scanner scan = new Scanner(System.in);


    Items meat = new Items( 1,"Meat", false);
    Items water = new Items(2,"Water", false);
    Items wood = new Items(3,"Wood", false);
    Items specItem = new Items(4, "Special Item", false);

    Items[] inventory = {meat, water, wood, specItem};


    public Player(String name) {
        this.name = name;
    }

    public void selectChar(){
        GameChars[] charList = {new Samurai(), new Archer(), new Knight()};

        for (GameChars x : charList){
            System.out.println("ID: " + x.getId() +
                    "\t\t Character: " + x.getCharName() +
                    "\t\t Damage: " + x.getDamage() +
                    "\t\t Health: " + x.getHealth() +
                    "\t\t Money: " + x.getMoney());
        }

        System.out.println("--- Please enter Character ID: --- ");
        int selectChar = scan.nextInt();

        if (selectChar == 1) {
            initPlayer(new Samurai());
        }
        else if (selectChar == 2){
            initPlayer(new Archer());
        }

        else if (selectChar == 3){
            initPlayer(new Knight());
        }
        else{
            System.out.println("--- Please Make Sure You Enter Character ID Correctly ---");
            this.selectChar();
        }

        System.out.println("Characters: " + getCharName() +
                            "\t\t Damage: " + getDamage() +
                            "\t\t Health: " + getHealth() +
                            "\t\t Money: " + getMoney() +
                            "\t\t Weapon: " + getWeapon().getName());

    }

    public void buyWeapon(Weapons weapon){
        if (this.getMoney() >= weapon.getPrice()){
            this.setWeapon(weapon);
            this.setMoney(this.getMoney() - weapon.getPrice());
            this.setDamage(this.getDefDamage() + weapon.getDamage());
            System.out.println("--- Transaction Approved ---");
            System.out.println("Available Fund: " + this.getMoney());
        }
    }

    public void buyArmor(Armor armor){
        if(this.getMoney() >= armor.getPrice()){
            this.setArmor(armor);
            this.setMoney(this.getMoney() - armor.getPrice());
            this.setBlock(this.getBlock() + armor.getBlock());
            System.out.println("--- Transaction Approved ---");
            System.out.println("Available Fund: " + this.getMoney());
        }
    }

    public void printInventory(){
        for (Items x : this.getInventory()){
            if (x.isCollected()){
                System.out.println(x.getId() + " - " +
                        x.getName() + " Is Collected");
            }
            else {
                System.out.println(x.getId() + " - " +
                        x.getName() + " Is Not Collected");
            }
        }
    }

    public Monsters generateMonster(int selMons){

        Random rand = new Random();


        if (selMons == 1){
            return new Monsters(1, "Zombie", 3, 10, meat, 4);
        }
        else if (selMons == 2){
            return new Monsters(2, "Snake", 4, 14, water, 7);
        }
        else if (selMons == 3){
            return new Monsters(3, "Bear", 7, 20, wood, 12);
        }
        else {
            return new Monsters(4, "Bat", rand.nextInt(3, 7), 12 , specItem, 0);
        }
    }

    public boolean playerAttack(Player player, Monsters monster){
        System.out.print(" <A>ttack or <R>un ");
        String selAct = scan.next().toUpperCase();

        if (selAct.equals("A")){
            System.out.println("You Attacked");
            monster.setHealth(monster.getHealth() - player.getDamage());

            if (monster.getHealth() <= 0) {
                monster.setHealth(0);
            }
            System.out.println("---------------");
            System.out.println("Enemy Health: " + monster.getHealth());
            System.out.println("Your Health: " + player.getHealth());
            System.out.println("---------------");

            if (monster.getHealth() <= 0) {
                player.setMoney(monster.getPrize() + player.getMoney());
                System.out.println("You slain an enemy");
                System.out.println();
                return true;
            }
        }
        else {
            System.out.println("--- You Escaped ---");
            this.setCoward(true);
            return true;
        }
        return false;
    }
    

    // Burada mantik hatasi var

    public boolean monsterAttack(Player player, Monsters monster){

        System.out.println("Enemy Attacked");

        int monsterDamage = monster.getDamage() - player.getBlock();

        if (monsterDamage < 0){
            monsterDamage = 0;
        }

        player.setHealth(player.getHealth() - monsterDamage);

        if (player.getHealth() <= 0){
            player.setHealth(0);
        }

        System.out.println("---------------");
        System.out.println("Enemy Health: " + monster.getHealth());
        System.out.println("Your Health: " + player.getHealth());
        System.out.println("---------------");

        if (player.getHealth() <= 0){
            System.out.println("--- You Died ---");
            return true;
        }
        return false;
    }

    public void combat(Player player, Monsters monster){

        Random rand = new Random();
        boolean yourTurn = rand.nextInt(2) != 0;

        if (yourTurn){
            while(player.getHealth() > 0 && monster.getHealth() > 0){
                if (playerAttack(player, monster)){
                    break;
                }
                else {
                    if (this.monsterAttack(player, monster)){
                        break;
                    }
                }
            }
        }

        else {
            while(player.getHealth() > 0 && monster.getHealth() > 0){
                if (monsterAttack(player, monster)){
                    break;
                }
                else {
                    if (this.playerAttack(player, monster)){
                        break;
                    }
                }
            }
        }

    }

    public void initPlayer(GameChars gameChar){
        this.setCharName(gameChar.getCharName());
        this.setDamage(gameChar.getDamage());
        this.setDefDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setDefHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
    }


    public int specialItem(){

        double x = Math.random()*100;

        if (x <= 15){
            return 1;
        }
        else if (x <= 30){
            return 2;
        }
        else if (x < 55){
            return 3;
        }
        else {
            return 4;
        }
    }

    public int specialItemSpec(){
        double x = Math.random()*100;

        if (x <= 20){                           // Rifle chance // Gold Armor // 10 gold
            return 1;
        }
        else if (x <= 50){                      // Gun chance // Chain Armor // 5 Gold
            return 2;
        }
        else {                                  // Sword chance // Leather Armor // 1 Gold
            return 3;
        }
    }


    public void specialItemChance() {
        int x = specialItem();
        int y = specialItemSpec();
        String itemName;

        Weapons sword = new Weapons(1, "Sword", 2, 5);
        Weapons gun = new Weapons(2, "Gun", 3, 35);
        Weapons rifle = new Weapons(3, "Rifle", 7, 45);

        Armor leather = new Armor(1, "Leather Armor", 2, 5);
        Armor chain = new Armor(2, "Chain Armor", 3, 30);
        Armor gold = new Armor(3, "Gold Armor ", 4, 40);


        if (x == 1){
            if (y == 1){
                itemName = "Rifle";

                if (this.weapon.getDamage() < rifle.getDamage()){
                    this.setWeapon(rifle);
                    this.setDamage(this.getDefDamage() + rifle.getDamage());
                }
                System.out.println("You Earn this Item " + itemName);
            }
            else if (y == 2){
                itemName = "Gun";

                if (this.weapon.getDamage() < gun.getDamage()){
                    this.setWeapon(gun);
                    this.setDamage(this.getDefDamage() + gun.getDamage());
                }
                System.out.println("You Earn this Item " + itemName);
            }
            else {
                itemName = "Sword";

                if (this.weapon.getDamage() < sword.getDamage()){
                    this.setWeapon(sword);
                    this.setDamage(this.getDefDamage() + sword.getDamage());
                }
                System.out.println("You Earn this Item " + itemName);
            }
        }
        else if (x == 2){
            if (y == 1){
                itemName = "Gold Armor";

                if (this.armor.getBlock() < gold.getBlock()){
                    this.setArmor(gold);
                    this.setBlock(gold.getBlock());
                }
                System.out.println("You Earn this Item " + itemName);
            }
            else if (y == 2){
                itemName = "Chain Armor";

                if (this.armor.getBlock() < chain.getBlock()){
                    this.setArmor(chain);
                    this.setBlock(chain.getBlock());
                }
                System.out.println("You Earn this Item " + itemName);
            }
            else {
                itemName = "Leather Armor";

                if (this.armor.getBlock() < leather.getBlock()){
                    this.setArmor(leather);
                    this.setBlock(leather.getBlock());
                }
                System.out.println("You Earn this Item " + itemName);
            }
        }
        else if (x == 3){
            if (y == 1){
                itemName = "10 Gold";
                this.setMoney(this.getMoney() + 10);
                System.out.println("You Earn this Item " + itemName);
            }
            else if (y == 2){
                itemName = "5 Gold";
                this.setMoney(this.getMoney() + 5);
                System.out.println("You Earn this Item " + itemName);
            }
            else {
                itemName = "1 Gold";
                this.setMoney(this.getMoney() + 1);
                System.out.println("You Earn this Item " + itemName);
            }
        }
        else {
            itemName = "You earned Nothing";
        }

        System.out.println(itemName);
    }



    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }

    public int getDefDamage() {
        return defDamage;
    }

    public void setDefDamage(int defDamage) {
        this.defDamage = defDamage;
    }

    public Items[] getInventory() {
        return inventory;
    }

    public void setInventory(Items[] inventory) {
        this.inventory = inventory;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public boolean isCoward() {
        return coward;
    }

    public void setCoward(boolean coward) {
        this.coward = coward;
    }

    public Items getMeat() {
        return meat;
    }

    public void setMeat(Items meat) {
        this.meat = meat;
    }

    public Items getWood() {
        return wood;
    }

    public void setWood(Items wood) {
        this.wood = wood;
    }

    public Items getWater() {
        return water;
    }

    public void setWater(Items water) {
        this.water = water;
    }

    public Items getSpecItem() {
        return specItem;
    }

    public void setSpecItem(Items specItem) {
        this.specItem = specItem;
    }
}
