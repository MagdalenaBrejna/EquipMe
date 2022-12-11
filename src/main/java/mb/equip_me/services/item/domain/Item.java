package mb.equip_me.services.item.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "items")
public class Item extends BaseEntity {

    public Item(UUID itemId, String itemName, String itemBrand, String itemModel, String itemDescription, byte[] itemImage, Double dayRentPrice, UUID userId) {
        super(itemId);
        this.itemName = itemName;
        this.itemBrand = itemBrand;
        this.itemModel = itemModel;
        this.itemDescription = itemDescription;
        this.itemImage = itemImage;
        this.dayRentPrice = dayRentPrice;
        this.userId = userId;
    }

    @Column(name="name")
    private String itemName;

    @Column(name="brand")
    private String itemBrand;

    @Column(name="model")
    private String itemModel;

    @Lob
    @Column(name="description")
    private String itemDescription;

    @Column(name="image")
    private byte[] itemImage;

    @Column(name="day_price")
    private Double dayRentPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @Column(name="owner_id")
    private UUID userId;
}
