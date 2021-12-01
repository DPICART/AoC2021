package main.java.fr.daart.ex01;

import main.java.fr.daart.AoC2021;

import java.util.ArrayList;
import java.util.List;

public class AoC01 extends AoC2021 {

    @Override
    public void run() {

        partOne();
        partTwo();

    }


    void partOne() {
        var list = readInput("input.txt");
        var previous = Integer.MAX_VALUE;
        var increased = 0;
        for(int i = 0; i < list.size(); i++) {
            var current = Integer.parseInt(list.get(i));
            if(current > previous) {
                increased++;
            }
            previous = current;
        }
        System.out.println(increased);
        // 1139
    }

    void partTwo() {
        var list = readInput("input.txt");

        List<Integer> newList = new ArrayList<>();

        for(int i = 2; i < list.size(); i++) {
            var newVal = Integer.parseInt(list.get(i-2)) + Integer.parseInt(list.get(i-1)) + Integer.parseInt(list.get(i));
            newList.add(newVal);
        }

        var previous = Integer.MAX_VALUE;
        var increased = 0;
        for(int i = 0; i < newList.size(); i++) {
            var current = newList.get(i);
            if(current > previous) {
                increased++;
            }
            previous = current;
        }
        System.out.println(increased);
        // 1103
    }

}
