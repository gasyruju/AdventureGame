package com.company;

import com.company.Inventory.Items;

import java.time.ZonedDateTime;
import java.util.Random;
import java.util.Scanner;

public class Monsters {

    Scanner scan = new Scanner(System.in);

    private int id;
    private String name;
    private int damage;
    private int health;
    private Items reward;
    private int defHealth;
    private int prize;

    public Monsters(int id, String name, int damage, int health, Items reward, int prize) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.reward = reward;
        this.prize = prize;
        this.defHealth = health;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Items getReward() {
        return reward;
    }

    public void setReward(Items reward) {
        this.reward = reward;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }
}
