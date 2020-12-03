package edu.ale.rentofbilds.forms;

import java.time.LocalDateTime;

public class ItemForm {
    private String id = " ";
    private String name = " ";
    private String price = " ";
    private String capacity = " ";

    @Override
    public String toString() {
        return "ItemForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", capacity='" + capacity + '\'' +
                ", type='" + type + '\'' +
                ", reservation='" + reservation + '\'' +
                ", created_at='" + created_at + '\'' +
                ", modified_at='" + modified_at + '\'' +
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

    public ItemForm(String name, String price, String capacity, String type, String reservation) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.type = type;
        this.reservation = reservation;
    }

    public ItemForm(String id, String name, String price, String capacity, String type, String reservation) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.type = type;
        this.reservation = reservation;
    }

    public ItemForm(String id, String name, String price, String capacity, String type, String reservation, String created_at, String modified_at) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.type = type;
        this.reservation = reservation;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    private String type = " ";
    private String reservation = " ";
    private String created_at = "";
    private String modified_at = "";

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

    public ItemForm(String name, String reservation) {
        this.name = name;
        this.reservation = reservation;
    }

    public ItemForm(String id, String name, String reservation) {
        this.id = id;
        this.name = name;
        this.reservation = reservation;
    }

    public ItemForm() {
    }
}
