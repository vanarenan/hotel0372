package edu.ale.rentofbilds.forms;

public class ClientForm {
    private String id = "";
    private String name = "";

    @Override
    public String toString() {
        return "ClientForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", passport='" + passport + '\'' +
                ", description='" + description + '\'' +
                ", created_at='" + created_at + '\'' +
                ", modified_at='" + modified_at + '\'' +
                '}';
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public ClientForm(String id, String name, String passport, String description) {
        this.id = id;
        this.name = name;
        this.passport = passport;
        this.description = description;
    }

    public ClientForm(String id, String name, String passport, String description, String created_at, String modified_at) {
        this.id = id;
        this.name = name;
        this.passport = passport;
        this.description = description;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    private String passport = "";
    private String description = "";
    private String created_at = "";

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getModified_at() {
        return modified_at;
    }

    public void setModified_at(String modified_at) {
        this.modified_at = modified_at;
    }

    private String modified_at = "";

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ClientForm(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ClientForm(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ClientForm() {
    }
}
