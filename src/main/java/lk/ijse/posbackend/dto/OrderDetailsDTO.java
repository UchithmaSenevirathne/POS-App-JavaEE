package lk.ijse.posbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDTO {
    private String itemId;
    private int qty;
    private double unitPrice;
    private String itemName;
    private String itemDescription;
    private double total;
}
