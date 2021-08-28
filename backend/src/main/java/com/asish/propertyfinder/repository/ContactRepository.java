package com.asish.propertyfinder.repository;

import com.asish.propertyfinder.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {
}
