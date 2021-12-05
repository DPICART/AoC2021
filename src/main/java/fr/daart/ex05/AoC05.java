package main.java.fr.daart.ex05;

import main.java.fr.daart.AoC2021;

import java.util.List;

public class AoC05 extends AoC2021 {
    @Override
    public void run() {
        partOne();
//        partTwo();
    }
    private void partOne() {

        List<String> input = readInput("input.txt");

        VentsBoard ventsBoard = new VentsBoard();
        ventsBoard.setLines(input);
        ventsBoard.parsePaths();
        ventsBoard.createTab();
        ventsBoard.applyPaths();

        int over = ventsBoard.getOverlaps(2);

        System.out.println(over);
    }

    private void partTwo() {

    }

}
