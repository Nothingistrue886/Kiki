package com.czff.study.knowledge.comparator;

/**
 * @author cuidi
 * @date 2020/8/6 16:28
 * @description Comparable是排序接口，若一个类实现了Comparable接口，就意味着“该类支持排序”。
 */
public class Book implements Comparable<Book> {
    private String name;
    private String title;
    private Double price;

    public Book(String name, String title, Double price) {
        this.name = name;
        this.title = title;
        this.price = price;
    }

    @Override
    public int compareTo(Book book) {
        if (this.price > book.price) {
            return 1;
        } else if (this.price < book.price) {
            return -1;
        } else {
            return 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
