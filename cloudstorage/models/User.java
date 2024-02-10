package com.udacity.jwdnd.course1.cloudstorage.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity(name = "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    @Size(max = 255)
    private String username;
    @Size(max = 512)
    private String password;
    @Size(max = 255)
    private String salt;

    @Column(name = "firstname")
    @Size(max = 255)
    private String firstName;

    @Column(name = "lastname")
    @Size(max = 255)
    private String lastName;
}
