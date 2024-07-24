package cn.ws.blazefire;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2023-03-03 14:06
 */
public class jixiao {

    public static double sum = 250000;

    public static void main(String[] args) {
        System.out.println(cul(75)/100);
    }


    public static double cul(double score) {
        if (score >= 80) {
            return sum - (100-score)*(sum/100);
        }
        else if (score >= 70) {
            return sum- (100-score)*(sum/100) - (80-score)*(sum/100);
        }
        else {
            return sum- (100-score)*(sum/100)- (80-score)*(sum/100) - (70-score)*(sum/50);
        }
    }
}
