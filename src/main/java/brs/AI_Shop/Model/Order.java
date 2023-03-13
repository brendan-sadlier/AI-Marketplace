package brs.AI_Shop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private int order_number;
    private String sku;
    private double price;
    private int customer_id;
    private boolean fulfilled;
    private Date date_ordered;

    public Order() {}

    public Order(int order_number, String sku, double price, int customer_id, boolean fulfilled, Date date_ordered) {
        this.order_number = order_number;
        this.sku = sku;
        this.price = price;
        this.customer_id = customer_id;
        this.fulfilled = fulfilled;
        this.date_ordered = date_ordered;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    public Date getDate_ordered() {
        return date_ordered;
    }

    public void setDate_ordered(Date date_ordered) {
        this.date_ordered = date_ordered;
    }
}
