package ru.kuzn_evg.vacancyHHjson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Phone {

    @SerializedName("comment")
    @Expose
    private Object comment;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("country")
    @Expose
    private String country;

    /**
     * No args constructor for use in serialization
     *
     */
    public Phone() {
    }

    /**
     *
     * @param number
     * @param comment
     * @param country
     * @param city
     */
    public Phone(Object comment, String city, String number, String country) {
        super();
        this.comment = comment;
        this.city = city;
        this.number = number;
        this.country = country;
    }

    public Object getComment() {
        return comment;
    }

    public void setComment(Object comment) {
        this.comment = comment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}