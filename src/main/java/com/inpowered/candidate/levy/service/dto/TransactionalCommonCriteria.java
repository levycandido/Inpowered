package com.inpowered.candidate.levy.service.dto;

import com.inpowered.candidate.levy.service.Criteria;
import com.inpowered.candidate.levy.service.filter.StringFilter;
import com.inpowered.candidate.levy.service.filter.ZonedDateTimeFilter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static com.inpowered.candidate.levy.util.CriteriaUtil.updateProperty;

/**
 * BLD Common criteria class that handle common fields
 * ClientTimeZone, CreateDate and ModificationDate
 */
@Data
@NoArgsConstructor
public class TransactionalCommonCriteria implements Serializable, Criteria {

    private ZonedDateTimeFilter createDate;
    private ZonedDateTimeFilter modificationDate;
    private StringFilter clientTimeZone;

    protected TransactionalCommonCriteria(TransactionalCommonCriteria other){
        this.createDate = updateProperty(other.createDate);
        this.modificationDate = updateProperty(other.modificationDate);
        this.clientTimeZone = updateProperty(other.clientTimeZone);
    }

    @Override
    public Criteria copy() {
        return new TransactionalCommonCriteria(this);
    }

}
