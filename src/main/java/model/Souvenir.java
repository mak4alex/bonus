package model;

import java.util.Date;

public class Souvenir {

    private int id;
    private String name;
    private Date madeDate;
    private double price;
    private int producerId;
    private Producer producer;    

    public Souvenir() {
        id = -1;
        producerId = -1;
        name = "NoName";
        madeDate = new Date();
        price = 0.0;
        producer = null;
    }

    public Souvenir(int id, String name, Date madeDate, double price, Producer producer) {
        this.id = id;
        this.name = name;
        this.madeDate = madeDate;
        this.price = price;
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getMadeDate() {
        return madeDate;
    }

    public void setMadeDate(Date madeDate) {
        this.madeDate = madeDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

}
