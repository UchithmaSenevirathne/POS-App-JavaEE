package lk.ijse.posbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lk.ijse.posbackend.dto.OrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class OrderEntity {
    private String oId;

    private String date;

    private double total;

    private String customerId;
}
