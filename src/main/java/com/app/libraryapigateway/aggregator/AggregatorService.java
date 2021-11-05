package com.app.libraryapigateway.aggregator;

import com.app.libraryapigateway.dtos.CartDto;
import com.app.libraryapigateway.dtos.OrderDto;
import com.app.libraryapigateway.pojos.Book;
import com.app.libraryapigateway.pojos.OrderItem;
import com.app.libraryapigateway.pojos.ProductCart;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AggregatorService {
    private static final Logger LOG = LoggerFactory.getLogger(AggregatorService.class);

    @Value("${books.url}")
    private String booksUrl;

    @Value("${carts.url}")
    private String cartsUrl;

    @Value("${orders.url}")
    private String ordersUrl;

    @Autowired
    private RestTemplate restTemplate;

    public List<CartDto> getCartAggregatedDetails() {
        List<Book> books = getBooks();
        List<ProductCart> carts = getCarts();
        LOG.info("books: {}", books);
        LOG.info("carts: {}", carts);

        List<CartDto> result = new ArrayList<>();
        for (ProductCart cart : carts) {
            CartDto cartDto = new CartDto();
            Book book = getBookByBookId(books, cart.getBookId());
            if(book != null) {
                cartDto.setId(cart.getId());
                cartDto.setName(book.getName());
                cartDto.setPrice(book.getPrice());
                cartDto.setQuantity(cart.getCount().toString());
                result.add(cartDto);
            }
        }
        return result;
    }

    public List<CartDto> getCartAggregatedDetailsByUserId(String userId) {
        return null;
    }

    public List<OrderDto> getOrderAggregatedDetailsByUserId(String userId) {
        return null;
    }

    public List<OrderDto> getOrderAggregatedDetails() {
        List<OrderDto> result = new ArrayList<>();
        List<Book> books = getBooks();
        List<OrderItem> orders = getOrders();
        LOG.info("books: {}", books);
        LOG.info("orders: {}", orders);

        for (OrderItem order: orders) {
            OrderDto orderDto = new OrderDto();
            Book book = getBookByBookId(books, order.getItemId());
            if(book != null) {
                orderDto.setId(order.getId());
                orderDto.setOrderName(book.getName());
                orderDto.setStatus(order.getStatus());

                result.add(orderDto);
            }
        }
        return result;
    }



    private Book getBookByBookId(List<Book> books, Long bookId) {
        return books.stream().filter(book -> book.getId().equals(bookId)).findFirst().orElse(null);
    }

    private List<OrderItem> getOrders() {
        OrderItem[] orderItems = restTemplate.getForObject(ordersUrl, OrderItem[].class);
        return ArrayUtils.isEmpty(orderItems) ? Collections.emptyList() : Arrays.asList(orderItems);
    }

    private List<ProductCart> getCarts() {
        ProductCart[] cartObjects = restTemplate.getForObject(cartsUrl, ProductCart[].class);
        return ArrayUtils.isEmpty(cartObjects) ? Collections.emptyList() : Arrays.asList(cartObjects);
    }

    private List<Book> getBooks() {
        Book[] booksObjects = restTemplate.getForObject(booksUrl, Book[].class);
        return ArrayUtils.isEmpty(booksObjects) ? Collections.emptyList() : Arrays.asList(booksObjects);
    }
}
