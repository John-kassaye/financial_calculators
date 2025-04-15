import java.util.Scanner;

public class finance {
    static Scanner value = new Scanner(System.in);
    public static void main(String[] args) {
        futureValue();
        System.out.println();
        mortgageCalculator();
        System.out.println();
        presentValue();

    }


    public static void futureValue(){
        System.out.printf("here is your future value: %.2f", futureValues(deposit(), interestRate(), years()));
    }
    public static void mortgageCalculator(){
        System.out.printf("here is your mortgage value: %.2f", calculation(loan(),rate(),length()));
    }
    public static void presentValue(){
        System.out.printf("here is your present value: %.2f",annuity(monthly(),interest(),years()));
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
        return amount * (i * power)/(power - 1);
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
    public static double yearss(){
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




