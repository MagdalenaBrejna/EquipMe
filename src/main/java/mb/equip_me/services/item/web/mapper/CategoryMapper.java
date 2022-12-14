package mb.equip_me.services.item.web.mapper;

import mb.equip_me.services.item.domain.Category;
import mb.equip_me.services.item.web.model.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface CategoryMapper {

    @Mappings({
            @Mapping(target="id", source="category.id"),
            @Mapping(target="categoryName", source="category.categoryName"),
    })
    CategoryDto categoryToCategoryDto(Category category);

    @Mappings({
            @Mapping(target="id", source="dto.id"),
            @Mapping(target="categoryName", source="dto.categoryName"),
    })
    Category categoryDtoToCategory(CategoryDto dto);
}
