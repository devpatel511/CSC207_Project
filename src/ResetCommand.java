/**
 * Class ResetCommand
 * A Command to be applied to the maze
 */
public class ResetCommand implements MazeCommand {
    private final Maze maze; // the receiver of the command

    /**
     * Constructor
     *
     * @param maze Maze to reset
     */
    public ResetCommand(Maze maze) {
        this.maze = maze;
    }

    /**
     * execute the reset command.
     */
    @Override
    public void execute() {
        this.maze.reset();
        System.out.println("Maze reset!");
    }
}
