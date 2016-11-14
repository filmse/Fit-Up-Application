//package camt.FitUp.Project.config.security;
//
//import camt.FitUp.Project.entity.User;
//import camt.FitUp.Project.service.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
///**
// * Created by Dto on 4/19/2015.
// */
//@Component
//public class CustomUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UserServiceImpl userService;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userService.findByUsername(username);
//        if(user == null){
//            throw new UsernameNotFoundException("User name" + username + "not found");
//        }
//        return new SecurityUser(user);
//    }
//}
