package com.ifmo.lesson26;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

    // SimpleDateFormat не потокобезопасный,
    // поэтому необходимо создавать отдельный экземпляр для каждого потока
    private final static ThreadLocal<DateFormat> dateFormat = new
            ThreadLocal<DateFormat>() {
                @Override
                protected DateFormat initialValue() {
                    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
                }
            };

    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(formatTime(record.getMillis())).append(']');
        sb.append('[').append(record.getLevel()).append(']');
        sb.append('[').append(record.getSourceClassName()).append('.')
                .append(record.getSourceMethodName()).append("()");
        sb.append(" - ").append(record.getMessage());
        sb.append('\r');
        return sb.toString();
    }

    private String formatTime(long millis) {
        return dateFormat.get().format(new Date(millis));
    }

}
