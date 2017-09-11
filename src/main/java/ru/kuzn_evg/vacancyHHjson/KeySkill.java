
package ru.kuzn_evg.vacancyHHjson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KeySkill {

    @SerializedName("name")
    @Expose
    private String name;

    /**
     * No args constructor for use in serialization
     * 
     */
    public KeySkill() {
    }

    /**
     * 
     * @param name
     */
    public KeySkill(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
