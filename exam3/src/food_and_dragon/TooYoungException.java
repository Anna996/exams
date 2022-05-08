package food_and_dragon;

import java.time.LocalDate;

public class TooYoungException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8990960594153092379L;
	private LocalDate birthDate;

	public TooYoungException(LocalDate birthDate) {
		super();
		this.birthDate = birthDate;
	}

	public TooYoungException(String message, Throwable cause, LocalDate birthDate) {
		super(message + " ,the birthDate is: " + birthDate, cause);
		this.birthDate = birthDate;
	}

	public TooYoungException(String message, LocalDate birthDate) {
		super(message + " ,the birthDate is: " + birthDate);
		this.birthDate = birthDate;
	}

	public TooYoungException(Throwable cause, LocalDate birthDate) {
		super(cause);
		this.birthDate = birthDate;
	}

	public LocalDate getBirthDate() {
		return this.birthDate;
	}

}
