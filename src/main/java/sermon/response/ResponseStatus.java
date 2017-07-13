package sermon.response;
/**
 *
 *  @autor mserrano
 *  @since Jul 19, 2015 11:34:41 PM
 */
public class ResponseStatus {
	private int code;
	private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
