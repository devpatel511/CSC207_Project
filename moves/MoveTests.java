package moves;

class Test {
    public static void main(String[] args) {
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
 
