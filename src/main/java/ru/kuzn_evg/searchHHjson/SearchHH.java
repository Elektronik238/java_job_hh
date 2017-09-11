
package ru.kuzn_evg.searchHHjson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.kuzn_evg.GetJSON;
import ru.kuzn_evg.vacancyHHjson.Vacancy;

public class SearchHH {

    @SerializedName("clusters")
    @Expose
    private Object clusters;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("pages")
    @Expose
    private int pages;
    @SerializedName("arguments")
    @Expose
    private Object arguments;
    @SerializedName("found")
    @Expose
    private int found;
    @SerializedName("alternate_url")
    @Expose
    private String alternateUrl;
    @SerializedName("per_page")
    @Expose
    private int perPage;
    @SerializedName("page")
    @Expose
    private int page;

    /**
     * No args constructor for use in serialization
     */
    public static int SearchHH(String json, int num) {
        if (json == null)
            return -1;
        Gson gson = new Gson();
        SearchHH searchResult = gson.fromJson(json, SearchHH.class);
        if (num == 0) {
            System.out.println("Вакансии выводятся по одной, доступен просмотр не более 2000 вакансий\nПереход на следующую вакансию - любой символ , для перехода на вакансию №123 введите -nv 123, для выхода в главное меню -mm, выход из программы -exit.\n");
            System.out.println("Найдено " + searchResult.getFound() + " вакансий по вашему запросу.\n");
        }
        if (searchResult.getFound() == 0)
            return -1;
        List<Item> vacancyList = searchResult.getItems();
        Scanner next = new Scanner(System.in);
        int i = num % 10;
        int page = num / 10;
        for (; ; i++) {
            String searchUI = next.next();
            Item vacancy = vacancyList.get(i);

            if (searchUI.equals("-nv")) {
                int nEmp = next.nextInt();
                if (nEmp - 1 > searchResult.getFound()) {
                    System.out.println("Введено значение превышающее количество найденных вакансий по вашему запросу");
                    continue;
                } else if (nEmp / 10 == searchResult.getPage())
                    i = nEmp % 10 - 1;
                else return nEmp - 1;
            } else if (searchUI.equals("-v")) {
                i--;
                try {
                    new Vacancy(GetJSON.load(new URL("https://api.hh.ru/vacancies/" + next.nextInt())));
                } catch (MalformedURLException e) {
                    System.out.println("Введено недопустимое значение.");
                    return -1;
                } catch (IllegalArgumentException e) {
                    System.out.println("Введено недопустимое значение номера вакансии.");
                    return -1;
                }
            } else if (searchUI.equals("-mm"))
                break;
            else if (searchUI.equals("-exit"))
                System.exit(0);
            else {
                System.out.println("Результат поиска №" + (page * 10 + i + 1) + " из " + searchResult.getFound() + "\nВакансия №" + searchResult.getItems().get(i).getId() + "\n" + searchResult.getItems().get(i).getName());
                if (searchResult.getItems().get(i).getSalary() != null) {
                    System.out.print("Зарплата: ");
                    if (searchResult.getItems().get(i).getSalary().getFrom() != null) {
                        int from = (int) Double.parseDouble(searchResult.getItems().get(i).getSalary().getFrom().toString());
                        System.out.print("от " + from);
                        if (searchResult.getItems().get(i).getSalary().getTo() != null) {
                            int to = (int) Double.parseDouble(searchResult.getItems().get(i).getSalary().getTo().toString());
                            System.out.print(" до " + to);
                        }
                    } else if (searchResult.getItems().get(i).getSalary().getTo() != null) {
                        int to = (int) Double.parseDouble(searchResult.getItems().get(i).getSalary().getTo().toString());
                        System.out.print("до " + to);
                    }
                    System.out.print(" " + searchResult.getItems().get(i).getSalary().getCurrency());
                    if (searchResult.getItems().get(i).getSalary().isGross() != null)
                        System.out.print(searchResult.getItems().get(i).getSalary().isGross().equals("true") ? " до вычета налогов" : " на руки");
                    System.out.println();
                }
                System.out.println("Город: " + searchResult.getItems().get(i).getArea().getName());
                System.out.println("Компания(№" + searchResult.getItems().get(i).getEmployer().getId() + "): " + searchResult.getItems().get(i).getEmployer().getName());
                System.out.println("Url вакансии - " + vacancy.getAlternateUrl());
                if (searchResult.getItems().get(i).getSnippet().getRequirement() != null) {
                    StringBuilder requirement = new StringBuilder(searchResult.getItems().get(i).getSnippet().getRequirement());
                    for (; ; ) {
                        if (requirement.indexOf("<") == -1 && requirement.indexOf(">") == -1)
                            break;
                        requirement.delete(requirement.indexOf("<"), requirement.indexOf(">") + 1);
                    }
                    System.out.println(requirement.toString());
                }
                if (searchResult.getItems().get(i).getSnippet().getResponsibility() != null) {
                    StringBuilder responsibility = new StringBuilder(searchResult.getItems().get(i).getSnippet().getResponsibility());
                    for (; ; ) {
                        if (responsibility.indexOf("<") == -1 && responsibility.indexOf(">") == -1)
                            break;
                        responsibility.delete(responsibility.indexOf("<"), responsibility.indexOf(">") + 1);
                    }
                    System.out.println(responsibility.toString());
                }
            }
            if (i >= 9)
                return page * 10 + i + 1;
        }
        return -1;
    }

    /**
     * @param arguments
     * @param alternateUrl
     * @param clusters
     * @param page
     * @param items
     * @param pages
     * @param perPage
     * @param found
     */
    public SearchHH(Object clusters, List<Item> items, int pages, Object arguments, int found, String alternateUrl, int perPage, int page) {
        super();
        this.clusters = clusters;
        this.items = items;
        this.pages = pages;
        this.arguments = arguments;
        this.found = found;
        this.alternateUrl = alternateUrl;
        this.perPage = perPage;
        this.page = page;
    }

    public Object getClusters() {
        return clusters;
    }

    public void setClusters(Object clusters) {
        this.clusters = clusters;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Object getArguments() {
        return arguments;
    }

    public void setArguments(Object arguments) {
        this.arguments = arguments;
    }

    public int getFound() {
        return found;
    }

    public void setFound(int found) {
        this.found = found;
    }

    public String getAlternateUrl() {
        return alternateUrl;
    }

    public void setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
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

}
