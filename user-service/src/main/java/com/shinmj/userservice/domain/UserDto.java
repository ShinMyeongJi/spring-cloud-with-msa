package com.shinmj.userservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shinmj.userservice.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Table(name = "user", schema = "public")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements UserDetails{

    @Id
    @Column(name = "id", length=20)
    private String id;

    @Column
    private String encrypt_pw;

    @Column
    private String name;

    @Column
    private String role = "user";

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
        return this.encrypt_pw;
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
