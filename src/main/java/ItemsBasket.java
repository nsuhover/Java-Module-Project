public class ItemsBasket {
    static String itemsNames = "None";

    ItemsBasket() {
    }

    public static void addItemInBasket(String name) {
        if (itemsNames.equals("None")) {
            itemsNames = name;
        }
        else {
            itemsNames = itemsNames + ", " + name;
        }
    }

    public static void writeItemsFromBasket () {
        System.out.println("Добавленные товары:\n"+itemsNames.replaceAll(", ","\n"));
        }
    }

