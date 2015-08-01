public class Sim {
    static int timestamp = 0;
    static int slice = 0;
    static Task on_cpu = null;

    static void advance_time(int steps) {
        timestamp = timestamp + steps;
    }
}

