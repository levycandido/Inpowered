package com.inpowered.candidate.levy.domain.util.date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Objects;

/**
 * This should keep consistency in dates all over the microservices.
 *
 * @author wahab.ahmed
 * @version 1.0
 */
public class DateUtils {

    private static final Logger LOG = LoggerFactory.getLogger(DateUtils.class);

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public static LocalDate parseLocalDate(String date) {
        return LocalDate.parse(date, DATE_TIME_FORMATTER);
    }

    public static ZonedDateTime parseZonedDateTime(String date) {
        return ZonedDateTime.parse(date);
    }

    public static ZonedDateTime getZonedDateNow() {
        return ZonedDateTime.now();
    }

    public static LocalDate getLocalDateNow() {
        return LocalDate.now();
    }

    public static ZonedDateTime calculateStartDayOfAMonth(final Integer year, final String month) {

        if (Objects.nonNull(year) && Objects.nonNull(month)) {
            try {

                Month currentMonth = Month.valueOf(month);
                return LocalDateTime.now().atZone(ZoneOffset.UTC)
                        .withYear(year)
                        .withMonth(currentMonth.getValue())
                        .with(TemporalAdjusters.firstDayOfMonth())
                        .with(LocalTime.MIN);

            } catch (IllegalArgumentException e) {
                LOG.error("Not able to parse Year/Month {}/{}", year, month, e);
                return null;
            }

        }
        return null;

    }

    public static ZonedDateTime calculateEndDayOfAMonth(final Integer year, final String month) {

        if (Objects.nonNull(year) && Objects.nonNull(month)) {
            try {

                Month currentMonth = Month.valueOf(month);
                return LocalDateTime.now().atZone(ZoneOffset.UTC)
                        .withYear(year)
                        .withMonth(currentMonth.getValue())
                        .with(TemporalAdjusters.lastDayOfMonth())
                        .with(LocalTime.MAX);

            } catch (IllegalArgumentException e) {
                LOG.error("Not able to parse Year/Month {}/{}", year, month, e);
                return null;
            }

        }
        return null;

    }
}
