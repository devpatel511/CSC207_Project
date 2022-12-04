package models;

import java.io.Serializable;

public class MazeModel implements Serializable {
    public static final int WIDTH = 25; //size of the board in blocks
    public static final int HEIGHT = 25; //height of the board in blocks

    protected MazeBoard board;  // Board data structure

    protected int currentX, newX;
    protected int currentY, newY;

    public enum MoveType {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    public MazeModel()
    {
        this.board = new MazeBoard(WIDTH, HEIGHT);
    }

    /**
     * Overloaded constructor for model.
     * Creates a new maze board with a specified size, rather than utilizing default sizes.
     */
    public MazeModel(int width, int height) {
        this.board = new MazeBoard(width, height);
    }

    public MazeBoard getBoard()
    {
        return this.board;
    }

    public void moveCharacter(MoveType move) {
        //MUST COMPLETE TO MOVE CHARACTER ON MAZE
        return;
    }

    public double getHeight()
    {
        return HEIGHT;
    }

    public double getWidth()
    {
        return WIDTH;
    }
}
