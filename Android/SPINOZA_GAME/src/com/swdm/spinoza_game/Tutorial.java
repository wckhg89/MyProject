package com.swdm.spinoza_game;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.TransitionDrawable;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class Tutorial extends View {

	Bitmap a1;
	int count = 0;
	int eventX, eventY;
	int x, y;

	MediaPlayer m_Sound_Effect;
	// 클릭시 효과음
	MediaPlayer m_Sound_Effect_GetApple;
	// 사과를 얻었을때, 효과음
	MediaPlayer m_Sound_Effect_HealOne;
	// 아이템1효과음 (나무 한그루 체력회복)
	MediaPlayer m_Sound_Effect_HealAll;
	// 아이템2효과음 (모든 나무 체력회복)
	MediaPlayer m_Sound_Effect_Heal;
	// 아이템3효과음 (죽은 나무 살리기)
	MediaPlayer m_Sound_throw;
	// 사과 던지기 효과음

	Resources res = getResources();

	public void init() {
		m_Sound_Effect = MediaPlayer.create(getContext(), R.raw.effectclick);
		m_Sound_Effect_GetApple = MediaPlayer.create(getContext(),
				R.raw.getapple);
		m_Sound_Effect_HealAll = MediaPlayer.create(getContext(),
				R.raw.heal_all_sound);
		m_Sound_Effect_HealOne = MediaPlayer.create(getContext(),
				R.raw.heal_full_sound);
		m_Sound_Effect_Heal = MediaPlayer.create(getContext(), R.raw.heal);
		m_Sound_throw = MediaPlayer.create(getContext(), R.raw.throw_apple);
		// 효과음
		Resources res = getResources();

	}

	public Tutorial(Context c) {
		super(c);
		init();

	}

	public Tutorial(Context c, AttributeSet a) {
		super(c, a);
		init();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		x = this.getWidth();
		y = this.getHeight();
		Bitmap scale;
		if (count == 0) {
			a1 = BitmapFactory.decodeResource(res, R.drawable.aa);
			scale = Bitmap.createScaledBitmap(a1, x, y, false);
			canvas.drawBitmap(scale, 0, 0, null);
		} else if (count == 1) {
			a1 = BitmapFactory.decodeResource(res, R.drawable.bb);
			scale = Bitmap.createScaledBitmap(a1, x, y, false);
			canvas.drawBitmap(scale, 0, 0, null);
		} else if (count == 2) {
			a1 = BitmapFactory.decodeResource(res, R.drawable.cc);
			scale = Bitmap.createScaledBitmap(a1, x, y, false);
			canvas.drawBitmap(scale, 0, 0, null);
		} else if (count == 3) {

			a1 = BitmapFactory.decodeResource(res, R.drawable.dd);
			scale = Bitmap.createScaledBitmap(a1, x, y, false);
			canvas.drawBitmap(scale, 0, 0, null);

		} else if (count == 4) {
			a1 = BitmapFactory.decodeResource(res, R.drawable.ee);
			scale = Bitmap.createScaledBitmap(a1, x, y, false);
			canvas.drawBitmap(scale, 0, 0, null);
		} else if (count == 5) {
			a1 = BitmapFactory.decodeResource(res, R.drawable.ff);
			scale = Bitmap.createScaledBitmap(a1, x, y, false);
			canvas.drawBitmap(scale, 0, 0, null);

		} else if (count == 6) {
			a1 = BitmapFactory.decodeResource(res, R.drawable.gg);
			scale = Bitmap.createScaledBitmap(a1, x, y, false);
			canvas.drawBitmap(scale, 0, 0, null);
		} else if (count == 7) {
			a1 = BitmapFactory.decodeResource(res, R.drawable.hh);
			scale = Bitmap.createScaledBitmap(a1, x, y, false);
			canvas.drawBitmap(scale, 0, 0, null);
		} else if (count == 8) {
			a1 = BitmapFactory.decodeResource(res, R.drawable.ii);
			scale = Bitmap.createScaledBitmap(a1, x, y, false);
			canvas.drawBitmap(scale, 0, 0, null);
		} else if (count == 9) {
			a1 = BitmapFactory.decodeResource(res, R.drawable.jj);
			scale = Bitmap.createScaledBitmap(a1, x, y, false);
			canvas.drawBitmap(scale, 0, 0, null);
		} else if (count == 10) {
			a1 = BitmapFactory.decodeResource(res, R.drawable.kk);
			scale = Bitmap.createScaledBitmap(a1, x, y, false);
			canvas.drawBitmap(scale, 0, 0, null);
		} else if (count == 11) {
			a1 = BitmapFactory.decodeResource(res, R.drawable.ll);
			scale = Bitmap.createScaledBitmap(a1, x, y, false);
			canvas.drawBitmap(scale, 0, 0, null);
		} else if (count == 12) {
			a1 = BitmapFactory.decodeResource(res, R.drawable.mm);
			scale = Bitmap.createScaledBitmap(a1, x, y, false);
			canvas.drawBitmap(scale, 0, 0, null);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		eventX = (int) event.getX();
		eventY = (int) event.getY();
		System.out.println(x + " " + y);
		if (event.getAction() == MotionEvent.ACTION_UP) {
			if (count == 0) {
				if (eventX >= x * 2 / 3 && eventY >= y / 5 && eventX < x
						&& eventY < y * 2 / 5){
					count++;
					m_Sound_Effect_GetApple.start();
				}
				invalidate();
			} else if (count == 1) {
				count++;
				invalidate();
			} else if (count == 2) {
				if (eventX >= x * 2 / 3 && eventY >= y / 12
						&& eventX < x * 3 / 4 && eventY < y * 2 / 9){
						count++;
						m_Sound_Effect_HealOne.start();
				}
				invalidate();
			} else if (count == 3) {
				count++;
				invalidate();
			} else if (count == 4) {
				count++;
				invalidate();
			} else if (count == 5) {
				if (eventX >= x * 3 / 4 && eventY >= y / 12
						&& eventX < x * 20 / 23 && eventY < y * 2 / 9) {
					count++;
					m_Sound_Effect_HealAll.start();
				}
				invalidate();
			} else if (count == 6) {
				count++;
				invalidate();
			} else if (count == 7) {
				count++;
				invalidate();
			} else if (count == 8) {
				if (eventX >= x * 20 / 23 && eventY >= y / 12
						&& eventX < x - 10 && eventY < y * 2 / 9) {
					m_Sound_Effect_Heal.start();
					count++;
				}
				invalidate();
			} else if (count == 9) {
				count++;
				invalidate();
			} else if (count == 10) {
				count++;
				invalidate();
			} else if (count == 11) {
				if (eventX >= x * 11 / 12 && eventY >= y * 179 / 190
						&& eventX < x && eventY < y) {
					count++;
					m_Sound_throw.start();
				}
				invalidate();
			} else if (count == 12) {
				AlertDialog myQuittingDialogBox = createDialogBox();
				myQuittingDialogBox.show();
			}
		}
		return true;
	}

	public AlertDialog createDialogBox() {
		AlertDialog myQuittingDialogBox = new AlertDialog.Builder(getContext())
		// set message, title, and icon
				.setTitle("수고하셨습니다!").setMessage("튜토리얼 모드 끝 ! 튜토리얼 다시 할래요?")
				// set three option buttons
				.setPositiveButton("네", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// whatever should be done when answering "YES" goes
						// here
						new Tutorial(null);
					}
				})// setPositiveButton
				.setNegativeButton("아니요",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// whatever should be done when answering "NO"
								// goes here
								System.exit(0);
							}
						})// setNegativeButton
				.create();
		return myQuittingDialogBox;
	}

}