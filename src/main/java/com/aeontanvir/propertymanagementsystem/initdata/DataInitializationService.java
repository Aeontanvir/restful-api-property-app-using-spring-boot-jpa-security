package com.aeontanvir.propertymanagementsystem.initdata;

import com.aeontanvir.propertymanagementsystem.domains.Message;
import com.aeontanvir.propertymanagementsystem.domains.Property;
import com.aeontanvir.propertymanagementsystem.domains.Role;
import com.aeontanvir.propertymanagementsystem.domains.User;
import com.aeontanvir.propertymanagementsystem.repositories.MessageRepository;
import com.aeontanvir.propertymanagementsystem.repositories.PropertyRepository;
import com.aeontanvir.propertymanagementsystem.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DataInitializationService implements CommandLineRunner {
    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        initializeData();
    }

    private void initializeData() {
        User newUser = User.builder()
                .name("Tanvir")
                .email("aeontanvir@gmail.com")
                .password(passwordEncoder.encode("132132132"))
                .role(Role.OWNER)
                .build();
        User user = userRepository.save(newUser);

        Property newProperty = Property.builder()
                .name("Property 1")
                .description("description")
                .address("address")
                .size("size")
                .room("room")
                .bath("bath")
                .ketchen("ketchen")
                .status("available")
                .price(5000)
                .owner(user)
                .build();
        Property newProperty2 = Property.builder()
                .name("Property 2")
                .description("description")
                .address("address")
                .size("size")
                .room("room")
                .bath("bath")
                .ketchen("ketchen")
                .status("available")
                .price(5000)
                .owner(user)
                .build();
        Property property1 = propertyRepository.save(newProperty);
        Property property2 = propertyRepository.save(newProperty2);

        Message message = Message.builder()
                .property(property1)
                .user(user)
                .message("Test Messasge")
                .build();
        messageRepository.save(message);

    }
}