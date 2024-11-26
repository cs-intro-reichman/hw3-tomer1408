// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// System.out.println((double) endBalance(loan, rate, n, 10000));
		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	
	}


	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {
		rate = rate / 100.0 + 1.0;
		double balance = loan;

		for (int i = 0; i < n; i++) {
			balance = (balance - payment) * rate;
		}

		return balance;
	}

	public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		double g = loan / n;  
		double balance;
		iterationCounter = 0;

		while (g <= loan) {
			balance = endBalance(loan, rate, n, g); 
			//System.out.print(balance);
			if (balance <= epsilon) {
				break;
			}
			g += epsilon;
			iterationCounter++;
		}

		return g; 
	}


	public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		double L = loan / n;  
		double H = loan;     
		double g = (L + H) / 2; 
		double balance;
		iterationCounter = 0;

		while (H - L > epsilon) {
			balance = endBalance(loan, rate, n, g); 

			if (Math.abs(balance) <= epsilon) {
				break;
			}

			if (balance > 0) {
				L = g; 
			} else {
				H = g;
			}
			g = (L + H) / 2;
			iterationCounter++;
		}
		return g; 
	}
}