
package ru.kuzn_evg.searchHHjson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Snippet {

    @SerializedName("requirement")
    @Expose
    private String requirement;
    @SerializedName("responsibility")
    @Expose
    private String responsibility;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Snippet() {
    }

    /**
     * 
     * @param requirement
     * @param responsibility
     */
    public Snippet(String requirement, String responsibility) {
        super();
        this.requirement = requirement;
        this.responsibility = responsibility;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

}
