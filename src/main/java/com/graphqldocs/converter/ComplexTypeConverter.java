package com.graphqldocs.converter;

import com.common.Location;
import com.common.Price;
import com.graphqldocs.dto.ComplexTypeProjectionDto;
import com.graphqldocs.model.ComplexType;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;


@Component
public class ComplexTypeConverter {

    public ComplexType toEntity(ComplexTypeProjectionDto dto) {
        ComplexType entity = new ComplexType();

        entity.setTitle(dto.getTitle());

        Price price = dto.getPrice();
        if (nonNull(price)) {
            entity.setAmountMinorUnits(price.getAmountMinorUnits());
            entity.setCurrency(price.getCurrency());
            entity.setConversionMajor(price.getConversionMajor());
        }

        Location location = dto.getLocation();
        if (nonNull(location)) {
            entity.setLongitude(location.getLongitude());
            entity.setLatitude(location.getLatitude());
        }

        return entity;
    }
}
