package com.example.hw_1;

public class BubbleState {
	public static final int STATE_BUBBLE_1 = 1;
	public static final int STATE_BUBBLE_2 = 2;
	public static final int STATE_BUBBLE_3 = 3;
	
	
	private int m_state;
	
	public BubbleState(int state){
		m_state = state;
	}
	
	public void setState(int state)
	{
		if(STATE_BUBBLE_1==state)
		{
			m_state = state;
		}
		if(STATE_BUBBLE_2==state)
		{
			m_state = state;
		}
		if(STATE_BUBBLE_3==state)
		{
			m_state = state;
		}
	}
	public int getState()
	{
		return m_state;
	}
}
