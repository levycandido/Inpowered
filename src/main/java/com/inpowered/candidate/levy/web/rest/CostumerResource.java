package com.inpowered.candidate.levy.web.rest;

import com.inpowered.candidate.levy.service.CustomerCriteriaService;
import com.inpowered.candidate.levy.service.criteria.CustomerCriteria;
import com.inpowered.candidate.levy.service.dto.CustomerDTO;
import com.inpowered.candidate.levy.util.PaginationUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@Slf4j
public class CostumerResource {

    private final CustomerCriteriaService customerCriteriaService;

    public CostumerResource(CustomerCriteriaService customerCriteriaService) {
        this.customerCriteriaService = customerCriteriaService;
    }

    @GetMapping("/v1/customers")
    public ResponseEntity<List<CustomerDTO>> addCostumerRole(
            @ParameterObject CustomerCriteria criteria,
            @SortDefault(sort = "firstName", direction = Sort.Direction.ASC)
            @PageableDefault(size = 10000) Pageable pageable
    ) {
        Page<CustomerDTO> result = customerCriteriaService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), result);
        return ResponseEntity.ok().headers(headers).body(result.getContent());
    }

}
