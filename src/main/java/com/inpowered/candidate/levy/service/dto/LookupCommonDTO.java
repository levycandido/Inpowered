package com.inpowered.candidate.levy.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * A DTO with the most common fields for LK tables
 * OrderNumber, Active, CreateDate, ModificationDate
 */
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class LookupCommonDTO implements Serializable {

    private Integer orderNumber = 1;

    private Boolean active = true;

    private ZonedDateTime createDate;

    private ZonedDateTime modificationDate;

}
