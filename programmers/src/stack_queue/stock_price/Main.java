package stack_queue.stock_price;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] prices = {2,3,5,6,1};
        System.out.println(Arrays.toString(solution(prices)));
    }
    public static int[] solution(int[] prices) {
        List<Integer> result = new LinkedList<>();
        loop_i:
        for(int i = 0; i<prices.length; i++){
            int time = -1;
            loop_j:
            for(int j = i; j<prices.length; j++){
                time++;
                if(prices[i] > prices[j]){
                    result.add(time);
                    continue loop_i;
                }
            }
            result.add(time);
        }
        return result.stream().mapToInt(e->e).toArray();
    }
}
