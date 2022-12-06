import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int personsQuantity = inputPersonsQuantity(); // получем колчиество персон
        String itemName = inputItemName(1); // получаем имя первого товара
        float itemCost = inputItemCost(itemName); // получаем стоимость товара

        ItemsBasket.addItemInBasket(itemName); // записали Item в Basket
        Calculator.sumCostsOfItems(itemCost); // приплюсовали Cost
        int roubles = (int) (itemCost);
        String roubleName = Calculator.findRightRoubleWord(roubles);

        System.out.printf("Вы успешно добавили товар %s стоимостью %.2f %s%n", itemName, itemCost, roubleName);
        while (true) {
            itemName = inputItemName(2); // получаем имя следующего товара
            if (itemName.equalsIgnoreCase("ЗАВЕРШИТЬ")) {
                break;
            } // проверяем команду Завершить
            itemCost = -1.1f; // сброс предыдущего значения для вхождения в цикл
            while (itemCost < 0) {
                itemCost = inputItemCost(itemName);
            }// получаем стоимость следующего товара
            ItemsBasket.addItemInBasket(itemName); // записали Item в Basket
            Calculator.sumCostsOfItems(itemCost); // приплюсовали Cost
            roubles = (int) (itemCost);
            roubleName = Calculator.findRightRoubleWord(roubles);
            System.out.printf("Вы успешно добавили товар %s стоимостью %.2f %s%n", itemName, itemCost, roubleName);
        }

        float resultCalculator = Calculator.calculateCostPerPerson(personsQuantity);
        ItemsBasket.writeItemsFromBasket();
        roubles = (int) (resultCalculator);
        roubleName = Calculator.findRightRoubleWord(roubles);
        System.out.printf("Каждому нужно заплатить %.2f %s%n", resultCalculator, roubleName);
    }

//_____________________________________________________________________________________________

    public static int inputPersonsQuantity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число персон, на которых разделить счет:");
        int personsQuantity;
        while (true) {
            if (scanner.hasNextInt()) {
                personsQuantity = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибочный ввод. Попробуйте ещё раз ввести число персон в виде целого положительного числа, например 10,45");
                scanner.next();
            }
        }
        return personsQuantity;
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
        while (true) {
            if (scanner.hasNextFloat()) {
                itemCost = scanner.nextFloat();
                if (itemCost >= 0) {
                    break;
                } else {
                    System.out.println("Вы ввели стоимость не в правильном фомате. Попробуйте ещё раз, например 10,45");
                    scanner.next();
                }
            } else {
                System.out.println("Вы ввели стоимость не в правильном фомате. Попробуйте ещё раз, например 10,45");
                scanner.next();
            }
        }
        return itemCost;
    }
}