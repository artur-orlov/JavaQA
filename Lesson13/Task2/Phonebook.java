import java.util.*;

public class Phonebook {
    private Map<String, List<String>> contacts;

    public Phonebook() {
        contacts = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {

        if (!contacts.containsKey(lastName)) {
            contacts.put(lastName, new ArrayList<>());
        }
        contacts.get(lastName).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return contacts.getOrDefault(lastName, new ArrayList<>());
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.add("Иванов", "7-777-777");
        phonebook.add("Петров", "55-555");
        phonebook.add("Иванов", "8888-8888");

        System.out.println("Номера телефонов Ивановых: " + phonebook.get("Иванов"));
        System.out.println("Номера телефонов Петровых: " + phonebook.get("Петров"));
        System.out.println("Номера телефонов Сидоровых: " + phonebook.get("Сидоров"));
    }
}
