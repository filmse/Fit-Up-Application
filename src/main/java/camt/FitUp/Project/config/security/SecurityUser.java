//package camt.FitUp.Project.config.security;
//
//import camt.FitUp.Project.entity.Role;
//import camt.FitUp.Project.entity.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Set;
//
///**
// * Created by Dto on 4/19/2015.
// */
//public class SecurityUser extends User implements UserDetails {
//    private static final long serialVersionUID = 1L;
//
//    public SecurityUser(User user) {
//        if (user != null) {
//            this.setId(user.getId());
//            this.setUsername(user.getUsername());
//            this.setEmail(user.getEmail());
//            this.setRoles(user.getRoles());
//            this.setImages(user.getImages());
//            this.setPassword(user.getPassword());
////            this.setShoppingCarts(user.getShoppingCarts());
//        }
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        Set<Role> userRoles = this.getRoles();
//
//        if (userRoles != null) {
//            for (Role role : userRoles) {
//                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
//                authorities.add(authority);
//            }
//        }
//        return authorities;
//    }
//
//    @Override
//    public String getUsername() {
//        return super.getUsername();
//    }
//
//    @Override
//    public String getPassword() {
//        return super.getPassword();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
