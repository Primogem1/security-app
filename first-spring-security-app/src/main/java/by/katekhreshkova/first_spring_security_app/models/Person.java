package by.katekhreshkova.first_spring_security_app.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
@Data
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    @Column(name = "username")
    private String username;
    @Column(name="year_of_birth")
    private String yearOfBirth;
    @Column(name = "password")
    private String password;
}
