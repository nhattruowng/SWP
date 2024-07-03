package com.example.booking88be.iservice;

import com.example.booking88be.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@Service
public interface ICustomer {

    /**
     * add new customer
     *
     * @param customer Customer
     * @return
     */
    Customer addCustomer(Customer customer, MultipartFile file);

    /**
     * update customer
     *
     * @param customer Customer
     * @param id       long
     * @return
     */
    Customer updateCustomer(long id, Customer customer);

    /**
     * remove customer
     *
     * @param id
     * @return true if customer deleted
     */
    void deleteCustomer(long id);

    /**
     * get customer for id
     *
     * @param id
     * @return customer
     */
    Customer getCustomerById(long id);

    /**
     * get all customers for datebase
     *
     * @return List all customers for datebase
     */
    List<Customer> getAllCustomer();

    /**
     * find customer by name
     *
     * @param name string
     * @return List<Customer> with name contents
     */

    List<Customer> findCustomerByName(String name);

    /**
     * find customer by email and password
     *
     * @param email string
     * @return customer matching email and password
     */

    Customer getCustomer(String email, String password);

    /**
     * kiem tra dia chi mail co ton tai tren database khong ?
     * @param email string
     * @return true if email is valid
     */

    Customer checkGmailAddress(String email);
}
