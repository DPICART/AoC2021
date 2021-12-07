package main.java.fr.daart.ex06;

import main.java.fr.daart.AoC2021;

import java.util.*;

public class AoC06 extends AoC2021 {
    @Override
    public void run() {

        partOne();
        partTwo();
    }

    private void partOne() {
        var days = 80;
        var input = Arrays.stream(readInputAsString("input.txt").split(",")).mapToInt(Integer::parseInt).toArray();
        var tabFish = new long[9];
        for (int i : input) {
            tabFish[i]++;
        }

        for (int day = 0; day < days; day++) {
            long deadFishes = tabFish[0];
            // https://stackoverflow.com/questions/18638743/is-it-better-to-use-system-arraycopy-than-a-for-loop-for-copying-arrays/18638835
            System.arraycopy(tabFish, 1, tabFish, 0, 8);
            tabFish[6] += deadFishes;
            tabFish[8] = deadFishes;
        }

        var sum = Arrays.stream(tabFish).sum();

        System.out.println(sum);
    }

    private void partTwo() {
        var days = 256;
        var input = Arrays.stream(readInputAsString("input.txt").split(",")).mapToInt(Integer::parseInt).toArray();
        var tabFish = new long[9];
        for (int i : input) {
            tabFish[i]++;
        }

        for (int day = 0; day < days; day++) {
            long deadFishes = tabFish[0];
            System.arraycopy(tabFish, 1, tabFish, 0, 8);
            tabFish[6] += deadFishes;
            tabFish[8] = deadFishes;
        }

        var sum = Arrays.stream(tabFish).sum();

        System.out.println(sum);
    }
}
