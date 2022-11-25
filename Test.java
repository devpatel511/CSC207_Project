class Test {
    public static void main(String[] args) {
        /*
        Sanity checks to make sure only one object is created and the moves counter and reset
        methods work. Running the file should print the following:
        3
        true
        true
        true
        0
         */
        Moves db1;
        Moves db2;
        Moves db3;

        // refers to the only object of Moves
        db1= Moves.getInstance();
        db2= Moves.getInstance();
        db3= Moves.getInstance();

        System.out.println(db1.movesMade());

        System.out.println(db1.equals(db2));
        System.out.println(db3.equals(db1));
        System.out.println(db2.equals(db3));

        db1.reset();
        System.out.println(db2.movesMade());
    }
}

