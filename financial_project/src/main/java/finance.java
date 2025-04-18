import java.util.Scanner;

public class finance {
    static Scanner value = new Scanner(System.in);
    public static void main(String[] args) {
          // first method of doing it
          //  futureValue();
          //  System.out.println();
          //  mortgageCalculator();
          //  System.out.println();
          //  presentValue();

          // better way of doing it
            System.out.println("What calculator do you want use");
            System.out.println("Enter 1 for mortgage calculator");
            System.out.println("Enter 2 for future value");
            System.out.println("Enter 3 for present value");
            int want = value.nextInt();

            switch (want) {
                case 1:
                    mortgageCalculator();
                    break;
                case 2:
                    futureValue();
                    break;
                case 3:
                    presentValue();
                    break;
                default:
                    System.out.println("please choice the right option");
            }

    }


    public static void futureValue(){
        System.out.printf("here is your future value: %.2f", futureValues(deposit(), interestRate(), years()));
    }
    public static void mortgageCalculator(){
        double loanAmount = loan();
        double interestRate = rate();
        int Years = length();

        double monthlyPayment = calculation(loanAmount, interestRate, Years);
        double totalInterest = calculateTotalInterestPaid(monthlyPayment, Years, loanAmount);

        System.out.printf("here is your mortgage value: %.2f\n", monthlyPayment);
        System.out.printf("here is your total interest paid: %.2f\n", totalInterest);
    }
    public static void presentValue(){
        System.out.printf("here is your present value: %.2f",annuity(monthly(),interest(),numYears()));
    }



    // future value
    public static double deposit(){
        System.out.println("how much do you want to deposit?");
        return value.nextDouble();
    }
    public static double interestRate(){
        System.out.println("interest rate in %?");
        return value.nextDouble();
    }
    public static double years(){
        System.out.println("how many years?");
        return value.nextDouble();
    }
    public static double futureValues(double principal, double rate, double years) {
        double dailyRate = (rate/100) / 365;
        double exponent = 365 * years;
        return principal * Math.pow(1 + dailyRate, exponent);
    }



    // mortgage
    public static double loan( ){
        System.out.println("How much do u want to borrow?");
        return value.nextDouble();
    }
    public static double rate( ){
        System.out.println("What is the interest rate in %? ");
        return value.nextDouble();
    }
    public static int length ( ){
        System.out.println("loan length in years? ");
        return value.nextInt();
    }
    public static double calculation(double amount, double rate, int years ){

        double i = (rate/100) / 12;
        double y = years * 12;
        double power = Math.pow(1 + i, y);
        double payment = amount * (i * power)/(power - 1);
        return payment;
    }
    public static double calculateTotalInterestPaid(double calculation, int length, double amount) {
        double totalInterstRate = 0;
        totalInterstRate = calculation * length * 12 - amount;
        return totalInterstRate;
    }


    // present
    public static double monthly(){
        System.out.println("Enter your monthly payment:");
        return value.nextDouble();
    }
    public static double interest(){
        System.out.println("Enter interest rate in %:");
        return value.nextDouble();
    }
    public static double numYears(){
        System.out.println("Enter the number of years:");
        return value.nextDouble();
    }
    public static double annuity(double amount, double rate, double years){
        //  payment * 1 + r square - 1/r
        double r = (rate/100) /12 ;
        double y = years * 12;
        return amount * ((Math.pow(1 + r,y)-1)/r);
    }
}




