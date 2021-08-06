public class Cat {

    private String name;
    private int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat (Plate p) {
        if (appetite <= p.getFood()) {
            System.out.printf("%s поел еду из тарелки: %d\n", name, appetite);
            p.decreaseFood(appetite);
            isFull = true;
        }
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }


    public boolean isFull() {
        if (isFull) {
            System.out.printf("%s сыт\n", name);
        } else {
            System.out.printf("%s голоден\n", name);
        }
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}
