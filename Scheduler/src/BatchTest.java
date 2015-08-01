public class BatchTest {


  public static void main(String[] args) {

    Batch sched = new Batch();
    sched.setup();
    Task first = new Task(3, 10);
    Task second = new Task(4, 5);
    Task third = new Task(6, 99);

    Sim.slice = -1;

    sched.new_task(second);
    sched.new_task(third);

    sched.schedule();
    sched.new_task(first);
    sched.schedule();
    sched.schedule();
    
  }
  
}
