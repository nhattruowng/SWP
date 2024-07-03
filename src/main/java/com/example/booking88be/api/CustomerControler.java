package com.example.booking88be.api;


import com.example.booking88be.entity.Customer;
import com.example.booking88be.entity.Location;
import com.example.booking88be.sendmail.EmailService;
import com.example.booking88be.service.CustomerService;
import com.example.booking88be.service.LocationService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/account")
@ComponentScan(basePackages = {"com.example.booking88be.service",
        "com.example.booking88be.repository",
        "com.example.booking88be.api"})
public class CustomerControler {



    private final CustomerService customerService;
    private final LocationService locationService;
    private final EmailService emailService;

    /// ham khoi tao

    @Autowired
    public CustomerControler(CustomerService customerService,
                             EmailService emailService,
                             LocationService locationService) {
        this.customerService = customerService;
        this.emailService = emailService;
        this.locationService = locationService;
    }



    @PostMapping("/login")
    public ResponseEntity<Customer> login(@RequestBody Customer customer) {
        Customer foundCustomer = customerService.getCustomer(customer.getEmail(), customer.getPassword());
        if (foundCustomer != null)
            return ResponseEntity.ok(foundCustomer);
        return ResponseEntity.status(401).build();

    }

    // Quên mật khẩu
    @PutMapping("/forgotPassword")
    public ResponseEntity<Void> forgotPassword(@RequestBody Customer customer) {
        Customer customers = customerService.checkGmailAddress(customer.getEmail());
        if (customers != null){
            customerService.updateCustomer(customers.getCustomerId(),customer);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(404).build();
    }

    // Đăng ký
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody Customer customer,
                                         @RequestPart("file") MultipartFile file) {
        Customer addedCustomer = customerService.addCustomer(customer,file);
        if (addedCustomer != null)
            return ResponseEntity.status(201).build();
        return ResponseEntity.status(400).build();

    }

    //Xem thông tin cá nhân:

    @GetMapping("/getinfo/{id}")
    public ResponseEntity<Customer> getinfo(@PathVariable("id") Long id) {
        Customer foundCustomer = customerService.getCustomerById(id);
        if (foundCustomer != null)
            return ResponseEntity.ok(foundCustomer);
        return ResponseEntity.status(404).build();
    }

    //Cập nhật thông tin cá nhân:

    @PutMapping("/updateinfo/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
        Customer foundCustomer = customerService.getCustomerById(id);
        if (foundCustomer != null) {
            customerService.updateCustomer(id, customer);
            return ResponseEntity.ok(customer);
        }
        return null;
    }

    //Xem danh sách phòng:
    @GetMapping("/listCourt")
    public ResponseEntity<List<Location>> getAllLocation(){
        return ResponseEntity.ok(locationService.getAllLocation());
    }


    // Tìm kiếm san
    @GetMapping("Search/{name}")
    public ResponseEntity<List<Location>> getLocationByName(@NonNull @PathVariable("name") String name) {
        if(!name.isEmpty())
            return ResponseEntity.ok(locationService.getLocationByName(name));
        return ResponseEntity.status(404).build();
    }

    //Xem chi tiết phòng
    @GetMapping("/location/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable("id") Long id) {
        Location foundLocation = locationService.getLocationById(id);
        if (foundLocation != null)
            return ResponseEntity.ok(foundLocation);
        return ResponseEntity.status(404).build();
    }

    //Đặt phòng
    @PostMapping("/booking")
    public ResponseEntity<Void> addBooking(@RequestBody Customer customer) {
        Customer foundCustomer = customerService.getCustomerById(customer.getCustomerId());

        return ResponseEntity.status(404).build();
    }


    /**
     * Đăng ký:
     *
     * POST /api/register
     *
     *
     * POST /api/login
     * Xem thông tin cá nhân:
     *
     * GET /api/customers/{customerId}
     * Cập nhật thông tin cá nhân:
     *
     * PUT /api/customers/{customerId}
     * Xem danh sách phòng:
     *
     * GET /api/rooms
     * Tìm kiếm phòng:
     *
     * GET /api/rooms/search?params
     * Xem chi tiết phòng:
     *
     * GET /api/rooms/{roomId}
     * Đặt phòng:
     *
     * POST /api/bookings
     * Xem danh sách đặt phòng:
     *
     * GET /api/bookings
     * Hủy đặt phòng:
     *
     * DELETE /api/bookings/{bookingId}
     * Thanh toán:
     *
     * POST /api/payments
     * Xem lịch sử thanh toán:
     *
     * GET /api/payments
     */

}
