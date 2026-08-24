package enums;

enum Direction {
    NORTH(0),
    SOUTH(180),
    EAST(90),
    WEST(270);

    private final int degree;

    // compiler will automatically convert this into private constructor
    Direction(int degree){
        this.degree = degree;
    }

    public int getDegree(){
        return this.degree;
    }

}

public class EnumClassesWithFields {
    static void main() {
        Direction d = Direction.SOUTH;
        // Direction d = new Direction(); wont allow, error here enums cannot be instantiated
        System.out.println(d.getDegree());
    }
}
