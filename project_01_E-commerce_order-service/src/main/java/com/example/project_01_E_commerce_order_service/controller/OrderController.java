package com.example.project_01_E_commerce_order_service.controller;

import com.example.project_01_E_commerce_order_service.dto.OrderResponseDTO;
import com.example.project_01_E_commerce_order_service.dto.ProductDTO;
import com.example.project_01_E_commerce_order_service.entity.Order;
import com.example.project_01_E_commerce_order_service.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @PostMapping("/placeOrder")
    public Mono<ResponseEntity<OrderResponseDTO>> placeOrder(@RequestBody Order order){

        return webClientBuilder.build()
                .get()

                .uri("http://PRODUCT-SERVICE/products/" + order.getProductId())
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .map(productDTO -> {

                    OrderResponseDTO responseDTO = new OrderResponseDTO();
                    Order savedOrder = orderRepository.save(order);
                    responseDTO.setOrderId(savedOrder.getId());
                    responseDTO.setProductId(order.getProductId());
                    responseDTO.setQuantity(order.getQuantity());
                    responseDTO.setProductName(productDTO.getName());
                    responseDTO.setProductPrice(productDTO.getPrice());
                    responseDTO.setTotalPrice(order.getQuantity() * productDTO.getPrice());

                    return responseDTO;
                })
                .map(responseDTO -> {
                    return ResponseEntity.ok(responseDTO);
                });
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
}