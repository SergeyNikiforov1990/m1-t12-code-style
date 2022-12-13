import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercentFunction(double amount, double yearRate, int depositPeriod) { // метод подсчета вклада с капитализацией
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return getResult(pay, 2);
    }

    double calculateSimplePercentFunction(double amount, double yearRate, int depositPeriod) { // метод подсчета вклад с обычным процентом
        return getResult(amount + amount * yearRate * depositPeriod, 2);
    }

    double getResult(double value, int degree) {
        double scale = Math.pow(10, degree);

        return Math.round(value * scale) / scale;
    }

    void doMenu() {
        int amount;
        int depositPeriod;
        int depositType;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        double outDoubleVar = 0;
        if (depositType == 1) {
            outDoubleVar = calculateSimplePercentFunction(amount, 0.06, depositPeriod);
        } else if (depositType == 2) {
            outDoubleVar = calculateComplexPercentFunction(amount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + outDoubleVar);
    }

    public static void main(String[] args) {
        new DepositCalculator().doMenu();
    }
}