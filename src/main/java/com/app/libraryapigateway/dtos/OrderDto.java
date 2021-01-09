package com.app.libraryapigateway.dtos;

public class OrderDto {
    private Long id;
    private String orderName;
    private String status;

    public OrderDto() {}

    public OrderDto(Long id, String orderName, String status) {
        this.id = id;
        this.orderName = orderName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
