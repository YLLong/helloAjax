package com.uiyllong.testAjax.app.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YLL on 2016/2/2.
 */
public class ShoppingCart {
    //存放 ShoppingCartItem 的 Map: 键：书名 值：ShoppingCartItem 对象
    private Map<String, ShoppingCartItem> items = new HashMap<String, ShoppingCartItem>();
    private String bookName;
    public void addToCart(String bookName, int price) {
        this.bookName = bookName;
        if(items.containsKey(bookName)) {
            ShoppingCartItem item = items.get(bookName);
            item.setBookNum(item.getBookNum() + 1);
        }else {
            ShoppingCartItem item = new ShoppingCartItem();
            item.setBookName(bookName);
            item.setBookNum(1);
            item.setPrice(price);
            items.put(bookName, item);
        }
    }

    public int getTotalBookNum() {
        int number = 0;
        for(ShoppingCartItem item: items.values()) {
            number += item.getBookNum();
        }
        return number;
    }

    public String getBookName() {
        return bookName;
    }

    public int getTotalMoney() {
        int money = 0;
        for(ShoppingCartItem item: items.values()) {
            money += item.getBookNum() * item.getPrice();
        }
        return money;
    }
}
