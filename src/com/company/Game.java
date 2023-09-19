package com.company;

import com.company.Chars.Archer;
import com.company.Chars.GameChars;
import com.company.Chars.Knight;
import com.company.Chars.Samurai;
import com.company.Inventory.Items;
import com.company.Locations.*;
import com.company.Player;

import javax.tools.Tool;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Game {
    String playerName;

    Scanner scan = new Scanner(System.in);

    public void start(){

        System.out.println("---WELCOME---");
        System.out.println("---Please Enter Your Name---");
        String playerName = scan.nextLine();
        Player player = new Player(playerName);
        System.out.println("--- Welcome " + player.getName() + " ---");
        player.selectChar();

        SafeHouse safeHouse = new SafeHouse(player);
        ToolStore toolStore = new ToolStore(player);
        Cave cave = new Cave(player);
        River river = new River(player);
        Forest forest = new Forest(player);
        Mine mine = new Mine(player);


        boolean gameOver = false;

        while(!gameOver) {
            System.out.println();
            System.out.println("---------------------------------");
            System.out.println("--- Please Choose Destination ---");
            System.out.println("---------------------------------");
            System.out.println("1 - " + safeHouse.getName());
            System.out.println("2 - " + toolStore.getName());
            System.out.println("3 - " + cave.getName());
            System.out.println("4 - " + river.getName());
            System.out.println("5 - " + forest.getName());
            System.out.println("6 - " + mine.getName());
            System.out.println("0 - EXIT");

            int selLocNum = scan.nextInt();

            if (selLocNum == 1){
                if (!safeHouse.onLocation()){
                    gameOver = true;
                }
            }
            else if (selLocNum == 2){
                if (!toolStore.onLocation()){
                    gameOver = true;
                }
            }
            else if (selLocNum == 3){
                if (!cave.onLocation()){
                    gameOver = true;
                }
            }
            else if (selLocNum == 4){
                if (!river.onLocation()){
                    gameOver = true;
                }
            }
            else if (selLocNum == 5){
                if (!forest.onLocation()){
                    gameOver = true;
                }
            }
            else if (selLocNum == 6){
                if (!mine.onLocation()){
                    gameOver = true;
                }
            }
            else if (selLocNum == 0) {
                gameOver = true;
                System.out.println("!!! Coward Alert !!!");
            }

            else {
                System.out.println("--- Please Make Sure You Enter Destination Correctly ---");
            }

            System.out.println();
            System.out.println("Character: " + player.getCharName() +
                    "\t\t Damage: " + player.getDamage() +
                    "\t\t Health: " + player.getHealth() +
                    "\t\t Money: " + player.getMoney() +
                    "\t\t Weapon: " + player.getWeapon().getName() +
                    "\t\t Armor: " + player.getArmor().getName() +
                    "\t\t Block: " + player.getBlock());

            int sum = 0;
            for (Items x : player.getInventory()){
                if (x.isCollected()){
                    sum += 1;
                }
            }
            if (sum == 4){
                if (selLocNum == 1){
                    System.out.println("--- YOU WIN ---");
                    gameOver = true;
                }
            }
        }

    }
}
