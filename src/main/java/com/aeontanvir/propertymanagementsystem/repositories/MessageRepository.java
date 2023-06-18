package com.aeontanvir.propertymanagementsystem.repositories;

import com.aeontanvir.propertymanagementsystem.domains.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
