package lk.ijse.posbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDTO {
    private String itemCode;
    private int qty;
    private double unitPrice;
    private String customerId;
}
