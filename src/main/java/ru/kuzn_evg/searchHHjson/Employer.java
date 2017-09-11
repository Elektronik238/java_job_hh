
package ru.kuzn_evg.searchHHjson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employer {

    @SerializedName("logo_urls")
    @Expose
    private LogoUrls logoUrls;
    @SerializedName("vacancies_url")
    @Expose
    private String vacanciesUrl;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("alternate_url")
    @Expose
    private String alternateUrl;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("trusted")
    @Expose
    private boolean trusted;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Employer() {
    }

    /**
     * 
     * @param id
     * @param trusted
     * @param alternateUrl
     * @param name
     * @param vacanciesUrl
     * @param logoUrls
     * @param url
     */
    public Employer(LogoUrls logoUrls, String vacanciesUrl, String name, String url, String alternateUrl, String id, boolean trusted) {
        super();
        this.logoUrls = logoUrls;
        this.vacanciesUrl = vacanciesUrl;
        this.name = name;
        this.url = url;
        this.alternateUrl = alternateUrl;
        this.id = id;
        this.trusted = trusted;
    }

    public LogoUrls getLogoUrls() {
        return logoUrls;
    }

    public void setLogoUrls(LogoUrls logoUrls) {
        this.logoUrls = logoUrls;
    }

    public String getVacanciesUrl() {
        return vacanciesUrl;
    }

    public void setVacanciesUrl(String vacanciesUrl) {
        this.vacanciesUrl = vacanciesUrl;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isTrusted() {
        return trusted;
    }

    public void setTrusted(boolean trusted) {
        this.trusted = trusted;
    }

}
