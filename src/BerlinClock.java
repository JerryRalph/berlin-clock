
public class BerlinClock {
	private static final int HOURDIVISION = 5;
	private static final int MINUTEDIVISION = 5;
	private static final int TWO = 2;
	private static final int NOREMAINDER = 0;
	private static final String OUT = "O";
	private static final String RED = "R";
	private static final String YELLOW = "Y";
	private static final int HOURLAMPS = 4;
	private static final int MINUTELAMPS = 11;

	private int seconds;
	private int topMinutes;
	private int bottomMinutes;
	private int topHours;
	private int bottomHours;
	private String[] berlinTime;

	public String displayTime() {

		System.out.println("     " + getSeconds());
		System.out.println("   " + topHours());
		System.out.println("   " + bottomHours());
		System.out.println(topMinutes());
		System.out.println("   " + bottomMinutes());
		return getSeconds() + topHours() + bottomHours() + topMinutes() + bottomMinutes();

	}

	public void convertTime(String time) {
		berlinTime = time.split(":");
		seconds = Integer.parseInt(berlinTime[2]);
		topMinutes = Integer.parseInt(berlinTime[1]);
		bottomMinutes = Integer.parseInt(berlinTime[1]);
		topHours = Integer.parseInt(berlinTime[0]);
		bottomHours = Integer.parseInt(berlinTime[0]);

	}

	public String getSeconds() {
		if (seconds % TWO == NOREMAINDER) {
			return YELLOW;
		}
		return OUT;
	}

	public String topMinutes() {

		int lampsLit = topMinutes / MINUTEDIVISION;
		return hoursOnOff(MINUTELAMPS, lampsLit, YELLOW).replaceAll("YYY", "YYR");
	}

	public String topHours() {

		int lampsLit = topHours / HOURDIVISION;
		return hoursOnOff(HOURLAMPS, lampsLit, RED);

	}

	public String bottomHours() {

		int lampsLit = bottomHours % HOURDIVISION;
		return hoursOnOff(HOURLAMPS, lampsLit, RED);
	}

	public String bottomMinutes() {

		int lampsLit = bottomMinutes % MINUTEDIVISION;
		return hoursOnOff(HOURLAMPS, lampsLit, YELLOW);
	}

	private String hoursOnOff(int lamps, int lampsLit, String lamp) {
		String berlinHours = "";
		for (int i = 0; i < lampsLit; i++) {
			berlinHours += lamp;
		}
		for (int i = 0; i < lamps - lampsLit; i++) {
			berlinHours += OUT;
		}

		return berlinHours;
	}

}
