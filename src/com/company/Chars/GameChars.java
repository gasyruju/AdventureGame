package com.company.Chars;

public abstract class GameChars {
    private final String charName;
    private final int damage;
    private final int health;
    private final int money;
    private final int id;


    public GameChars(int id, String charName, int damage, int health, int money) {
        this.charName = charName;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.id = id;
    }

    public String getCharName() {
        return charName;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }

    public int getId() {
        return id;
    }
}
