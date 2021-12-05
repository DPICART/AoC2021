package main.java.fr.daart.ex04;

import main.java.fr.daart.AoC2021;

import java.util.ArrayList;
import java.util.List;

public class AoC04 extends AoC2021 {
    @Override
    public void run() {

        //partOne();
        partTwo();
    }

    private void partOne() {

        List<String> values = readInput("input.txt");

        String line = values.get(0);
        String numbers[] = line.split(",");

        List<Board> boards = new ArrayList<>();
        List<Cell> cells = new ArrayList<>();
        int x = 0;
        int y = 0;
        for (int i = 2; i < values.size(); i++) {

            String currentLine = values.get(i);
            currentLine = currentLine.trim().replace("  ", " ");
            if (currentLine.equals("")) {
                x = 0;
                y = 0;
                Board board = new Board(5, cells);
                boards.add(board);
                cells = new ArrayList<>();
            } else {
                String[] cellVal = currentLine.split(" ");
                for (int c = 0; c < cellVal.length; c++) {
                    String currentValue = cellVal[c];
                    currentValue = currentValue.trim().replace("  ", " ");
                    cells.add(new Cell(x++, y, currentValue));
                }
                x = 0;
                y++;
            }


        }
        Board board = new Board(5, cells);
        boards.add(board);
        cells = null;

        List<Integer> winnerBoard = boards.stream()
                .map(b -> b.checkVictory(numbers))
                .toList();

        int min = Integer.MAX_VALUE;
        int winner = -1;
        for(int i = 0; i < winnerBoard.size(); i++) {
            if(min > winnerBoard.get(i)) {
                min = winnerBoard.get(i);
                winner = i;
            }
        }

        var hey = boards.get(winner);

        System.out.println(hey.getSumUnmarked()+" * "+hey.getLastMarked()+" = "+hey.getSumUnmarked() * hey.getLastMarked());
    }

    private void partTwo() {

        List<String> values = readInput("input.txt");

        String line = values.get(0);
        String numbers[] = line.split(",");

        List<Board> boards = new ArrayList<>();
        List<Cell> cells = new ArrayList<>();
        int x = 0;
        int y = 0;
        for (int i = 2; i < values.size(); i++) {

            String currentLine = values.get(i);
            currentLine = currentLine.trim().replace("  ", " ");
            if (currentLine.equals("")) {
                x = 0;
                y = 0;
                Board board = new Board(5, cells);
                boards.add(board);
                cells = new ArrayList<>();
            } else {
                String[] cellVal = currentLine.split(" ");
                for (int c = 0; c < cellVal.length; c++) {
                    String currentValue = cellVal[c];
                    currentValue = currentValue.trim().replace("  ", " ");
                    cells.add(new Cell(x++, y, currentValue));
                }
                x = 0;
                y++;
            }


        }
        Board board = new Board(5, cells);
        boards.add(board);
        cells = null;

        List<Integer> winnerBoard = boards.stream()
                .map(b -> b.checkVictory(numbers))
                .toList();

        int max = Integer.MIN_VALUE;
        int winner = -1;
        for(int i = 0; i < winnerBoard.size(); i++) {
            if(max <  winnerBoard.get(i)) {
                max = winnerBoard.get(i);
                winner = i;
            }
        }

        var hey = boards.get(winner);

        System.out.println(hey.getSumUnmarked()+" * "+hey.getLastMarked()+" = "+hey.getSumUnmarked() * hey.getLastMarked());
    }

}
