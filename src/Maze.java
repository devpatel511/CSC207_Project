/**
 * The maze UI class which visualizes the maze. The maze can be reset once a visualization begins
 * and has the ability to toggle between two colours.
 * The receiver of the commands.
 */
public class Maze {
    private int state = 0; // toggle between state 0 and 1 to identify colour

    /**
     * Reset the maze to begin new visualization.
     */
    public void reset() {
        throw new UnsupportedOperationException();
    }

    /**
     * Change the colour of the maze.
     */
    public void colourChange() {
        this.state = (this.state == 0) ? 1 : 0;
        throw new UnsupportedOperationException();
    }
}
