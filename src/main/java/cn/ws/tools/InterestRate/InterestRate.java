package cn.ws.tools.InterestRate;

public class InterestRate {  //根基公式计算月供，总供
    public static void main(String[] args) {


        dayin(2000000,600000, 4.1, 30);



        dayin(600000, 3.1,600000,4.1, 30);





    }


    public static void dayin(double aggregateAmount,
                             double annualInterestRate,
                             double aggregateAmount2,
                             double annualInterestRate2,
                             int year){
        InterestNode interestNode = interestRate(aggregateAmount, annualInterestRate, aggregateAmount2, annualInterestRate2, year);
        System.out.println(
                "月支付：" + Math.round(interestNode.getMonthlyPaymen())
                + "，总利息：" + Math.round(interestNode.getTotalPaymen() - interestNode.getTotal())
                + "，总还款：" + Math.round(interestNode.getTotalPaymen())
        );
    }


    public static void dayin(double aggregateAmount,
                             double pay,
                             double annualInterestRate,
                             int year){
        InterestNode interestNode = interestRate(aggregateAmount-pay, annualInterestRate, year);

        System.out.println(
                "价格：" + aggregateAmount
                        + "，首付：" + Math.round(pay)
                        + "，贷款金额：" + Math.round(aggregateAmount-pay)
                        + "，月支付：" + Math.round(interestNode.getMonthlyPaymen())
                        + "，总利息：" + Math.round(interestNode.getTotalPaymen() - interestNode.getTotal())
                        + "，总还款：" + Math.round(interestNode.getTotalPaymen())
                        + "，总支付：" + Math.round(interestNode.getTotalPaymen()+aggregateAmount*0.3)
        );
    }



    public static InterestNode interestRate(double aggregateAmount,
                                                       double annualInterestRate,
                                                       double aggregateAmount2,
                                                       double annualInterestRate2,
                                                       int year){
        InterestNode interestNode = interestRate(aggregateAmount, annualInterestRate, year);
        InterestNode interestNode2 = interestRate(aggregateAmount2, annualInterestRate2, year);
        interestNode.setTotal(interestNode.getTotal() + interestNode2.getTotal());
        interestNode.setTotalInterest(interestNode.getTotalInterest() + interestNode2.getTotalInterest());
        interestNode.setTotalPaymen(interestNode.getTotalPaymen() + interestNode2.getTotalPaymen());
        interestNode.setMonthlyPaymen(interestNode.getMonthlyPaymen() + interestNode2.getMonthlyPaymen());
        return interestNode;
    }

    public static InterestNode interestRate(double aggregateAmount, double annualInterestRate, int year) {

        InterestNode interestNode = new InterestNode();
        interestNode.setTotal(aggregateAmount);
        double monelyrate = annualInterestRate / 1200;//月利率
        double monthlyPaymen = (aggregateAmount * monelyrate) / (1 - 1 / Math.pow((1 + monelyrate), year * 12));//
        interestNode.setMonthlyPaymen(monthlyPaymen);
        double totalPaymen = monthlyPaymen * year * 12;
        interestNode.setTotalPaymen(totalPaymen);
        interestNode.setTotalInterest(totalPaymen - aggregateAmount);


        return interestNode;
    }








}
