package com.example.booking88be.infor;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    CUSTOMER,
    ADMIN,
    OWNER,
    STAFF;

    @Override
    public String getAuthority() {
        return name();
    }
}
