
public class SmartThermostat implements SmartDevice {
	// Data members 
	private boolean isOn;
	private double temperature;
	
	public SmartThermostat() {
		isOn = false; 
		temperature = 25;
	}
	
	public SmartThermostat(boolean isOn, double temperature) {
		this.isOn = isOn;
		this.temperature = temperature;
	}
	
	// Other methods
	public String setTemp(double newTemp) {
		if (isOn) {
			temperature = newTemp;
			return "The temperature is set to: " + temperature; 
		}
		else {
			return "The SmartThermostat is turned Off"; 
		}
	}
	@Override
	public String turnOn() {
		isOn = true;
		return "SmartThermostat is turned On";
	}
	@Override
	public String turnOff() {
		isOn = false;
		return "SmartThermostat is turned Off";
	}
	@Override
	public String getStatus() {
		if (isOn) {
			return "The SmartThermostat is turned On";
		}
		else {
			return "The SmartThermostat is turned Off"; 
		}
	} 
	
	
	
}
