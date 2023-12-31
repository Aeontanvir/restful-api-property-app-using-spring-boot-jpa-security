package com.aeontanvir.propertymanagementsystem.domains;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToOne(mappedBy = "property", cascade = CascadeType.ALL)
    private Address address;
    private String size;
    private String room;
    private String bath;
    private String kitchen;
    private String status;
    private double price;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    @OneToMany(mappedBy = "property")
    private List<Message> message;

}
