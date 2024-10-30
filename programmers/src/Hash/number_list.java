package Hash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class number_list {
    public static void main(String[] args) {
        String [] phone_book = {"12", "13", "15", "567", "88"};
        System.out.println(solution(phone_book));
    }
    static boolean solution(String[] phone_book) {
        boolean answer = true;
        String[] result = Arrays.stream(phone_book).sorted(Comparator.naturalOrder()).toArray(String[]::new);

        for(int i = 0 ; i < result.length-1 ; i++) {
            if(result[i+1].startsWith(result[i])){
                answer = false;
                break;
            }
        }



        return answer;
    }
}

