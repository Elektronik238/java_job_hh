
package ru.kuzn_evg.employerHHjson;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employer {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("site_url")
    @Expose
    private String siteUrl;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("branded_description")
    @Expose
    private String brandedDescription;
    @SerializedName("vacancies_url")
    @Expose
    private String vacanciesUrl;
    @SerializedName("trusted")
    @Expose
    private boolean trusted;
    @SerializedName("alternate_url")
    @Expose
    private String alternateUrl;
    @SerializedName("logo_urls")
    @Expose
    private LogoUrls logoUrls;
    @SerializedName("area")
    @Expose
    private Area area;

    /**
     * No args constructor for use in serialization
     */
    public Employer(String json) {
        if (json == null)
            return;
        Gson gson = new Gson();
        Employer employerhh = gson.fromJson(json, Employer.class);
        System.out.println("Компания(" + employerhh.getId() + "): " + employerhh.getName());
        if (employerhh.getSiteUrl() != null)
            System.out.println("Сайт: " + employerhh.getSiteUrl());
        StringBuffer description = new StringBuffer(employerhh.getDescription());
        for (; ; ) {
            if (description.indexOf("<p>") != -1)
                description.replace(description.indexOf("<p>"), description.indexOf("<p>") + 3, "\n");
            if (description.indexOf("<br>") != -1)
                description.replace(description.indexOf("<br>"), description.indexOf("<br>") + 4, "\n");
            if (description.indexOf("<br />") != -1)
                description.replace(description.indexOf("<br />"), description.indexOf("<br />") + 6, "\n");
            if (description.indexOf("<li>") != -1)
                description.replace(description.indexOf("<li>"), description.indexOf("<li>") + 4, "\n* ");
            if (description.indexOf("<p>") == -1 && description.indexOf("<li>") == -1 && description.indexOf("<br>") == -1 && description.indexOf("<br />") == -1)
                break;
        }
        for (; ; ) {
            if (description.indexOf("<") == -1 && description.indexOf(">") == -1)
                break;
            description.delete(description.indexOf("<"), description.indexOf(">") + 1);
        }
        System.out.println(description.toString());
    }

    /**
     * @param siteUrl
     * @param id
     * @param area
     * @param trusted
     * @param alternateUrl
     * @param description
     * @param name
     * @param logoUrls
     * @param vacanciesUrl
     * @param type
     * @param brandedDescription
     */
    public Employer(String name, String type, String id, String siteUrl, String description, String brandedDescription, String vacanciesUrl, boolean trusted, String alternateUrl, LogoUrls logoUrls, Area area) {
        super();
        this.name = name;
        this.type = type;
        this.id = id;
        this.siteUrl = siteUrl;
        this.description = description;
        this.brandedDescription = brandedDescription;
        this.vacanciesUrl = vacanciesUrl;
        this.trusted = trusted;
        this.alternateUrl = alternateUrl;
        this.logoUrls = logoUrls;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrandedDescription() {
        return brandedDescription;
    }

    public void setBrandedDescription(String brandedDescription) {
        this.brandedDescription = brandedDescription;
    }

    public String getVacanciesUrl() {
        return vacanciesUrl;
    }

    public void setVacanciesUrl(String vacanciesUrl) {
        this.vacanciesUrl = vacanciesUrl;
    }

    public boolean isTrusted() {
        return trusted;
    }

    public void setTrusted(boolean trusted) {
        this.trusted = trusted;
    }

    public String getAlternateUrl() {
        return alternateUrl;
    }

    public void setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
    }

    public LogoUrls getLogoUrls() {
        return logoUrls;
    }

    public void setLogoUrls(LogoUrls logoUrls) {
        this.logoUrls = logoUrls;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

}
