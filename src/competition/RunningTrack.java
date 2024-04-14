package competition;

public class RunningTrack implements Obstacle {
    private final double length;

    public RunningTrack(double length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Participant participant) {
        boolean canOvercome = participant.run(length);
        if (canOvercome) {
            System.out.println(STR."Participant \{participant.name()} has overcome the running track (\{length} m).");
        } else {
            System.out.println(STR."Participant \{participant.name()} hasn't overcome the running track (\{length} m).");
        }
        return canOvercome;
    }

    @Override
    public String toString() {
        return STR."RunningTrack{length=\{length}}";
    }
}
