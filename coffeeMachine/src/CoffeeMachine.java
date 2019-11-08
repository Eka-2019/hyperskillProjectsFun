import java.util.Scanner;

public class CoffeeMachine {
    private Scanner scan = new Scanner(System.in);
    private int waterAmount;
    private int milkAmount;
    private int coffeeAmount;
    private int disposableCups;
    private int money;

    private int waterAmountResult = 0;
    private int milkAmountResult = 0;
    private int coffeeAmountResult = 0;
    private int disposableCupsResult = 0;
    private int moneyResult = 0;


    private CoffeeMachine() {
        this.scan = new Scanner(System.in);
        this.waterAmount = 400;
        this.milkAmount = 540;
        this.coffeeAmount = 120;
        this.disposableCups = 9;
        this.money = 550;
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        boolean status;
        do {
            status = machine.processActions();
        }
        while (status);

    }

    public void printAmountTest() {
        System.out.println("The coffe machine has:\n" +
                String.format("%d of water\n", this.waterAmount) +
                String.format("%d of milk\n", this.milkAmount) +
                String.format("%d of coffee\n", this.coffeeAmount) +
                String.format("%d of disposable cups\n", this.disposableCups) +
                String.format("%d of money\n", this.money));
    }

    public static void printAmount(int water, int milk, int coffee, int cups, int money) {
        System.out.println("");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println("");
    }




    public void processBuy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeType = scan.next();
        switch (coffeeType) {
            case "1":
                if (waterAmount < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (coffeeAmount < 16) {
                    System.out.println("Sorry, not enough coffee!");
                } else if (disposableCups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterAmountResult = waterAmount - 250;
                    coffeeAmountResult = coffeeAmount - 16;
                    disposableCupsResult = disposableCups - 1;
                    moneyResult = money + 4;
                }

                waterAmount = waterAmountResult;
                milkAmount = milkAmount;
                coffeeAmount = coffeeAmountResult;
                disposableCups = disposableCupsResult;
                money = moneyResult;
                break;

            case "2":
                if (waterAmount < 350) {
                    System.out.println("Sorry, not enough water!");
                } else if (milkAmount < 75) {
                    System.out.println("Sorry, not enough cups!");
                } else if (coffeeAmount < 20) {
                    System.out.println("Sorry, not enough coffee!");
                } else if (disposableCups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterAmountResult = waterAmount - 350;
                    milkAmountResult = milkAmount - 75;
                    coffeeAmountResult = coffeeAmount - 20;
                    disposableCupsResult = disposableCups - 1;
                    moneyResult = money + 7;
                }

                waterAmount = waterAmountResult;
                milkAmount = milkAmountResult;
                coffeeAmount = coffeeAmountResult;
                disposableCups = disposableCupsResult;
                money = moneyResult;
                break;
            case "3":

                if (waterAmount < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (milkAmount < 100) {
                    System.out.println("Sorry, not enough cups!");
                } else if (coffeeAmount < 12) {
                    System.out.println("Sorry, not enough coffee!");
                } else if (disposableCups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterAmountResult = waterAmount - 200;
                    milkAmountResult = milkAmount - 100;
                    coffeeAmountResult = coffeeAmount - 12;
                    disposableCupsResult = disposableCups - 1;
                    moneyResult = money + 6;
                }

                waterAmount = waterAmountResult;
                milkAmount = milkAmountResult;
                coffeeAmount = coffeeAmountResult;
                disposableCups = disposableCupsResult;
                money = moneyResult;
                break;
            default:
                System.out.println("Unsuitable action, please, try again");
                break;
        }
    }


    public void processFill() {
        System.out.println("Write how many ml of water do you want to add:");
        int addWater = scan.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int addMilk = scan.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int addCoffee = scan.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int addCups = scan.nextInt();

        waterAmountResult = waterAmount + addWater;
        milkAmountResult = milkAmount + addMilk;
        coffeeAmountResult = coffeeAmount + addCoffee;
        disposableCupsResult = disposableCups + addCups;

        System.out.println("");
        // printAmount(waterAmountResult, milkAmountResult, coffeeAmountResult, disposableCupsResult, money);

        waterAmount = waterAmountResult;
        milkAmount = milkAmountResult;
        coffeeAmount = coffeeAmountResult;
        disposableCups = disposableCupsResult;
    }

    public void processRemaining() {
        printAmountTest();
    }

    public void processTake() {
        System.out.println("I gave you $" + money);
        System.out.println("");
        //printAmount(waterAmount, milkAmount, coffeeAmount, disposableCups, money - money);
        money = 0;
    }


    public boolean processActions() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = this.scan.next();
        switch (action) {
            case "buy":
                this.processBuy();
                break;
            case "fill":
                this.processFill();
                break;
            case "take":
                this.processTake();
                break;
            case "remaining":
                this.processRemaining();
                break;
            case "exit":
                return false;
            default:
                System.out.println("Unsuitable action, please, try again");
                break;
        }
        return true;
    }

}
