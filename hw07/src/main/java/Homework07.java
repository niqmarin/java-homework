import java.util.Random;

public class Homework07 {

    public static void main(String[] args) {

        Random rand = new Random();
        Plate plate = new Plate(100);
        int catNumber = (1 + rand.nextInt(5)); //создаем до 20 котов
        Cat[] catArr = new Cat[catNumber];
        String[] names = {"Маркиз", "Барсик", "Мурзик", "Персик", "Бублик",
        "Барон", "Кустик", "Леон", "Лучик", "Бандит", "Пират", "Батон",
        "Лёва", "Пухлик", "Мурчатель", "Мегатрон", "Феанор", "Воробей",
        "Самурай", "Демон"};

        //заполняем массив сгенерированными котами
        for (int i = 0, j = 19; i < catNumber; i++, j--) {
            catArr[i] = new Cat(names[j], 5 + rand.nextInt(16));
            catArr[i].isFull();
        }

        plate.info();
        System.out.printf("кормим %d голодных котов\n", catNumber);
        //отправляем котов есть из тарелки
        for (int i = 0; i < catNumber; i++) {
            if (catArr[i].getAppetite() > plate.getFood()) {
                plate.increaseFood(100);
            }
            catArr[i].eat(plate);
            catArr[i].isFull();
        }
        plate.info();
    }
}
