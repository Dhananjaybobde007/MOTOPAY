package com.logical.tronixpayadmin.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name="admin")
public class Admin{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;
    private String adminName;
    @Column(unique=true)
    private String email;
    private String role;
    private String password;
    private String profileImgUrl;
    private String adminBio;
}
