package edu.ale.rentofbilds.forms;

public class ClientForm {
    private String id = "";
    private String name = "";
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

    @Override
    public String toString() {
        return "ClientForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
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
