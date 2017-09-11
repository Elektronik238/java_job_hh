
package ru.kuzn_evg.employerSearchHHjson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.kuzn_evg.GetJSON;
import ru.kuzn_evg.employerHHjson.Employer;
import ru.kuzn_evg.searchHHjson.SearchHH;

public class EmployerSearch {

    @SerializedName("per_page")
    @Expose
    private int perPage;
    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("pages")
    @Expose
    private int pages;
    @SerializedName("found")
    @Expose
    private int found;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;


    /**
     * No args constructor for use in serialization
     */
    public static int EmployerSearch(String json, int num) {
        if (json == null)
            return -1;
        Gson gson = new Gson();
        EmployerSearch searchEmployers = gson.fromJson(json, EmployerSearch.class);
        if (num == 0) {
            System.out.println("Компании выводятся по одной, доступен просмотр не более 2000 компаний\nпереход на следующую компанию - любой символ , для перехода к компании №123 введите -nr 123, для выхода в главное меню -mm, выход из программы -exit.\n");
            System.out.println("Найдено " + searchEmployers.getFound() + " компаний по вашему запросу.\n");
        }
        if (searchEmployers.getFound() == 0)
            return -1;
        List<Item> employersList = searchEmployers.getItems();
        Scanner nextEmp = new Scanner(System.in);
        int i = num % 10;
        int page = num / 10;
        for (; ; i++) {
            String searchUI = nextEmp.next();
            Item employer = employersList.get(i);

            if (searchUI.equals("-nr")) {
                int nEmp = nextEmp.nextInt();
                if (nEmp - 1 > searchEmployers.getFound()) {
                    System.out.println("Введено значение превышающее количество найденных компаний по вашему запросу");
                    continue;
                } else if (nEmp / 10 == searchEmployers.getPage())
                    i = nEmp % 10 - 1;
                else return nEmp - 1;
            } else if (searchUI.equals("-e")) {
                i--;
                try {
                    new Employer(GetJSON.load(new URL("https://api.hh.ru/employers/" + nextEmp.nextInt())));
                } catch (MalformedURLException e) {
                    System.out.println("Введено недопустимое значение.");
                } catch (IllegalArgumentException e){
                    System.out.println("Введено недопустимое значение номера компании.");
                }
            } else if (searchUI.equals("-mm"))
                break;
            else if (searchUI.equals("-exit"))
                System.exit(0);
            else {
                System.out.println("Результат поиска №" + (page * 10 + i + 1) + " из " + searchEmployers.getFound());
                System.out.println("Компания(№" + searchEmployers.getItems().get(i).getId() + "): " + searchEmployers.getItems().get(i).getName());
                System.out.println("Url компании на hh.ru - " + searchEmployers.getItems().get(i).getAlternateUrl());
                System.out.println("Открытых вакансий у компании: " + searchEmployers.getItems().get(i).getOpenVacancies());
            }
            if (i >= 9)
                return page * 10 + i + 1;

        }
        return -1;
    }

    /**
     * @param items
     * @param page
     * @param pages
     * @param perPage
     * @param found
     */
    public EmployerSearch(int perPage, int page, int pages, int found, List<Item> items) {
        super();
        this.perPage = perPage;
        this.page = page;
        this.pages = pages;
        this.found = found;
        this.items = items;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getFound() {
        return found;
    }

    public void setFound(int found) {
        this.found = found;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
