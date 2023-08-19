package com.emreunaldi.springboot.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class ProductDTO {
    private Long productId;
    private String productName;
    private double productPrice;
}
