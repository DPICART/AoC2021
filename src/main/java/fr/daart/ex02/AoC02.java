package main.java.fr.daart.ex02;

import main.java.fr.daart.AoC2021;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AoC02 extends AoC2021 {

    @Override
    public void run() {

        partOne();
        partTwo();

    }


    void partOne() {
        int depth = 0;
        int horizontal = 0;

        List<String> moves = readInput("input.txt");

        for (var m : moves) {
            var tab = m.split(" ");
            var verb = tab[0];
            var qtt = Integer.parseInt(tab[1]);

            switch (verb) {
                case "forward":
                    horizontal += qtt;
                    break;
                case "down":
                    depth += qtt;
                    break;
                case "up":
                    depth -= qtt;
                    break;
                case "backward":
                    horizontal -= qtt;
                    break;
                default:
                    System.out.println("Failed " + verb + " " + qtt);
            }

        }
        System.out.println("depth " + depth + " horizontal " + horizontal + " product " + depth * horizontal);

    }

    void partTwo() {
        int depth = 0;
        int horizontal = 0;
        int aim = 0;

        List<String> moves = readInput("input.txt");

        for (var m : moves) {
            var tab = m.split(" ");
            var verb = tab[0];
            var qtt = Integer.parseInt(tab[1]);

            switch (verb) {
                case "forward":
                    horizontal += qtt;
                    depth += (aim * qtt);
                    break;
                case "down":
                    aim += qtt;
                    break;
                case "up":
                    aim -= qtt;
                    break;
                case "backward":
                    horizontal -= qtt;
                    break;
                default:
                    System.out.println("Failed " + verb + " " + qtt);
            }

        }
        System.out.println("depth " + depth + " horizontal " + horizontal + " product " + depth * horizontal);
    }

}
