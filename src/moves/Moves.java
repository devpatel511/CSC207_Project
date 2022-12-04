package moves;

class Moves {
    private static Moves moveMade = null;
    // static var to keep track of moves made
    private static int numMoves = 0;

    private Moves() {}

    public static synchronized Moves getInstance() {

        // create the singleton Moves object if it
        // isn't already created
        if(moveMade == null) {
            moveMade = new Moves();
        }
        // movesMade increments
        numMoves += 1;
        // return the singleton Moves object
        return moveMade;
    }

    // if ever board is cleared, counter is reset
    public void reset() {
        numMoves = 0;
    }

    // returns a string saying obj. is initialized
    public String createObj() {
        return "Moves object initialized";
    }

    // returns static variable
    public int movesMade() {
        return numMoves;
    }
}

