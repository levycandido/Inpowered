package com.inpowered.candidate.levy.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inpowered.candidate.levy.InpoweredApplication;
import com.inpowered.candidate.levy.service.CustomerCriteriaService;
import com.inpowered.candidate.levy.service.dto.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = InpoweredApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class CustomerSpecificationTest {

    public static final String GET_ALL = "/v1/customers";

    @MockBean
    CustomerCriteriaService customerCriteriaService;

    @Autowired
    MockMvc mockMvc;

     @Autowired
    ObjectMapper objectMapper;

    @Test
    void fidingByCriteriaOk() throws Exception {
        List<CustomerDTO> customerDTOS = new java.util.ArrayList<>();
        customerDTOS.add(dto());

        given(customerCriteriaService.findByCriteria(any(), any(PageRequest.class))).willReturn(new PageImpl<>(customerDTOS));

        MvcResult result = mockMvc.perform(get(GET_ALL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String actualResponseBody = result.getResponse().getContentAsString();
        List<CustomerDTO> value = new ArrayList<>();
        value.add(dto());
        String expectedResponseBody = objectMapper.writeValueAsString(value);
        assertThat(actualResponseBody).isEqualToIgnoringWhitespace(expectedResponseBody);
    }


    public CustomerDTO dto() {
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setFirstName("Levy");
        customerDTO.setLastName("Candido");
        customerDTO.setCreateDate(ZonedDateTime.now());
        customerDTO.setModificationDate(ZonedDateTime.now());
        return customerDTO;
    }

}