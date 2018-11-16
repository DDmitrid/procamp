package com.globallogic.procamp.lesson7.data.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
                componentModel = "spring",
                unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class MappingConfig {
}
