package com.example.hw_2;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class PathGameThread extends Thread {

	private SurfaceHolder m_surfaceholder;
	private PathGameView m_View;
	private boolean m_run = false;
	public static boolean isPause = false;

	public PathGameThread(SurfaceHolder surfaceHolder, PathGameView view) {
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
			if (!isPause) {
				_canvas = null;
				_canvas = m_surfaceholder.lockCanvas(null);

				try {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
					m_View.setBlockImg(i);

					synchronized (m_surfaceholder) {
						// ���� �׷��� ó�� �κ�.
						m_View.onDraw(_canvas);
						i++;
						if (i == 3) {
							i = 1;
						}

						m_View.postInvalidate();
					}
				} finally {// ���� �۾��� ������
					if (_canvas != null)
					// ������ ������ View�� ����
					{
						m_surfaceholder.unlockCanvasAndPost(_canvas);
					}
				}
			}
		}
	}
}
