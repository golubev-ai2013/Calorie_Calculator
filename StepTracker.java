import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class StepTracker {

    HashMap<Integer, ArrayList<Integer>> monthToData = new HashMap<>();

    public StepTracker() {

        Random ran = new Random();
        for (int i = 0; i < 12; i++) {
            ArrayList<Integer> dayStepList = new ArrayList<>();
            for (int j = 0; j < 30; j++) {
                dayStepList.add(ran.nextInt(15000));
            }
            monthToData.put(i, dayStepList);

        }
    }
}
