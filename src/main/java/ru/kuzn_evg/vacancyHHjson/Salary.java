package ru.kuzn_evg.vacancyHHjson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Salary {

    @SerializedName("to")
    @Expose
    private Object to;
    @SerializedName("gross")
    @Expose
    private Object gross;
    @SerializedName("from")
    @Expose
    private Object from;
    @SerializedName("currency")
    @Expose
    private String currency;

    /**
     * No args constructor for use in serialization
     *
     */
    public Salary() {
    }

    /**
     *
     * @param to
     * @param gross
     * @param from
     * @param currency
     */
    public Salary(Object to, boolean gross, Object from, String currency) {
        super();
        this.to = to;
        this.gross = gross;
        this.from = from;
        this.currency = currency;
    }

    public Object getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public Object isGross() {
        return gross;
    }

    public void setGross(boolean gross) {
        this.gross = gross;
    }

    public Object getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}