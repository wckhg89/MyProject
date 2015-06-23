package com.swdm.spinoza_game;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;

public class AppleTreeThread extends Thread {

	private SurfaceHolder m_surfaceholder;
	private AppleTreeGameView m_View;
	public static MediaPlayer m_Sound_Background;
	public boolean wait = false;

	public boolean isEnd = false;
	public static boolean isPause = false;

	public AppleTreeThread(SurfaceHolder surfaceHolder, AppleTreeGameView view) {
		/*
		 * 생성자
		 */
		m_surfaceholder = surfaceHolder;
		m_View = view;
		m_Sound_Background = MediaPlayer.create(m_View.getContext(),
				R.raw.background);
	}

	@SuppressLint("WrongCall")
	public void run() {
		int i = 1;

		Canvas _canvas;
		while (!isEnd) {
			if (!isPause) {
				if (m_Sound_Background.isPlaying() == false) {
					m_Sound_Background.start();
				} else if (m_Sound_Background.isPlaying() == true) { // empty
																		// state;
																		// }
				}
				AppleTreeGameView.currentTime = System.currentTimeMillis();
				_canvas = null;
				_canvas = m_surfaceholder.lockCanvas(null);
				// canvas를 잠그고 버퍼 할당.
				try {
					// 사람이 없을때 사과나무의 움직임.
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}

				
					m_View.setMidTree(i);
					m_View.setLowTree(i);
					m_View.setTree(i);

					m_View.setPeople(i);
					m_View.setMidPeople(i);
					
					m_View.setItem1(i);
					m_View.setItem2(i);
					m_View.setHeal(i);

					m_View.setPeopleR(i);
					m_View.setPeopleL(i);
					m_View.setBallon(i);
					
					m_View.setPeopleBoss(i);
					m_View.setBallonBoss(i);
					m_View.setButtonBoss(i);
					
					m_View.setBug1(i);
					m_View.setBug2(i);
					m_View.setBug3(i);
					
					m_View.setBoss(i);
					m_View.setBossAttack(i);

					synchronized (m_surfaceholder) {
						// 실제 그래픽 처리 부분.
						m_View.onDraw(_canvas);
						i++;

						if (i == 4) {
							i = 1;
						}

						m_View.postInvalidate();
					}
				} finally {// 버퍼 작업이 끝나면
					if (_canvas != null)
					// 버퍼의 내용을 View에 전송
					{
						m_surfaceholder.unlockCanvasAndPost(_canvas);
					}
				}// while
			}
		}// run
	}
}
