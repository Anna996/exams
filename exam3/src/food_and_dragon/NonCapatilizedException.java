package food_and_dragon;

public class NonCapatilizedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4970000456198154439L;
	private String name;

	public NonCapatilizedException() {
		super();
		this.name = "Do not have a name";
	}

	public NonCapatilizedException(String name) {
		super();
		this.name = name;
	}

	public NonCapatilizedException(String message, String name) {
		super(message+" the name is: "+name);
		this.name = name;
		}

	public NonCapatilizedException(String message,Throwable cause, String name) {
		super(message+" the name is: "+name, cause);
		this.name = name;
		}

	public NonCapatilizedException(Throwable cause, String name) {
		super(cause);
		this.name = name;
		}

	public String getName() {
		return name;
	}
}
