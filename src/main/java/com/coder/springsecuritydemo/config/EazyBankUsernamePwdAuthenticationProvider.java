package com.coder.springsecuritydemo.config;


import com.coder.springsecuritydemo.model.AuthorityEntity;
import com.coder.springsecuritydemo.model.CustomerEntity;
import com.coder.springsecuritydemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String usrname = authentication.getName();
        String password = authentication.getCredentials().toString();
        CustomerEntity customer = customerRepository.findByEmail(usrname);
        if (customer != null){
            return  new UsernamePasswordAuthenticationToken(usrname,password,getGrantedAuthorities(customer.getAuthorities()));
        }else {
            throw new BadCredentialsException("invalid");
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(Set<AuthorityEntity> authorities){
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (AuthorityEntity authority : authorities){
            System.out.println(authority.getName());

            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return  grantedAuthorities;
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
