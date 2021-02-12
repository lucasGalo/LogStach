package com.galo.logstach.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DatasUtil {

    public static String formatacao(String formato, Date data) {
        SimpleDateFormat format = new SimpleDateFormat(formato, Locale.getDefault());
        return format.format(data);
    }

    public static String dataAtual(String format) {
        Locale aDefault = Locale.getDefault();
        Calendar instance = Calendar.getInstance(aDefault);
        return formatacao(format, instance.getTime());
    }
}
