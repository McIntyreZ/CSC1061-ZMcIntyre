
public class SecurityCamera implements SmartDevice {
	// Data members
	private boolean isOn;
	private boolean isRecording;
	
	public SecurityCamera() {
		isOn = false; 
		isRecording = false; 
	}
	
	public SecurityCamera(boolean isOn, boolean isRecording) {
		super();
		this.isOn = isOn;
		this.isRecording = isRecording;
	}
	
	// Other methods 
	public String toggleRecording() {
		if (isOn) {
			isOn = false;
			return "The SecurityCamera is turned Off";
		}
		else {
			return "The SecurityCamera is turned On"; 
		}
	}
	
	@Override
	public String turnOn() {
		isOn = true; 
		return "The SecurityCamera is turned On";
	}
	@Override
	public String turnOff() {
		isOn = false;
		return "The SecurityCamera is turned Off";
	}
	@Override
	public String getStatus() {
		if (isOn) {
			return "The SecurityCamera is turned On";
		}
		else {
			return "The SecurityCamera is turned Off"; 
		}
	} 
	
	
}
