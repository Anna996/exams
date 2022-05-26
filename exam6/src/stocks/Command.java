package stocks;

import java.util.concurrent.Callable;

public class Command implements Callable<Double> {

	String stockName;
	Operation operation;
	private Stock stock;

	private static final double BUY_INTEREST = 0.02;
	private static final double SELL_INTEREST = 0.01;

	public Command(String stockName, Operation operation) {
		this.stockName = stockName;
		this.operation = operation;
	}

	public static enum Operation {
		BUY, SELL;
	}

	@Override
	public Double call() throws Exception {
		try {
			this.stock = StocksDB.getStockByName(stockName);
		} catch (IllegalArgumentException e) {
			System.out.println("The stock " + stockName + " is not in the database");
			return 0.0;
		}

		return operation == Operation.BUY ? handleBuyOperation() : handleSellOperation();
	}

	private double handleBuyOperation() {
		double originalPrice = stock.getBuyPrice();
		
		// This method is synchronized
		stock.setBuyPrice(originalPrice + BUY_INTEREST);
		printInfo(originalPrice, originalPrice + BUY_INTEREST);
		return originalPrice;
	}

	private double handleSellOperation() {
		double originalPrice = stock.getSellPrice();
		
		// This method is synchronized
		stock.setSellPrice(originalPrice - SELL_INTEREST);
		printInfo(originalPrice, originalPrice - SELL_INTEREST);
		return originalPrice;
	}

	private void printInfo(double originalPrice, double currentPrice) {
		System.out.printf("Stock name: %s , operation: %s , original price: %f , current price: %f\n", stockName,
				operation, originalPrice, currentPrice);
	}
}
