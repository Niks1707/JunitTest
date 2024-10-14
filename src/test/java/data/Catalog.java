package data;

public enum Catalog {
    DRYFOOD("Сухие корма"),
    WETFOOD("Влажные корма"),
    VETERINARYFEED("Ветеринарные корма"),
    TREATS("Лакомства"),
    TOYS("Игрушки"),
    CATLITTER("Наполнители"),
    TOILETRIES("Лотки, туалеты, совки");

    public final String name;
    Catalog(String name) {
        this.name = name;
    }

}
