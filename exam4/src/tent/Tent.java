package tent;

public class Tent {
	protected int numPeople;
	protected int width;
	protected int length;
	protected int height;

	public Tent(int numPeople, int width, int length, int height) {
		this.numPeople = numPeople;
		this.width = width;
		this.length = length;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Tent [numPeople: " + numPeople + ", width: " + width + ", length: " + length + ", height: " + height + "]" + "---> (area: " + width*length+")";
	}
}
