package com.asish.propertyfinder.repository;

import com.asish.propertyfinder.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
