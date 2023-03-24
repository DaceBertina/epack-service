package estack.epack.business.mapper;

import estack.epack.business.repository.model.CategoryEntity;
import estack.epack.business.repository.model.EpackEntity;
import estack.epack.domain.Epack;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface EpackMapStruct {

    EpackMapStruct INSTANCE = Mappers.getMapper(EpackMapStruct.class);

    @Mapping(source="categoryId", target="categoryEntity", qualifiedByName = "categoryIdToCategoryEntity")
    EpackEntity epackDtoToEpackEntity(Epack epackDto);

    @Mapping(source="categoryEntity", target="categoryId", qualifiedByName = "categoryEntityToCategoryId")
    Epack epackEntityToEpackDto(EpackEntity epackEntity);

    @Named("categoryIdToCategoryEntity")
    static CategoryEntity categoryIdToCategoryEntity(Long  categoryId) {
        if (categoryId == null) return null;
        return new CategoryEntity(categoryId);
    }

    @Named("categoryEntityToCategoryId")
    static Long categoryEntityToCategoryId(CategoryEntity categoryEntity){
        if (categoryEntity == null) return null;
        return categoryEntity.getCategoryId();
    }

}
