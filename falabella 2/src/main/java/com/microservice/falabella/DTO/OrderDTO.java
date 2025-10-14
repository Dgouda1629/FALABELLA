package com.microservice.falabella.DTO;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    @NotBlank (message = "Logistic Order ID is required")
    private String logisticOrderId;

    @NotBlank(message = "Customer Info is required")
    private String customerInfo;

    @NotBlank(message = "Destination Info is required")
    private String destinationInfo;
}
