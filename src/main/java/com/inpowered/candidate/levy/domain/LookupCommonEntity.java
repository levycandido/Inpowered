package com.inpowered.candidate.levy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * An Entity with the most common fields for LK tables
 * OrderNumber, Active, CreateDate, ModificationDate
 */
@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public abstract class LookupCommonEntity implements Serializable {

    @Column(name = "order_number", nullable = false)
    private Integer orderNumber = 1;

    @Column(name = "active", length = 1, nullable = false)
    private Boolean active = true;

    
    @Column(name = "create_date", nullable = false)
    private ZonedDateTime createDate;

    
    @Column(name = "modification_date", nullable = false)
    private ZonedDateTime modificationDate;

}
