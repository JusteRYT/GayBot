package com.justeryt.discordbot.commands.Utils;

import com.justeryt.discordbot.commands.music.Track;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.io.IOException;
import java.text.ParseException;
public abstract class Utils {
    private static final String DURATION_FORMAT = "mm:ss";
    private static final String DURATION_FORMAT_LONG = "HH:mm:ss";
    private static final String DURATION_FORMAT_ULTRA = "y лет M месяцев dd дней HH:mm:ss";
    private static final long zero = 0L;

    public static String formatDuration(long duration) {
        return DurationFormatUtils.formatDuration(duration, DURATION_FORMAT);
    }

    public static String formatLongDuration(long duration) {
        return DurationFormatUtils.formatDuration(duration, DURATION_FORMAT_LONG);
    }

    public static String formatUltraLongDuration(long duration) {
        return DurationFormatUtils.formatPeriod(zero, duration, DURATION_FORMAT_ULTRA);
    }

    public static String formatDurationMegaLong(long duration, long duration1) {
        return DurationFormatUtils.formatPeriod(duration, duration1, DURATION_FORMAT_ULTRA);
    }

    public static String bestFormatDuration(long duration) {
        if (duration > 86400000) {
            return formatUltraLongDuration(duration);
        }
        if (duration < 86400000) {
            return formatLongDuration(duration);
        }
        return null;
    }

    public static String bestFormatDuration(long duration, String videoId) {
        try {
            if (duration > 31536000000L) {
                long[] time = Track.getPublicationVideo(videoId);
                return formatDurationMegaLong(time[0], time[1]);
            }
        } catch (IOException | ParseException exception) {
            System.out.println("Не удалось преобразовать в классе Utils");
        }
        return null;
    }
}
