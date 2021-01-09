package com.app.libraryapigateway.pojos;

public class ProductCart {
    private Long id;
    private Long bookId;
    private Integer count;

    public ProductCart() {}

    public ProductCart(Long id, Long bookId, Integer count) {
        this.id = id;
        this.bookId = bookId;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ProductCart{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", count=" + count +
                '}';
    }
}
