package com.swdm.spinoza_game;

public class AppleTree {
	public static final int STATE_CLICK_ON = 1;
	public static final int STATE_CLICK_OFF = 2;
	public static final int STATE_FULL = 3;
	public static final int STATE_LOW = 4;
	public static final int STATE_CLICK_ON_MID = 5;
	public static final int STATE_CLICK_OFF_MID = 6;
	public static final int STATE_WATER_ON = 7;
	public static final int STATE_HEAL_ON = 8;
	public static final int STATE_CLOUD_ON = 9;
	public static final int STATE_FIRE_ON = 10;
	

	private int m_state;

	public AppleTree(int state) {
		m_state = state;
	}

	public void setState(int state) {
		if (STATE_CLICK_ON == state) {
			m_state = 1;
		}
		if (STATE_CLICK_OFF == state) {
			m_state = 2;
		}
		if (STATE_FULL == state) {
			m_state = 3;
		}
		if (STATE_LOW == state) {
			m_state = 4;
		}
		if (STATE_CLICK_ON_MID == state) {
			m_state = 5;
		}
		if (STATE_CLICK_OFF_MID == state) {
			m_state = 6;
		}
		if (STATE_WATER_ON == state) {
			m_state = 7;
		}
		if (STATE_HEAL_ON == state) {
			m_state = 8;
		}
		if (STATE_CLOUD_ON == state) {
			m_state = 9;
		}
		if (STATE_FIRE_ON == state){
			m_state = 10;
		}

	}

	public int getState() {
		return m_state;
	}
}
