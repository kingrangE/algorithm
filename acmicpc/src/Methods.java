import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Methods {
    public static void acmic_10807() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N 입력
        sc.nextLine(); // buffer씹기
        String[] nums = sc.nextLine().split(" "); // 숫자 list 입력
        int target = sc.nextInt(); // 타겟 넘버
        int result = 0;
        for(String num : nums) {
            if (Integer.parseInt(num) == target){
                result++;
            }
        }
        System.out.println(result);
    }
    public static void acmic_10810(){
        Scanner sc = new Scanner(System.in);
        // 바구니 수 N, 공을 넣을 횟수 M
        String[] firstInput= sc.nextLine().split(" ");
        int N = Integer.parseInt(firstInput[0]);
        int M = Integer.parseInt(firstInput[1]);
        //바구니에 든 공을 점검하기 위한 배열
        int[] basket = new int[N] ;
        //variable
        int start,end,ball;
        String[] tmp;
        //M 번 반복하며 공을 넣음
        for (int i = 0 ; i<M; i++){
            tmp = sc.nextLine().split(" ");
            start= Integer.parseInt(tmp[0]);
            end= Integer.parseInt(tmp[1]);
            ball = Integer.parseInt(tmp[2]);
            for (int j=start; j<=end; j++){
                basket[j-1] = ball;
            }
        }
        for (int num : basket){
            System.out.print(num + " ");
        }
    }
}
