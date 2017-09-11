
package ru.kuzn_evg.employerHHjson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogoUrls {

    @SerializedName("90")
    @Expose
    private String _90;
    @SerializedName("240")
    @Expose
    private String _240;
    @SerializedName("original")
    @Expose
    private String original;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LogoUrls() {
    }

    /**
     * 
     * @param original
     * @param _240
     * @param _90
     */
    public LogoUrls(String _90, String _240, String original) {
        super();
        this._90 = _90;
        this._240 = _240;
        this.original = original;
    }

    public String get90() {
        return _90;
    }

    public void set90(String _90) {
        this._90 = _90;
    }

    public String get240() {
        return _240;
    }

    public void set240(String _240) {
        this._240 = _240;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

}
