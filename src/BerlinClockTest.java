import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BerlinClockTest {

	BerlinClock berlinTime = new BerlinClock();

	@Test
	void testGetSeconds() {
		berlinTime.convertTime("00:00:00");
		assertEquals("Y", berlinTime.getSeconds());
	}

	@Test
	void testGetSecondsOff() {
		berlinTime.convertTime("00:00:59");
		assertEquals("O", berlinTime.getSeconds());
	}

	@Test
	void testDisplayTime() {
		berlinTime.convertTime("00:05:00");
		assertEquals("YOOOOOOOOYOOOOOOOOOOOOOO", berlinTime.displayTime());
	}

	@Test
	void testGetMinutes() {
		berlinTime.convertTime("00:00:00");
		assertEquals("OOOOOOOOOOO", berlinTime.topMinutes());
	}

	@Test
	void testGetNoHours() {
		berlinTime.convertTime("04:00:00");
		assertEquals("OOOO", berlinTime.topHours());
	}

	@Test
	void testGetFiveHour() {
		berlinTime.convertTime("05:00:00");
		assertEquals("ROOO", berlinTime.topHours());
	}

	@Test
	void testTenHour() {
		berlinTime.convertTime("10:00:00");
		assertEquals("RROO", berlinTime.topHours());
	}

	@Test
	void testFifteenHour() {
		berlinTime.convertTime("15:42:00");
		assertEquals("RRRO", berlinTime.topHours());
		assertEquals("YRRROOOOOYYRYYRYYOOOYYOO", berlinTime.displayTime());
	}

	@Test
	void testTwentyThreeHour() {
		berlinTime.convertTime("23:00:00");
		assertEquals("RRRO", berlinTime.bottomHours());
		assertEquals("YRRRRRRROOOOOOOOOOOOOOOO", berlinTime.displayTime());
	}

	@Test
	void testTopHour() {
		berlinTime.convertTime("11:00:00");
		assertEquals("RROO", berlinTime.topHours());

	}

	@Test
	void testBottomHour() {
		berlinTime.convertTime("12:00:00");
		assertEquals("RROO", berlinTime.bottomHours());

	}

	@Test
	void testTopHour2() {
		berlinTime.convertTime("17:23:32");
		assertEquals("RRRO", berlinTime.topHours());
		assertEquals("YRRRORROOYYRYOOOOOOOYYYO", berlinTime.displayTime());

	}

	@Test
	void testBottomHour2() {
		berlinTime.convertTime("17:00:00");
		assertEquals("RROO", berlinTime.bottomHours());

	}

	@Test
	void testBottomMinutes() {
		berlinTime.convertTime("17:23:32");
		assertEquals("YYYO", berlinTime.bottomMinutes());
		assertEquals("YRRRORROOYYRYOOOOOOOYYYO", berlinTime.displayTime());
	}

	@Test
	void testTopMinutes() {
		berlinTime.convertTime("17:59:32");
		assertEquals("YYRYYRYYRYY", berlinTime.topMinutes());
		assertEquals("YRRRORROOYYRYYRYYRYYYYYY", berlinTime.displayTime());
	}

}
