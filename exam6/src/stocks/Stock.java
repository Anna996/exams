package stocks;

public class Stock {

	private String name;
	private double buyPrice;
	private double sellPrice;

	public Stock(String name, double buyPrice, double sellPrice) {
		setName(name);
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}

	private void setName(String name) {
		if (StockName.valueOf(name.toUpperCase()) != null) { // throws IllegalArgumentException
			this.name = name;
		}
	}

	public synchronized void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public synchronized void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	@Override
	public String toString() {
		return "Stock [name=" + name + ", buyPrice=" + buyPrice + ", sellPrice=" + sellPrice + "]";
	}
}
