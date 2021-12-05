package main.java.fr.daart.ex05;

public class VentPath {

    String raw;
    int fromX;
    int fromY;

    int toX;
    int toY;

    // 0,9 -> 5,9
    public VentPath(String raw) {
        this.raw = raw;
        var input = raw.replace(" ", "");
        var tab = input.split("->");
        var from = tab[0].split(",");
        var to = tab[1].split(",");
        this.fromX = Integer.parseInt(from[0]);
        this.fromY = Integer.parseInt(from[1]);
        this.toX = Integer.parseInt(to[0]);
        this.toY = Integer.parseInt(to[1]);
    }

    public int getToX() {
        return toX;
    }

    public int getToY() {
        return toY;
    }

    public boolean isHorizontal() {
        return this.fromX != this.toX && this.fromY == this.toY;
    }

    public boolean isVertical() {
        return this.fromX == this.toX && this.fromY != this.toY;
    }

    public boolean isDiagonal() {
        return this.fromX != this.toX && this.fromY != this.toY;
    }

    @Override
    public String toString() {
        return raw;
    }
}
