package springidol;

public class Song {
    String title;
    String artist;

    public Song(){ //기본 생성자
    }

    public Song(String title,String artist){ //생성자
        this.title=title;
        this.artist=artist;
    }

    public void setTitle(String title){
        this.title=title;
    }
    public void setArtist(String artist){
        this.artist=artist;
    }

    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return artist;
    }
}
