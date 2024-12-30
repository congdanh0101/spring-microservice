package spring.microservice.productservice.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelMappingUtil<Entity,DTO> {

    @Autowired
    private ModelMapper modelMapper;

    public Entity mapToEntity(DTO dto, Class<Entity> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    public DTO mapToDTO(Entity entity, Class<DTO> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }
}
