public class Calculator {
    static float itemsSum;
    static float costPerPerson;

    public static void sumCostsOfItems(float cost) {
        itemsSum = itemsSum + cost;
    }

    public static float calculateCostPerPerson(int personsQuantity) {
        costPerPerson = itemsSum / (float) personsQuantity;
        return costPerPerson;
    }

    public static String findRightRoubleWord(int roubles) {
        String roubleName;
        int lastDigit;
        int lastTwoDigits;
        lastTwoDigits = roubles % 100;
        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            roubleName = "рублей";
            return roubleName;
        }
        lastDigit = roubles % 10;
        if (lastDigit == 1) {
            roubleName = "рубль";
            return roubleName;
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            roubleName = "рубля";
            return roubleName;
        } else {
            roubleName = "рублей";
            return roubleName;
        }
    }

}

