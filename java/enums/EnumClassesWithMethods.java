package enums;

enum DirectionClass {
    NORTH {
        @Override
        void move(){
            System.out.println("Move up (Y+1)");
        }
    },
    SOUTH {
        @Override
        void move(){
            System.out.println("Move down (Y-1)");
        }
    },
    EAST {
        @Override
        void move(){
            System.out.println("Move right (X+1)");
        }
    },
    WEST {
        @Override
        void move(){
            System.out.println("Move left (X-1)");
        }
    };

    // objects(NORTH, SOUTH, EAST, WEST) will have to override this function
    abstract void move();
}

public class EnumClassesWithMethods {
    static void main() {
        DirectionClass d = DirectionClass.SOUTH;
        // Direction d = new Direction(); wont allow, error here enums cannot be instantiated
        d.move();
        DirectionClass[] directions = DirectionClass.values();
        for(DirectionClass direction : directions){
            System.out.println(direction);
        }
        System.out.println();

        for(DirectionClass direction : directions){
            if(direction == DirectionClass.EAST){
                direction = DirectionClass.WEST;
            }
            System.out.println(direction.name());
        }
        System.out.println();

        //NO CHANGE HERE
        directions = DirectionClass.values();
        for(DirectionClass direction : directions){
            System.out.println(direction);
        }
        System.out.println();

        // DirectionClass directionClass = DirectionClass.valueOf("sneha"); IllegalArgumentException

        DirectionClass directionClass = DirectionClass.valueOf("EAST");
        System.out.println(directionClass.name());

        DirectionClass directionClass1 = DirectionClass.WEST;
        System.out.println(directionClass1.ordinal());
    }
}
