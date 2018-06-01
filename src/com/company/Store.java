package com.company;

/*
 Склад, с которого покупатели будут забирать товар
 и куда производители товар будут приносить
 */
public class Store {
    int counter = 0; // счетчик товаров
    final int N = 5; // максимум товаров который может хранится на складе

    // для производителей
    synchronized int put() {
        if (counter <= N) { // если товаров меньге N
            counter++; // добавляем товар
            System.out.println("Items in store = " + counter + " (put)");
            return 1; // если добавили возвращаем 1
        }
        return 0; // если не добавили 0
    }

    // для покупателей
    synchronized int get() {
        if (counter > 0) { // если есть хоть 1 товар
            counter--; //забираем его
            System.out.println("Items in store = " + counter + " (get)");
            return 1; // если забрали возвращаем 1
        }
        return 0; // если нет 0
    }
}
