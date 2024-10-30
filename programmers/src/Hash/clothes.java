package Hash;

import java.util.HashMap;

public class clothes {
    public static void main(String[] args) {
        String[][] phone_book = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution(phone_book);
    }
    static int solution(String[][] arrays) {
        HashMap<String, Integer> clothes = new HashMap<>();

        for (String[] array : arrays) {
            clothes.put(array[1], clothes.getOrDefault(array[1], 0) + 1);
        }

        int answer = 1;

        for(Integer cloth : clothes.values()) {
            answer *= (cloth+1);//옷 종류 + 1 (선택 안하기)
        }


        return answer-1;//모두 다 선택 안하는 경우 제외
    }
}
