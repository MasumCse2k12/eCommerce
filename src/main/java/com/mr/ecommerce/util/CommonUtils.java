package com.mr.ecommerce.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CommonUtils {

    public static Date localDateToDate(LocalDate  localDate) {
        if(localDate == null) return null;
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
