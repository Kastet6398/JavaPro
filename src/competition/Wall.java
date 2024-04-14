package competition;

public class Wall implements Obstacle {
    private final double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Participant participant) {
        boolean canOvercome = participant.jump(height);
        if (canOvercome) {
            System.out.println(STR."Participant \{participant.getName()} has overcome the wall (\{height} m).");
        } else {
            System.out.println(STR."Participant \{participant.getName()} hasn't overcome the wall (\{height} m).");
        }
        return canOvercome;
    }

    @Override
    public String toString() {
        return STR."Wall{height=\{height}}";
    }
}

