package com.inpowered.candidate.levy.service.mapper;

import com.inpowered.candidate.levy.domain.Customer;
import com.inpowered.candidate.levy.service.dto.CustomerDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Customer} and its DTO {@link CustomerDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {

}
