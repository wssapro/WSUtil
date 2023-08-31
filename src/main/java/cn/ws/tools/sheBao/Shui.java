package cn.ws.tools.sheBao;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-02-28 17:43
 */
public class Shui {


    /**
     *
     */
    public static double ALL_PAY_PERCENTAGE = 0.175;
    /**
     *
     */
    public static double PROVIDENT_FUND_PERCENTAGE = 0.07;
    /**
     *
     */
    public static double THRESHOLD_POINT = 5000;
    /**
     *
     */
    public static double RENTAL_DEDUCTION = 1500;


    public static void main(String[] args) {

        /*for (int i = 12000; i <= 25000; i += 1000) {
            getOne(i, i * 2);
        }*/
        getOne(7500, 12000);
    }

    public static void getOne(double monthlySalary, double yearEndAwards) {

        // 公积金
        double monthlyGJJ = monthlySalary * PROVIDENT_FUND_PERCENTAGE * 2;

        // 总收入
        double totalIncome = yearEndAwards + monthlySalary * 12;

        // 实际收入
        double actualIncome = yearEndAwards + 12 * (monthlyGJJ + monthlySalary - monthlySalary * ALL_PAY_PERCENTAGE);

        // 应纳税所得额
        double taxableIncome = getTaxableIncome(totalIncome,monthlySalary);

        // 应缴税
        double tax = getTax(taxableIncome);

        // 税后收入
        double afterTaxIncome = actualIncome - tax;

        System.out.println(
                "月薪：" + monthlySalary
                + "年终奖：" + yearEndAwards
                + "总收入：" + totalIncome
                        + ",实际收入：" + actualIncome
                        + ",应纳税所得额：" + taxableIncome
                        + ",应缴税：" + tax
                        + ",税后收入：" + afterTaxIncome
        );
    }

    public static double getTaxableIncome(double totalIncome,double monthlySalary) {
        double monthlyDeduct = monthlySalary * ALL_PAY_PERCENTAGE + THRESHOLD_POINT + RENTAL_DEDUCTION;
        return totalIncome - monthlyDeduct * 12;
    }

    public static double getTax(double taxableIncome) {
        double tax;
        if (taxableIncome <= 36000) {
            tax = taxableIncome * 0.03 - 0;
        }
        else if (taxableIncome <= 144000) {
            tax = taxableIncome * 0.1 - 2520;
        }
        else if (taxableIncome <= 300000) {
            tax = taxableIncome * 0.2 - 16920;
        }
        else if (taxableIncome <= 420000) {
            tax = taxableIncome * 0.25 - 31920;
        }
        else if (taxableIncome <= 660000) {
            tax = taxableIncome * 0.3 - 52920;
        }
        else if (taxableIncome <= 960000) {
            tax = taxableIncome * 0.35 - 85920;
        }
        else {
            tax = taxableIncome * 0.45 - 181920;
        }
        return tax;
    }


}
