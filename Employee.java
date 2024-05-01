public class Employee {

    public static void main(String[] args) {

        Employee vano = new Employee("Иванов Иван Иванович", "Главный инженер",
                "vano@rabota.com", "+77777777777", 77777, 77);
        Employee noname = new Employee();

        System.out.println("Задача №2\n");
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Sidorov Sidor", "Engineer",
                "sisidor@mailbox.com", "892312313", 31000, 31);
        persArray[2] = new Person("Petrov Petr", "Engineer",
                "pepetr@mailbox.com", "892312314", 32000, 32);
        persArray[3] = new Person("Alexandrov Alexandr", "Engineer",
                "alalex@mailbox.com", "892312315", 33000, 33);
        persArray[4] = new Person("Dmitriev Dmitriy", "Engineer",
                "dmdima@mailbox.com", "892312316", 34000, 34);


    }

    private String fullname;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;
    public Employee () {
        System.out.println("Данные сотрудника неизвестны.\n");
    }
    public Employee (String fullname, String position, String email, String phone, int salary, int age) {
            this.fullname = fullname;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;
            System.out.println("ФИО: " + fullname + "\nДолжность: " + position + "\nE-mail: " + email +
                    "\nТелефон: " + phone + "\nЗарплата: " + salary + "\nВозраст: " + age + "\n");
    }
    static class Person extends Employee{
        Person(String fullname, String position, String email, String phone, int salary, int age) {
            super(fullname, position, email, phone, salary, age);
        }
        Person () {
            super();
        }
    }
}
