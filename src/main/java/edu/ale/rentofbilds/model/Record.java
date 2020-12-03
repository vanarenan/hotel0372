package edu.ale.rentofbilds.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Record {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime start;
    private LocalDateTime finish;
    private Client client;
    private Room room;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;

    public Record() {
    }

    public Record(String id, String name, String description, LocalDateTime start, LocalDateTime finish, Client client, Room room, LocalDateTime created_at, LocalDateTime modified_at) {
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

    public Record(String name, String description, LocalDateTime start, LocalDateTime finish, Client client, Room room) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
        this.client = client;
        this.room = room;
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

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getModified_at() {
        return modified_at;
    }

    public void setModified_at(LocalDateTime modified_at) {
        this.modified_at = modified_at;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start=" + start +
                ", finish=" + finish +
                ", client=" + client +
                ", room=" + room +
                ", created_at=" + created_at +
                ", modified_at=" + modified_at +
                '}';
    }
}
