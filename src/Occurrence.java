public class Occurrence {
    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    private final String name;
    private int count;

    public Occurrence(String name) {
        this(name, 0);
    }

    public Occurrence(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public void increaseCount() {
        count++;
    }

    @Override
    public String toString() {
        return STR."{name: '\{name}', count: \{count}}";
    }
}
