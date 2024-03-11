package com.paytm.integration.entity;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import jakarta.persistence.*;

@Entity
@Table(name = "orderData")
public class OrderData {
       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
       private Long myOrderId;
       public String getOrderId() {
              return orderId;
       }

       public void setOrderId(String orderId) {
              this.orderId = orderId;
       }

       public String getAmount() {
              return amount;
       }

       public void setAmount(String amount) {
              this.amount = amount;
       }

       public String getReceipt() {
              return receipt;
       }

       public void setReceipt(String receipt) {
              this.receipt = receipt;
       }

       public String getStatus() {
              return status;
       }

       public void setStatus(String status) {
              this.status = status;
       }

       public String getPaymentId() {
              return paymentId;
       }

       public void setPaymentId(String paymentId) {
              this.paymentId = paymentId;
       }

       private String orderId;
       private String amount;
       private String receipt;
       private String status;
       private String paymentId;
}
