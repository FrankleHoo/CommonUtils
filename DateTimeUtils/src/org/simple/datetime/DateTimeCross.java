package org.simple.datetime;

import java.util.Date;
import java.util.Objects;

import org.simple.datetime.format.DateTimeFormat;
import org.simple.datetime.util.DateTimeUtils;

public class DateTimeCross {

	private Date startTime;
	private Date endTime;
	
	public DateTimeCross(Date startTime, Date endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getTimeRange() {
		return DateTimeUtils.format(startTime, DateTimeFormat.SIMPLE_DATETIME_FORMAT) + " - " + DateTimeUtils.format(endTime, DateTimeFormat.SIMPLE_DATETIME_FORMAT);
	}
	
	public boolean isCross() {
		return Objects.isNull(startTime) || Objects.isNull(endTime);
	}
}
