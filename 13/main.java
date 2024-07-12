/*
Вариант А
9. Магазин часов. В БД хранится информация о часах, продающихся в магазине.
Для часов необходимо хранить:
• марку;
• тип (кварцевые, механические);
• стоимость;
• количество;
• реквизиты производителя.
Для производителей необходимо хранить:
• название;
• страна.
• Вывести марки заданного типа часов.
• Вывести информацию о механических часах, стоимость которых не превышает заданную.
• Вывести марки часов, изготовленных в заданной стране.
• Вывести производителей, общая сумма часов которых в магазине не превышает заданную.
*/

public class main {
    public static void main(String[] args) {
        WatchQueries watchQueries = new WatchQueries();
        WatchModification watchModification = new WatchModification();

        watchModification.addManufacturer("Rolex", "Switzerland");
        watchModification.addManufacturer("Seiko", "Japan");
        watchModification.addWatch("Rolex Submariner", "mechanical", 7500.00, 5, 1);
        watchModification.addWatch("Seiko 5", "mechanical", 150.00, 10, 2);

        System.out.println("Марки механических часов:");
        watchQueries.getBrandsByType("mechanical");

        System.out.println("Механические часы стоимостью до 2000:");
        watchQueries.getMechanicalWatchesByPrice(2000.00);

        System.out.println("Марки часов из Японии:");
        watchQueries.getBrandsByCountry("Japan");

        System.out.println("Производители с общей стоимостью часов до 10000:");
        watchQueries.getManufacturersByTotalWatchValue(10000.00);
    }
}
