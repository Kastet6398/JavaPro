package phonebook;

import java.util.ArrayList;
import java.util.List;

// Клас Телефонний довідник
public class PhoneBook {
    private final List<Record> records;

    public PhoneBook() {
        this.records = new ArrayList<>();
    }

    // Метод додавання запису до телефонного довідника
    public void add(Record record) {
        records.add(record);
    }

    // Метод пошуку запису за ім'ям
    public Record find(String name) {
        for (Record record : records) {
            if (record.getName().equals(name)) {
                return record;
            }
        }
        return null;
    }

    // Метод пошуку всіх записів за ім'ям
    public List<Record> findAll(String name) {
        List<Record> foundRecords = new ArrayList<>();
        for (Record record : records) {
            if (record.getName().equals(name)) {
                foundRecords.add(record);
            }
        }
        return foundRecords.isEmpty() ? null : foundRecords;
    }
}
