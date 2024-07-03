package com.example.booking88be.api;


import com.example.booking88be.entity.Customer;
import com.example.booking88be.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@ComponentScan(basePackages = {"com.example.booking88be.service",
        "com.example.booking88be.repository",
        "com.example.booking88be.api"})

public class AdminControler {


}
/**
 * Authentication API
 *
 * Đăng nhập
 * Đăng xuất
 * Đổi mật khẩu
 * Tổng: 3 API
 * User Management API
 *
 * Tạo người dùng mới
 * Cập nhật thông tin người dùng
 * Xóa người dùng
 * Danh sách người dùng
 * Tổng: 4 API
 * Booking Management API
 *
 * Tạo đặt phòng mới
 * Cập nhật đặt phòng
 * Hủy đặt phòng
 * Danh sách đặt phòng
 * Chi tiết đặt phòng
 * Tổng: 5 API
 * Room Management API
 *
 * Thêm phòng mới
 * Cập nhật thông tin phòng
 * Xóa phòng
 * Danh sách phòng
 * Tổng: 4 API
 * Pricing and Availability API
 *
 * Cập nhật giá phòng
 * Kiểm tra tính khả dụng của phòng
 * Tổng: 2 API
 * Reports and Analytics API
 *
 * Báo cáo doanh thu
 * Báo cáo tình trạng phòng
 * Phân tích khách hàng
 * Tổng: 3 API
 * Support and Feedback API
 *
 * Xử lý phản hồi khách hàng
 * Danh sách phản hồi
 * Tổng: 2 API
 * System Management API
 *
 * Quản lý cấu hình hệ thống
 * Giám sát hiệu suất hệ thống
 * Tổng: 2 API
 */
