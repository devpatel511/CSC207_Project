package models;

import java.io.Serializable;

public class MazeBoard implements Serializable {

    private int width; //board height and width
    private int height;

    protected boolean[][] mazeGrid; //board grid

    public MazeBoard(int width, int height)
    {
        this.height = height;
        this.width = width;

        this.mazeGrid = new boolean[width][height];
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean getGrid(int x, int y) {
        if (x >= width || x < 0 || y >= height || y < 0 || mazeGrid[x][y])
            return true;
        return false;
    }
}
