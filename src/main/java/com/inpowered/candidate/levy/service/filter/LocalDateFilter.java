package com.inpowered.candidate.levy.service.filter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDate;
import java.util.List;

/**
 * Filter class for {@link LocalDate} type attributes.
 *
 * @see RangeFilter
 */
public class LocalDateFilter extends RangeFilter<LocalDate> {

    private static final long serialVersionUID = 1L;

    /**
     * <p>Constructor for LocalDateFilter.</p>
     */
    public LocalDateFilter() {
    }

    /**
     * <p>Constructor for LocalDateFilter.</p>
     *
     * @param value a {@link String} object.
     */
    public LocalDateFilter(final String value) {
        super();
        setEquals(LocalDate.parse(value));
    }

    /**
     * <p>Constructor for LocalDateFilter.</p>
     *
     * @param filter a {@link LocalDateFilter} object.
     */
    public LocalDateFilter(final LocalDateFilter filter) {
        super(filter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @DateTimeFormat(iso = ISO.DATE)
    public LocalDateFilter setEquals(LocalDate equals) {
        super.setEquals(equals);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @DateTimeFormat(iso = ISO.DATE)
    public LocalDateFilter setGreaterThan(LocalDate equals) {
        super.setGreaterThan(equals);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @DateTimeFormat(iso = ISO.DATE)
    public LocalDateFilter setGreaterThanOrEqual(LocalDate equals) {
        super.setGreaterThanOrEqual(equals);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @DateTimeFormat(iso = ISO.DATE)
    public LocalDateFilter setIn(List<LocalDate> in) {
        super.setIn(in);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @DateTimeFormat(iso = ISO.DATE)
    public LocalDateFilter setLessThan(LocalDate equals) {
        super.setLessThan(equals);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @DateTimeFormat(iso = ISO.DATE)
    public LocalDateFilter setLessThanOrEqual(LocalDate equals) {
        super.setLessThanOrEqual(equals);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @DateTimeFormat(iso = ISO.DATE)
    public LocalDateFilter setNotEquals(LocalDate equals) {
        super.setNotEquals(equals);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @DateTimeFormat(iso = ISO.DATE)
    public LocalDateFilter setNotIn(List<LocalDate> notIn) {
        super.setNotIn(notIn);
        return this;
    }

    /**
     * <p>copy.</p>
     *
     * @return a {@link LocalDateFilter} object.
     */
    @Override
    public LocalDateFilter copy() {
        return new LocalDateFilter(this);
    }

}
