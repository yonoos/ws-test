package yc.jee.test.ws.rest.endpoint;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import javax.json.bind.annotation.JsonbDateFormat;

public class DatesObject {
	
	public final static String FORMAT = "yyyy-MM-ddThh:mm:ss"; 
	
	@JsonbDateFormat(FORMAT)
	private java.util.Date utilDate;
	
	@JsonbDateFormat(FORMAT)
	private Date sqlDate;
	
	@JsonbDateFormat(FORMAT)
	private Timestamp sqlTimeStamp;
	
	@JsonbDateFormat(FORMAT)
	private LocalDateTime localDateTime;
	
	@JsonbDateFormat(FORMAT)
	private ZonedDateTime zonedDateTime;
	
	
	public java.util.Date getUtilDate() {
		return utilDate;
	}
	public void setUtilDate(java.util.Date utilDate) {
		this.utilDate = utilDate;
	}
	public Date getSqlDate() {
		return sqlDate;
	}
	public void setSqlDate(Date sqlDate) {
		this.sqlDate = sqlDate;
	}
	public Timestamp getSqlTimeStamp() {
		return sqlTimeStamp;
	}
	public void setSqlTimeStamp(Timestamp sqlTimeStamp) {
		this.sqlTimeStamp = sqlTimeStamp;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public ZonedDateTime getZonedDateTime() {
		return zonedDateTime;
	}
	public void setZonedDateTime(ZonedDateTime zonedDateTime) {
		this.zonedDateTime = zonedDateTime;
	}
	
	
	@Override
	public String toString() {
		return "DatesObject [utilDate=" + utilDate + ", sqlDate=" + sqlDate + ", sqlTimeStamp=" + sqlTimeStamp
				+ ", localDateTime=" + localDateTime + ", zonedDateTime=" + zonedDateTime + "]";
	}
	

}
