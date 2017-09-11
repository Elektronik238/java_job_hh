package ru.kuzn_evg;

import ru.kuzn_evg.employerHHjson.Employer;
import ru.kuzn_evg.employerSearchHHjson.EmployerSearch;
import ru.kuzn_evg.searchHHjson.SearchHH;
import ru.kuzn_evg.vacancyHHjson.Vacancy;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        System.out.println("###########################################");
        for (; ; ) {
            ResultUI result = UI.UserInterface();
            if (result.getCode() == 1) {
                int i = 0;
                while (i != -1) {
                    URL url = null;
                    try {
                        url = new URL(result.getURL().toString()+"&page="+i/10);
                    } catch (MalformedURLException e) {
                        System.out.println("Введено недопустимое значение.");
                    }
                    i = SearchHH.SearchHH(GetJSON.load(url), i);
                }
            } else if (result.getCode() == 2) {
                new Vacancy(GetJSON.load(result.getURL()));
            } else if (result.getCode() == 3) {
                int i = 0;
                while (i != -1) {
                    URL url = null;
                    try {
                        url = new URL(result.getURL().toString()+"&page="+i/10);
                    } catch (MalformedURLException e) {
                        System.out.println("Введено недопустимое значение.");
                    }
                    i = EmployerSearch.EmployerSearch(GetJSON.load(url), i);
                }
            } else if (result.getCode() == 4) {
                new Employer(GetJSON.load(result.getURL()));
            }
        }
        //
    }

    public static class ResultUI {
        private static int code;
        private static URL url;

        public ResultUI(URL url, int code) {
            ResultUI.url = url;
            ResultUI.code = code;
        }

        static int getCode() {
            return code;
        }

        static URL getURL() {
            return url;
        }
    }
}
