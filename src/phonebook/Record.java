package phonebook;

public class Record {
    private final String name;
    private String phone;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Record(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
