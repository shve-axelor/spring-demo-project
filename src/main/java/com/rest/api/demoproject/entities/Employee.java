package com.rest.api.demoproject.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private String department;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Address> empAddresses;
}
