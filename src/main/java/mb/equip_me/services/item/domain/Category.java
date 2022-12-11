package mb.equip_me.services.item.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    public Category(UUID categoryId, String categoryName) {
        super(categoryId);
        this.categoryName = categoryName;
    }

    @Column(name="name")
    private String categoryName;

    @OneToOne()
    @JoinColumn(name = "id")
    private Item item;
}
