import java.lang.Iterable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Methods {
    public String solution(String myString) {
        String[] strs = myString.split("");
        String answer = "";
        for(String str : strs){
            if(str.equals("A")){
                //String은 객체이므로, == 를 사용하게 되면 참조값을 비교하게 됩니다.
                // 따라서 equals를 이용하여 주소 내부의 값을 비교하도록 해야 합니다.
                answer += str;
                continue;
            }
            if (str.equals("a")){
                str = str.toUpperCase();
            }else{
                str = str.toLowerCase();
            }
            answer+=str;
        }
        return answer;
        /* 모범답안
        myString.toLowerCase();
        myString.replace("a","A");
        return myString
        라이브러리를 잘 쓰면 아주 쉽게 해결 가능합니다.
        */
    }
    public int solution_181851(int[] rank, boolean[] attendance) {
        int answer = 0;

        Map<Integer,Integer> studentNumber = new HashMap<>();
        for(int i = 0; i<rank.length; i++){
            studentNumber.put(rank[i], i);
        }
        for(int i = 0 ; i < rank.length; i++){
            for(int j = i+1 ; j< rank.length; j++){
                if (rank[i] > rank[j]){
                    int tmp = rank[i];
                    boolean sub_tmp = attendance[i];
                    rank[i] = rank[j];
                    attendance[i] = attendance[j];
                    rank[j] = tmp;
                    attendance[j]= sub_tmp;
                }
            }
        }

        int[] result= new int[3];
        int check = 0;
        for( int i = 0 ; i<rank.length; i++){
            if (attendance[i] == true){
                result[check++] = studentNumber.get(rank[i]);
            }
            if (check == 3){
                break;
            }
        }

        answer = result[0]*10000+result[1]*100+result[2];

        return answer;
        /*모범답안 (with stream)
        *return IntStream.range(0, rank.length)
            .filter(i -> attendance[i])
            .boxed()
            .sorted(Comparator.comparing(i -> rank[i]))
            .limit(3L)
            .reduce((current, next) -> current * 100 + next)
            .get();
        2번쨰 모범답인 ( with 우선순위큐 )
       PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> rank[a] - rank[b]);
        for (int i = 0; i < attendance.length; i++) {
            if (attendance[i])
                que.add(i);
        }

        return que.poll() * 10000 + que.poll() * 100 + que.poll();
    *
        * */
    }
    public int solution_120921(String A, String B) {
        char[] A_chs = A.toCharArray();
        char[] B_chs = B.toCharArray();

        for(int i = 0; i<A_chs.length;i++){
            if(sameChs(A_chs,B_chs))
                return i;
            A_chs = pushStr(A_chs);
            System.out.println(A_chs);
        }

        return -1;
    }
    char[] pushStr(char[] A){
        char tmp = A[A.length-1];
        char tmp_next = A[0];
        char tmp_pre = ' ';
        for(int i = 0; i<A.length-1;i++){
            tmp_pre = tmp_next;
            tmp_next = A[i+1];
            A[i+1]=tmp_pre;
        }
        A[0]=tmp;
        return A;
    }

    boolean sameChs(char[] A, char[] B){
        for(int i = 0; i<A.length;i++){
            if( A[i] != B[i])
                return false;
        }
        return true;
    }
    /*
    * 모범답안
    * B.repeat(2); // 반복
    * return B.indexOf(A);//반복하면 순서를 미는 것도 모두 검출 가능 검출 되면 해당 인덱스를 반환 아니면 -1 반환
    * */
}