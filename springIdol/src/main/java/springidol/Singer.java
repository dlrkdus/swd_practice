package springidol;

public class Singer implements Performer{

    String name;
    Song song;
    Instrument instrument;
    public Singer(){ //기본생성자
    }
    public Singer(String name, Song song){ //매개변수 있는 생성자
        this.name=name;
        this.song=song;
    }
    public Singer(String name, Song song,Instrument instrument){ //매개변수 있는 생성자
        this.name=name;
        this.song=song;
        this.instrument=instrument;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setSong(Song song){
        this.song=song;
    }
    public void setInstrument(Instrument instrument){
        this.instrument=instrument;
    }
    public String getName(){
        return name;
    }
    public Song getSong(){
        return song;
    }
    public Instrument getInstrument(){
        return instrument;
    }
    @Override
    public void perform() throws PerformanceException{
        System.out.println(name+" is singing a song "+song.title+" by "+song.artist);
        if (instrument!=null){
            System.out.print("while playing "+instrument.toString()+" ");
            instrument.play();
        }

    }

}
