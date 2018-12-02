package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductRepository repository) {
        return (args) -> {
            Product product = new Product();
            product.setId(1L);
            product.setName("Notebook");
            product.setPrice(new BigDecimal(2100));
            product.setDescription("This is notebook description");
            product.getAttributes().put("CPU", "i7-8550U");
            repository.save(product);

            Product product2 = new Product();
            product2.setId(2L);
            product2.setName("Notebook");
            product2.setPrice(new BigDecimal(2000));
            product2.setDescription("This is notebook description");
            product2.getAttributes().put("CPU", "i5-3525");
            product2.getAttributes().put("RAM", "8Gb");
            repository.save(product2);

        };
    }

}
