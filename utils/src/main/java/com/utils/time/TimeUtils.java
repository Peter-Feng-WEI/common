package com.utils.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 基于 JDK 8 time包的时间工具类
 * <p/>
 * Created by feng_wei on 2016/8/23.
 */
public final class TimeUtils {

	/**
	 * Get the default time format: yyyy-MM-dd HH:mm:ss
	 */
	private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = TimeFormat.FORMAT_Y_M_D_H_M_S.formatter;

	private TimeUtils() {
		// no construct function
	}

	/**
	 * Calculate the age between the two, based on two time stamps
	 * 
	 * @param birthday
	 *            Birthday time stamps,The starting point(if null ,the default a
	 *            current date-time )
	 * @param endTime
	 *            At the end of time stamps (if null ,the default a current
	 *            date-time )
	 * @return
	 */
	public static Integer parseAgeByTime(int birthday, int endTime) {
		Period p = Period.between(parseLocalDate(birthday), parseLocalDate(endTime));
		if (p != null) {
			int years = p.getYears();
			int months = p.getMonths();
			if (months > 0)
				years++;

			return years;
		} else
			return 0;
	}

	/**
	 * Count birthdays according to age
	 * 
	 * @param age
	 * 
	 * @return
	 */
	public static Integer parseTimeByAge(Integer age) {
		if (age > 0) {
			ZoneId zoneId = ZoneId.systemDefault();
			LocalDateTime localDateTime = parseLocalDateTime(Instant.now(), zoneId);
			localDateTime = localDateTime.minusYears(age);
			return (int) localDateTime.atZone(zoneId).toInstant().getEpochSecond();
		} else {
			return getInstantCurrentSecondDatetimestamp();
		}
	}

	/**
	 * Time stamp turns localtDate
	 * 
	 * @param time
	 *            time stamp (if null ,the default a current data-time )
	 * @return the default time format：yyyy-MM-dd
	 */
	public static LocalDate parseLocalDate(Integer time) {
		if (time == null)
			time = getInstantCurrentSecondDatetimestamp();

		return LocalDate.parse(parseLocalDateTimeToTime(time, TimeFormat.FORMAT_Y_M_D));
	}

	/**
	 * String Time format turns time stamp
	 * 
	 * @param time
	 *            formart:yyyy-MM-dd
	 * @return
	 */
	public static Integer parseLocalDateToTimeStamp(String time) {
		return (int) parseLocalDate(time).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
	}

	/**
	 * String Time format turns time stamp
	 * 
	 * @param time
	 *            formart:yyyy-MM-dd
	 * @return
	 */
	public static Integer parseLocalDateToTimeStamp(LocalDate localDate) {
		if (localDate == null)
			return 0;
		return (int) localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
	}

	/**
	 * Time stamp turns localtDate
	 * 
	 * @param time
	 *            time stamp (if null ,the default a current data-time )
	 * @return the default time format：yyyy-MM-dd
	 */
	public static LocalDate parseLocalDate(String time) {
		if (time == null || "".equals(time))
			time = "1970-01-01";

		return LocalDate.parse(time, TimeFormat.FORMAT_Y_M_D.formatter);
	}

	/**
	 * Time stamp turns string
	 * 
	 * @param time
	 *            time stamp (if null ,the default a current data-time )
	 * @return the default time format：yyyy-MM-dd HH:mm:ss
	 */
	public static String parseLocalDateTimeToTime(Integer time) {
		if (time == null)
			time = getInstantCurrentSecondDatetimestamp();

		return parseLocalDateTimeToTime(parseLocalDateTime(Instant.ofEpochSecond(time), ZoneId.systemDefault()));
	}

	/**
	 * Formats a date-time time stamp object using this formatter.
	 * 
	 * @param time
	 *            time stamp (if null ,the default a current data-time )
	 * @param format
	 *            formatter
	 * @return the formatted string
	 */
	public static String parseLocalDateTimeToTime(Integer time, TimeFormat format) {
		if (time == null)
			time = getInstantCurrentSecondDatetimestamp();

		return parseLocalDateTimeToTime(parseLocalDateTime(Instant.ofEpochSecond(time), ZoneId.systemDefault()),
				format);
	}

	/**
	 * Formats a date-time time stamp object using this formatter.
	 * 
	 * @param time
	 *            time stamp (if null ,the default a current data-time )
	 * @param format
	 *            formatter
	 * @return the formatted string
	 */
	public static Integer parseLocalDateTimeToTime(String timestr, TimeFormat format) {
		if (timestr == null || "".equals(timestr))
			timestr = parseLocalDateTimeToTime(getInstantCurrentSecondDatetimestamp());

		return (int) parseLocalDateTime(timestr, format).atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
	}

