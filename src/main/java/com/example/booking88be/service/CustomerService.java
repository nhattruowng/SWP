package com.example.booking88be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.booking88be.entity.*;
import com.example.booking88be.iservice.*;
import com.example.booking88be.repository.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerService implements ICustomer,UserDetailsService {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ICustomerRepository customerRepository;


        /**
     * them nguoi dung moi khi du dieu kien => email chua dang ki
     * @param customer Customer
     *
     */
    @Override
    @Transactional
    public Customer addCustomer(Customer customer, MultipartFile file) {
        if(customer != null) {
           Customer customers = customerRepository.findByEmail(customer.getEmail());
            if(customers==null){
                String password = passwordEncoder.encode(customer.getPassword());
                //System.out.println(password);
                if(file != null) {
                    try {
                        customer.setImage(file.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                customer.setPassword(password);
               return this.customerRepository.save(customer);
            }
        }
        return null;
    }

    /**
     * lay ra 1 customer co email va password khop.
     * @param email string
     * @param password string
     * @return Customer
     */
    @Override
    public Customer getCustomer(String email, String password) {
        Customer customers = customerRepository.findByEmail(email);
        if (customers!=null) {
            if (passwordEncoder.matches(password, customers.getPassword())) {
                return customers;
            }
        }
        return null;
    }

    //
    @Override
    @Transactional
    public Customer checkGmailAddress(String email) {
        return customerRepository.findByEmail(email);
    }


    //
    @Override
    @Transactional
    public Customer updateCustomer(long id,Customer customer) {
        return customerRepository.findById(id).map(
                c -> {
                    c.setEmail(customer.getEmail());
                    c.setName(customer.getName());
                    c.setPassword(passwordEncoder.encode(customer.getPassword()));
                    c.setPhone(customer.getPhone());
                    return customerRepository.save(c);
                }
        ).orElse(null);
    }


    //
    @Override
    @Transactional
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }


    //
    @Override
    public Customer getCustomerById(long id) {
        if (id >= 1) {
            return customerRepository.getReferenceById(id);
        }
        return null;
    }

    ///
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }


    //
    @Override
    public List<Customer> findCustomerByName(String name) {
        return customerRepository.getCustomerByName(name);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository.findByEmail(username);
    }
}
