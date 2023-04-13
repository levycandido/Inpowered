package com.inpowered.candidate.levy.service.dto;

import com.inpowered.candidate.levy.service.Criteria;
import com.inpowered.candidate.levy.service.filter.BooleanFilter;
import com.inpowered.candidate.levy.service.filter.IntegerFilter;
import com.inpowered.candidate.levy.service.filter.ZonedDateTimeFilter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static com.inpowered.candidate.levy.util.CriteriaUtil.updateProperty;

/**
 * LK Common criteria class that handle common fields
 * OrderNumber, Active, CreateDate and ModificationDate
 */
@Data
@NoArgsConstructor
public class LookupCommonCriteria implements Serializable, Criteria {

    private IntegerFilter orderNumber;
    private BooleanFilter active;
    private ZonedDateTimeFilter createDate;
    private ZonedDateTimeFilter modificationDate;

    protected LookupCommonCriteria(LookupCommonCriteria other){
        this.orderNumber = updateProperty(other.orderNumber);
        this.active = updateProperty(other.active);
        this.createDate = updateProperty(other.createDate);
        this.modificationDate = updateProperty(other.modificationDate);
    }

    @Override
    public Criteria copy() {
        return new LookupCommonCriteria(this);
    }

}
