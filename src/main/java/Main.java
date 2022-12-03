import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float itemCost = -1.1f;
        int personsQuantity = -1;
        while (personsQuantity < 0) {personsQuantity = inputPersonsQuantity();} // получем колчиество персон
        String itemName = inputItemName(1); // получаем имя первого товара
        while (itemCost < 0) {itemCost = inputItemCost(itemName);} // получаем стоимость товара
        new ItemsBasket();
        new Calculator();

        ItemsBasket.addItemInBasket(itemName); // записали Item в Basket
        Calculator.sumCostsOfItems(itemCost); // приплюсовали Cost
        int roubles = (int) (itemCost);
        int pennies = (int) ((itemCost % 1)*100);
        String roubleName = Calculator.findRightRoubleWord (roubles);
        String pennyName = Calculator.findRightPennyWord (pennies);

        System.out.printf("Вы успешно добавили товар %s стоимостью %d %s %d %s%n", itemName,roubles,roubleName,pennies,pennyName );
        while (true) {
            itemName = inputItemName(2); // получаем имя следующего товара
            if (itemName.equalsIgnoreCase("ЗАВЕРШИТЬ")) {break;} // проверяем команду Завершить
            itemCost = -1.1f; // сброс предыдущего значения для вхождения в цикл
            while (itemCost < 0) {itemCost = inputItemCost(itemName);}// получаем стоимость следующего товара
            ItemsBasket.addItemInBasket(itemName); // записали Item в Basket
            Calculator.sumCostsOfItems(itemCost); // приплюсовали Cost
            roubles = (int) (itemCost);
            pennies = (int) ((itemCost % 1)*100);
            roubleName = Calculator.findRightRoubleWord (roubles);
            pennyName = Calculator.findRightPennyWord (pennies);
            System.out.printf("Вы успешно добавили товар %s стоимостью %d %s %d %s%n", itemName,roubles,roubleName,pennies,pennyName );
        }

        float resultCalculator = Calculator.calculateCostPerPerson(personsQuantity);
        ItemsBasket.writeItemsFromBasket();
        roubles = (int) (resultCalculator);
        pennies = (int) ((resultCalculator % 1)*100);
        roubleName = Calculator.findRightRoubleWord (roubles);
        System.out.printf("Каждому нужно заплатить %d,%d %s%n",roubles,pennies,roubleName);
    }

//_____________________________________________________________________________________________

    public static int inputPersonsQuantity() {
        Scanner scanner = new Scanner(System.in);
        int errorInt = -1;
        System.out.println("Введите число персон, на которых разделить счет:");
        try {
            int personsQuantity = scanner.nextInt(); // После запуска программа должна спрашивать у пользователя, на скольких человек необходимо разделить счёт.
            while (personsQuantity <= 1) {
                System.out.println("Вы ввели неправильное число персон.");
                System.out.println("Снова введите число персон, на которых будем делить счет. Персон должно быть две и больше:");
                personsQuantity = scanner.nextInt();
            }
            return personsQuantity;
        } catch (InputMismatchException e) {
            System.out.println("Ошибочный ввод. Попробуйте ещё раз ввести число персон в виде целого положительного числа, например 10:");
            return errorInt;
        }
    }

    public static String inputItemName(int type) {
        Scanner scanner = new Scanner(System.in);
        String itemName;
        switch (type) {
            case 1:
                System.out.println("Введите название товара из чека:");
                itemName = scanner.next();
                itemName = itemName.trim();
                return itemName;
            case 2:
                System.out.println("Если хотите завершить ввод напишите \"Завершить\" или введите название следующего товара из чека:");
                itemName = scanner.next();
                itemName = itemName.trim();
                return itemName;
        }
        itemName = "None";
        return itemName;
    }

    public static float inputItemCost(String itemName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите стоимость товара " + itemName + " в формате 0,00 в рублях с копейками:");
        float itemCost;
        float errorFloat = -1.10f;

        try {
            itemCost = scanner.nextFloat();
            if (itemCost < 0) {
                System.out.println("Вы ввели стоимость не в правильном фомате. Попробуйте ещё раз, например 10,45");
                return errorFloat;
            }
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели стоимость не в правильном фомате. Попробуйте ещё раз, например 10,45");
            return errorFloat;
            }
        return itemCost;
    }
}