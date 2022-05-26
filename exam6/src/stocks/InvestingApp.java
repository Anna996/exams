package stocks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import stocks.Command.Operation;

public class InvestingApp {
	private float totalFunds;
	private List<Command> transactions;
	private List<Future<Double>> futureList;

	public InvestingApp() {
		setTotalFunds(0);
		futureList = new LinkedList<>();
	}

	private void setTotalFunds(float totalFunds) {
		this.totalFunds = totalFunds;
	}

	public float getTotalFunds() {
		return totalFunds;
	}

	public void printInfo() {
		System.out.println("stocks information:");
		StocksDB.printInfo();
		System.out.println("\nThe initial total transactions funds: " + totalFunds);
	}

	public void start() {
		initTransactions();

		ExecutorService executorService = Executors.newCachedThreadPool();
		
		transactions.forEach(transaction -> {
			futureList.add(executorService.submit(transaction));
		});

		updateTotalFunds();
		executorService.shutdown();
	}

	private void initTransactions() {
		transactions = Arrays.asList(
				new Command("DOODLE", Operation.BUY), 
				new Command("HEADBOOK", Operation.BUY),
				new Command("HEADBOOK", Operation.SELL), 
				new Command("BARVAZON", Operation.SELL),
				new Command("DOODLE", Operation.SELL), 
				new Command("BARVAZON", Operation.BUY),
				new Command("BARVAZON", Operation.SELL),
				
				// Add a command to buy a stock that is not in the AJBC stock market.
				new Command("JAVA", Operation.BUY)
				);
	}

	private void updateTotalFunds() {
		float sum = 0;

		for (Future<Double> future : futureList) {
			try {
				sum += future.get();
			} catch (InterruptedException | ExecutionException e) {
				System.out.println(e);
			}
		}

		setTotalFunds(totalFunds + sum);
	}
}
