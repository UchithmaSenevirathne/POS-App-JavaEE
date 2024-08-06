package lk.ijse.posbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    @JsonProperty("oId")
    private String oId;

    @JsonProperty("date")
    private String date;

    @JsonProperty("total")
    private double total;

    @JsonProperty("total")
    private String customerId;

    @JsonProperty("orderDetails")
    private List<OrderDetailsDTO> orderDetails;
}
