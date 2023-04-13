package com.inpowered.candidate.levy.util;

import com.inpowered.candidate.levy.service.filter.Filter;
import org.springframework.data.util.CastUtils;

import java.util.Objects;

public class CriteriaUtil {

    private CriteriaUtil(){}

    /**
     * Method that clones the criteria filters
     * @param other criteria field
     * @return
     */
    public static <T> T updateProperty(Filter<?> other) {
        if (Objects.nonNull(other)) {
            return CastUtils.cast(other.copy());
        }
        return null;
    }

}
