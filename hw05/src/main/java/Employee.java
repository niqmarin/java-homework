public class Employee {

    private String fullName; //фио
    private String position; //должность
    private String email; //e-mail
    private String phone; //номер телефона
    private int salary; //зарплата
    private int age; //возраст

    public Employee(String fullName) {
        this.fullName = fullName;
    }

    public Employee(String fullName, String position, String email, String phone, int salary, int age){
        this(fullName);
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = Math.max(salary, 20589); //платить меньше МРОТа нельзя
        this.age = Math.max(age, 18); //нанимать несовершеннолених тоже
    }

    public void printInfo() {
        System.out.printf("ФИО: %s\nДолжность: %s\nE-mail: %s\nТелефон: %s\nЗарплата: %d\nВозраст: %d\n", fullName, position, email, phone, salary, age);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = Math.max(salary, 20589);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = Math.max(age, 18);
    }
}
