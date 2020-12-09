package edu.ale.rentofbilds.forms;

import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Room;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RecordForm {
    private String id;
    private String name;
    private String description;
    private String start;
    private String finish;
    private String client;
    private String room;
    private String created_at;
    private String modified_at;

    @Override
    public String toString() {
        return "RecordForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start='" + start + '\'' +
                ", finish='" + finish + '\'' +
                ", client='" + client + '\'' +
                ", room='" + room + '\'' +
                ", created_at='" + created_at + '\'' +
                ", modified_at='" + modified_at + '\'' +
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

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

    public RecordForm(String name, String description, String start, String finish, String client, String room) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
        this.client = client;
        this.room = room;
    }

    public RecordForm(String id, String name, String description, String start, String finish, String client, String room, String created_at, String modified_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
        this.client = client;
        this.room = room;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public RecordForm() {
    }
}
