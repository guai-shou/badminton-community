package com.cloud.badminton.framework.security.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.cloud.badminton.framework.common.check.Publish;
import com.cloud.badminton.framework.common.check.Update;
import com.cloud.badminton.project.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Collection;
import java.util.Set;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/6 21:17
 */
@Data
public class LoginUser implements UserDetails {

    private String uuid;

    private Long loginTime;

    private Long expireTime;

    /*权限列表, 还未实现*/
    //private Set<String> permissions;

    private User user;

    public LoginUser() {}

    public LoginUser(User user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
