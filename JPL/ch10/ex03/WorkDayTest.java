package ch10.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorkDayTest {

	@Test
	public void test() {
		try {
			assertTrue(WorkDay.IsWorkDayByIfElse(Day.MONDAY));
			assertTrue(WorkDay.IsWorkDayByIfElse(Day.THUESEDAY));
			assertTrue(WorkDay.IsWorkDayByIfElse(Day.WEDNESDAY));
			assertTrue(WorkDay.IsWorkDayByIfElse(Day.TUESDAY));
			assertTrue(WorkDay.IsWorkDayByIfElse(Day.FRIDAY));
			assertFalse(WorkDay.IsWorkDayByIfElse(Day.SATURDAY));
			assertFalse(WorkDay.IsWorkDayByIfElse(Day.SUNDAY));
			
			assertTrue(WorkDay.IsWorkDayBySwitch(Day.MONDAY));
			assertTrue(WorkDay.IsWorkDayBySwitch(Day.THUESEDAY));
			assertTrue(WorkDay.IsWorkDayBySwitch(Day.WEDNESDAY));
			assertTrue(WorkDay.IsWorkDayBySwitch(Day.TUESDAY));
			assertTrue(WorkDay.IsWorkDayBySwitch(Day.FRIDAY));
			assertFalse(WorkDay.IsWorkDayBySwitch(Day.SATURDAY));
			assertFalse(WorkDay.IsWorkDayBySwitch(Day.SUNDAY));
		} catch (NullPointerException e) {
			fail("この行が実行されたらエラー");
		}	
	}
	
	@Test
	public void exceptionTestforIsWorkDayByIfElse() {
		try {
			assertFalse(WorkDay.IsWorkDayByIfElse(null));
			fail("この行が実行されたらエラー");
		} catch (NullPointerException e) {
			//succeed
		}
	}
	
	@Test
	public void exceptionTestforIsWorkDayBySwitch() {
		try {
			assertFalse(WorkDay.IsWorkDayBySwitch(null));
			fail("この行が実行されたらエラー");
		} catch (NullPointerException e) {
			//succeed
		}
	}
}
