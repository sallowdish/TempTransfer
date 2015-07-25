/**
 * Created by JessicaWang on 15-07-12.
 */
public class Krakow {
    // Debug Macro http://stackoverflow.com/a/3778768
    boolean isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().
            getInputArguments().toString().indexOf("jdwp") >= 0;

    PQueue permitQueue = null;
    PQueue iceCreamPQueue = null;
    Queue hospitalQueue = null;
    Integer priorities = -1;

    final String kBazyliszek = "Bazyliszek";
    final String kSmokWawelski = "Smok Wawelski";
    final String kBabaJaga = "Baba Jaga";

    /**
     * constructor
     * @param priorities unknown(?)
     * @param n the capacity of queues
     */
    public Krakow(int priorities, int n)
    {
        this.priorities = priorities;
        permitQueue = new PQueue(priorities, n);
        iceCreamPQueue = new PQueue(priorities, n);
        hospitalQueue = new Queue(n);
    }

    /**
     * give permit to next person in permitQueue
     * and move him/her to iceCreameQueue
     */
    public void give_permit(){
        Person nextPerson = permitQueue.remove();
        if(nextPerson != null){
            nextPerson.get_permit();
            addToIceCreameQueue(nextPerson);
        }
    }

    /**
     * gives ice cream to the next person lining up for ice cream.
     * Then remove him/her from ice cream queue
     */
    public void give_ice_cream(){
        Person nextPerson = iceCreamPQueue.remove();
        if (nextPerson != null){
            nextPerson.get_ice_cream();
        }
    }

    /**
     * gives ice cream to the next person in the hospital queue
     */
    public void give_hospital_ice_cream(){
        Person nextPerson = hospitalQueue.remove();
        if (nextPerson != null){
            nextPerson.get_ice_cream();
        }
    }

    /**
     * enters the given person into the permit queue
     * @param p a Person instance
     */
    public void enter_system(Person p){
        addToPermitQueue(p);
    }


    /**
     * enters the person into the hospital queue.
     * This person is removed from any other queues
     * @param p a Person instance
     */
    public void fake_illness(Person p){
        permitQueue.give_up(p);
        iceCreamPQueue.give_up(p);
        // Warning: since Person.eqaul can't distinct two Bada Jada. It is undefined either if one Baba Jada can be threatened by another Baba Jada.
        // So we assume that a Baba Jada will never fake ill when she is in hospital queue
        if(p.name.equals(kBabaJaga) && hospitalQueue.contains(p)){
            System.out.println("A Baba Jada will never be a silly person to fake ill in hospital queue");
        }
        else{
            hospitalQueue.give_up(p);
        }
        addToHospitalQueue(p);
    }

    private void addToIceCreameQueue(Person p){
        if (p.name.equals(kSmokWawelski) || p.name.equals(kBazyliszek)){
            handleImpatient(p, iceCreamPQueue);
        }
        else if (p.name.equals(kBabaJaga)) {
            handleBlackMagic(p, iceCreamPQueue);
        }
        else{
            iceCreamPQueue.add(p);
        }
    }

    private void addToPermitQueue(Person p){
        if (p.name.equals(kSmokWawelski) || p.name.equals(kBazyliszek)){
            handleImpatient(p, permitQueue);
        }
        else if (p.name.equals(kBabaJaga)) {
            handleBlackMagic(p, permitQueue);
        }
        else{
            permitQueue.add(p);
        }
    }

    private void addToHospitalQueue(Person p){
        if (p.name.equals(kSmokWawelski) || p.name.equals(kBazyliszek)){
            handleImpatient(p, hospitalQueue);
        }
        else if (p.name.equals(kBabaJaga)) {
            handleBlackMagic(p, hospitalQueue);
        }
        else{
            hospitalQueue.add(p);
        }
    }

    private void handleImpatient(Person p, Object q) {
        if (q != null){
            if (q instanceof PQueue){
                Person removedPerson = null;
                while ( (removedPerson = ((PQueue) q).remove()) != null){
                    removedPerson.print_obituary();
                }
                ((PQueue) q).add(p);
            }
            else if (q instanceof Queue){
                Person removedPerson = null;
                while ( (removedPerson = ((Queue) q).remove())!= null){
                    removedPerson.print_obituary();
                }
                ((Queue) q).add(p);
            }
        }else {
        }
    }

    private void handleBlackMagic(Person p, Object q){
        try {
            if (q != null) {
                Integer totalSize = 0;
                Person[] personInTransit = null;
                if (q instanceof PQueue) {
                    // remove scraed ppl from current Queue
                    totalSize = ((PQueue) q).getTotalSize();
                    personInTransit = new Person[totalSize];
                    for (int i = 0; i < totalSize; i++) {
                        personInTransit[i] = ((PQueue) q).remove();
                        if(isDebug){
                            System.out.println(personInTransit[i].name + " is transiting.");
                        }
                    }
                    // add Baba Jaga to current queue
                    ((PQueue) q).add(p);
                } else if (q instanceof Queue) {
                    // remove all scared ppl from current queue
                    totalSize = ((Queue) q).size;
                    personInTransit = new Person[totalSize];
                    for (int i = 0; i < totalSize; i++) {
                        personInTransit[i] = ((Queue) q).remove();
                        if(isDebug){
                            System.out.println(personInTransit[i].name + " is transiting.");
                        }
                    }
                    // add Baba Jaga to current queue
                    ((Queue) q).add(p);
                } else {
                    throw new IllegalStateException("You should never be here.");
                }
                // add all scared ppl to hospital queue
                for (Person ppl : personInTransit) {
                    addToHospitalQueue(ppl);
                }
            } else {

            }
        }
        catch (StackOverflowError err){
            System.out.println("BlackMagic 'Infinity' is voided. StackOverFlow(.com) is watching you.\n");
        }
        catch (IllegalStateException ex){
            System.err.println("Fault: " + ex.getMessage());
        }
    }
}
