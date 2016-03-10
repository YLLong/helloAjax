package com.uiyllong.testAjax.app.beans;

/**
 * Created by YLL on 2016/2/2.
 */
public class ShoppingCartItem {
    private String bookName;
    private int BookNum;
    private int Price;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookNum() {
        return BookNum;
    }

    public void setBookNum(int totalBookNum) {
        this.BookNum = totalBookNum;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int totalPrice) {
        this.Price = totalPrice;
    }
}
