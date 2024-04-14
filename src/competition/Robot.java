package competition;


public record Robot(String name) implements Participant {
    private static final double MAX_LENGTH = 5000;
    private static final double MAX_HEIGHT = 5;

    @Override
    public String toString() {
        return STR."Robot{name='\{name}'}";
    }

    @Override
    public boolean run(double length) {
        if (length <= MAX_LENGTH) {
            System.out.println(STR."Robot \{name} is running.");
            return true;
        } else {
            System.out.println(STR."Robot \{name} cannot run \{length} m.");
            return false;
        }
    }

    @Override
    public boolean jump(double height) {
        if (height <= MAX_HEIGHT) {
            System.out.println(STR."Robot \{name} is jumping.");
            return true;
        } else {
            System.out.println(STR."Robot \{name} cannot jump \{height} m.");
            return false;
        }
    }
}
