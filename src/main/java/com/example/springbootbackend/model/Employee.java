package com.example.springbootbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name", nullable = false,length = 100)
    private String firstName;

    @Column(name="last_name", nullable = false,length = 100)
    private String lastName;

    @Column(name="email", unique = true, nullable = false,length = 100)
    private String email;

}
