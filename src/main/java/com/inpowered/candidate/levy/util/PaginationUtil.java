package com.inpowered.candidate.levy.util;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

public final class PaginationUtil {
    private static final String HEADER_X_TOTAL_COUNT = "X-Total-Count";
    private static final String HEADER_LINK_FORMAT = "<{0}>; rel=\"{1}\"";

    private PaginationUtil() {
    }

    public static <T> Page<T> generatePage(HttpHeaders headers, List<T> contents) {
        long total = 0L;
        if (headers != null && headers.getFirst("X-Total-Count") != null) {
            total = Long.parseLong((String)Objects.requireNonNull(headers.getFirst("X-Total-Count")));
        }

        return new PageImpl(contents, Pageable.unpaged(), total);
    }

    public static <T> HttpHeaders generatePaginationHttpHeaders(UriComponentsBuilder uriBuilder, Page<T> page) {
        HttpHeaders headers = new HttpHeaders();
        if (page == null) {
            return headers;
        } else {
            headers.add("X-Total-Count", Long.toString(page.getTotalElements()));
            int pageNumber = page.getNumber();
            int pageSize = page.getSize();
            StringBuilder link = new StringBuilder();
            if (pageNumber < page.getTotalPages() - 1) {
                link.append(prepareLink(uriBuilder, pageNumber + 1, pageSize, "next")).append(",");
            }

            if (pageNumber > 0) {
                link.append(prepareLink(uriBuilder, pageNumber - 1, pageSize, "prev")).append(",");
            }

            link.append(prepareLink(uriBuilder, page.getTotalPages() - 1, pageSize, "last")).append(",").append(prepareLink(uriBuilder, 0, pageSize, "first"));
            headers.add("Link", link.toString());
            return headers;
        }
    }

    private static String prepareLink(UriComponentsBuilder uriBuilder, int pageNumber, int pageSize, String relType) {
        return MessageFormat.format("<{0}>; rel=\"{1}\"", preparePageUri(uriBuilder, pageNumber, pageSize), relType);
    }

    private static String preparePageUri(UriComponentsBuilder uriBuilder, int pageNumber, int pageSize) {
        return uriBuilder.replaceQueryParam("page", new Object[]{Integer.toString(pageNumber)}).replaceQueryParam("size", new Object[]{Integer.toString(pageSize)}).toUriString().replace(",", "%2C").replace(";", "%3B");
    }
}
