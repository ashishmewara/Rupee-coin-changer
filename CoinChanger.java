import java.util.Scanner;

public class CoinChanger {

    
    static int[] coins = {20, 10, 5, 2, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("         🪙 COIN CHANGER         ");
        System.out.println("=================================");

        boolean runAgain = true;

        while (runAgain) {
            System.out.print("\nEnter amount in rupees (positive integer): ");

            if (!scanner.hasNextInt()) {
                System.out.println("❌ Invalid input. Please enter a number.");
                scanner.next(); 
                continue;
            }

            int amount = scanner.nextInt();

            if (amount <= 0) {
                System.out.println("❌ Amount must be greater than 0.");
                continue;
            }

            System.out.println("\nCalculating minimum coins needed for ₹" + amount + "...");
            getMinimumCoins(amount);

            
            System.out.print("\nWould you like to convert another amount? (yes/no): ");
            scanner.nextLine(); 
            String choice = scanner.nextLine().trim().toLowerCase();

            if (!choice.equals("yes") && !choice.equals("y")) {
                runAgain = false;
                System.out.println("\nThank you for using Coin Changer! 😊");
            }
        }

        scanner.close();
    }

    
    public static void getMinimumCoins(int amount) {
        int totalCoins = 0;

        for (int coin : coins) {
            int count = amount / coin;

            if (count > 0) {
                System.out.println("→ " + coin + " rs coin x " + count);
                amount %= coin;
                totalCoins += count;
            }
        }

        System.out.println("✅ Total coins used: " + totalCoins);
    }
}
