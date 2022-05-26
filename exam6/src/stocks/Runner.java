package stocks;

public class Runner {
	private static InvestingApp investingApp;
	
	public static void main(String[] args) {
		investingApp = new InvestingApp();
		printInfo("Start of the day");
		investingApp.start();
		printInfo("\nEnd of the day");
	}
	
	public static void printInfo(String title) {
		System.out.println(title);
		System.out.println("================");
		investingApp.printInfo();
		System.out.println("\n");
	}
}
