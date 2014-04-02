import com.tinkerforge.IPConnection;
import com.tinkerforge.BrickletIndustrialQuadRelay;

public class RemoteSwitch {
	private static final String HOST = "localhost";
	private static final int PORT = 4223;
	private static final String UID = "ctG"; // Change to your UID
	private static final int VALUE_A_ON  = (1 << 0) | (1 << 2); // Pin 0 and 2 high
	private static final int VALUE_A_OFF = (1 << 0) | (1 << 3); // Pin 0 and 3 high
	private static final int VALUE_B_ON  = (1 << 1) | (1 << 2); // Pin 1 and 2 high
	private static final int VALUE_B_OFF = (1 << 1) | (1 << 3); // Pin 1 and 3 high

	// Note: To make the example code cleaner we do not handle exceptions. Exceptions you
	//       might normally want to catch are described in the documentation
	public static void main(String args[]) throws Exception {
		IPConnection ipcon = new IPConnection(); // Create IP connection
		BrickletIndustrialQuadRelay iqr = new BrickletIndustrialQuadRelay(UID, ipcon); // Create device object

		ipcon.connect(HOST, PORT); // Connect to brickd
		// Don't use device before ipcon is connected

		iqr.setMonoflop(VALUE_A_ON, 15, 1500); // Set pins to high for 1.5 seconds

		ipcon.disconnect();
	}
}
