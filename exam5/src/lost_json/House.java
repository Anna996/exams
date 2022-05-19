package lost_json;

import java.util.List;

public class House {
	private Address address;
	private List<Room> rooms;
	private boolean hasYard;
	private boolean hasBasement;
	private float area;

	public House() {
		super();
	}

	public House(Address address, List<Room> rooms, boolean hasYard, boolean hasBasement, float area) {
		super();
		this.address = address;
		this.rooms = rooms;
		this.hasYard = hasYard;
		this.hasBasement = hasBasement;
		this.area = area;
	}

	@Override
	public String toString() {
		return "House [address=" + address + ", rooms=" + rooms + ", hasYard=" + hasYard + ", hasBasement="
				+ hasBasement + ", area=" + area + "]";
	}
}
