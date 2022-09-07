package com.coder.springsecuritydemo.service;

import com.coder.springsecuritydemo.model.CustomerEntity;
import com.coder.springsecuritydemo.model.SecurityCustomer;
import com.coder.springsecuritydemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EazyBankUserDetailsService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerEntity customer = customerRepository.findByEmail(username);
        if (customer == null) throw new UsernameNotFoundException(username);
        return  new SecurityCustomer(customer);
    }
}
