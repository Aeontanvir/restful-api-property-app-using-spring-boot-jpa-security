package com.aeontanvir.propertymanagementsystem.initdata;

import com.aeontanvir.propertymanagementsystem.domains.*;
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
        User admin = User.builder()
                .name("Admin")
                .email("admin@gmail.com")
                .password(passwordEncoder.encode("admin"))
                .role(Role.ADMIN)
                .build();
        userRepository.save(admin);

        User newUser1 = User.builder()
                .name("Tanvir")
                .email("aeontanvir@gmail.com")
                .password(passwordEncoder.encode("132132132"))
                .role(Role.OWNER)
                .build();
        User user1 = userRepository.save(newUser1);
        User newUser2 = User.builder()
                .name("Yadab")
                .email("yadab@gmail.com")
                .password(passwordEncoder.encode("132132132"))
                .role(Role.OWNER)
                .build();
        User user2 = userRepository.save(newUser2);

        Address address1 = Address.builder()
                .street("Test1").zip("43545").city("Fairfield").state("Iowa").build();
        Address address2 = Address.builder()
                .street("Test2").zip("43545").city("Fairfield").state("Iowa").build();
        Address address3 = Address.builder()
                .street("Test3").zip("43545").city("Fairfield").state("Iowa").build();
        Address address4 = Address.builder()
                .street("Test4").zip("43545").city("Fairfield").state("Iowa").build();
        Property newProperty = Property.builder()
                .name("Property 1")
                .description("description")
                .address(address1)
                .size("size")
                .room("room")
                .bath("bath")
                .kitchen("ketchen")
                .status("available")
                .price(5000)
                .owner(user1)
                .build();
        Property newProperty2 = Property.builder()
                .name("Property 2")
                .description("description")
                .address(address2)
                .size("size")
                .room("room")
                .bath("bath")
                .kitchen("ketchen")
                .status("available")
                .price(5000)
                .owner(user1)
                .build();
        Property newProperty3 = Property.builder()
                .name("Property 3")
                .description("description")
                .address(address3)
                .size("size")
                .room("room")
                .bath("bath")
                .kitchen("ketchen")
                .status("available")
                .price(5000)
                .owner(user2)
                .build();
        Property newProperty4 = Property.builder()
                .name("Property 4")
                .description("description")
                .address(address4)
                .size("size")
                .room("room")
                .bath("bath")
                .kitchen("ketchen")
                .status("available")
                .price(5000)
                .owner(user2)
                .build();
        address1.setProperty(newProperty);
        address2.setProperty(newProperty2);
        address3.setProperty(newProperty3);
        address4.setProperty(newProperty4);
        Property property1 = propertyRepository.save(newProperty);
        Property property2 = propertyRepository.save(newProperty2);
        Property property3 = propertyRepository.save(newProperty3);
        Property property4 = propertyRepository.save(newProperty4);

        Message message = Message.builder()
                .property(property1)
                .user(user1)
                .message("Test Messasge")
                .build();
        messageRepository.save(message);

    }
}