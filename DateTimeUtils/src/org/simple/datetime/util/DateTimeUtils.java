package org.simple.datetime.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

import org.simple.datetime.DateTimeCross;
import org.simple.datetime.format.DateTimeFormat;

/**
 * DateTimeUtils
 * @author Frankle
 * @version 1.0.0
 *
 */
public class DateTimeUtils {

	private DateTimeUtils(){}
	
	/**
	 * 获取两个时间之间的间隔天数
	 * @param start 起始时间
	 * @param end 结束时间
	 * @return
	 * Frankle
	 * 2018年6月26日
	 */
	public static long intervalDays(Date start, Date end) {
		if(Objects.isNull(start) || Objects.isNull(end)) {
			throw new IllegalArgumentException("Date start or Date end can not be null!");
		}
		if (start.getTime() == end.getTime()){
			return 0;
		} else {
			long max = Math.max(start.getTime(), end.getTime());
			long min = Math.min(start.getTime(), end.getTime());
			return (long)((max - min) / (1000 * 60 * 60 *24) + 0.5);
		}
	}
	
	/**
	 * 获取某个时间之后的日期
	 * @param date
	 * @param time
	 * @param chronoUnit
	 * @return
	 * Frankle
	 * 2018年6月26日
	 */
	public static Date add(Date date, long time, ChronoUnit chronoUnit) {
		if(Objects.isNull(date)) {
			throw new IllegalArgumentException("date can not be null");
		}
		LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		LocalDateTime localDateTime2 = localDateTime.plus(time, chronoUnit);
		ZonedDateTime zdt = localDateTime2.atZone(ZoneId.systemDefault());
		return Date.from(zdt.toInstant());
	}
	
	/**
	 * 获取某个时间之前的日期
	 * @param date
	 * @param time
	 * @param chronoUnit
	 * @return
	 * Frankle
	 * 2018年6月26日
	 */
	public static Date minus(Date date, long time, ChronoUnit chronoUnit) {
		if(Objects.isNull(date)) {
			throw new IllegalArgumentException("date can not be null");
		}
		LocalDateTime localDateTime = date2LocalDateTime(date);
		LocalDateTime localDateTime2 = localDateTime.minus(time, chronoUnit);
		return localDateTime2Date(localDateTime2);
	}
	
	/**
	 * 格式化日期
	 * @param date
	 * @param pattern
	 * @return
	 * Frankle
	 * 2018年6月26日
	 */
	public static String format(Date date, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return formatter.format(date2LocalDateTime(date));
	}
	
	/**
	 * 获取日期的起始时间
	 * 例如：2018-06-26 00:00:00
	 * @param date
	 * @return
	 * Frankle
	 * 2018年6月26日
	 */
	public static Date firstTimeOfDay(Date date) {
		LocalDateTime localDateTime = date2LocalDateTime(date);
		LocalDateTime firstTime = localDateTime.with(LocalTime.MIN);
		return localDateTime2Date(firstTime);
	}
	
	/**
	 * LocalDateTime转换成Date
	 * @param localDateTime
	 * @return
	 * Frankle
	 * 2018年6月26日
	 */
	public static Date localDateTime2Date(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	/**
	 * Date转换成LocalDateTime
	 * @param date
	 * @return
	 * Frankle
	 * 2018年6月26日
	 */
	public static LocalDateTime date2LocalDateTime(Date date) {
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}
	
	/**
	 * 获取日期的结束时间
	 * 例如：2018-06-26 23:59:59
	 * @param date
	 * @return
	 * Frankle
	 * 2018年6月26日
	 */
	public static Date lastTimeOfDay(Date date) {
		LocalDateTime localDateTime = date2LocalDateTime(date);
		LocalDateTime lastTime = localDateTime.with(LocalTime.MAX);
		return localDateTime2Date(lastTime);
	}
	
	/**
	 * 判断两个时间段是否相交
	 * @param start1
	 * @param end1
	 * @param start2
	 * @param end2
	 * @return
	 * Frankle
	 * 2018年6月26日
	 */
	public static boolean isCross(Date start1, Date end1, Date start2, Date end2) {
		if(start1.getTime() > start2.getTime()) {
			
		}
		return false;
	}
	
	/**
	 * 
	 * @param start1
	 * @param end2
	 * @param start2
	 * @param end2
	 * Frankle
	 * 2018年6月26日
	 */
	public static DateTimeCross getDateTimeCross(Date start1, Date end1, Date start2, Date end2) {
		if(!isCross(start1, end1, start2, end2)) {
			return new DateTimeCross(start1, end2);
		}
		return null;
	}
	
	public static void main(String[] args) {
		long intervalDays = DateTimeUtils.intervalDays(new Date(), new Date());
		System.out.println(intervalDays);
		
		Date add = add(new Date(), 1, ChronoUnit.DAYS);
		System.out.println(format(add, DateTimeFormat.SIMPLE_DATETIME_FORMAT));
		
		Date firstTimeOfDay = firstTimeOfDay(new Date());
		System.out.println("firstTimeOfDay:" + format(firstTimeOfDay, DateTimeFormat.SIMPLE_DATETIME_FORMAT));
		
		Date lastTimeOfDay = lastTimeOfDay(new Date());
		System.out.println("lastTimeOfDay:" + format(lastTimeOfDay, DateTimeFormat.SIMPLE_DATETIME_FORMAT));
	}
}
