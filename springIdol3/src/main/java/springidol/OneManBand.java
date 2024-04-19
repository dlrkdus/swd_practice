package springidol;

import org.springframework.beans.factory.BeanNameAware;

import java.util.Map;

public class OneManBand implements Performer, BeanNameAware {
	private Map<String, Instrument> instruments; // Map 타입 property
	private String beanName;

	public void setBeanName(String beanName){
		this.beanName=beanName;
	}
	public String getBeanName(){
		return beanName;
	}

	public OneManBand() {}

	public void setInstruments(Map<String, Instrument> instruments) {
		this.instruments = instruments;
	}

	@Override
	public void perform() throws PerformanceException {
		for (String key : instruments.keySet()) {
			System.out.print(key + ": ");
			Instrument instrument = instruments.get(key);
			instrument.play();
		}
	}
}
