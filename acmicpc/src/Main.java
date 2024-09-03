import java.io.IOException;
import java.util.*;

public class Main {
    /*
    문제 풀이 관련 소스코드는 Methods에 있습니다.
    method명은 acmic_(문제 번호) 입니다.
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] alpha = new String[26];
        int word = 0;
        scanner.nextLine();
        for(int i = 0; i<N; i++){
            String[] tmp = scanner.nextLine().split("");
            alpha[0] = tmp[0];
            word++;
            for(int j=1; j<tmp.length;j++){
//                System.out.println( "Array Contain tmp? :"+ Arrays.toString(alpha).contains(tmp[j])+ "\ntmp[j] =" + tmp[j] + "\ntmp[j-1] ="+tmp[j-1]);
                if (!(Arrays.toString(alpha).contains(tmp[j])) || Objects.equals(tmp[j], tmp[j - 1])){
                    alpha[j] = tmp[j];
                }
                else{
//                    System.out.println("i =" +i);
//                    System.out.println("j =" + j);
                    word--;
                    break;
                }
            }
//            System.out.println(Arrays.toString(tmp)+" "+word);
            alpha = new String[26];
        }
        System.out.println(word);
    }
}
