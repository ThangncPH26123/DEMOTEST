package com.example.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "USERDATA")
public class User {
        @Id
        @GeneratedValue
        private int id;
        private String username;
        private String password;
        private String fullname;
        private int age;
        private boolean gender;

}
