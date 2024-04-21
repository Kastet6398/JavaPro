package phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    @Override
    public String toString() {
        return STR."PhoneBook{records=\{records}}";
    }

    private final List<Record> records;

    public PhoneBook() {
        this.records = new ArrayList<>();
    }

    public void add(Record record) {
        records.add(record);
    }

    public Record find(String name) {
        return records.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Record> findAll(String name) {
        List<Record> res = records.stream().filter(x -> x.getName().equals(name)).toList();
        if (res.isEmpty()) {
            return null;
        }
        return res;
    }
}
