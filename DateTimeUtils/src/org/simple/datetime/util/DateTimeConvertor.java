package org.simple.datetime.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * 时间转换工具类
 * @author Frankle
 *
 */
public class DateTimeConvertor {

	private DateTimeConvertor(){}
	
	/**
	 * LocalDateTime 转换成 java.util.Date
	 * @param localDateTime
	 * @return
	 * Frankle
	 * 2018年6月26日
	 */
	public static Date toDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	/**
	 * LocalDate 转换成 java.util.Date
	 * @param localDate
	 * @return
	 * Frankle
	 * 2018年6月26日
	 */
	public static Date toDate(LocalDate localDate) {
		ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
		return Date.from(zdt.toInstant());
	}
	
	/**
	 * java.util.Date 转换成 LocalDateTime
	 * @param date
	 * @return
	 * Frankle
	 * 2018年6月26日
	 */
	public static LocalDateTime toLocalDateTime(Date date) {
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}
	
	/**
	 * java.util.Date 转换成 LocalDate
	 * @param date
	 * @return
	 * Frankle
	 * 2018年6月26日
	 */
	public static LocalDate toLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
		return instant.atZone(zoneId).toLocalDate();
	}
}
