package com.example.booking88be.entity;

import com.example.booking88be.infor.Roles;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "locationOwner")
public class LocationOwner implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourtOwnerId")
    private Long locationOwnerId;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_account_id", referencedColumnName = "bank_account_id")
    private BankAccount bankAccount;

    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "Roles",
            joinColumns = @JoinColumn(name = "CourtOwnerId"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"CourtOwnerId", "role_type"})
    )
    @Enumerated(EnumType.STRING)
    private Set<Roles> roles = new HashSet<>();

    public void setRoles(Roles roles) {
        this.roles.clear();
        this.roles.add(roles);
    }

    @OneToMany(mappedBy = "locationOwner",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Location> locations;

    @OneToMany(mappedBy = "locationOwner",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<LocationStaff> locationStaffs;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.name())).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

}
