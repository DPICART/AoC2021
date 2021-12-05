package main.java.fr.daart.ex04;

public class Cell {

    int poxX;
    int poxY;
    String value;

    boolean marked;

    public Cell(int poxX, int poxY, String value) {
        this.poxX = poxX;
        this.poxY = poxY;
        this.value = value;
    }

    public boolean setMarked(String number) {
        if(this.value.equals(number)) {
            this.marked = true;
        }
        return this.marked;
    }
}
