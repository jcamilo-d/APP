package com.example.APP.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "users")
public class User {

    public User(String name,String lastname,String username, String password, List<Authority> authorities) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    private String name;
    private String lastname;
    @Column(nullable = false)
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id_authority"))
    private List<Authority> authorities;

}