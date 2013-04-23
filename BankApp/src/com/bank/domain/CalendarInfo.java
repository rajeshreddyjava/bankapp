package com.bank.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name= "CALENDAR_INFO")
public class CalendarInfo {
	@Column(name="DATE_ID")
	@Id
	@GeneratedValue
	private int date_id;
	@Column(name="date")
	private Date date;
	@Column(name="DAY")
	private String day;
	@Column(name="DAY_OF_WEEK")
	private int dayOfWeek;
	@Column(name="DAY_OF_MONTH")
	private int dayOfMonth;
	@Column(name="DAY_OF_YEAR")
	private int dayOfYear;
	@Column(name="PREVIOUS_DAY")
	private Date previousDay;
	@Column(name="NEXT_DAY")
	private Date nextDay;
	@Column(name="WEEKEND")
	private String weekend;
	@Column(name="WEEK_OF_YEAR")
	private String weekOfYear;
	@Column(name="MONTH")
	private String month;
	@Column(name="MONTH_OF_YEAR")
	private String monthOfYear;
	@Column(name="QUARTER_OF_YEAR")
	private int quarterOfYear;
	@Column(name="YEAR")
	private int year;
	public int getDate_id() {
		return date_id;
	}
	public void setDate_id(int date_id) {
		this.date_id = date_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public int getDayOfMonth() {
		return dayOfMonth;
	}
	public void setDayOfMonth(int dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}
	public int getDayOfYear() {
		return dayOfYear;
	}
	public void setDayOfYear(int dayOfYear) {
		this.dayOfYear = dayOfYear;
	}
	public Date getPreviousDay() {
		return previousDay;
	}
	public void setPreviousDay(Date previousDay) {
		this.previousDay = previousDay;
	}
	public Date getNextDay() {
		return nextDay;
	}
	public void setNextDay(Date nextDay) {
		this.nextDay = nextDay;
	}
	public String getWeekend() {
		return weekend;
	}
	public void setWeekend(String weekend) {
		this.weekend = weekend;
	}
	public String getWeekOfYear() {
		return weekOfYear;
	}
	public void setWeekOfYear(String weekOfYear) {
		this.weekOfYear = weekOfYear;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getMonthOfYear() {
		return monthOfYear;
	}
	public void setMonthOfYear(String monthOfYear) {
		this.monthOfYear = monthOfYear;
	}
	public int getQuarterOfYear() {
		return quarterOfYear;
	}
	public void setQuarterOfYear(int quarterOfYear) {
		this.quarterOfYear = quarterOfYear;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	

}
