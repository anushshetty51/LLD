import java.util.*;
interface FitnessObserver{
    void update(FitnessData data);
}


interface FitnessDataSubject{
    void registerObserver(FitnessObserver observer);
    void removeObserver(FitnessObserver observer);
    void notifyObservers();
}

class FitnessData implements FitnessDataSubject{
    List<FitnessObserver> observers = new ArrayList<>();
      private int steps;
    private int activeMinutes;
    private int calories;

    @Override
    public void registerObserver(FitnessObserver observer) {
        observers.add(observer);
    }

     @Override
    public void removeObserver(FitnessObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(){
        for(FitnessObserver observer: observers){
            observer.update(this);
        }
    }


    public void newDataPushed(int steps, int activeMinutes, int calories) {
        this.steps = steps;
        this.activeMinutes = activeMinutes;
        this.calories = calories;
        System.out.println("FitnessData: New data pushed - Steps: " + steps + ", Active Minutes: " + activeMinutes + ", Calories: " + calories);
        notifyObservers();
    }
}


class LiveActivityObserver implements FitnessObserver{
    @Override
    public void update(FitnessData data) {
        System.out.println("LiveActivityObserver: " + data);
    }
}

class FitnessAppObserverDemo{
    public static void main(String[] args) {
       LiveActivityObserver liveactivity=new LiveActivityObserver();
       FitnessData fitnessData=new FitnessData();
       fitnessData.registerObserver(liveactivity);
         fitnessData.newDataPushed(1000, 30, 200);


    }
}