package com.aeontanvir.propertymanagementsystem.repositories;

import com.aeontanvir.propertymanagementsystem.domains.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}
