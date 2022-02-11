package mark.patterns.mediator;

class Mediator {
    private Host host;
    private Guest guest;
    public void regHost(Host host){
        this.host = host;
    }
    public void regGuest(Guest guest){
        this.guest=guest;
    }

    public void hostSpeak(){
        if(guest.isFree()){
            guest.stop();
        }
        System.out.println("Anchor is speaking....");
        host.setFree(false);
    }
    public void guestSpeak(){
        if(host.isFree()){
            System.out.println("Guest is speaking....");
            guest.setFree(false);
        }
        else{
            System.out.println("Anchor is speaking. Do not interrupt...");
        }

    }
    public void hostStop(){
        System.out.println("Anchor stop speaking now....");
        host.setFree(true);
    }
    public void guestStop(){
        System.out.println("Guest stop speaking now...");
        guest.setFree(true);

    }
}

class Host {
    private boolean free;
    private final Mediator med;

    public Host(Mediator md){
        med = md;
    }
    public boolean isFree() {
        return free;
    }
    public void setFree(boolean free) {
        this.free = free;
    }
    public void speak() {
        med.hostSpeak();
    }
    public void stop() {
        med.hostStop();
    }

}
class Guest {
    private boolean free = false;
    private final Mediator med;

    public Guest(Mediator md) {
        this.med = md;
    }
    public boolean isFree() {
        return free;
    }
    public void setFree(boolean free) {
        this.free = free;
    }
    public void speak() {
        med.guestSpeak();

    }
    public void stop() {
        med.guestStop();
    }
}



public class MediatorPattern {
    public static void main(String[] args) {
        Mediator med = new Mediator();

        Host host = new Host(med);
        Guest guest = new Guest(med);

        med.regHost(host);
        med.regGuest(guest);

        host.speak();
        guest.speak();
        host.stop();
        guest.speak();
        guest.stop();

    }
}
