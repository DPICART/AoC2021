package main.java.fr.daart.ex04;

import java.util.ArrayList;
import java.util.List;

public class Board {

    int width = 5;
    int sumUnmarked = 0;
    int lastMarked = 0;
    List<Cell> cells = new ArrayList<>();

    public Board(int width, List<Cell> cells) {
        this.width = width;
        this.cells = cells;
    }

    public int checkVictory(String[] numbers) {
        int turn = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int c = 0; c < cells.size(); c++) {
                if (cells.get(c).setMarked(numbers[i])) {
                    if (this.isComplete()) {
                        this.sumUnmarked = computeUnmarked();
                        this.lastMarked = Integer.parseInt(cells.get(c).value);
                        return turn;
                    }
                }
            }
            turn++;
        }
        return turn;
    }

    private int computeUnmarked() {
        int sum = 0;
        for(Cell c : cells) {
            if(!c.marked) {
                sum += Integer.parseInt(c.value);
            }
        }
        return sum;
    }

    private boolean isComplete() {
        int maxX = width;
        int maxY = cells.size() / width;

        int sumX = 0;
        int sumY = 0;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < maxY; y++) {
                int index = x + y * width;
                Cell c = cells.get(index);
                if (c.marked) {
                    sumX++;
                }
            }
            if (sumX == maxX) {
                return true;
            }
            sumX = 0;
        }

        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < width; x++) {
                int index = x + y * width;
                Cell c = cells.get(index);
                if (c.marked) {
                    sumY++;
                }
            }
            if (sumY == maxY) {
                return true;
            }
            sumY = 0;
        }

        return false;
    }

    public int getSumUnmarked() {
        return sumUnmarked;
    }

    public int getLastMarked() {
        return lastMarked;
    }
}
