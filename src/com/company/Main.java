package com.company;

import com.company.Chars.Archer;
import com.company.Chars.GameChars;
import com.company.Chars.Knight;
import com.company.Chars.Samurai;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

	    Game game = new Game();
        game.start();

    }
}
