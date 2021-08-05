public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        if (food > 0) {
            System.out.printf("тарелка: %d\n", food);
        } else {
            System.out.println("тарелка пуста");
        }
    }

    public void decreaseFood (int n) {
        if (n <= food) {
            food -= n;
        }
        //info();
    }

    public int getFood() {
        return food;
    }

    public void increaseFood(int n) {
        food += n;
        System.out.printf("в тарелку добавили еды: %d\n", n);
        info();
    }
}
