package com.asish.propertyfinder.repository;

import com.asish.propertyfinder.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PropertyRepository extends JpaRepository<Property, UUID> {

    List<Property> findTop3ByOrderByPublishedDateDesc();
}
