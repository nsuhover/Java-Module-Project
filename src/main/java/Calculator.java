public class Calculator {
    static float itemsSum = 0.00f;
    static float costPerPerson;

    public static void sumCostsOfItems (float cost) {
        itemsSum = itemsSum + cost;
    }

    public static float calculateCostPerPerson (int personsQuantity) {
        float costPerPerson = itemsSum / (float)personsQuantity;
        return costPerPerson;
    }

    public static String findRightRoubleWord (int roubles){
        String roubleName;
        int lastDigit = -1;
        int lastTwoDigits = -11;
        lastTwoDigits = roubles - (roubles / 100) * 100;
        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            roubleName = "рублей";
            return roubleName;
        }
        lastDigit = roubles - (roubles / 10) * 10;
        if (lastDigit == 1) {
            roubleName = "рубль";
            return roubleName;
        }
        else if (lastDigit >= 2 && lastDigit <= 4){
            roubleName = "рубля";
            return roubleName;
        }
        else if ((lastDigit >= 5 && lastDigit <= 9)||(lastDigit == 0)){
            roubleName = "рублей";
            return roubleName;
        } else {
            roubleName = "Unknown";
            return roubleName;
        }
    }

    public static String findRightPennyWord (int penny){
        String pennyName;
        int lastDigit = -1;
        int lastTwoDigits = -11;

        lastTwoDigits = penny - (penny / 100) * 100;
        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            pennyName = "копеек";
            return pennyName;
        }
        lastDigit = penny - (penny / 10) * 10;
        if (lastDigit == 1) {
            pennyName = "копейка";
            return pennyName;
        }
        else if (lastDigit >= 2 && lastDigit <= 4){
            pennyName = "копейки";
            return pennyName;
        }
        else if ((lastDigit >= 5 && lastDigit <= 9)||(lastDigit == 0)){
            pennyName = "копеек";
            return pennyName;
        }
        pennyName = "Unknown";
        return pennyName;
    }
}

