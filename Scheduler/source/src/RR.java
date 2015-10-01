/**
 * Created by Ray on 15-08-01.
 */
public class RR implements Scheduler {
    Queue<Task> RRScheduler;
    Task currentTask;

    /**
     * Initializer
     */
    public RR()
    {
        setup();
    }

    public void setup()
    {
        RRScheduler = new Queue<Task>(MAXTASKCOUNT);
    }

    /**
     * Revise and update current scheduel
     * be called whenever the time given to a task to execute is up, a task completes
     * and also at the beginning of the simulation.
     * @return int stands for how much time are assigned to task to use CPU
     */
    public int schedule()
    {
        // if current task is not finished with the time assigned,
        // put it back to task queue
        currentTask = Sim.on_cpu;
        if (currentTask != null && ! currentTask.finished){
            RRScheduler.add(currentTask);
        }
        // find next task to work on
        Task taskToExecute = RRScheduler.remove();
        if(taskToExecute != null) {
            Sim.on_cpu = taskToExecute;
        }
        return Sim.slice;
    }

    /**
     * Add a new task in to task queue
     * @param t Task instance which stands for the new arrived task
     */
    public void new_task(Task t)
    {
        RRScheduler.add(t);
    }

    /**
     * update the deadline of given task
     * @param t Task object which is going to be updated
     * @param old_deadline original deadline of the task?
     */
    public void change_deadline(Task t, int old_deadline)
    {
        return;
    }
}
