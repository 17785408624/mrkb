package com.mrkb.dao.modle.order;

public class OrderStore {
	private Integer order_store_id;//订单包含商品ID
    private Integer order_id;//商品ID
    private Integer store_id;//商品ID
    private Integer store_num;//商品数量

    public Integer getOrder_store_id() {
        return order_store_id;
    }

    public void setOrder_store_id(Integer order_store_id) {
        this.order_store_id = order_store_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    public Integer getStore_num() {
        return store_num;
    }

    public void setStore_num(Integer store_num) {
        this.store_num = store_num;
    }

    @Override
    public String toString() {
        return "OrderStore{" +
                "order_store_id=" + order_store_id +
                ", order_id=" + order_id +
                ", store_id=" + store_id +
                ", store_num=" + store_num +
                '}';
    }
}
