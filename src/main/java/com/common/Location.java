package com.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Imitates WKDA Location from common libs
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location {
    private Double latitude;
    private Double longitude;
}
