import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> dayStepList = new ArrayList<>();
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter(75, 50, 10000); // , stepTracker);
        Scanner scanner = new Scanner(System.in);
        String[] nameMonth = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август",
                "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        while (true) {
             printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                System.out.println("Введите название месяца:");
                String month = scanner.next();
                System.out.println("Введите порядковый номер дня от 1 до 30:");
                int day = scanner.nextInt();
                if ((day<=0) | (day>30))
                    {System.out.println("Введите корректные данные");}
                else {
                    System.out.println("Введите количество шагов, пройденных за этот день:");
                    int stepDay = scanner.nextInt();
                    Integer inpMonth = 0;
                    for(int k = 0; k < nameMonth.length; k++) {

                        if (nameMonth[k].toLowerCase().equals(month.toLowerCase())) {
                            inpMonth = k+1;
                            break;
                        }
                    }
                    converter.changeStepDay(inpMonth, day, stepDay);
            }}
            else if (userInput == 2) {
                System.out.println("Выберете месяц (от 1 до 12)");
                Integer inputMonth = scanner.nextInt();

                String nameOfMonth = nameMonth[inputMonth - 1];
                System.out.println(nameOfMonth);
                ArrayList<Integer> numDay = new ArrayList<>();
                System.out.print("Количество пройденных шагов по дням: ");
                System.out.println(converter.getAllDay(inputMonth));
                converter.findBestSeria(inputMonth);
                System.out.println("Максимальное пройденное количество шагов в месяце: " +converter.findMaxStep(inputMonth));
                System.out.println("Общее количество шагов за месяц: " + converter.convertPrintMonth(inputMonth));
                System.out.println("Среднее количество шагов " + converter.convertPrintMonthAvergate(inputMonth));
                System.out.println("Пройденная дистанция (в км): "+ converter.convertPrintMonth(inputMonth)
                        * converter.getLengthStep(inputMonth));
                System.out.println("Количество сожжённых килокалорий: "+ converter.convertPrintMonth(inputMonth)
                        * converter.getCaloStep(inputMonth));

            } else if (userInput == 3) {
                System.out.println("Введите новую цель:");
                int newTarget = scanner.nextInt();
                if (newTarget<0){
                    System.out.println("Введите корректные данные");
                }  else
                {converter.maxStep = newTarget;
                System.out.println("Поздравляем, цель успешно изменена!");}

            } else if (userInput == 4) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }
    public static void printMenu()
    {
        System.out.println("1 - Введите количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");

    }
}