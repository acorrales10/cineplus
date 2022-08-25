/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.service;

import com.cine.entity.Registro;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author AMCG_
 */
public class UserPrincipal implements UserDetails {

    private Registro registro;

    public UserPrincipal(Registro registro) {
        this.registro = registro;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        GrantedAuthority permission = new SimpleGrantedAuthority(this.registro.getPermisos());
        authorities.add(permission);
        GrantedAuthority rol = new SimpleGrantedAuthority("ROLE_" + this.registro.getRol());
        authorities.add(rol);
        return authorities;

    }

    @Override
    public String getPassword() {
        return this.registro.getContrasena();
    }

    @Override
    public String getUsername() {
        return this.registro.getCorreo();
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
        return this.registro.getActive() == 1;
    }
}
