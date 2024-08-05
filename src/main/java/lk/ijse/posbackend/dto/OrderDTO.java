package lk.ijse.posbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String id;
    private String date;
    private Double total;
    private List<OrderDetailsDTO> orderDetailsDTOS;
}
