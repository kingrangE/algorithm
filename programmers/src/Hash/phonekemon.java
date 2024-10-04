package Hash;

import java.util.Arrays;

public class phonekemon {
    /*
     * N/2개를 선택할 수 있음. 가장 다양하게 고를 경우를 출력 따라서 다른 종류가 N/2 이상 있으면 N/2가 최대. 그게 아니면 종류의 수가 최대값
     */
    public static void main(String[] args) {
        int[] nums = {3, 1, 2,2,4, 3};
        solution(nums);
    }
    static int solution(int[] nums) {
        int distinct_len = (int) Arrays.stream(nums).distinct().count();

        return Math.min(nums.length / 2, distinct_len);
    }
}
