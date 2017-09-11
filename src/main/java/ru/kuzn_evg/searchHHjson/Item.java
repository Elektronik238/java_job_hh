
package ru.kuzn_evg.searchHHjson;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("salary")
    @Expose
    private Salary salary;
    @SerializedName("snippet")
    @Expose
    private Snippet snippet;
    @SerializedName("archived")
    @Expose
    private boolean archived;
    @SerializedName("premium")
    @Expose
    private boolean premium;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("area")
    @Expose
    private Area area;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("alternate_url")
    @Expose
    private String alternateUrl;
    @SerializedName("apply_alternate_url")
    @Expose
    private String applyAlternateUrl;
    @SerializedName("relations")
    @Expose
    private List<Object> relations = null;
    @SerializedName("employer")
    @Expose
    private Employer employer;
    @SerializedName("response_letter_required")
    @Expose
    private boolean responseLetterRequired;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("department")
    @Expose
    private Object department;
    @SerializedName("sort_point_distance")
    @Expose
    private Object sortPointDistance;
    @SerializedName("type")
    @Expose
    private Type type;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }

    /**
     * 
     * @param sortPointDistance
     * @param department
     * @param premium
     * @param employer
     * @param snippet
     * @param type
     * @param url
     * @param id
     * @param publishedAt
     * @param area
     * @param archived
     * @param alternateUrl
     * @param address
     * @param relations
     * @param createdAt
     * @param name
     * @param applyAlternateUrl
     * @param responseLetterRequired
     * @param salary
     */
    public Item(Salary salary, Snippet snippet, boolean archived, boolean premium, String name, Area area, String url, String createdAt, String alternateUrl, String applyAlternateUrl, List<Object> relations, Employer employer, boolean responseLetterRequired, String publishedAt, Address address, Object department, Object sortPointDistance, Type type, String id) {
        super();
        this.salary = salary;
        this.snippet = snippet;
        this.archived = archived;
        this.premium = premium;
        this.name = name;
        this.area = area;
        this.url = url;
        this.createdAt = createdAt;
        this.alternateUrl = alternateUrl;
        this.applyAlternateUrl = applyAlternateUrl;
        this.relations = relations;
        this.employer = employer;
        this.responseLetterRequired = responseLetterRequired;
        this.publishedAt = publishedAt;
        this.address = address;
        this.department = department;
        this.sortPointDistance = sortPointDistance;
        this.type = type;
        this.id = id;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAlternateUrl() {
        return alternateUrl;
    }

    public void setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
    }

    public String getApplyAlternateUrl() {
        return applyAlternateUrl;
    }

    public void setApplyAlternateUrl(String applyAlternateUrl) {
        this.applyAlternateUrl = applyAlternateUrl;
    }

    public List<Object> getRelations() {
        return relations;
    }

    public void setRelations(List<Object> relations) {
        this.relations = relations;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public boolean isResponseLetterRequired() {
        return responseLetterRequired;
    }

    public void setResponseLetterRequired(boolean responseLetterRequired) {
        this.responseLetterRequired = responseLetterRequired;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Object getDepartment() {
        return department;
    }

    public void setDepartment(Object department) {
        this.department = department;
    }

    public Object getSortPointDistance() {
        return sortPointDistance;
    }

    public void setSortPointDistance(Object sortPointDistance) {
        this.sortPointDistance = sortPointDistance;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
