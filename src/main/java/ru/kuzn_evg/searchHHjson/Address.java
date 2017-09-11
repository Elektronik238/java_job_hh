
package ru.kuzn_evg.searchHHjson;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("building")
    @Expose
    private String building;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("metro")
    @Expose
    private Object metro;
    @SerializedName("metro_stations")
    @Expose
    private List<MetroStation> metroStations = null;
    @SerializedName("raw")
    @Expose
    private Object raw;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lng")
    @Expose
    private double lng;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Address() {
    }

    /**
     * 
     * @param id
     * @param raw
     * @param building
     * @param metro
     * @param description
     * @param street
     * @param lng
     * @param lat
     * @param metroStations
     * @param city
     */
    public Address(String building, String city, Object description, Object metro, List<MetroStation> metroStations, Object raw, String street, double lat, double lng, String id) {
        super();
        this.building = building;
        this.city = city;
        this.description = description;
        this.metro = metro;
        this.metroStations = metroStations;
        this.raw = raw;
        this.street = street;
        this.lat = lat;
        this.lng = lng;
        this.id = id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getMetro() {
        return metro;
    }

    public void setMetro(Object metro) {
        this.metro = metro;
    }

    public List<MetroStation> getMetroStations() {
        return metroStations;
    }

    public void setMetroStations(List<MetroStation> metroStations) {
        this.metroStations = metroStations;
    }

    public Object getRaw() {
        return raw;
    }

    public void setRaw(Object raw) {
        this.raw = raw;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
