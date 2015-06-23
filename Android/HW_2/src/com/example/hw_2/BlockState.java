package com.example.hw_2;

public class BlockState {

	public static final int STATE_BLOCK_1 = 1;
	public static final int STATE_BLOCK_2 = 2;

	private int m_state;

	public BlockState(int state) {
		m_state = state;
	}

	public void setState(int state) {
		if (STATE_BLOCK_1 == state) {
			m_state = state;
		}
		if (STATE_BLOCK_2 == state) {
			m_state = state;
		}
	}
	public int getState(){
		return m_state;
	}
}
