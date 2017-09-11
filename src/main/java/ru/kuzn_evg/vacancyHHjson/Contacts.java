package ru.kuzn_evg.vacancyHHjson;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contacts {

    @SerializedName("phones")
    @Expose
    private List<Phone> phones = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;

    /**
     * No args constructor for use in serialization
     *
     */
    public Contacts() {
    }

    /**
     *
     * @param email
     * @param name
     * @param phones
     */
    public Contacts(List<Phone> phones, String name, String email) {
        super();
        this.phones = phones;
        this.name = name;
        this.email = email;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}