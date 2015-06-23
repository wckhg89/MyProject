package com.example.hw_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

public class PathGameView extends SurfaceView implements SurfaceHolder.Callback {
	Display display = ((WindowManager) this.getContext().getSystemService(
			Context.WINDOW_SERVICE)).getDefaultDisplay();

	private int scaleWidth = display.getWidth();
	// 디바이스의 넓이를 가져온다.
	private int scaleHeight = display.getHeight() + 50;

	private PathGameThread pathThread;
	MediaPlayer m_Sound_Over;
	private Bitmap blockImg;
	private Bitmap blockImg1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.block_1);
	private Bitmap blockImg2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.block_2);

	private Bitmap start = BitmapFactory.decodeResource(getResources(),
			R.drawable.start);
	private Bitmap finish = BitmapFactory.decodeResource(getResources(),
			R.drawable.finish);
	private Bitmap gameEnd = BitmapFactory.decodeResource(getResources(),
			R.drawable.gameover);

	private boolean[][] block;
	private boolean[][] visited;

	private Rect[][] start_End;
	private Rect[][] block_rect;
	private int dest_x = 14;
	private int dest_y = 14;

	private boolean startGame = false;
	private Path mPath;
	private Paint mPaint;
	Point mPoint;

	private boolean gameOver;

	/**
	 * constructor
	 */
	public PathGameView(Context context) {
		super(context);
		this.init();
		this.initMap();
		getHolder().addCallback(this);
		pathThread = new PathGameThread(getHolder(), this);
		// TODO Auto-generated constructor stub
	}

	/**
	 * initialize variable and image.
	 */
	public void init() {
		m_Sound_Over = MediaPlayer.create(getContext(), R.raw.gameover);
		startGame = false;

		gameOver = false;
		block = new boolean[15][15];
		block_rect = new Rect[15][15];
		start_End = new Rect[15][15];
		visited = new boolean[15][15];
		blockImg1 = Bitmap.createScaledBitmap(blockImg1, scaleWidth / 15,
				scaleWidth / 15, true);
		blockImg2 = Bitmap.createScaledBitmap(blockImg2, scaleWidth / 15,
				scaleWidth / 15, true);
		start = Bitmap.createScaledBitmap(start, scaleWidth / 15,
				scaleWidth / 15, true);
		finish = Bitmap.createScaledBitmap(finish, scaleWidth / 15,
				scaleWidth / 15, true);
		gameEnd = Bitmap.createScaledBitmap(gameEnd, scaleWidth, scaleHeight,
				true);

		mPath = new Path();
		mPaint = new Paint();
		mPaint.setDither(true);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeJoin(Paint.Join.ROUND);
		mPaint.setStrokeCap(Paint.Cap.ROUND);
		mPaint.setColor(Color.BLUE);
		mPaint.setStrokeWidth(3);
		mPoint = new Point();
	}
	/**
	 * initialize map that 15x15 size
	 */
	public void initMap() {

		for (int x = 0; x < 15; x++) {
			for (int y = 0; y < 15; y++) {
				int num = (int) (Math.random() * 2);
				if (num == 0) {
					block[x][y] = true;
				} else {
					block[x][y] = false;
				}
				block_rect[x][y] = new Rect();
				start_End[x][y] = new Rect();
				visited[x][y] = false;
			}
		}
		block[0][0] = false;
		block[14][14] = false;
	}

	/**
	 * initialize exist path map
	 */
	public boolean initRightPath(int row, int col) {
		if ((row < 0) || (col < 0) || row > dest_x || col > dest_y) {
			return false;
		}
		if (block[row][col] == true || visited[row][col] == true) {
			return false;
		}

		if (row == dest_x && col == dest_y) {
			PathGame.block_chk = true;
			return true;
		}
		visited[row][col] = true;
		try {
			initRightPath(row, col + 1);
			initRightPath(row, col - 1);
			initRightPath(row + 1, col);
			initRightPath(row - 1, col);
		} catch (Exception ArrayIndexOfBoundsException) {
			;// for index out of array.
		}
		return false;

	}

	public void setBlockImg(int state) {
		if (state == 1) {
			blockImg = blockImg1;
		}
		if (state == 2) {
			blockImg = blockImg2;
		}
	}

	/**
	 * called by thread every time
	 */
	public void onDraw(Canvas canvas) {
		canvas.drawColor(Color.WHITE);
		Paint txtOfTitle = new Paint();
		txtOfTitle.setColor(Color.RED);
		txtOfTitle.setTextSize(scaleWidth / 6);
		canvas.drawColor(Color.WHITE);
		canvas.drawText("미로찾기게임!", scaleWidth / 60, scaleHeight / 8, txtOfTitle);

		if (block[0][0] == false) {
			canvas.drawBitmap(start, scaleWidth / 15 * 0, scaleHeight / 26 * 1
					+ scaleHeight / 4, null);
		}
		if (block[14][14] == false) {
			canvas.drawBitmap(finish, scaleWidth / 15 * 14, scaleHeight / 26
					* 15 + scaleHeight / 4, null);
		}

		for (int x = 0; x < 15; x++) {
			for (int y = 0; y < 15; y++) {

				if (block[x][y] == true) {

					canvas.drawBitmap(blockImg, scaleWidth / 15 * x,
							scaleHeight / 26 * (y + 1) + scaleHeight / 4, null);
				}

			}
		}
		canvas.drawPath(mPath, mPaint);
		if (gameOver == true) {
			canvas.drawBitmap(gameEnd, 0, 0, null);
			m_Sound_Over.start();
		}
	}

	public boolean onTouchEvent(MotionEvent event) {
		int px = (int) event.getX();
		int py = (int) event.getY();
		start_End[0][0].set(scaleWidth / 15 * 0, scaleHeight / 26 * 1
				+ scaleHeight / 4, scaleWidth / 15 * 0 + blockImg.getWidth(),
				scaleHeight / 26 * 1 + scaleHeight / 4 + blockImg.getHeight());
		block_rect[14][14].set(scaleWidth / 15 * 14, scaleHeight / 26 * 15
				+ scaleHeight / 4, scaleWidth / 15 * 14 + blockImg.getWidth(),
				scaleHeight / 26 * 15 + scaleHeight / 4 + blockImg.getHeight());

		for (int x = 0; x < 15; x++) {
			for (int y = 0; y < 15; y++) {
				if (block[x][y] == true) {
					block_rect[x][y].set(scaleWidth / 15 * x, scaleHeight / 26
							* (y + 1) + scaleHeight / 4, scaleWidth / 15 * x
							+ blockImg.getWidth(), scaleHeight / 26 * (y + 1)
							+ scaleHeight / 4 + blockImg.getHeight());
				}
				if (start_End[0][0].contains(px, py)) {
					startGame = true;
				}
				if (startGame == true) {
					if (block_rect[x][y].contains(px, py)) {

						gameOver = true;

					} else {
						switch (event.getAction()) {
						case MotionEvent.ACTION_DOWN:
							mPaint.setColor(Color.BLUE);
							mPaint.setStrokeWidth(3);
							mPath.moveTo(px, py);
							break;
						case MotionEvent.ACTION_MOVE:
							mPath.quadTo(px, py, (mPoint.x + px) / 2,
									(mPoint.y + py) / 2);
							break;
						case MotionEvent.ACTION_UP:

							mPath.reset();
							break;
						}
						mPoint.x = px;
						mPoint.y = py;

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
		pathThread.setRunning(true);
		pathThread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		boolean retry = true;
		pathThread.setRunning(false);

		while (retry) {
			try {
				pathThread.join();
				retry = false;
			} catch (InterruptedException e) {

			}
		}
	}

}
