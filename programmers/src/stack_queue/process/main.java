package stack_queue.process;

import javax.sound.sampled.Port;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class main {
    public static void main(String[] args) {
        int[] priorities = {5, 1, 4, 3,2,3, 2, 5};
        int rocation =5;
        Queue<Integer> queue = new LinkedList<>();
        System.out.println(solution(priorities, rocation));

    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> priNums = new LinkedList<>();
        Queue<Process> queue = new LinkedList<>();

        for(int i = 0; i<priorities.length; i++) {
            queue.add(new Process(priorities[i],i));
            priNums.add(priorities[i]);
        }
        priNums = priNums.stream().distinct().sorted(Comparator.reverseOrder()).toList();
        for(Integer num : priNums) {
            int tmp = queue.peek().getPriority();
            if(tmp < num){
                //제거한 후, 뒤로 다시 넣음
                Process tmpProcess = queue.poll();
                queue.add(tmpProcess);
            }else if(tmp == num){
                //같으면 추출 대상 추출하는 순번이 우리가 원한 순번이면 종료
                if (queue.poll().getLocation() == location){
                    answer++;
                    break;
                }
                answer++;
            }else{

            }
            for(Process p : queue) {
                System.out.print(p.getPriority()+", ");
            }
            System.out.println();
        }

        return answer;
    }
}
class Process{
    private int priority;
    private int location;
    public Process(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
    public int getPriority() {
        return priority;
    }
    public int getLocation() {
        return location;
    }
}