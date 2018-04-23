package exception;

import java.util.Date;

// object that has the ttributes we want to be send as the exception response
public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String details;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public ExceptionResponse(Date timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

}
