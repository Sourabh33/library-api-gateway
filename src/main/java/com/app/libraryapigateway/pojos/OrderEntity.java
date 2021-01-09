package com.app.libraryapigateway.pojos;

public class OrderEntity {
    private Long id;
    private Long itemId;
    private String status;

    public OrderEntity() {
    }

    public OrderEntity(Long id, Long itemId, String status) {
        this.id = id;
        this.itemId = itemId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
