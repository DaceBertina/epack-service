package estack.epack.business.mapper;

import estack.epack.business.repository.model.CategoryEntity;
import estack.epack.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapStruct {

    CategoryMapStruct INSTANCE = Mappers.getMapper(CategoryMapStruct.class);

    CategoryEntity categoryDtoToCategoryEntity(Category categoryDto);

    Category categoryEntityToCategoryDto(CategoryEntity categoryEntity);
}
