package book;

import java.util.ArrayList;

public class book {
    public ArrayList<String> book;
    public String name;
    public float bookprice;

    public ArrayList<String> getBook() {
        return book;
    }

    public void setBook(ArrayList<String> book) {
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBookprice() {
        return bookprice;
    }

    public void setBookprice(float bookprice) {
        this.bookprice = bookprice;
    }
}
