package Hash;

import java.util.HashMap;
import java.util.Map;

public class marathon42576 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        solution(participant,completion);
    }
    static String solution(String[] participant, String[] completion) {
        /*
        * map -> 이름 , 출전 수 저장 => completion에서 String을 통해 값을 하나씩 빼면서
        * 출전수가 2 이상이면 숫자를 1 감소, 출전수가 1이면, 삭제 한다.
        * */
        String answer = "";
        Map<String,Integer> partMap = new HashMap<>();
        for(String name:participant){
            try {
                partMap.compute(name, (k, num) -> num + 1);
            }catch (Exception e){
                partMap.put(name,1);
            }
        }
        for(String name: completion){
            int count = partMap.get(name);
            if(count == 1){
                partMap.remove(name);
            }else{
                partMap.put(name,count-1);
            }
        }
        for(String name : partMap.keySet()){
            System.out.println(name);
        }
        return answer;
    }
}
