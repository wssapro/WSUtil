package cn.ws.tools.sheBao;

public class MortgageCalculator {

    public static void main(String[] args) {
        double principal = 1610000; // 贷款本金
        double annualInterestRate = 0.04; // 年利率（5%）
        int loanTermYears = 30; // 贷款期限（30年）

        calculateAndPrintAmortizationSchedule(principal, annualInterestRate, loanTermYears);
    }

    public static void calculateAndPrintAmortizationSchedule(double principal, double annualInterestRate, int loanTermYears) {
        double monthlyInterestRate = annualInterestRate / 12;
        int numberOfPayments = loanTermYears * 12;

        double monthlyPayment = (principal * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

        System.out.println("贷款本金: " + principal);
        System.out.println("年利率: " + annualInterestRate);
        System.out.println("贷款期限: " + loanTermYears + " 年");
        System.out.println("每月还款额: " + monthlyPayment);
        System.out.println("\n还款计划:");

        for (int month = 1; month <= numberOfPayments; month++) {
            double interestPayment = principal * monthlyInterestRate;
            double principalPayment = monthlyPayment - interestPayment;

            System.out.println("月份 " + month +
                    ": 还款金额 = " + monthlyPayment+
                    ": 还款本金 = " + principalPayment +
                    ", 还款利息 = " + interestPayment +
                    ", 剩余本金 = " + principal);

            principal -= principalPayment;
        }
    }
}
