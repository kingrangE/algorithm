package stack_queue.function_development;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int[] progress = {90, 90};
        int[] speeds = {10,9};
        List<Work> works = new ArrayList<>();
        for(int i = 0; i<progress.length; i++) {
            works.add(new Work(progress[i], speeds[i]));
        }
        int cur = works.getFirst().getDayForComplete();
        int complete = 0;
        boolean check = true;
        List<Integer> result = new ArrayList<>();
        for (Work work : works) {
            if (cur < work.getDayForComplete()) {
                result.add(complete);
                complete = 0;
                cur = work.getDayForComplete();
            }
            complete++;
        }
        result.add(complete);
        int[] answer = result.stream().mapToInt(e->e).toArray();
        System.out.println(result);
    }
}
class Work{
    private int progress;
    private int speed;
    private int dayForComplete;

    public Work(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
        this.dayForComplete = (100-progress)/speed +((100-progress)%speed == 0 ? 0 : 1);
    }

    public int getDayForComplete() {
        return dayForComplete;
    }
}