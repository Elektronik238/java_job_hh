
package ru.kuzn_evg.searchHHjson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Area {

    @SerializedName("url")
    @Expose
    private String url;
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
    public Area() {
    }

    /**
     * 
     * @param id
     * @param name
     * @param url
     */
    public Area(String url, String id, String name) {
        super();
        this.url = url;
        this.id = id;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
