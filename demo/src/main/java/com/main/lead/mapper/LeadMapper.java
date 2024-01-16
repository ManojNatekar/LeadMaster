package com.main.lead.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.main.lead.enitites.LeadEntity;
import com.main.lead.models.LeadDTO;


@Mapper(componentModel = "spring")
public interface LeadMapper {

	LeadMapper INSTANCE = Mappers.getMapper(LeadMapper.class);

	@Mapping(target = "leadId", ignore = false)
	LeadDTO toDto(LeadEntity lead);

	LeadEntity toEntity(LeadDTO leadDTO);
	
	   @AfterMapping
	    default void mapLeadId(LeadDTO leadDTO, @MappingTarget LeadEntity leadEntity) {
	        leadEntity.setLeadId(leadDTO.getLeadId());
	    }

}
