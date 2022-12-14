package mb.equip_me.services.item.web.mapper;

import mb.equip_me.services.item.domain.Item;
import mb.equip_me.services.item.web.model.ItemDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mappings({
            @Mapping(target="id", source="item.id"),
            @Mapping(target="itemName", source="item.itemName"),
            @Mapping(target="itemBrand", source="item.itemBrand"),
            @Mapping(target="itemModel", source="item.itemModel"),
            @Mapping(target="itemDescription", source="item.itemDescription"),
            @Mapping(target="itemImage", source="item.itemImage"),
            @Mapping(target="dayRentPrice", source="item.dayRentPrice"),
            @Mapping(target="category", source="item.category"),
            @Mapping(target="userId", source="item.userId")
    })
    ItemDto itemToItemDto(Item item);

    @Mappings({
            @Mapping(target="id", source="dto.id"),
            @Mapping(target="itemName", source="dto.itemName"),
            @Mapping(target="itemBrand", source="dto.itemBrand"),
            @Mapping(target="itemModel", source="dto.itemModel"),
            @Mapping(target="itemDescription", source="dto.itemDescription"),
            @Mapping(target="itemImage", source="dto.itemImage"),
            @Mapping(target="dayRentPrice", source="dto.dayRentPrice"),
            @Mapping(target="category", source="dto.category"),
            @Mapping(target="userId", source="dto.userId")
    })
    Item itemDtoToItem(ItemDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateItemFromDto(ItemDto dto, @MappingTarget Item entity);
}

