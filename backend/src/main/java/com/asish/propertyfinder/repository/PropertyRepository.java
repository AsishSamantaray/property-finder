package com.asish.propertyfinder.repository;

import com.asish.propertyfinder.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
