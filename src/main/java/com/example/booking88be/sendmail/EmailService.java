package com.example.booking88be.sendmail;

import com.example.booking88be.entity.*;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;
//import swp.booking.booking88be.entity.BookingDetail;

@Service
public class EmailService {

//    @Value("${spring.mail.username")
    private String fromMail= "swpproject2024@gmail.com";

    private JavaMailSender javaMailSender;
    private String codeRandom;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    /**
     * gui mail dang text
     * @param to
     * @param subject
     * @param text
     */
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(fromMail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        javaMailSender.send(message);
    }

    /**
     * gui bill duoi dang html
     * @param to
     * @param subject
     * @param htmlContent
     * @throws MessagingException
     */
    public void sendHtmlEmail(String to, String subject, String htmlContent) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlContent, true);

        javaMailSender.send(message);
    }


    /**
     *  gui 1 ma code dang chuoi 6 so ve email la tham so
     * @param to : dia chi email nguoi nhan
     * @throws MessagingException
     */
    public void sendCodeEmail(String to) throws MessagingException {
        codeRandom = new randomcode().getRandomNumber();
        sendEmail(to, "Booking 88 ", "Your Code: " + codeRandom );
    }

    /**
     * so sanh ma code nguoi dung nhap vao voi ma code duoc random.
     * @param code chuoi ki tu gon 6 so.
     * @return true neu ca 2 giong nhau va nguoc lai.
     */
    public boolean checkCode(String code){
        return code.equals(codeRandom);
    }


    /**
     * form bill html
     * @param booking tham so dau vao
     * @return
     */
    public static String getBill(Booking booking) {

        List<BookingDetail> bookingDetails = booking.getBookingDetails();

        Customer customer = booking.getCustomer();

        // tinh tong tien
        float totalPrice = (float) bookingDetails.stream()
                .mapToDouble(BookingDetail::getPrice)
                .sum();

        String contentBill = null;

        for (BookingDetail a : bookingDetails) {
            List<CourtSlot> courtSlots = a.getCourtSlots();
            for (CourtSlot cs : courtSlots) {
                String temp = "<tr class=\"item\" style=\"border-bottom: 1px solid #eee;\">\n" +
                        "                <td>" + cs.getSlot().getTime() + "</td>\n" +
                        "                <td style=\"text-align: center;\">" + a.getCourtSlots().size() + "</td>\n" +
                        "                <td style=\"text-align: right;\">" + cs.getSlot().getPrice() + "</td>\n" +
                        "                <td style=\"text-align: right;\">" + a.getCourtSlots().size() * cs.getSlot().getPrice() + "</td>\n" +
                        "            </tr>\n" +
                        "            \n";

                contentBill += temp;
            }

        }


        Location location = bookingDetails.get(0).getCourtSlots().get(0).getCourt().getLocation();

        return "<!DOCTYPE html>" +
                "<html lang=\"en\">" + "" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Booking 88</title>\n" +
                "</head>" +
                "<body style=\"font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4;\">\n" +
                "    <div style=\"max-width: 800px; margin: 30px auto; padding: 20px; border: 1px solid #eee; box-shadow: 0 0 10px rgba(0, 0, 0, 0.15); background-color: #fff;\">\n" +
                "<table style=\"width: 100%; line-height: 24px; text-align: left; border-collapse: collapse;\">\n" +
                "            <tr class=\"top\">\n" +
                "                <td colspan=\"4\" style=\"padding-bottom: 20px;\">\n" +
                "                    <table style=\"width: 100%;\">\n" +
                "                        <tr>\n" +
                "                            <td class=\"title\" style=\"font-size: 30px; line-height: 45px; color: #333;\">\n" +
                "                                <h2>Booking 88</h2>\n" +
                "                            </td>\n" +
                "                            <td style=\"text-align: right;\">\n" +
                "                                <h2 style=\"margin: 0;\">SÂN:" + location.getName() + "</h2>\n" +
                "                                Số hóa đơn: " + booking.getBookingId() + "<br>\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                    </table>\n" +
                "                </td>\n" +
                "            </tr>" +
                "<tr class=\"information\">\n" +
                "                <td colspan=\"4\" style=\"padding-bottom: 40px;\">\n" +
                "                    <table style=\"width: 100%;\">\n" +
                "                        <tr>\n" +
                "                            <td>\n" +
                "                                Gửi đến:<br>\n" +
//                "                                Imani Olowe<br>\n" +
                customer.getName() +
//                "                                +123-456-7890<br>\n" +
                customer.getPhone() +
                "                                Ngày đặc:?\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                    </table>\n" +
                "                </td>\n" +
                "            </tr>" +
                "<tr class=\"heading\" style=\"background: #eee;\n" +
                "             border-bottom: 1px solid #ddd;\n" +
                "              font-weight: bold;\">\n" +
                "                <td>Item</td>\n" +
                "                <td style=\"text-align: right;\"s>Số lượng</td>\n" +
                "                <td style=\"text-align: right;\">Đơn giá</td>\n" +
                "                <td style=\"text-align: right;\">Tổng tiền</td>\n" +
                "            </tr>\n" +
                "            \n" +
                contentBill
//                "            <tr class=\"item\" style=\"border-bottom: 1px solid #eee;\">\n" +
//                "                <td>Eggshell Camisole Top</td>\n" +
//                "                <td style=\"text-align: center;\">1</td>\n" +
//                "                <td style=\"text-align: right;\">$123</td>\n" +
//                "                <td style=\"text-align: right;\">$123</td>\n" +
//                "            </tr>\n" +
//                "            \n"
                +
//                "            <tr class=\"item\" style=\"border-bottom: 1px solid #eee;\">\n" +
//                "                <td>Cuban Collar Shirt</td>\n" +
//                "                <td style=\"text-align: center;\">2</td>\n" +
//                "                <td style=\"text-align: right;\">$127</td>\n" +
//                "                <td style=\"text-align: right;\">$254</td>\n" +
//                "            </tr>\n" +
//                "            \n" +
//                "            <tr class=\"item last\" style=\"border-bottom: none;\">\n" +
//                "                <td>Floral Cotton Dress</td>\n" +
//                "                <td style=\"text-align: center;\">1</td>\n" +
//                "                <td style=\"text-align: right;\">$123</td>\n" +
//                "                <td style=\"text-align: right;\">$123</td>\n" +
//                "            </tr>" +
                "<tr class=\"total\" style=\"font-weight: bold;\">\n" +
                "                <td colspan=\"3\"></td>\n" +
                "                <td style=\"text-align: right; border-top: 2px solid #eee;\">Subtotal: " + totalPrice + "vnd</td>\n" +
                "            </tr>\n" +
                "            \n" +
                "            <tr class=\"total\" style=\"font-weight: bold;\">\n" +
                "                <td colspan=\"3\"></td>\n" +
                "                <td style=\"text-align: right;\">Tax (0%): $0</td>\n" +
                "            </tr>\n" +
                "            \n" +
                "            <tr class=\"total\" style=\"font-weight: bold;\">\n" +
                "                <td colspan=\"3\"></td>\n" +
                "                <td style=\"text-align: right;\"><strong>Total:" + totalPrice + "</strong></td>\n" +
                "            </tr>\n" +
                "        </table>\n" +
                "        <div class=\"thank-you\" style=\"margin-top: 30px; font-size: 18px; text-align: center;\">\n" +
                "            Cảm ơn vì đã sử dụng dịch vụ.\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }

}
