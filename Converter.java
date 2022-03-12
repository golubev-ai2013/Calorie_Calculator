import java.util.ArrayList;

public class Converter {
    int lengthStep;
    int caloStep;
    int maxStep = 10000;

    Converter(int len, int calo, int target){
        lengthStep = len;
        caloStep = calo;
        maxStep = target;
    }
    StepTracker stepTracker = new StepTracker();


    Integer convertPrintMonth(Integer nMonth) {

        Integer sumStepMonth = 0;
        ArrayList<Integer> stepList = stepTracker.monthToData.get(nMonth-1);
        for (Integer countStepDay : stepList) {
           sumStepMonth += countStepDay;
        }
       return sumStepMonth;
    }

    Integer convertPrintMonthAvergate(Integer nMonth) {
        return convertPrintMonth(nMonth) / 30;
    }

    double getLengthStep(double step) {
        return step = 0.00075;

    }

    double getCaloStep(double step) {
        return  step = 0.05;
    }

    String getAllDay(Integer nMonth) {
        ArrayList<Integer> stepList = stepTracker.monthToData.get(nMonth-1);
        String s = "";
        int j = 1;
        for (Integer allDay : stepList) {
            s+=j+" день: "+allDay+", ";
           j++;

        }
        return s;
    }
    void changeStepDay(Integer nMonth, int nDay, Integer nStep) {
        Integer sumStepMonth = 0;
        ArrayList<Integer> stepList = stepTracker.monthToData.get(nMonth-1);
        stepList.set(nDay-1, nStep);
        System.out.println("Количество шагов за "+nDay+" день успешно изменено!!!");
    }

    Integer findMaxStep(Integer nMonth) {
        Integer maxStep = 0;
        ArrayList<Integer> stepList = stepTracker.monthToData.get(nMonth-1);
        for (Integer daystep : stepList) {
            if (daystep > maxStep) {
                maxStep = daystep;
            }
        }
        return maxStep;
    }

    void findBestSeria(Integer nMonth){
        ArrayList<Integer> stepList = stepTracker.monthToData.get(nMonth-1);
        int bestDay = 0;
        int bestSeria = 0;
        String s = "";
        int i = 0;

        for (Integer steps : stepList) {
            i++;
            if (steps >= maxStep) {
                bestDay++;
                s+=i+" день: "+steps+", ";
            } else if (bestDay < bestSeria) {
                bestDay = 0;
                s = "";
            } else if (bestDay > bestSeria) {
                bestSeria = bestDay;
            }
        }
        System.out.println("Лучшая серия: "+bestSeria+" ("+s+")");
    }
}
