import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean starter = true;
        Thread threadNew = null;
        List<Timer> timerList = new ArrayList<>();

        while (starter) {

            String userInput = scanner.nextLine();
            List<String> timItems = Arrays.asList(userInput.split(" "));

            if (userInput.contains("start")){

                String name = timItems.get(1);
                Timer sameTimer = null;
                boolean same = false;
                Timer timerNew = null;

                for (int i = 0; i < timerList.size(); i++) {
                    if(timerList.get(i).getName().equals(name)) {
                        System.out.println("EGGYEZIK!");
                        same = true;
                        sameTimer = timerList.get(i);
                        if(!sameTimer.isRun()) {
                            threadNew = new Thread(sameTimer);
                            threadNew.start();
                        } else {
                            System.out.println("It's already running! ;)");
                        }
                    }
                }

                if (!same) {
                    timerNew = new Timer(name);
                    threadNew = new Thread(timerNew);
                    timerNew.setId(threadNew.getId());
                    threadNew.start();
                    timerList.add(timerNew);
                }
            }

            if (userInput.contains("check")){
                for (int i = 0; i < timerList.size(); i++) {
                    System.out.println(timerList.get(i).check());
                }
            }

            if (userInput.contains("stop")){
                String name = timItems.get(1);
                for (int i = 0; i < timerList.size(); i++) {
                    if (timerList.get(i).getName().equals(name)) {
                        timerList.get(i).stop();
                        System.out.println(name + " received interrupt while sleeping");
                    }
                }
            }

            if (timItems.get(0).equals("exit")){
                for (int i = 0; i < timerList.size(); i++) {
                    timerList.get(i).stop();
                    System.out.println(timerList.get(i).check());
                }
                timerList = null;
                starter = false;
            }
        }
    }
}
