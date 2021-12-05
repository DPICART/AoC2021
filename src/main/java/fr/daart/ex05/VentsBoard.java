package main.java.fr.daart.ex05;

import java.util.List;

public class VentsBoard {

    List<String> lines;
    List<VentPath> paths;
    int maxX;
    int maxY;
    int[][] tab;

    public VentsBoard() {
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public void parsePaths() {
        this.paths = lines.stream().map(VentPath::new).toList();
        this.maxX = paths.stream().max((p1, p2) -> Integer.compare(p1.getToX(), p2.getToX())).stream().findFirst().get().toX + 2;
        this.maxY = paths.stream().max((p1, p2) -> Integer.compare(p1.getToY(), p2.getToY())).stream().findFirst().get().toY + 2;
    }

    public void createTab() {
        tab = new int[maxX + 1][maxY + 1];
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxX; y++) {
                tab[x][y] = 0;
            }
        }
    }

    public void applyPaths() {
        for (VentPath path : paths) {
            System.out.println(path.toString());
            applyPathToTab(path);
        }
    }

    private void applyPathToTab(VentPath path) {

        if (path.isHorizontal()) {
            int from = Math.min(path.fromX, path.toX);
            int to = Math.max(path.fromX, path.toX);
            for (int i = from; i <= to; i++) {
                tab[path.fromY][i] += 1;
            }
        } else if (path.isVertical()) {
            int from = Math.min(path.fromY, path.toY);
            int to = Math.max(path.fromY, path.toY);
            for (int j = from; j <= to; j++) {
                tab[j][path.toX] += 1;
            }
        } else if (path.isDiagonal()) {
            // 2,6 -> 4,2
            // 2,0 -> 4,2
            int currentX = path.fromX;
            int currentY = path.fromY;
            int xInc = 1;
            int yInc = 1;
            if (path.fromX > path.toX) {
                xInc = -1;
            }
            if (path.fromY > path.toY) {
                yInc = -1;
            }

            tab[currentY][currentX] += 1;
            while (currentX != path.toX) {
                currentX += xInc;
                currentY += yInc;
                tab[currentY][currentX] += 1;
            }
        }
    }

    public int getOverlaps(int limit) {

        int count = 0;
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxX; y++) {
                if (tab[x][y] >= limit) {
                    count++;
                }
            }
        }
        return count;
    }
}
