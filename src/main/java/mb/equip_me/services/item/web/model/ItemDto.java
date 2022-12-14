package mb.equip_me.services.item.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto implements Serializable {

    @Null
    @JsonProperty("id")
    private UUID id;

    @NotBlank
    private String itemName;

    @NotBlank
    private String itemBrand;

    @NotBlank
    private String itemModel;

    @NotBlank
    private String itemDescription;

    @NotBlank
    private byte[] itemImage;

    @NotBlank
    @Min(0)
    private Double dayRentPrice;

    @NotNull
    private UUID category;

    @NotNull
    private UUID userId;
}
