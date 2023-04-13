package com.inpowered.candidate.levy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * An Entity with the most common fields for BLD tables
 * DeleteDate, ClientTimeZone, CreateDate, ModificationDate
 */
@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public abstract class TransactionalCommonEntity implements Serializable {

    @Column(name = "delete_date")
    private ZonedDateTime deleteDate;

    
    @Column(name = "create_date", nullable = false)
    private ZonedDateTime createDate;

    
    @Column(name = "modification_date", nullable = false)
    private ZonedDateTime modificationDate;

    @Column(name = "client_timezone")
    @Size(max = 50)
    private String clientTimeZone;

}
