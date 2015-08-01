public class Task {
  final public static int NO_DEADLINE = 1023;
  public int deadline = NO_DEADLINE;
  public int time_required;
  public boolean has_deadline = false;
  public boolean finished = false;
  
  private int time_arrived;
  private int time_worked = 0;
  private int time_task_completed = NO_DEADLINE;
  private boolean deadline_expired = false;


  Task(int time_required, int deadline) {
    this.deadline = deadline;
    this.time_required = time_required;
    this.time_arrived = Sim.timestamp;

    
    if (deadline != 1023) {
      has_deadline = true;
    } else {
      has_deadline = false;
    }
    
  }

  public int run_n_units(int steps) {
    int spare_time = 0;
    
    time_worked = time_worked + steps;
    // Changed
    if (time_required < time_worked) {
      // task is finished within time interval assigned
      spare_time = time_worked - time_required;
      time_worked = time_required;
      finished = true;
      // return the spare_time to Sim
      time_task_completed = Sim.timestamp - spare_time;
    }

    if (time_task_completed > deadline && deadline != NO_DEADLINE) {
      deadline_expired = true;
    }

    return spare_time;
  }

  public void wait_n_units(int steps) {
    if (Sim.timestamp + steps > deadline && deadline != NO_DEADLINE) {
      deadline_expired = true;
    }
  }

  
  
}
  
