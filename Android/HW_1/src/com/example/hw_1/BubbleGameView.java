package com.example.hw_1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

public class BubbleGameView extends SurfaceView implements
		SurfaceHolder.Callback {
	Display display = ((WindowManager) this.getContext().getSystemService(
			Context.WINDOW_SERVICE)).getDefaultDisplay();

	private int scaleWidth = display.getWidth();
	// 디바이스의 넓이를 가져온다.
	private int scaleHeight = display.getHeight() + 50;
///
	MediaPlayer m_Sound_Effect;
	MediaPlayer m_Sound_Over;

	private BubbleGameThread bubbleThread;

	private Bitmap bubble1;
	private Bitmap bubble2;
	private Bitmap bubble3;

	private Bitmap bubble1_1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bubble1_1);
	private Bitmap bubble1_2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bubble1_2);
	private Bitmap bubble1_3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bubble1_3);

	private Bitmap bubble2_1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bubble2_1);
	private Bitmap bubble2_2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bubble2_2);
	private Bitmap bubble2_3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bubble2_3);

	private Bitmap bubble3_1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bubble3_1);
	private Bitmap bubble3_2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bubble3_2);
	private Bitmap bubble3_3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bubble3_3);
	
	private Bitmap gameEnd = BitmapFactory.decodeResource(getResources(),
			R.drawable.gameover);

	private int[][] count;
	private Rect[][] box_bubble;
	private BubbleState[][] bubble;
	

	/**
	 * Constructor
	 */
	public BubbleGameView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		m_Sound_Effect = MediaPlayer.create(getContext(), R.raw.effectclick);
		m_Sound_Over = MediaPlayer.create(getContext(),R.raw.gameover);
		box_bubble = new Rect[3][3];
		bubble = new BubbleState[3][3];
		count = new int[3][3];
		this.init();
		getHolder().addCallback(this);
		bubbleThread = new BubbleGameThread(getHolder(), this);
	}
	/**
	 * initialize image and variables
	 */
	public void init() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				box_bubble[x][y] = new Rect();
				bubble[x][y] = new BubbleState(BubbleState.STATE_BUBBLE_1);
				count[x][y] = 0;
			}
		}

		bubble1_1 = Bitmap.createScaledBitmap(bubble1_1, scaleWidth / 3,
				scaleHeight / 5, true);
		bubble1_2 = Bitmap.createScaledBitmap(bubble1_2, scaleWidth / 3,
				scaleHeight / 5, true);
		bubble1_3 = Bitmap.createScaledBitmap(bubble1_3, scaleWidth / 3,
				scaleHeight / 5, true);

		bubble2_1 = Bitmap.createScaledBitmap(bubble2_1, scaleWidth / 3,
				scaleHeight / 5, true);
		bubble2_2 = Bitmap.createScaledBitmap(bubble2_2, scaleWidth / 3,
				scaleHeight / 5, true);
		bubble2_3 = Bitmap.createScaledBitmap(bubble2_3, scaleWidth / 3,
				scaleHeight / 5, true);

		bubble3_1 = Bitmap.createScaledBitmap(bubble3_1, scaleWidth / 3,
				scaleHeight / 5, true);
		bubble3_2 = Bitmap.createScaledBitmap(bubble3_2, scaleWidth / 3,
				scaleHeight / 5, true);
		bubble3_3 = Bitmap.createScaledBitmap(bubble3_3, scaleWidth / 3,
				scaleHeight / 5, true);
		
		gameEnd = Bitmap.createScaledBitmap(gameEnd, scaleWidth, scaleHeight,
				true);
	}
	
	/**
	 * moving bubble 1
	 */
	public void setBubble1(int state) {
		if (state == 1) {
			bubble1 = bubble1_1;
		}
		if (state == 2) {
			bubble1 = bubble1_2;
		}
		if (state == 3) {
			bubble1 = bubble1_3;
		}
	}
	/**
	 * moving bubble 2
	 */
	public void setBubble2(int state) {
		if (state == 1) {
			bubble2 = bubble2_1;
		}
		if (state == 2) {
			bubble2 = bubble2_2;
		}
		if (state == 3) {
			bubble2 = bubble2_3;
		}
	}
	/**
	 * moving bubble 3
	 */
	public void setBubble3(int state) {
		if (state == 1) {
			bubble3 = bubble3_1;
		}
		if (state == 2) {
			bubble3 = bubble3_2;
		}
		if (state == 3) {
			bubble3 = bubble3_3;
		}
	}

	/**
	 * this method called by thread every time
	 */
	public void onDraw(Canvas canvas) {
		
		Paint txtOfTitle = new Paint();
		txtOfTitle.setColor(Color.BLUE);
		txtOfTitle.setTextSize(scaleWidth / 6);
		canvas.drawColor(Color.WHITE);
		canvas.drawText(" 뾱뾱이 게임!!",scaleWidth / 60, scaleHeight / 8, txtOfTitle);
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (bubble[x][y].getState() == BubbleState.STATE_BUBBLE_1) {
					canvas.drawBitmap(bubble1, scaleWidth / 3 * x,
							(scaleHeight / 5 * (y + 1)), null);
				}
				if (bubble[x][y].getState() == BubbleState.STATE_BUBBLE_2) {
					canvas.drawBitmap(bubble2, scaleWidth / 3 * x,
							(scaleHeight / 5 * (y + 1)), null);
				}
				if (bubble[x][y].getState() == BubbleState.STATE_BUBBLE_3) {
					canvas.drawBitmap(bubble3, scaleWidth / 3 * x,
							(scaleHeight / 5 * (y + 1)), null);
				}
			}
		}
		this.gameOver(canvas);
	}
	/**
	 * check end of game
	 */
	public void gameOver(Canvas canvas){
		
		Paint over = new Paint();
		over.setColor(Color.BLUE);
		over.setTextSize(scaleWidth/8);
		int countOver=0;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if(bubble[x][y].getState()==BubbleState.STATE_BUBBLE_3)
				{
					countOver++;
				}
				
			}
		}
		if(countOver == 9)
		{
			//BubbleGame test= new BubbleGame();
			canvas.drawBitmap(gameEnd, 0, 0, null);
			m_Sound_Over.start();
		}
	}
	
	/**
	 * touch event method
	 */
	public boolean onTouchEvent(MotionEvent event) {
		int px = (int) event.getX();
		int py = (int) event.getY();

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				box_bubble[x][y].set(scaleWidth / 3 * x, scaleHeight / 5
						* (y + 1), scaleWidth / 3 * x + bubble1.getWidth(),
						scaleHeight / 5 * (y + 1) + bubble1.getHeight());

				if (box_bubble[x][y].contains(px, py)) {

					switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN:
						// mPath.reset();

						break;

					case MotionEvent.ACTION_UP:
						count[x][y]++;
						m_Sound_Effect.start();
						if (count[x][y] == 1) {
							bubble[x][y].setState(BubbleState.STATE_BUBBLE_2);
						} else {
							bubble[x][y].setState(BubbleState.STATE_BUBBLE_3);
						}

						break;
					}
				}
			}

		}
		return true;
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		bubbleThread.setRunning(true);
		bubbleThread.isEnd = false;
		bubbleThread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		boolean retry = true;
		bubbleThread.setRunning(false);

		while (retry) {
			try {
				bubbleThread.join();
				retry = false;
			} catch (InterruptedException e) {

			}
		}

	}

}
