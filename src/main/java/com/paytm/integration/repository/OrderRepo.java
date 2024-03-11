package com.paytm.integration.repository;

import com.paytm.integration.entity.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderData, Long>{
    public OrderData findByOrderId(String razorpayOrderId);
}
