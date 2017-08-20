package com.contest.recommend;

import java.util.List;

/**
 * Created by xhans on 2016/4/20.
 */
public class Order {
    private List<Item> items;
    private double expressFee;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getExpressFee() {
        return expressFee;
    }

    public void setExpressFee(double expressFee) {
        this.expressFee = expressFee;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public double getItemsFee(){
        double total = 0;
        for (Item item : items){
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public double getTotalFee(){

        return getItemsFee() + expressFee;
    }
}
