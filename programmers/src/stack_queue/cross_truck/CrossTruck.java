package stack_queue.cross_truck;
import java.util.*;

public class CrossTruck {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> trucks = new LinkedList<>();
        Bridge bridge = new Bridge(bridge_length,weight);
        for(int truck_weight : truck_weights){
            trucks.add(new Truck(truck_weight));
        }
        int answer = 0;
        do{
            if(trucks.isEmpty()) bridge.moveTrucks();
            else if(bridge.process(trucks.peek())){
                //비어있지 않고
                //올리는게 성공하면
                trucks.poll(); //제거
            }
            // bridge.printTrucks();
            answer++;
        }while(!bridge.isTrucksEmpty());


        return answer;
    }
}
class Bridge{
    private int maxWeight;
    private int length;
    private Queue<Truck> crossingTrucks = new LinkedList<>();
    private int curWeight;
    public Bridge(int length,int maxWeight){
        this.maxWeight = maxWeight;
        this.length = length;
    }
    public boolean process(Truck truck){
        moveTrucks(); // 다리 위의 트럭을 이동
        return addCrossingTrucks(truck); // 다리 위로 트럭을 올림
    }
    public void moveTrucks(){
        boolean poll = false;
        for(Truck truck : this.crossingTrucks){
            truck.moveTruck();
            if(truck.completeCross(this.length)){
                //트럭이 다리를 건넜다면
                // 어차피 선입된 트럭이 먼저 도착할 것이 자명하기에 그냥 pop실행( 맨 앞 );
                poll = true;
            }
        }
        if(poll) this.curWeight -= this.crossingTrucks.poll().getTruckWeight();
    }
    public boolean addCrossingTrucks(Truck truck){
        if(!canCross(truck.getTruckWeight())) return false; // 무게가 감당 안되면 false
        if(!canBoarding()) return false; // 길이 감당 안되면 false
        // 둘 다 감당 되면 올림
        this.crossingTrucks.add(truck);
        this.curWeight += truck.getTruckWeight();
        return true;
    }
    private boolean canCross(int truckWeight){
        return (this.curWeight + truckWeight) <= this.maxWeight;
    }
    private boolean canBoarding(){
        return crossingTrucks.size()+1 <= this.length;
    }
    public boolean isTrucksEmpty(){
        return this.crossingTrucks.isEmpty();
    }
    public void printTrucks(){
        for(Truck truck : this.crossingTrucks){
            System.out.print("truck weight: " + truck.getTruckWeight()+" truck moveTime: "+truck.getMoveTime());
        }
        System.out.println();
    }

}
class Truck{
    private int truckWeight;
    private int moveTime;
    private boolean cross;
    public Truck(int truckWeight){
        this.truckWeight = truckWeight;
        this.moveTime = 0;
        this.cross = false;
    }
    public int getTruckWeight(){
        return this.truckWeight;
    }
    public int getMoveTime(){
        return this.moveTime;
    }
    public void moveTruck(){
        this.moveTime++;
    }
    public boolean completeCross(int bridgeLength){
        return bridgeLength == moveTime;
    }
}