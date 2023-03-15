package brs.AI_Shop.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    private int order_number;
    @Column(nullable = false)
    private int sku;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int user_id;
    @Column(nullable = false)
    private boolean fulfilled;

    public Order() {}

    public Order(int order_number, int sku, double price, int customer_id, boolean fulfilled) {
        this.order_number = order_number;
        this.sku = sku;
        this.price = price;
        this.user_id = customer_id;
        this.fulfilled = fulfilled;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

}
