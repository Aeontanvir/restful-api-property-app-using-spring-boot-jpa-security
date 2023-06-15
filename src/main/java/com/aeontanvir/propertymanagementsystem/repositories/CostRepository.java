package com.aeontanvir.propertymanagementsystem.repositories;

import com.aeontanvir.projectcosting.domains.Cost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostRepository extends JpaRepository<Cost, Long> {
}
