package phonebook;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(new Record("Bob", "5553322"));
        phoneBook.add(new Record("Alice", "5553311"));
        phoneBook.add(new Record("Bob", "5553321"));
        phoneBook.add(new Record("Donald", "5653322"));
        phoneBook.add(new Record("Joe", "5593322"));
        phoneBook.add(new Record("Jeff", "7777777"));

        System.out.println(phoneBook.find("Bob"));
        System.out.println(phoneBook.findAll("Bob"));
    }
}

