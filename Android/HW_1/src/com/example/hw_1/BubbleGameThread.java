package com.example.hw_1;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class BubbleGameThread extends Thread {
	private SurfaceHolder m_surfaceholder;
	private BubbleGameView m_View;
	private boolean m_run = false;
	public static boolean isEnd = false;

	public BubbleGameThread(SurfaceHolder surfaceHolder, BubbleGameView view) {
		m_surfaceholder = surfaceHolder;
		m_View = view;

	}

	public void setRunning(boolean run) {
		m_run = run;
	}

	@SuppressLint("WrongCall")
	public void run() {
		int i = 1;
		Canvas _canvas;
		while (m_run) {
			if (!isEnd) {
				_canvas = null;
				_canvas = m_surfaceholder.lockCanvas(null);

				try {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
					m_View.setBubble1(i);
					m_View.setBubble2(i);
					m_View.setBubble3(i);
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
				}
			}
		}
	}
}
