package com.app.libraryapigateway.aggregator;

import com.app.libraryapigateway.dtos.CartDto;
import com.app.libraryapigateway.dtos.OrderDto;
import com.app.libraryapigateway.pojos.Book;
import com.app.libraryapigateway.pojos.OrderEntity;
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
            cartDto.setId(cart.getId());
            cartDto.setName(book.getName());
            cartDto.setPrice(book.getPrice());
            cartDto.setQuantity(cart.getCount().toString());
            result.add(cartDto);
        }


        return result;
    }

    public List<OrderDto> getOrderAggregatedDetails() {
        List<OrderDto> result = new ArrayList<>();
        List<Book> books = getBooks();
        List<OrderEntity> orders = getOrders();
        LOG.info("books: {}", books);
        LOG.info("orders: {}", orders);

        for (OrderEntity order: orders) {
            OrderDto orderDto = new OrderDto();
            Book book = getBookByBookId(books, order.getItemId());
            orderDto.setId(order.getId());
            orderDto.setOrderName(book.getName());
            orderDto.setStatus(order.getStatus());

            result.add(orderDto);
        }
        return result;
    }

    private Book getBookByBookId(List<Book> books, Long bookId) {
        return books.stream().filter(book -> book.getId().equals(bookId)).findFirst().get();
    }

    private List<OrderEntity> getOrders() {
        List<OrderEntity> carts;
        OrderEntity[] cartObjects = restTemplate.getForObject(ordersUrl, OrderEntity[].class);
        if (ArrayUtils.isEmpty(cartObjects)) {
            carts = new ArrayList<>();
        } else {
            carts = Arrays.asList(cartObjects);
        }
        return carts;
    }

    private List<ProductCart> getCarts() {
        List<ProductCart> carts;
        ProductCart[] cartObjects = restTemplate.getForObject(cartsUrl, ProductCart[].class);
        if (ArrayUtils.isEmpty(cartObjects)) {
            carts = new ArrayList<>();
        } else {
            carts = Arrays.asList(cartObjects);
        }
        return carts;
    }

    private List<Book> getBooks() {
        List<Book> books;
        Book[] booksObjects = restTemplate.getForObject(booksUrl, Book[].class);
        if (ArrayUtils.isEmpty(booksObjects)) {
            books = new ArrayList<>();
        } else {
            books = Arrays.asList(booksObjects);
        }
        return books;
    }

}
