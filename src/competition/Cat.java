package competition;

public record Cat(String name) implements Participant {
    private static final double MAX_LENGTH = 75;
    private static final double MAX_HEIGHT = 1;

    @Override
    public String toString() {
        return STR."Cat{name='\{name}'}";
    }

    @Override
    public boolean run(double length) {
        if (length <= MAX_LENGTH) {
            System.out.println(STR."Cat \{name} is running.");
            return true;
        } else {
            System.out.println(STR."Cat \{name} cannot run \{length} m.");
            return false;
        }
    }

    @Override
    public boolean jump(double height) {
        if (height <= MAX_HEIGHT) {
            System.out.println(STR."Cat \{name} is jumping.");
            return true;
        } else {
            System.out.println(STR."Cat \{name} cannot jump \{height} m.");
            return false;
        }
    }
}
