package com.graphqldocs.service;

import com.graphqldocs.converter.ComplexTypeConverter;
import com.graphqldocs.dto.ComplexTypeProjectionDto;
import com.graphqldocs.dto.SellerAddressProjection;
import com.graphqldocs.graphql.GraphQLService;
import com.graphqldocs.repository.ComplexTypeRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLNonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@Service
public class ComplexTypeService implements GraphQLService {

    private final ComplexTypeRepository complexTypeRepository;
    private final ComplexTypeConverter converter;

    @GraphQLMutation(
            name = "saveComplexType",
            description = "Saves complex type."
    )
    public UUID save(ComplexTypeProjectionDto dto) {
        log.info("Request to save Complex Type");
        return complexTypeRepository.save(converter.toEntity(dto)).getId();
    }

    @GraphQLMutation(
            name = "saveSellerProjection",
            description = "Saves seller projection."
    )
    public void saveSellerProjection(
            @GraphQLArgument(name = "sellerId") @GraphQLNonNull final UUID sellerId,
            @GraphQLArgument(name = "addressId") @GraphQLNonNull final UUID addressId,
            @Valid @GraphQLArgument(name = "sellerAddress") @GraphQLNonNull final SellerAddressProjection projection
    ) {
        log.info("Request to save seller projection.");
        throw new UnsupportedOperationException("Not implemented.");
    }
}
