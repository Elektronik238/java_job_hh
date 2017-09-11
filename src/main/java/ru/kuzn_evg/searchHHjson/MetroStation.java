
package ru.kuzn_evg.searchHHjson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetroStation {

    @SerializedName("line_name")
    @Expose
    private String lineName;
    @SerializedName("station_id")
    @Expose
    private String stationId;
    @SerializedName("line_id")
    @Expose
    private String lineId;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("station_name")
    @Expose
    private String stationName;
    @SerializedName("lng")
    @Expose
    private double lng;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MetroStation() {
    }

    /**
     * 
     * @param lineName
     * @param stationId
     * @param lng
     * @param stationName
     * @param lat
     * @param lineId
     */
    public MetroStation(String lineName, String stationId, String lineId, double lat, String stationName, double lng) {
        super();
        this.lineName = lineName;
        this.stationId = stationId;
        this.lineId = lineId;
        this.lat = lat;
        this.stationName = stationName;
        this.lng = lng;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

}
