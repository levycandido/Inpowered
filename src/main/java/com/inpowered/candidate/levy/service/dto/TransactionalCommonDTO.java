package com.inpowered.candidate.levy.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * A DTO with the most common fields for BLD tables
 * DeleteDate, ClientTimeZone, CreateDate, ModificationDate
 */
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class TransactionalCommonDTO implements Serializable {

    private ZonedDateTime deleteDate;

    private ZonedDateTime createDate;

    private ZonedDateTime modificationDate;

    @Size(max = 50)
    private String clientTimeZone;

}
