package com.inpowered.candidate.levy.service.criteria;

import com.inpowered.candidate.levy.service.Criteria;
import com.inpowered.candidate.levy.service.filter.BooleanFilter;
import com.inpowered.candidate.levy.service.filter.StringFilter;
import com.inpowered.candidate.levy.service.filter.ZonedDateTimeFilter;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class CustomerCriteria implements Serializable, Criteria {

    private StringFilter firstName;
    private StringFilter lastName;
    private StringFilter gender;
    private BooleanFilter active;
    private ZonedDateTimeFilter createDate;
    private ZonedDateTimeFilter modificationDate;
    private ZonedDateTimeFilter deleteDate;

     /**
     * Instantiates a new CustomerCriteria.
     *
     * @param other the other
     */
    public  CustomerCriteria(CustomerCriteria other) {
        this.firstName =  other.firstName == null ? null : other.firstName.copy();
        this.lastName = other.lastName == null ? null : other.lastName.copy();
        this.gender = other.gender == null ? null : other.gender.copy();
        this.active = other.active == null ? null : other.active.copy();
        this.createDate = other.createDate == null ? null : other.createDate.copy();
        this.modificationDate = other.modificationDate == null ? null : other.modificationDate.copy();
        this.deleteDate = other.deleteDate == null ? null : other.deleteDate.copy();
    }

    @Override
    public Criteria copy() {
        return new CustomerCriteria(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerCriteria that = (CustomerCriteria) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (modificationDate != null ? !modificationDate.equals(that.modificationDate) : that.modificationDate != null)
            return false;
        return deleteDate != null ? deleteDate.equals(that.deleteDate) : that.deleteDate == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modificationDate != null ? modificationDate.hashCode() : 0);
        result = 31 * result + (deleteDate != null ? deleteDate.hashCode() : 0);
        return result;
    }
}