package com.example.booking88be.repository;

import com.example.booking88be.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {


    /**
     * lay danh sach cac Customer co email trung khop
     * @param email String
     * @return List<Customer>
     */
    @Query(value = "SELECT U FROM Customer as U WHERE U.email = :email")
    Customer findByEmail(@Param("email") String email);


    /**
     * Lay ra 1 customer co email va password khop.
     * @param email
     * @param password
     * @return Customer
     */
    @Query(value = "select U from Customer as U where U.email= :email and U.password = :password")
    Customer getCustomer(@Param("email")String email, @Param("password")String password);


    /**
     * danh sach Customer co ten trung voi ten tim kiem
     * @param name String
     * @return List<Customer>
     */
    @Query(value = "select U from Customer as U where U.name = :name")
    List<Customer> getCustomerByName(@Param("name")String name);
}

