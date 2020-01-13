package com.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Imitates WKDA Price from common libs
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    @ApiModelProperty(value = "The price value in minor units", required = true)
    private Long amountMinorUnits;

    @ApiModelProperty(value = "Conversion value", required = true, example = "100", allowableValues = "100")
    private Integer conversionMajor;

    @ApiModelProperty(value = "Currency value", required = true, example = "EUR", allowableValues = "EUR")
    private String currency;
}
