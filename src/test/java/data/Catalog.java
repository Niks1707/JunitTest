package data;

public enum Catalog {
    dryfood("Сухие корма"),
    wetfood("Влажные корма"),
    veterinaryfeed("Ветеринарные корма"),
    treats("Лакомства"),
    toys("Игрушки"),
    catlitter("Наполнители"),
    toiletries("Лотки, туалеты, совки");

    public final String name;
    Catalog(String name) {
        this.name = name;
    }

}
