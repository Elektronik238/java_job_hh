
package ru.kuzn_evg.vacancyHHjson;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vacancy {

    @SerializedName("alternate_url")
    @Expose
    private String alternateUrl;
    @SerializedName("code")
    @Expose
    private Object code;
    @SerializedName("premium")
    @Expose
    private boolean premium;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("schedule")
    @Expose
    private Schedule schedule;
    @SerializedName("suitable_resumes_url")
    @Expose
    private Object suitableResumesUrl;
    @SerializedName("site")
    @Expose
    private Site site;
    @SerializedName("billing_type")
    @Expose
    private BillingType billingType;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("test")
    @Expose
    private Object test;
    @SerializedName("accept_handicapped")
    @Expose
    private boolean acceptHandicapped;
    @SerializedName("experience")
    @Expose
    private Experience experience;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("key_skills")
    @Expose
    private List<KeySkill> keySkills = null;
    @SerializedName("allow_messages")
    @Expose
    private boolean allowMessages;
    @SerializedName("employment")
    @Expose
    private Employment employment;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("response_url")
    @Expose
    private Object responseUrl;
    @SerializedName("salary")
    @Expose
    private Salary salary;
    @SerializedName("archived")
    @Expose
    private boolean archived;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("contacts")
    @Expose
    private Contacts contacts;
    @SerializedName("employer")
    @Expose
    private Employer employer;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("area")
    @Expose
    private Area area;
    @SerializedName("relations")
    @Expose
    private List<Object> relations = null;
    @SerializedName("accept_kids")
    @Expose
    private boolean acceptKids;
    @SerializedName("response_letter_required")
    @Expose
    private boolean responseLetterRequired;
    @SerializedName("apply_alternate_url")
    @Expose
    private String applyAlternateUrl;
    @SerializedName("quick_responses_allowed")
    @Expose
    private boolean quickResponsesAllowed;
    @SerializedName("negotiations_url")
    @Expose
    private Object negotiationsUrl;
    @SerializedName("department")
    @Expose
    private Object department;
    @SerializedName("branded_description")
    @Expose
    private String brandedDescription;
    @SerializedName("hidden")
    @Expose
    private boolean hidden;
    @SerializedName("type")
    @Expose
    private Type type;
    @SerializedName("specializations")
    @Expose
    private List<Specialization> specializations = null;

    /**
     * No args constructor for use in serialization
     */
    public Vacancy(String json) {
        if (json == null)
            return;
        Gson gson = new Gson();
        Vacancy vacancyhh = gson.fromJson(json, Vacancy.class);
        System.out.println("\nВакансия № " + vacancyhh.getId() + "\n" + vacancyhh.getName() + "\nГород: " + vacancyhh.getArea().getName());
        if (vacancyhh.getSalary() != null) {
            System.out.print("Зарплата: ");
            if (vacancyhh.getSalary().getFrom() != null) {
                int from = (int) Double.parseDouble(vacancyhh.getSalary().getFrom().toString());
                System.out.print("от " + from);
                if (vacancyhh.getSalary().getTo() != null) {
                    int to = (int) Double.parseDouble(vacancyhh.getSalary().getTo().toString());
                    System.out.print(" до " + to);
                }
            } else if (vacancyhh.getSalary().getTo() != null) {
                int to = (int) Double.parseDouble(vacancyhh.getSalary().getTo().toString());
                System.out.print("до " + to);
            }
            System.out.print(" " + vacancyhh.getSalary().getCurrency());
            if (vacancyhh.getSalary().isGross() != null)
                System.out.print(vacancyhh.getSalary().isGross().equals("true") ? " до вычета налогов" : " на руки");
            System.out.println();
        }
        System.out.println("Компания(№" + vacancyhh.getEmployer().getId() + "): " + vacancyhh.getEmployer().getName());
        if (vacancyhh.getContacts() != null) {
            System.out.print("Контакты:");
            if (vacancyhh.getContacts().getName() != null)
                System.out.print("\nИмя - " + vacancyhh.getContacts().getName());
            if (vacancyhh.getContacts().getEmail() != null)
                System.out.print("\nEmail - " + vacancyhh.getContacts().getEmail());
            if (vacancyhh.getContacts().getPhones().size() > 0) {
                System.out.print("\nТелефон(ы) -");
                for (int i = 0; i < vacancyhh.getContacts().getPhones().size(); i++) {
                    System.out.print(" " + vacancyhh.getContacts().getPhones().get(i).getCountry() + "(" + vacancyhh.getContacts().getPhones().get(i).getCity() + ")" + vacancyhh.getContacts().getPhones().get(i).getNumber());
                }
            }
            System.out.println();
        }
        System.out.println("Url вакансии - " + vacancyhh.getAlternateUrl());
        if (vacancyhh.keySkills.size() > 0) {
            System.out.print("Ключевые навыки: ");
            for (int i = 0; ; i++) {
                System.out.print(vacancyhh.keySkills.get(i).getName());
                if ((i + 1) < vacancyhh.keySkills.size())
                    System.out.print(", ");
                else if ((i + 1) == vacancyhh.keySkills.size()) {
                    System.out.print(".");
                    break;
                }
            }
        }
        StringBuffer description = new StringBuffer(vacancyhh.getDescription());
        for (; ; ) {
            if (description.indexOf("<p>") != -1)
                description.replace(description.indexOf("<p>"), description.indexOf("<p>") + 3, "\n");
            if (description.indexOf("<br>") != -1)
                description.replace(description.indexOf("<br>"), description.indexOf("<br>") + 4, "\n");
            if (description.indexOf("<br />") != -1)
                description.replace(description.indexOf("<br />"), description.indexOf("<br />") + 6, "\n");
            if (description.indexOf("<li>") != -1)
                description.replace(description.indexOf("<li>"), description.indexOf("<li>") + 4, "\n* ");
            if (description.indexOf("<p>") == -1 && description.indexOf("<li>") == -1 && description.indexOf("<br>") == -1 && description.indexOf("<br />") == -1)
                break;
        }
        for (; ; ) {
            if (description.indexOf("<") == -1 && description.indexOf(">") == -1)
                break;
            description.delete(description.indexOf("<"), description.indexOf(">") + 1);
        }
        System.out.println(description.toString());
    }

    /**
     * @param employment
     * @param acceptKids
     * @param test
     * @param department
     * @param employer
     * @param specializations
     * @param type
     * @param contacts
     * @param publishedAt
     * @param id
     * @param area
     * @param acceptHandicapped
     * @param archived
     * @param description
     * @param createdAt
     * @param applyAlternateUrl
     * @param name
     * @param responseUrl
     * @param experience
     * @param billingType
     * @param negotiationsUrl
     * @param salary
     * @param site
     * @param quickResponsesAllowed
     * @param premium
     * @param code
     * @param keySkills
     * @param schedule
     * @param alternateUrl
     * @param relations
     * @param address
     * @param hidden
     * @param responseLetterRequired
     * @param allowMessages
     * @param suitableResumesUrl
     * @param brandedDescription
     */
    public Vacancy(String alternateUrl, Object code, boolean premium, String description, Schedule schedule, Object suitableResumesUrl, Site site, BillingType billingType, String publishedAt, Object test, boolean acceptHandicapped, Experience experience, Address address, List<KeySkill> keySkills, boolean allowMessages, Employment employment, String id, Object responseUrl, Salary salary, boolean archived, String name, Contacts contacts, Employer employer, String createdAt, Area area, List<Object> relations, boolean acceptKids, boolean responseLetterRequired, String applyAlternateUrl, boolean quickResponsesAllowed, Object negotiationsUrl, Object department, String brandedDescription, boolean hidden, Type type, List<Specialization> specializations) {
        super();
        this.alternateUrl = alternateUrl;
        this.code = code;
        this.premium = premium;
        this.description = description;
        this.schedule = schedule;
        this.suitableResumesUrl = suitableResumesUrl;
        this.site = site;
        this.billingType = billingType;
        this.publishedAt = publishedAt;
        this.test = test;
        this.acceptHandicapped = acceptHandicapped;
        this.experience = experience;
        this.address = address;
        this.keySkills = keySkills;
        this.allowMessages = allowMessages;
        this.employment = employment;
        this.id = id;
        this.responseUrl = responseUrl;
        this.salary = salary;
        this.archived = archived;
        this.name = name;
        this.contacts = contacts;
        this.employer = employer;
        this.createdAt = createdAt;
        this.area = area;
        this.relations = relations;
        this.acceptKids = acceptKids;
        this.responseLetterRequired = responseLetterRequired;
        this.applyAlternateUrl = applyAlternateUrl;
        this.quickResponsesAllowed = quickResponsesAllowed;
        this.negotiationsUrl = negotiationsUrl;
        this.department = department;
        this.brandedDescription = brandedDescription;
        this.hidden = hidden;
        this.type = type;
        this.specializations = specializations;
    }

    public String getAlternateUrl() {
        return alternateUrl;
    }

    public void setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Object getSuitableResumesUrl() {
        return suitableResumesUrl;
    }

    public void setSuitableResumesUrl(Object suitableResumesUrl) {
        this.suitableResumesUrl = suitableResumesUrl;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public BillingType getBillingType() {
        return billingType;
    }

    public void setBillingType(BillingType billingType) {
        this.billingType = billingType;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Object getTest() {
        return test;
    }

    public void setTest(Object test) {
        this.test = test;
    }

    public boolean isAcceptHandicapped() {
        return acceptHandicapped;
    }

    public void setAcceptHandicapped(boolean acceptHandicapped) {
        this.acceptHandicapped = acceptHandicapped;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<KeySkill> getKeySkills() {
        return keySkills;
    }

    public void setKeySkills(List<KeySkill> keySkills) {
        this.keySkills = keySkills;
    }

    public boolean isAllowMessages() {
        return allowMessages;
    }

    public void setAllowMessages(boolean allowMessages) {
        this.allowMessages = allowMessages;
    }

    public Employment getEmployment() {
        return employment;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getResponseUrl() {
        return responseUrl;
    }

    public void setResponseUrl(Object responseUrl) {
        this.responseUrl = responseUrl;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Object> getRelations() {
        return relations;
    }

    public void setRelations(List<Object> relations) {
        this.relations = relations;
    }

    public boolean isAcceptKids() {
        return acceptKids;
    }

    public void setAcceptKids(boolean acceptKids) {
        this.acceptKids = acceptKids;
    }

    public boolean isResponseLetterRequired() {
        return responseLetterRequired;
    }

    public void setResponseLetterRequired(boolean responseLetterRequired) {
        this.responseLetterRequired = responseLetterRequired;
    }

    public String getApplyAlternateUrl() {
        return applyAlternateUrl;
    }

    public void setApplyAlternateUrl(String applyAlternateUrl) {
        this.applyAlternateUrl = applyAlternateUrl;
    }

    public boolean isQuickResponsesAllowed() {
        return quickResponsesAllowed;
    }

    public void setQuickResponsesAllowed(boolean quickResponsesAllowed) {
        this.quickResponsesAllowed = quickResponsesAllowed;
    }

    public Object getNegotiationsUrl() {
        return negotiationsUrl;
    }

    public void setNegotiationsUrl(Object negotiationsUrl) {
        this.negotiationsUrl = negotiationsUrl;
    }

    public Object getDepartment() {
        return department;
    }

    public void setDepartment(Object department) {
        this.department = department;
    }

    public String getBrandedDescription() {
        return brandedDescription;
    }

    public void setBrandedDescription(String brandedDescription) {
        this.brandedDescription = brandedDescription;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }

}
