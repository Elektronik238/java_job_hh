
package ru.kuzn_evg.employerSearchHHjson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("alternate_url")
    @Expose
    private String alternateUrl;
    @SerializedName("vacancies_url")
    @Expose
    private String vacanciesUrl;
    @SerializedName("open_vacancies")
    @Expose
    private int openVacancies;
    @SerializedName("logo_urls")
    @Expose
    private LogoUrls logoUrls;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }

    /**
     * 
     * @param id
     * @param openVacancies
     * @param alternateUrl
     * @param name
     * @param logoUrls
     * @param vacanciesUrl
     * @param url
     */
    public Item(String id, String name, String url, String alternateUrl, String vacanciesUrl, int openVacancies, LogoUrls logoUrls) {
        super();
        this.id = id;
        this.name = name;
        this.url = url;
        this.alternateUrl = alternateUrl;
        this.vacanciesUrl = vacanciesUrl;
        this.openVacancies = openVacancies;
        this.logoUrls = logoUrls;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlternateUrl() {
        return alternateUrl;
    }

    public void setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
    }

    public String getVacanciesUrl() {
        return vacanciesUrl;
    }

    public void setVacanciesUrl(String vacanciesUrl) {
        this.vacanciesUrl = vacanciesUrl;
    }

    public int getOpenVacancies() {
        return openVacancies;
    }

    public void setOpenVacancies(int openVacancies) {
        this.openVacancies = openVacancies;
    }

    public LogoUrls getLogoUrls() {
        return logoUrls;
    }

    public void setLogoUrls(LogoUrls logoUrls) {
        this.logoUrls = logoUrls;
    }

}
