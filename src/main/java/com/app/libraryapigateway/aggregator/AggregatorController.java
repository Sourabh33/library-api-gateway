package com.app.libraryapigateway.aggregator;

import com.app.libraryapigateway.dtos.CartDto;
import com.app.libraryapigateway.dtos.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("li-gateway/aggregate")
public class AggregatorController {

    @Autowired
    private AggregatorService service;

    @GetMapping("/cart/details")
    public ResponseEntity<List<CartDto>> getCartDetails() {
        return ResponseEntity.ok(service.getCartAggregatedDetails());
    }

    @GetMapping("/order/details")
    public ResponseEntity<List<OrderDto>> getOrderDetails() {
        return ResponseEntity.ok(service.getOrderAggregatedDetails());
    }
}
