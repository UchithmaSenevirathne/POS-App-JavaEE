package lk.ijse.posbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsEntity {
    private String itemCode;
    private int qty;
    private double unitPrice;
    private String customerId;
}
