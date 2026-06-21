
public class FinancialForecaster {

    // Recursive future value calculation
    // Formula: FV = PV * (1 + rate)^n
    // Recursive: FV(n) = FV(n-1) * (1 + rate)
    
    public static double calculateFutureValue(double presentValue, double rate, int years) {
        // Base case: No years left
        if (years == 0) {
            return presentValue;
        }
        // Recursive case: Apply growth for one year
        return calculateFutureValue(presentValue * (1 + rate), rate, years - 1);
    }

    // Optimized using memoization (to avoid repeated calculations)
    // For more complex recursive problems
    
    // Iterative version for comparison (more efficient)
    public static double calculateFutureValueIterative(double presentValue, double rate, int years) {
        double result = presentValue;
        for (int i = 0; i < years; i++) {
            result *= (1 + rate);
        }
        return result;
    }

    // Recursive with memoization for Fibonacci-like growth patterns
    private static double[] memo;

    public static double calculateCompoundGrowth(double initial, double rate, int years) {
        memo = new double[years + 1];
        return calcHelper(initial, rate, years);
    }

    private static double calcHelper(double initial, double rate, int years) {
        if (years == 0) return initial;
        if (memo[years] != 0) return memo[years];
        
        memo[years] = calcHelper(initial, rate, years - 1) * (1 + rate);
        return memo[years];
    }

    public static void main(String[] args) {
        double initialInvestment = 100000;
        double annualRate = 0.08; // 8%
        int years = 10;

        System.out.println("Initial Investment: ₹" + initialInvestment);
        System.out.println("Annual Rate: " + (annualRate * 100) + "%");
        System.out.println("Years: " + years);

        // Recursive
        long startTime = System.nanoTime();
        double recursiveResult = calculateFutureValue(initialInvestment, annualRate, years);
        long endTime = System.nanoTime();
        System.out.println("\nRecursive Result: ₹" + String.format("%.2f", recursiveResult));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");

        // Iterative
        startTime = System.nanoTime();
        double iterativeResult = calculateFutureValueIterative(initialInvestment, annualRate, years);
        endTime = System.nanoTime();
        System.out.println("\nIterative Result: ₹" + String.format("%.2f", iterativeResult));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");

        // With memoization (for more complex scenarios)
        double memoResult = calculateCompoundGrowth(initialInvestment, annualRate, years);
        System.out.println("\nMemoization Result: ₹" + String.format("%.2f", memoResult));
    }
}