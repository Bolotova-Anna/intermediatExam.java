package ru.geekbrains.api;

import java.util.*;

public class examenation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> bookPhone = new HashMap<>();
//        bookPhone.put("ИВАНОВ", "7990900");
//        bookPhone.put("ПЕТРОВ", "99,0");
        System.out.println("если хотите сделать запись в телефонной книге нажмите 1" +
                "если хотите вывести на экран все контакты нажмите 2");
        int a = scanner.nextInt();
        if (a == 1) {
            recordInBookPhone(bookPhone);
        }
        if (a == 2) {
            show(bookPhone);
        } else {
            System.out.println("для выбора доступны только команы 1 и 2");
        }
    }

    public static void recordInBookPhone(HashMap<String, String> bookPhone) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите через запятую фамилию и телефон человека, чьи данные ищете: ");
        String input = scanner.nextLine().toUpperCase();
        String[] parts = input.split(",");
        boolean isKeyExists = bookPhone.containsKey(parts[0]);
        if (isKeyExists == true) {
            for (String key :
                    bookPhone.keySet()) {
                if (key.equals(parts[0])) {
                    for (int j = 1; j < parts.length; j++) {
                        bookPhone.put(key, bookPhone.get(key) + "," + parts[j]);
                    }
                }
            }
        } else {
            for (int j = 1; j < parts.length; j++) {
                bookPhone.put(parts[0], parts[j]);
            }

        }
        System.out.println(bookPhone);
    }

    public static void show(HashMap<String, String> bookPhone) {
        TreeMap tMap = new TreeMap<>();
        LinkedHashMap newM = new LinkedHashMap<>();
        for (var item : bookPhone.entrySet()) {
            String temp = item.getValue();
            String[] s = temp.split(",");
            int len = s.length;
            tMap.put(len, item.getValue());


        }
        TreeMap ttt = new TreeMap(tMap.descendingMap());
        for (var i : ttt.values()) {
            if (bookPhone.containsValue(i)) {
                for (var k : bookPhone.entrySet()) {
                    if (i.equals(k.getValue())) {
                        newM.put(k.getKey(), i);
                    }

                }
            }
        }
        for (var i : newM.keySet()) {
            System.out.printf(" %s : %s \n", i, newM.get(i));


    }
        }
    }








