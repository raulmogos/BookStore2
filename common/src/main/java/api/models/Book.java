package api.models;

import java.io.Serializable;

public class Book extends BaseEntity<Long> implements Serializable {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book(Long ID, String title, String author, double price) {
        this.id = ID;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }

    //    @Override
//    public String toString() {
//        return "Book - ID = " + id + ", title = " + title + ", author = " + author + ", price = " + price + ";";
//    }
}
