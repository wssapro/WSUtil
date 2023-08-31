package cn.ws.study.IntroductionToAlgorithms.chapter401;

/**
 * 最大子数组问题
 *
 * @author : Host-424
 * @date Date : 2021-10-19 16:01
 */
public class LargestSubArray {

    /**
     * [0,-2,3,5,-1,2]返回2,5,9
     */
    public static void main(String[] args) {
        int[] arr = new int[]{0, -2, 3, 5, -1, 2};
        int low = 0;
        int high = arr.length - 1;

        Position position = subArray(arr, low, high);
        System.out.println(position.toString());
    }


    public static Position subArray(int[] arr, int low, int high) {
        if (low == high) {
            Position position = new Position();
            position.low = low;
            position.high = high;
            position.sum = arr[low];
            return position;
        }
        else {
            int middle = (high + low) / 2;
            Position left = subArray(arr, low, middle);
            Position right = subArray(arr, middle + 1, high);
            Position cross = subCrossArray(arr, low, middle, high);
            if (left.sum >= cross.sum && left.sum >= right.sum) {
                return left;
            }
            else if (right.sum >= left.sum && right.sum >= cross.sum) {
                return right;
            }
            else {
                return cross;
            }
        }
    }

    public static Position subCrossArray(int[] arr, int low, int middle, int high) {
        Position position = new Position();
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = middle; i >= low; i--) {
            sum += arr[i];
            if (sum >= leftSum) {
                leftSum = sum;
                position.low = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int j = middle + 1; j <= high; j++) {
            sum += arr[j];
            if (sum >= rightSum) {
                rightSum = sum;
                position.high = j;
            }
        }
        position.sum = leftSum + rightSum;
        return position;
    }


}

class Position {
    int low;
    int high;
    int sum;

    @Override
    public String toString() {
        return "Position{" +
                "low=" + low +
                ", high=" + high +
                ", sum=" + sum +
                '}';
    }
}
