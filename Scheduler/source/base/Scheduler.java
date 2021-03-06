/**
 * Created by t-razhen on 7/31/2015.
 */
public interface Scheduler {

    final int MAXTASKCOUNT = 1024;
    final int MAXTIMECOUNT = 1024;

    /**
     * Initializer
     */
    public void setup();

    /**
     * Revise and update current scheduel
     * be called whenever the time given to a task to execute is up, a task completes
     * and also at the beginning of the simulation.
     * @return int stands for how much time are assigned to task to use CPU
     */
    public int schedule();

    /**
     * Add a new task in to task queue
     * @param t Task instance which stands for the new arrived task
     */
    public void new_task(Task t);

    /**
     * update the deadline of given task
     * @param t Task object which is going to be updated
     * @param old_deadline original deadline of the task?
     */
    public void change_deadline(Task t, int old_deadline);
}
