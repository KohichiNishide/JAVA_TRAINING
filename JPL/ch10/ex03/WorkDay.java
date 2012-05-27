package ch10.ex03;

/*
 * Switch���̕������āBIf����day, Day�ȂǏd���L�q����Ă��ď璷�B
 */

public class WorkDay {
	static public Boolean IsWorkDayByIfElse(Day day) throws NullPointerException {
		if (day == Day.MONDAY || day == Day.TUESDAY || day == Day.WEDNESDAY || day == Day.THUESEDAY || day == Day.FRIDAY) {
			return true;
		} else if (day == Day.SATURDAY || day == Day.SUNDAY){
			return false;
		} else {
			throw new NullPointerException("The input parameter is NULL");
		}
	}
	
	static public Boolean IsWorkDayBySwitch(Day day) throws NullPointerException {
		switch (day) {
		case MONDAY: case TUESDAY: case WEDNESDAY: case THUESEDAY: case FRIDAY:
			return true;
		case SATURDAY: case SUNDAY:
			return false;
		default:
			throw new NullPointerException("The input parameter is NULL");
		}
	}
}
