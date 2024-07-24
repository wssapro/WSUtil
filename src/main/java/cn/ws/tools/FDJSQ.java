package cn.ws.tools;

import java.util.Scanner;

/**
 * @author : 10617-wangshun
 * @description :
 * @date : 2024-02-02 18:01
 */
public class FDJSQ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入贷款本金（Loan Amount）：");
        double loanAmount = scanner.nextDouble();

        System.out.print("请输入年利率（Annual Interest Rate）：");
        double annualInterestRate = scanner.nextDouble();

        System.out.print("请输入贷款期限（Loan Term in Years）：");
        int loanTermInYears = scanner.nextInt();

        System.out.print("请输入提前还款的年数：");
        int yearsAhead = scanner.nextInt();

        // 计算每月还款额
        double monthlyInterestRate = annualInterestRate / 12 / 100;
        int numberOfPayments = loanTermInYears * 12;
        double monthlyPayment = (loanAmount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

        // 计算提前还款后剩余贷款
        int remainingPayments = (loanTermInYears - yearsAhead) * 12;
        double remainingLoanAmount = calculateRemainingLoanAmount(loanAmount, monthlyInterestRate, monthlyPayment, remainingPayments);

        // 输出结果
        System.out.println("每月还款额：" + monthlyPayment);
        System.out.println("提前还款后剩余贷款：" + remainingLoanAmount);
    }

    private static double calculateRemainingLoanAmount(double loanAmount, double monthlyInterestRate, double monthlyPayment, int remainingPayments) {
        double remainingLoanAmount = 0;
        for (int i = 0; i < remainingPayments; i++) {
            double interestPayment = remainingLoanAmount * monthlyInterestRate;
            double principalPayment = monthlyPayment - interestPayment;
            remainingLoanAmount = remainingLoanAmount - principalPayment;
        }
        return remainingLoanAmount;
    }
}
