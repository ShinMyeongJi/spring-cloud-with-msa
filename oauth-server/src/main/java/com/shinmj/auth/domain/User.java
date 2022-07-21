package com.shinmj.auth.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shinmj.auth.common.Constants;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="user")
@Data
public class User implements UserDetails {

    @Id
    private String id;

    @Column(name="name", length = 10, nullable = false)
    private String name;

    @Column(name="encrypt_pw", length = 20, nullable = false)
    private String encryptPw;

    @Column(name="role", length = 30)
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = this.role;

        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(Constants.ROLE_PREFIX + role);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        return authorities;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getPassword() {
        return this.encryptPw;
    }

    @Override
    public String getUsername() {
        return this.id;
    }

    @Override
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return true;
    }
}