	/**
	 * Obtains an instance of {@code LocalDateTime} from an {@code Instant} and
	 * zone ID.
	 * <p>
	 * This creates a local date-time based on the specified instant. First, the
	 * offset from UTC/Greenwich is obtained using the zone ID and instant,
	 * which is simple as there is only one valid offset for each instant. Then,
	 * the instant and offset are used to calculate the local date-time.
	 *
	 * @param timeStr
	 * @return the local date-time, not null
	 */
	public static LocalDateTime parseLocalDateTime(String timeStr) {
		return LocalDateTime.parse(timeStr, DEFAULT_DATETIME_FORMATTER);
	}

	/**
	 * Obtains an instance of {@code LocalDateTime} from an {@code Instant} and
	 * zone ID.
	 * <p>
	 * This creates a local date-time based on the specified instant. First, the
	 * offset from UTC/Greenwich is obtained using the zone ID and instant,
	 * which is simple as there is only one valid offset for each instant. Then,
	 * the instant and offset are used to calculate the local date-time.
	 *
	 * @param timeStr
	 * @param format
	 *            the format object to format, not null((if null , using the
	 *            default time format))
	 * @return the local date-time, not null
	 */
	public static LocalDateTime parseLocalDateTime(String timeStr, TimeFormat format) {
		if (format == null)
			format = TimeFormat.FORMAT_Y_M_D;

		return LocalDateTime.parse(timeStr, format.formatter);
	}

	/**
	 * Obtains an instance of {@code LocalDateTime} from an {@code Instant} and
	 * zone ID.
	 * <p>
	 * This creates a local date-time based on the specified instant. First, the
	 * offset from UTC/Greenwich is obtained using the zone ID and instant,
	 * which is simple as there is only one valid offset for each instant. Then,
	 * the instant and offset are used to calculate the local date-time.
	 *
	 * @param instant
	 *            the instant to create the date-time from, not null(if null ,
	 *            the default current time -- Instant.now() )
	 * @param zoneId
	 *            the time-zone, which may be an offset, not null(if null,the
	 *            default zoneId -- ZoneId.systemDefault())
	 * @return the local date-time, not null
	 */
	public static LocalDateTime parseLocalDateTime(Instant instant, ZoneId zoneId) {
		if (instant == null) {
			instant = Instant.now();
			zoneId = ZoneId.systemDefault();
		}
		return LocalDateTime.ofInstant(instant, zoneId);
	}

	/**
	 * LocalDataTime to turn the string
	 *
	 * @param time
	 *            Include date and time
	 * @return the default time format：yyyy-MM-dd HH:mm:ss
	 */
	public static String parseLocalDateTimeToTime(LocalDateTime time) {
		return DEFAULT_DATETIME_FORMATTER.format(time);
	}

	/**
	 * Formats a date-time object using this formatter.
	 * <p>
	 * This formats the date-time to a String using the rules of the formatter.
	 *
	 * @param time
	 * @param format
	 *            the format object to format, not null((if null , using the
	 *            default time format))
	 * @return the formatted string
	 */
	public static String parseLocalDateTimeToTime(LocalDateTime time, TimeFormat format) {
		if (format == null)
			format = TimeFormat.FORMAT_Y_M_D_H_M_S;

		return format.formatter.format(time);
	}

	/**
	 * Formats the current date-time object using this formatter.
	 * <p>
	 * This formats the current date-time to a String using the rules of the
	 * formatter.
	 * 
	 * @param format
	 *            the format object to format, not null((if null , using the
	 *            default time format))
	 * @return the formatted string
	 */
	public static String getLocalDateTimeCurrentDatetimestamp(TimeFormat format) {
		if (format == null)
			format = TimeFormat.FORMAT_Y_M_D_H_M_S;

		return format.formatter.format(LocalDateTime.now());
	}

	/**
	 * Get the current date-time time stamp(Second)
	 * 
	 * @return
	 */
	public static Integer getInstantCurrentSecondDatetimestamp() {
		return (int) Instant.now().getEpochSecond();
	}

	/**
	 * Get the current date-time time stamp(Nano)
	 * 
	 * @return
	 */
	public static Integer getInstantCurrentNanoDataTimestamp() {
		return Instant.now().getNano();
	}

	/**
	 * The date-time format type
	 */
	public enum TimeFormat {

		/**
		 * This date-time formatter
		 */
		FORMAT_Y("yyyy"), FORMAT_YM("yyyyMM"), FORMAT_YMD("yyyyMMdd"), FORMAT_H("HH"), FORMAT_HM("HHmm"), FORMAT_HMS("HHmmss"), FORMAT_H_M("HH:mm"), FORMAT_Y_M_D("yyyy-MM-dd"), FORMAT_M_D("MM.dd"), FORMAT_Y_M_D_H_M("yyyy-MM-dd HH:mm"), FORMAT_YMDHMS("yyyyMMddHHmmss"), FORMAT_Y_M_D_H_M_S("yyyy-MM-dd HH:mm:ss");

		private transient DateTimeFormatter formatter;

		TimeFormat(String pattern) {
			formatter = DateTimeFormatter.ofPattern(pattern);
		}
	}
}
