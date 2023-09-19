package com.company.Inventory;

public class Items {
    int id;
    private String name;
    private boolean isCollected = false;

    public Items(int id, String name, boolean isCollected) {
        this.id = id;
        this.name = name;
        this.isCollected = isCollected;
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

    public boolean isCollected() {
        return isCollected;
    }

    public void setCollected(boolean collected) {
        isCollected = collected;
    }
}
