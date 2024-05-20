package com.mughrabi.dto;

import lombok.Data;

import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * @author - Mado
 */
@Data
public class DealDTO {
    private String dealUniqueId;
    @NotBlank(message = "From Currency ISO Code is mandatory")
    private String fromCurrencyIsoCode;
    @NotBlank(message = "To Currency ISO Code is mandatory")
    private String toCurrencyIsoCode;
    @NotNull(message = "Deal timestamp is mandatory")
    private LocalDateTime dealTimestamp;

    @NotNull(message = "Deal amount is mandatory")
    @Positive(message = "Deal amount must be positive")
    @DecimalMin(value = "0.0001", message = "Value must be greater than 0")
    private Double dealAmount;


}
