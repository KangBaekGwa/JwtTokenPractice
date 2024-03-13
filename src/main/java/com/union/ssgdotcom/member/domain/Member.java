package com.union.ssgdotcom.member.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;
import java.util.UUID;


@Entity
@ToString
@Getter
@NoArgsConstructor
public class Member implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String loginId;
    private String uuid;
    @Getter
    private String name;
    private String email;
    private String phone;
    private String address;
    @Column(columnDefinition = "TINYINT", length = 1, nullable = true)
    private Short gender;
    @Column(nullable = true)
    private String codeName;

    @Builder
    public Member(String password, String uuid, String loginId ,String name, String email, String phone, String address, Short gender) {
        this.password = password;
        this.uuid = uuid;
        this.loginId = loginId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }

    public Member(String uuid) {
        this.uuid = uuid;
    }

    public void hashPassword(String password) {
        //      this.password = password;
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return uuid;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
