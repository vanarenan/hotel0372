package edu.ale.rentofbilds.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
@Document
public class Item {
    @Id
    private String id;
    private String name;
    private String price;
    private String capacity;
    private String type;
    private String reservation;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", capacity='" + capacity + '\'' +
                ", type='" + type + '\'' +
                ", reservation='" + reservation + '\'' +
                ", created_at=" + created_at +
                ", modified_at=" + modified_at +
                '}';
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Item(String name, String price, String capacity, String type, String reservation) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.type = type;
        this.reservation = reservation;
    }

    public Item(String id, String name, String price, String capacity, String type, String reservation) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.type = type;
        this.reservation = reservation;
    }

    public Item(String id, String name, String price, String capacity, String type, String reservation, LocalDateTime created_at, LocalDateTime modified_at) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.type = type;
        this.reservation = reservation;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }



    public Item() {
    }

    public Item(String name, String reservation) {
        this.name = name;
        this.reservation = reservation;
    }

    public Item(String id, String name, String reservation, LocalDateTime created_at, LocalDateTime modified_at) {
        this.id = id;
        this.name = name;
        this.reservation = reservation;
        this.created_at = created_at;
        this.modified_at = modified_at;
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

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getId().equals(item.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
