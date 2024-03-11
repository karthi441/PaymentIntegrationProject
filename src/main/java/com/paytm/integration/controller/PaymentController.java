package com.paytm.integration.controller;

import com.paytm.integration.config.AppConfig;
import com.paytm.integration.entity.OrderData;
import com.paytm.integration.repository.OrderRepo;
import com.paytm.pg.merchant.PaytmChecksum;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import jdk.jfr.consumer.RecordedStackTrace;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class PaymentController {
    @Autowired
    private OrderRepo OrderRepo;
    Random rand = new Random();
    @PostMapping("/create/order")
    public String createOrder(@RequestBody Map<String, Object> data) throws RazorpayException {

        int amt=Integer.parseInt(data.get("amount").toString());
        RazorpayClient client= new RazorpayClient("rzp_test_DxCnFqDytGpljd","0b5zf5Ou9l9S2cie1S2nCrLM");
        JSONObject options = new JSONObject();
        options.put("amount", amt*100);
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");
        Order order=client.orders.create(options);
        System.out.println(order);

        // save the order into the database
        OrderData orderData = new OrderData();
        orderData.setOrderId(order.get("id"));
        orderData.setAmount(order.get("amount").toString());
        orderData.setReceipt(order.get("receipt"));
        orderData.setStatus("created");
        orderData.setPaymentId(null);
        OrderRepo.save(orderData);
     return order.toString();
    }
    @PostMapping("/update/payment")
    public ResponseEntity<?> updateOrder(@RequestBody Map<String, Object> data) {
        OrderData orderData = OrderRepo.findByOrderId(data.get("order_id").toString());
        orderData.setStatus(data.get("payment_id").toString());
        orderData.setPaymentId(data.get("status").toString());
        OrderRepo.save(orderData);
        return ResponseEntity.ok(Map.of("msg", "updated"));
    }
}
