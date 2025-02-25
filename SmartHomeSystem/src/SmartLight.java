
public class SmartLight implements SmartDevice{
	// Data members
	private boolean isOn;
	private int brightness;
	
	// Constructors 
	public SmartLight() {
		isOn = false;
		brightness = 50; 
	}
	
	public SmartLight(boolean isOn, int brightness) {
		this.isOn = isOn;
		this.brightness = brightness;
	}
	
	// Other methods 
	public String setBrightness(int level) {
		if (isOn && (0 <= level) && (level <= 100)) {
			brightness = level;
			return "SmartLight brightness is set to: " + level;
		}
		else {
			return "SmartLight is currently Off or incorrect brightness input";
		}
	}
	
	@Override
	public String turnOn() {
		isOn = true;
		return "SmartLight is now On";
	}

	@Override
	public String turnOff() {
		isOn = false;
		return "SmartLight is now Off";
	}

	@Override
	public String getStatus() {
		if (isOn) {
			return "SmartLight is On";
		}
		else {
			return "SmartLight is Off"; 
		}
	} 
	
	
	
}
