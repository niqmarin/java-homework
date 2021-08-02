public class Homework05 {

    public static void main(String[] args) {
        Employee[] arrEmployees = new Employee[5];
        arrEmployees[0] = new Employee("Васнецова Татьяна Геннадьевна");
        arrEmployees[0].setPosition("Автомеханик");
        arrEmployees[0].setEmail("vastat@mail.com");
        arrEmployees[0].setPhone("89164523002");
        arrEmployees[0].setSalary(80000);
        arrEmployees[0].setAge(36);
        arrEmployees[1] = new Employee("Стародуб Елена Павловна", "Комплектовщик заказов",
                "elennns@mail.com", "89263514785", 37500, 42);
        arrEmployees[2] = new Employee("Твардовская Зинаида Романовна", "Водитель-курьер",
                "zinaida.tvardovskaja@mail.com", "89653230669", 57000, 29);
        arrEmployees[3] = new Employee("Стрельцова Галина Михайловна", "Оператор",
                "shootemall@mail.com", "89665405050", 46000, 52);
        arrEmployees[4] = new Employee("Огневич Светлана Вячеславовна", "Администратор",
                "ognevich74@mail.com", "89719003235", 50000, 47);

        System.out.println("Сотрудники старше 40 лет:");
        for (Employee e : arrEmployees) {
            if (e.getAge() > 40) {
                e.printInfo();
                System.out.println("- - - - -");
            }
        }

    }

}

