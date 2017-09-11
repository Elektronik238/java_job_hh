package ru.kuzn_evg;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class UI {
    public static Main.ResultUI UserInterface() {
        System.out.println("Поиск вакансий: -s");
        System.out.println("Просмотр вакансии №123: -v 123");
        System.out.println("Поиск компаний: -r");
        System.out.println("Просмотр компании №123: -e 123");
        System.out.println("Выход: -exit");
        Scanner scan = new Scanner(System.in);
        int variant = 0;
        if (scan.hasNext()) {
            String com = scan.next();
            if (com.equals("-s"))
                variant = 1;
            else if (com.equals("-v"))
                variant = 2;
            else if (com.equals("-r"))
                variant = 3;
            else if (com.equals("-e"))
                variant = 4;
            else if (com.equals("-exit"))
                variant = -1;
        }
        switch (variant) {
            case 0:
                System.out.println("Введено недопустимое значение.");
                return new Main.ResultUI(null, 0);
            case 1:
                return new Main.ResultUI(SearchUI(), 1);
            case 2:
                try {
                    return new Main.ResultUI(new URL("https://api.hh.ru/vacancies/" + scan.nextInt()), 2);
                } catch (MalformedURLException e) {
                    System.out.println("Введено недопустимое значение.");
                    return new Main.ResultUI(null, 0);
                } catch (IllegalArgumentException e) {
                    System.out.println("Введено недопустимое значение номера вакансии.");
                    return new Main.ResultUI(null, 0);
                }
            case 3:
                return new Main.ResultUI(SearchEmpUI(), 3);
            case 4:
                try {
                    return new Main.ResultUI(new URL("https://api.hh.ru/employers/" + scan.nextInt()), 4);
                } catch (MalformedURLException e) {
                    System.out.println("Введено недопустимое значение.");
                    return new Main.ResultUI(null, 0);
                } catch (IllegalArgumentException e) {
                    System.out.println("Введено недопустимое значение номера вакансии.");
                    return new Main.ResultUI(null, 0);
                }
            case -1:
                System.exit(0);
        }
        return new Main.ResultUI(null, 0);
    }

    private static URL SearchEmpUI() {
        StringBuilder textURL = new StringBuilder();
        textURL.append("https://api.hh.ru/employers?per_page=10&");
        System.out.println("Введите параметры поиска:\n-t \"слово\"+\"слово\" - поисковой запрос, в конце написать \"end\"\nДля выхода в главное меню -mm, выход из программы -exit.");
        Scanner scanS = new Scanner(System.in);
        while (true) {
            String searchParam = scanS.next();
            if (searchParam.equals("-t")) textURL.append("text=").append(scanS.next()).append("&");
            else if (searchParam.equals("-exit")) System.exit(0);
            else if (searchParam.equals("-mm")) return null;
            else if (searchParam.equals("end")) break;
            else {
                System.out.println("Введена недопустимая команда и/или недопустимые значения.");
                scanS.nextLine();
                continue;
            }
        }
        textURL.deleteCharAt(textURL.length() - 1);
        URL url = null;
        try {
            url = new URL(textURL.toString());
        } catch (MalformedURLException e) {
            System.out.println("Введены недопустимые символы в значениях команды.");
            return null;
        }
        return url;
    }

    public static URL SearchUI() {
        StringBuilder textURL = new StringBuilder();
        textURL.append("https://api.hh.ru/vacancies?per_page=10&");
        System.out.println("Введите параметры поиска:\n-t \"слово\"+\"слово\" - поисковой запрос, минимум одно слово\n-а (Мск-1, Спб-2, Екб-3) - город, если не указать, то по всем городам\nПараметры можно вводить в любом порядке, сразу или поочерёдно, в конце написать \"end\"\nДля выхода в главное меню -mm, выход из программы -exit.");
        Scanner scanS = new Scanner(System.in);
        while (true) {
            String searchParam = scanS.next();
            if (searchParam.equals("-t")) textURL.append("text=").append(scanS.next()).append("&");
            else if (searchParam.equals("-a")) {
                try {
                    textURL.append("area=").append(scanS.nextInt()).append("&");
                } catch (IllegalArgumentException e) {
                    System.out.println("Введено недопустимое значение города.");
                    textURL.replace(0, textURL.length(), "https://api.hh.ru/vacancies?per_page=10&");
                    scanS.nextLine();
                }
                continue;
            } else if (searchParam.equals("-exit")) System.exit(0);
            else if (searchParam.equals("-mm")) return null;
            else if (searchParam.equals("end")) break;
            else {
                System.out.println("Введена недопустимая команда и/или недопустимые значения.");
                scanS.nextLine();
                continue;
            }
        }
        textURL.deleteCharAt(textURL.length() - 1);
        URL url = null;
        try {
            url = new URL(textURL.toString());
        } catch (MalformedURLException e) {
            System.out.println("Введены недопустимые символы в значениях команды.");
        }
        return url;
    }
}
