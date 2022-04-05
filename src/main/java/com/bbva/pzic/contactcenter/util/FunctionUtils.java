package com.bbva.pzic.contactcenter.util;

/**
 * Created on 19/10/2020.
 *
 * @author Entelgy.
 */
public class FunctionUtils {

    private FunctionUtils() {
    }

    public static Boolean convertToBoolean(final String value) {
        return org.apache.commons.lang.StringUtils.isEmpty(value) ? null : "S".equalsIgnoreCase(value) ? Boolean.TRUE : "N".equalsIgnoreCase(value) ? Boolean.FALSE : null;
    }

    public static Boolean convertToBoolean(final Integer value) {
        return value == null ? null : 1 == value ? Boolean.TRUE : 0 == value ? Boolean.FALSE : null;
    }
}
