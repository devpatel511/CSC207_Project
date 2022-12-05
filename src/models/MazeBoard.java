package src.models;

import java.io.Serializable;

public class MazeBoard implements Serializable {

    private int width; //board height and width
    private int height;

    protected int[][] mazeGrid; //board grid

    public MazeBoard(int width, int height) {
        this.height = height;
        this.width = width;

        this.mazeGrid = new int[width][height];
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                mazeGrid[i][j] = 0;
            }
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int[][] getMazeGrid() {
        return mazeGrid;
    }

    public void setPath() {
        int i = 0;
        int j = 0;
        while (i < this.width && j < this.height) {
            this.mazeGrid[i][j] = 1;
            if (Math.round(Math.random()) == 0) {
                i += 1;
            } else {
                j += 1;
            }
        }
        if (i >= this.width) {
            while (j < this.height) {
                this.mazeGrid[this.width - 1][j] = 1;
                j++;
            }
        } else {
            while (i < this.width) {
                this.mazeGrid[i][this.height - 1] = 1;
                i++;
            }
        }
    }

    public void makeWalls() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if (mazeGrid[i][j] != 1) {
                    if (Math.round(Math.random()) == 0) {
                        this.mazeGrid[i][j] = 2;
                    }
                }
            }
        }
        this.mazeGrid[0][0] = 4;
    }
}
