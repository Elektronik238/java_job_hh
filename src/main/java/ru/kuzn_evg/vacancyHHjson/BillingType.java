
package ru.kuzn_evg.vacancyHHjson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BillingType {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BillingType() {
    }

    /**
     * 
     * @param id
     * @param name
     */
    public BillingType(String id, String name) {
        super();
        this.id = id;
        this.name = name;
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

}
