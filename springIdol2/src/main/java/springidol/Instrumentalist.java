package springidol;

public class Instrumentalist implements Performer {
	private String song;
	private Instrument instrument;

	public Instrumentalist() {
	}
	public Instrumentalist(String song, Instrument instrument){
		this.song=song;
		this.instrument=instrument;
	}
	
	public void setSong(String song) {
		this.song = song;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void perform() throws PerformanceException {
		System.out.print("Playing " + song + " : ");
		instrument.play();
	}
}
