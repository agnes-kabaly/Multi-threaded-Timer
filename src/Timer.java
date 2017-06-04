public class Timer implements Runnable {

    private String name;
    private long id;
    private Integer counter;
    boolean run = true;

    public Timer(String name) {
        this.name = name;
        this.id = 0;
        this.counter = 0;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getCounter() {
        return counter;
    }

    public boolean isRun() {
        return run;
    }

    @Override
    public void run() {
        run = true;
        while (run) {
            try {
                Thread.sleep(1000);
                counter++;
            } catch (InterruptedException e) {
                System.out.println("Áj donnó wáj");
                run = false;
            }
        }
    }

    public String check() {
        String checkInf = "Name: " + name + ", ThreadId: " + id + ", Seconds: " + getCounter();
        return checkInf;
    }

    public void stop() {
        Thread.currentThread().interrupt();
        run = false;
    }
}
