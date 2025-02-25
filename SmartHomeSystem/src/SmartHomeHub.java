import java.util.ArrayList;

@SuppressWarnings("serial")
public class SmartHomeHub<E extends SmartDevice> extends ArrayList<E> {

	public SmartHomeHub() {
	}

	public String turnAllOn() {
		for (E temp: this) {
			temp.turnOn();
		}
		return "All SmartDevices are turned On"; 
	}
	
	public String turnAllOff() {
		for (E temp: this) {
			temp.turnOff();
		}
		return "All SmartDevices are turned Off";
	}
	
	public void showAllStatuses() {
		for (E temp: this) {
			temp.getStatus();
		}
	}
}
