package com.graphqldocs.dto;

import com.common.Location;
import com.common.Price;
import lombok.Data;

/**
 * Imitates WKDA Projection class
 */
@Data
public class ComplexTypeProjectionDto {

    private String title;
    private Price price;
    private Location location;
}
