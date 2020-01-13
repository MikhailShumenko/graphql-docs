package com.graphqldocs.repository;

import com.graphqldocs.model.ComplexType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ComplexTypeRepository extends JpaRepository<ComplexType, UUID> {
}
