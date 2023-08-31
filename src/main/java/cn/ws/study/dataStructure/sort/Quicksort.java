package cn.ws.study.dataStructure.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 *
 * @author wangshun
 * @date 2019/3/23 23:35
 */
public class Quicksort {
    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int flat = arr[start];
            int low = start;
            int high = end;
            while (low < high) {
                while (low < high && arr[high] >= flat) {
                    high--;
                }
                arr[low] = arr[high];

                while (low < high && arr[low] <= flat) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = flat;
            if (start < low - 1) {
                sort(arr, start, low - 1);
            }
            if (low + 1 < end) {
                sort(arr, low + 1, end);
            }
        }
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private final Random random = new Random();
    private final int[] quickSort3Arr = new int[2];

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 普通快排，时间复杂度O(nlogn)，在数组有序或者重复元素较多时会退化到O(n2)
     * 当数组重复元素较多时，partition过程会将数组分成两个不平衡的部分（重复元素都在一边）
     * @param arr
     * @param start
     * @param end
     */
    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = partition(arr, start, end);
        quickSort(arr, start, mid - 1);
        quickSort(arr, mid + 1 , end);
    }

    private int partition(int[] arr, int start, int end) {
        int r = start + random.nextInt(end - start + 1);
        swap(arr, r, start);
        int j = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < arr[start]) {
                swap(arr, i, ++j);
            }
        }
        swap(arr, j, start);
        print(arr);
        return j;
    }

    /**
     * 双路快排，优化重复元素多的情况，指针i和j从两端向中间逼近，
     * 将小于arr[mid]的值，放在左边；大于arr[mid]的值，放在右边，不会将重复元素放在一边，左右两变都可能包含相等的元素
     * @param arr
     * @param start
     * @param end
     */
    public void quickSort2(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = partition2(arr, start, end);
        quickSort(arr, start, mid - 1);
        quickSort(arr, mid + 1 , end);
    }

    private int partition2(int[] arr, int start, int end) {
        int r = start + random.nextInt(end - start + 1);
        swap(arr, r, start);
        int i = start + 1;
        int j = end;

        while (true) {
            // 这里不能arr[i] <= arr[start] 否则如果连续出现多个==的情况，则会把这些值归到一边
            while (i <= end && arr[i] < arr[start]) {
                i++;
            }
            // 这里不能arr[j] >= arr[start] 否则如果连续出现多个==的情况，则会把这些值归到一边
            while (j >= start + 1 && arr[j] > arr[start]) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, j, start);
        return j;
    }

    /**
     * 三路快排，将数据按arr[mid]分为，小于、等于、大于三个区域，
     * 递归时，只需处理小于和大于的区域，减少了一次处理的元素
     * @param arr
     * @param start
     * @param end
     */
    public void quickSort3(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int[] mid = partition3(arr, start, end);
        quickSort3(arr, start, mid[0]);
        quickSort3(arr, mid[1], end);
    }

    private int[] partition3(int[] arr, int start, int end) {
        int r = start + random.nextInt(end - start + 1);
        swap(arr, r, start);

        int lt = start; //arr[start+1, lt] < arr[start]
        int i = start + 1; //arr[lt+1, i] < arr[start]
        int gt = end + 1; //arr[gt, end] > arr[start]

        while (i < gt) {
            if (arr[i] < arr[start]) {
                swap(arr, i, lt + 1);
                i++;
                lt++;
            }else if (arr[i] > arr[start]) {
                swap(arr, i, gt - 1);
                gt--;
            }else {
                i++;
            }
        }
        swap(arr, lt, start);

        quickSort3Arr[0] = lt - 1;
        quickSort3Arr[1] = gt;

        return quickSort3Arr;
    }

    public static void main(String[] args) {
        //长度为N的数组
        int[] arr = new int[]{2, 4, 5, 7, 1, 2, 3, 6};

        new Quicksort().quickSort(arr, 0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
