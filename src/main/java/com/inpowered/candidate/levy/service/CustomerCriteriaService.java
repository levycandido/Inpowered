package com.inpowered.candidate.levy.service;

import com.inpowered.candidate.levy.domain.Customer;
import com.inpowered.candidate.levy.repository.CustomerRepository;
import com.inpowered.candidate.levy.service.criteria.CustomerCriteria;
import com.inpowered.candidate.levy.service.filter.StringFilter;
import com.inpowered.candidate.levy.service.dto.CustomerDTO;
import com.inpowered.candidate.levy.service.mapper.CustomerMapper;
import jakarta.persistence.criteria.*;
import jakarta.persistence.metamodel.SingularAttribute;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;

@Service
@Transactional(readOnly = true)
public class CustomerCriteriaService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerCriteriaService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public Specification<Customer> createSpecification(CustomerCriteria criteria) {
        Specification<Customer> specification = Specification.<Customer>where(null);
        if (criteria != null) {
            //if (criteria.getFirstName() != null) {
                //specification = specification.and(buildStringSpecification(criteria.getFirstName(), Customer_.firstName));
            //}
        }
        return specification;
    }

    public Specification<Customer> buildStringSpecification(StringFilter filter, SingularAttribute<? super Customer, String> field) {
        return this.buildSpecification(filter, (root) -> {
            return root.get(field);
        });
    }

    public Specification<Customer> buildSpecification(StringFilter filter, Function<Root<Customer>, Expression<String>> metaclassFunction) {
        if (filter.getEquals() != null) {
            return this.equalsSpecification(metaclassFunction, (String) filter.getEquals());
        } else if (filter.getIn() != null) {
            return this.valueIn(metaclassFunction, filter.getIn());
        } else if (filter.getNotEquals() != null) {
            return this.notEqualsSpecification(metaclassFunction, (String) filter.getNotEquals());
        } else {
            return filter.getSpecified() != null ? this.byFieldSpecified(metaclassFunction, filter.getSpecified()) : null;
        }
    }

    public Page<CustomerDTO> findByCriteria(CustomerCriteria criteria, Pageable page) {
        Specification<Customer> specification = createSpecification(criteria);
        return customerRepository.findAll(specification, page).map(customerMapper::toDto);
    }

    public <X> Specification<Customer> byFieldSpecified(Function<Root<Customer>, Expression<X>> metaclassFunction, boolean specified) {
        return specified ? (root, query, builder) -> {
            return builder.isNotNull((Expression) metaclassFunction.apply(root));
        } : (root, query, builder) -> {
            return builder.isNull((Expression) metaclassFunction.apply(root));
        };
    }

    public <X> Specification<Customer> notEqualsSpecification(Function<Root<Customer>, Expression<X>> metaclassFunction, X value) {
        return (root, query, builder) -> {
            return builder.not(builder.equal((Expression) metaclassFunction.apply(root), value));
        };
    }

    public <X> Specification<Customer> equalsSpecification(Function<Root<Customer>, Expression<X>> metaclassFunction, X value) {
        return (root, query, builder) -> {
            return builder.equal((Expression) metaclassFunction.apply(root), value);
        };
    }

    public <X> Specification<Customer> valueIn(Function<Root<Customer>, Expression<X>> metaclassFunction, Collection<X> values) {
        return (root, query, builder) -> {
            CriteriaBuilder.In<X> in = builder.in((Expression) metaclassFunction.apply(root));

            Object value;
            for (Iterator var6 = values.iterator(); var6.hasNext(); in = in.value((X) value)) {
                value = var6.next();
            }

            return in;
        };
    }


}