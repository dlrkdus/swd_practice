package springidol;

public class Encore {
    Performer performer;

    public Encore(){}
    public Encore(Performer performer){
        this.performer=performer;
    }
    public void setPerformer(Performer performer){
        this.performer=performer;
    }
    public Performer getPerformer(){
        return performer;
    }

    public void execute(){
        System.out.println("<Encore Performance>");
        performer.perform();
    }
}
