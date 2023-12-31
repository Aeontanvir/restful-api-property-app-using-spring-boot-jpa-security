package com.aeontanvir.propertymanagementsystem.repositories;

import com.aeontanvir.propertymanagementsystem.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}