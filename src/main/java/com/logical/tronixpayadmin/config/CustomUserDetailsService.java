package com.logical.tronixpayadmin.config;

import com.logical.tronixpayadmin.entity.Admin;
import com.logical.tronixpayadmin.repository.AdminRepository;
//import com.logical.tronixpayadmin.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin adminData = adminRepository.findByEmail(username);
        if(adminData==null){
            throw new UsernameNotFoundException("user not found!!");
        }
        UserDetails customUserDetails=new CustomUserDetails(adminData);
        return customUserDetails;
    }
}
