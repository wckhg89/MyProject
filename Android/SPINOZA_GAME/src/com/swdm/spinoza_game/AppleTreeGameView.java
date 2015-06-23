package com.swdm.spinoza_game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

public class AppleTreeGameView extends SurfaceView implements
		SurfaceHolder.Callback {
	public boolean isOver = false;
	Display display = ((WindowManager) this.getContext().getSystemService(
			Context.WINDOW_SERVICE)).getDefaultDisplay();

	private int scaleWidth = display.getWidth();
	// 디바이스의 넓이를 가져온다.
	private int scaleHeight = display.getHeight() + 50;
	// 디바이스의 높이를 가져온다.

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
	MediaPlayer m_Sound_Level_Up;
	// 난이도 상승 효과음
	MediaPlayer m_Sound_Effect_GameOver;
	// 게임오버 효과음
	MediaPlayer m_Sound_Effect_Damage;
	// 벌레없는 나무 클릭시 효과음
	MediaPlayer m_Sound_attack;
	// 보스 공격 효과음
	MediaPlayer m_Sound_throw;
	// 사과 던지기 효과음
	MediaPlayer m_Sound_boss_dam;
	// 보스 사과 맞았을때, 효과음
	MediaPlayer m_Sound_boss_die;
	// 보스 죽었을때, 효과음

	/*
	 * 사과나무동작
	 */
	private static final int TREE_STATE_1 = 1;
	private static final int TREE_STATE_2 = 2;
	private static final int TREE_STATE_3 = 3;
	// 사과나무의 동작 상태 3가지
	private static final int TREE_STATE_MID1 = 1;
	private static final int TREE_STATE_MID2 = 2;
	private static final int TREE_STATE_MID3 = 3;
	// 사과나무의 동작 상태 3가지(중간에너지)
	private static final int TREE_STATE_LOW1 = 1;
	private static final int TREE_STATE_LOW2 = 2;
	private static final int TREE_STATE_LOW3 = 3;
	// 사과나무의 동작 상태 3가지(낮은에너지)

	private static final int PEOPLE_STATE_1 = 1;
	private static final int PEOPLE_STATE_2 = 2;
	private static final int PEOPLE_STATE_3 = 3;
	// 클릭시 사과나무 상태 3가지(에너지 많은 나무)
	private static final int PEOPLE_STATE_MID1 = 1;
	private static final int PEOPLE_STATE_MID2 = 2;
	private static final int PEOPLE_STATE_MID3 = 3;
	// 클릭시 사과나무 상태 3가지(중간에너지)

	/*
	 * 아이템 동작
	 */
	private static final int HEALONE_STATE_1 = 1;
	private static final int HEALONE_STATE_2 = 2;
	private static final int HEALONE_STATE_3 = 3;
	// 아이템1(나무 1그루 체력 회복)의 동작 3가지
	private static final int HEALALL_STATE_1 = 1;
	private static final int HEALALL_STATE_2 = 2;
	private static final int HEALALL_STATE_3 = 3;
	// 아이템2(모든나무 체력 회복)의 동작 3가지

	private static final int HEAL_STATE_1 = 1;
	private static final int HEAL_STATE_2 = 2;
	private static final int HEAL_STATE_3 = 3;
	// 아이템3(죽은나무 살리기)의 동작 3가지

	/*
	 * 하단에 움직이는 사람 동작
	 */
	private static final int PEOPLE_RIGHT_1 = 1;
	private static final int PEOPLE_RIGHT_2 = 2;
	private static final int PEOPLE_RIGHT_3 = 3;
	// 우측으로 움직이는 사람 동작 3가지
	private static final int PEOPLE_LEFT_1 = 1;
	private static final int PEOPLE_LEFT_2 = 2;
	private static final int PEOPLE_LEFT_3 = 3;
	// 좌측으로 움직이는 사람 동작 3가지
	private static final int BALLON_STATE_1 = 1;
	private static final int BALLON_STATE_2 = 2;
	private static final int BALLON_STATE_3 = 3;
	// 땀방울 동작 3가지
	private static final int PEOPLE_BOSS_1 = 1;
	private static final int PEOPLE_BOSS_2 = 2;
	private static final int PEOPLE_BOSS_3 = 3;
	// 보스출현시 사람의 동작 3가지
	private static final int BALLON_BOSS_1 = 1;
	private static final int BALLON_BOSS_2 = 2;
	private static final int BALLON_BOSS_3 = 3;
	// 보스출현시 느낌표 말풍선 동작 3가지
	private static final int BUTTON_ATTACK_1 = 1;
	private static final int BUTTON_ATTACK_2 = 2;
	private static final int BUTTON_ATTACK_3 = 3;
	// 보스출현시 사과던지기 버튼 동작 3가지

	/*
	 * 3가지 종류의 벌레 동작 3가지
	 */
	private static final int BUG1_STATE_1 = 1;
	private static final int BUG1_STATE_2 = 2;
	private static final int BUG1_STATE_3 = 3;
	// 1번클릭 벌레 동작 3가지
	private static final int BUG2_STATE_1 = 1;
	private static final int BUG2_STATE_2 = 2;
	private static final int BUG2_STATE_3 = 3;
	// 3번클릭 벌레 동작 3가지
	private static final int BUG3_STATE_1 = 1;
	private static final int BUG3_STATE_2 = 2;
	private static final int BUG3_STATE_3 = 3;
	// 5번클릭 벌레 동작 3가지

	/*
	 * 보스 동작
	 */
	private static final int BOSS_STATE_1 = 1;
	private static final int BOSS_STATE_2 = 2;
	private static final int BOSS_STATE_3 = 3;
	// 보스 몬스터 동작 3가지
	private static final int BOSS_ATTACK_1 = 1;
	private static final int BOSS_ATTACK_2 = 2;
	private static final int BOSS_ATTACK_3 = 3;
	// 보스 공격시 효과 동작 3가지

	private AppleTreeThread movingTree;
	// 쓰레드 객체

	private Bitmap tree;
	private Bitmap people;
	// 보통나무
	private Bitmap treeMid;
	private Bitmap peopleMid;
	// 중간 에너지 나무
	private Bitmap treeLow;
	// 적은 에너지 나무

	private Bitmap heal_one;
	// 아이템 1
	private Bitmap heal_all;
	// 아이템 2
	private Bitmap heal;
	// 아이템 3

	private Bitmap peopleR;
	// 우측 사람
	private Bitmap peopleL;
	// 좌측 사람
	private Bitmap ballon;
	// 땀방울
	private Bitmap people_boss;
	// 보스출현시 사람
	private Bitmap ballon_boss;
	// 보스출현시 땀방울
	private Bitmap button;
	// 사과던지기 버튼

	private Bitmap bug1;
	// 벌레1
	private Bitmap bug2;
	// 벌레2
	private Bitmap bug3;
	// 벌레3

	private Bitmap boss;
	// 보스 몬스터
	private Bitmap boss_attack;
	// 보스 몬스터 공격

	private Bitmap ranking = BitmapFactory.decodeResource(getResources(),
			R.drawable.ranking);
	private Bitmap exit = BitmapFactory.decodeResource(getResources(),
			R.drawable.exit);

	private Bitmap backGround = BitmapFactory.decodeResource(getResources(),
			R.drawable.background_image);
	// 배경 화면

	private Bitmap tree1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree);
	private Bitmap tree2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree2);
	private Bitmap tree3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree3);
	// 일반 나무
	private Bitmap treeMid1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree_mid);
	private Bitmap treeMid2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree_mid2);
	private Bitmap treeMid3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree_mid3);
	// 중간 에너지 나무
	private Bitmap treeLow1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree_low);
	private Bitmap treeLow2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree_low2);
	private Bitmap treeLow3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree_low3);
	// 낮은 에너지 나무

	private Bitmap people1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people);
	private Bitmap people2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people2);
	private Bitmap people3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people3);
	// 클릭시 나무(평상시 에너지)
	private Bitmap peopleMid1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_mid);
	private Bitmap peopleMid2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_mid2);
	private Bitmap peopleMid3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_mid3);
	// 클릭시 나무(중간 에너지)

	private Bitmap apple = BitmapFactory.decodeResource(getResources(),
			R.drawable.apple);
	// 사과
	private Bitmap apple_throw = BitmapFactory.decodeResource(getResources(),
			R.drawable.apple_throw);

	private Bitmap item1A = BitmapFactory.decodeResource(getResources(),
			R.drawable.item1_a);
	private Bitmap item1D = BitmapFactory.decodeResource(getResources(),
			R.drawable.item1_d);
	// 하나 에너지 풀
	private Bitmap item2A = BitmapFactory.decodeResource(getResources(),
			R.drawable.item2_a);
	private Bitmap item2D = BitmapFactory.decodeResource(getResources(),
			R.drawable.item2_d);
	// 전체 에너지 증가
	private Bitmap item3A = BitmapFactory.decodeResource(getResources(),
			R.drawable.item3_a);
	private Bitmap item3D = BitmapFactory.decodeResource(getResources(),
			R.drawable.item3_d);
	// 죽은나무 살리기

	private Bitmap heal_one1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal_full1);
	private Bitmap heal_one2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal_full1);
	private Bitmap heal_one3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal_full1);
	// 나무 하나 체력가득체우는 임펙트
	private Bitmap heal_all1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal_all1);
	private Bitmap heal_all2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal_all2);
	private Bitmap heal_all3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal_all3);
	// 전체나무 체력회과 임팩트
	private Bitmap heal1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal1);
	private Bitmap heal2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal2);
	private Bitmap heal3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal3);
	// 살리기 임팩트효과
	private Bitmap gameOver = BitmapFactory.decodeResource(getResources(),
			R.drawable.gameover);

	private Bitmap peopleR1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_right1);
	private Bitmap peopleR2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_right2);
	private Bitmap peopleR3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_right3);
	// 우측사람 이미지
	private Bitmap peopleL1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_left1);
	private Bitmap peopleL2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_left2);
	private Bitmap peopleL3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_left3);
	// 좌측사람 이미지
	private Bitmap ballon1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.ballon1);
	private Bitmap ballon2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.ballon2);
	private Bitmap ballon3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.ballon3);
	// 땀방울 이미지
	private Bitmap people_boss1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_boss1);
	private Bitmap people_boss2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_boss2);
	private Bitmap people_boss3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_boss3);
	// 보스 몬스터 출현시 사람이미지
	private Bitmap ballon_boss1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.ballon_boss1);
	private Bitmap ballon_boss2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.ballon_boss2);
	private Bitmap ballon_boss3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.ballon_boss3);
	// 보스 몬스터 출현시 말풍선 이미지
	private Bitmap button_attack_1 = BitmapFactory.decodeResource(
			getResources(), R.drawable.button1);
	private Bitmap button_attack_2 = BitmapFactory.decodeResource(
			getResources(), R.drawable.button2);
	private Bitmap button_attack_3 = BitmapFactory.decodeResource(
			getResources(), R.drawable.button3);
	// 사과더지기 버튼 이미지
	private Bitmap basket = BitmapFactory.decodeResource(getResources(),
			R.drawable.basket);
	// 사과바구니 이미지
	private Bitmap manyApple = BitmapFactory.decodeResource(getResources(),
			R.drawable.many_apple);
	// 쌓여있는 사과 이미지
	private Bitmap bug1_1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug1_1);
	private Bitmap bug1_2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug1_2);
	private Bitmap bug1_3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug1_3);
	// 벌레1 이미지
	private Bitmap bug2_1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug2_1);
	private Bitmap bug2_2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug2_2);
	private Bitmap bug2_3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug2_3);
	// 벌레2 이미지
	private Bitmap bug3_1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug3_1);
	private Bitmap bug3_2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug3_2);
	private Bitmap bug3_3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug3_3);
	// 벌레3 이미지

	private Bitmap boss1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.boss1);
	private Bitmap boss2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.boss2);
	private Bitmap boss3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.boss3);
	// 보스 몬스터 이미지

	private Bitmap boss_attack1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.boss_attack1);
	private Bitmap boss_attack2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.boss_attack2);
	private Bitmap boss_attack3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.boss_attack3);
	// 보스 몬스터 공격 이미지
	private Bitmap boss_damage = BitmapFactory.decodeResource(getResources(),
			R.drawable.boss_dam);
	// 보스몬스터 사과 맞았을때 이미지
	private Bitmap level = BitmapFactory.decodeResource(getResources(),
			R.drawable.level);
	// 난이도 상승 이미지
	private Rect[] box_Item;
	// 아이템 클릭을 위한 사각형
	private Rect[] gameOverBtn;
	private Rect[][] box_Tree;
	// 사과 나무 클릭을 위한 사각형
	private AppleTree[][] arrayTree;
	// 나무 상태를 표시하기 위해 각각의 객체 따로 생성
	private AppleTree[][] prevTree;
	// 사과나무 비트맵을 저장할 공간 ,클릭이 가능한 나무의 지역을 각각 지정합니다.

	private Paint[][] Pnt;
	// 체력바를 그리기위한 페인트 객체입니다.
	private float[][] HP;
	// 9개의 나무의 체력을 각기 표시합니다.
	private boolean[][] fullEnergy;
	// 에너지가 꽉찻는지 아닌지 확인합니다.
	private boolean[][] lowEnergy;
	// 에너지가 다 달은 죽은 나무인지 확인합니다.
	private boolean[][] midEnergy;
	// 에너지가 중간이하로 내려간 나무인지 확인합니다.
	private boolean[] itemAvailable;
	private boolean[] itemUse;
	private boolean saveApple = false;
	// 사과를 땃는지 유무를 체크합니다.
	private int numOfApple;
	// 총 얻은 사과의 갯수를 표시합니다.
	public static long currentTime = 0;
	public static long sumOfTime = 0;
	public static long sumOfBossTime = 0;
	public static long startTime = 0;
	public static long bossStartTime = 0;
	public static long timeOfMin = 0;
	public static long bossTime = 0;
	// public int timeOfSec = 0;
	// 시간
	public static int recordMin;
	public static int recordSec;
	// 기록 시간

	private int peopleRPosX = 0;
	private int peopleLPosX = scaleWidth / 2 + scaleWidth / 3;
	// 하단에 움직이는 사람을 위한 변수
	private int bossPosRX = 0;
	private int bossPosLX = scaleWidth / 2 + scaleWidth / 7;
	private boolean bossAppear = false;
	private int bossHP = 5;
	// 보스몬스터를 위한 변수
	private Rect buttonApple;
	private int attackDelay = 10;
	private boolean throwApple = false;
	private int throwApplePos = 0;
	private int throwInitPos = 0;
	// 던지는 사과를 위한 변수
	private int[][] bugState;
	private int[][] bugCount;
	private int[][] bugDelay;

	// 벌레의 상태를 나타내는 변수

	/**
	 * 생성자로써 변수와 이미지들을 초기화 해주며, surfaceView를 이용하기 위한 객체를 생성합니다.
	 */
	public AppleTreeGameView(Context context) {
		// 생성자
		super(context);
		this.initVariable();
		// 변수 초기화
		this.initImage();
		// 이미지 초기화

		getHolder().addCallback(this);
		movingTree = new AppleTreeThread(getHolder(), this);
		// surfaceView를 위한 객체들.
	}

	/**
	 * 생성자에서 호출되는 helper메소드로써 변수를 초기화합니다.
	 */
	private void initVariable() {
		isOver = false;
		sumOfTime = 0;
		sumOfBossTime = 0;
		startTime = System.currentTimeMillis();
		bossStartTime = System.currentTimeMillis();
		m_Sound_Effect = MediaPlayer.create(getContext(), R.raw.effectclick);
		m_Sound_Effect_GetApple = MediaPlayer.create(getContext(),
				R.raw.getapple);
		m_Sound_Effect_HealAll = MediaPlayer.create(getContext(),
				R.raw.heal_all_sound);
		m_Sound_Effect_HealOne = MediaPlayer.create(getContext(),
				R.raw.heal_full_sound);
		m_Sound_Effect_Heal = MediaPlayer.create(getContext(), R.raw.heal);
		// 효과음
		m_Sound_Effect_GameOver = MediaPlayer.create(getContext(),
				R.raw.gameover);

		m_Sound_Effect_Damage = MediaPlayer.create(getContext(), R.raw.damage);
		m_Sound_Level_Up = MediaPlayer.create(getContext(), R.raw.levelup);
		m_Sound_attack = MediaPlayer.create(getContext(), R.raw.attack);
		m_Sound_throw = MediaPlayer.create(getContext(), R.raw.throw_apple);
		m_Sound_boss_dam = MediaPlayer.create(getContext(), R.raw.boss_damage);
		m_Sound_boss_die = MediaPlayer.create(getContext(), R.raw.boss_die);
		numOfApple = 0;
		// 총 사과 갯수.
		arrayTree = new AppleTree[3][3];
		prevTree = new AppleTree[3][3];
		// 9개의 나무를 담기위한 객체
		box_Tree = new Rect[3][3];
		box_Item = new Rect[3];
		gameOverBtn = new Rect[2];
		itemAvailable = new boolean[3];
		itemUse = new boolean[3];
		// 9개의 사각형 클릭을 위해서
		// 사과나무의 상태 초기화.

		Pnt = new Paint[3][3];
		// 9개의 나무의 에너지바 속성
		HP = new float[3][3];
		// 9개의 나무의 에너지양
		fullEnergy = new boolean[3][3];
		midEnergy = new boolean[3][3];
		lowEnergy = new boolean[3][3];
		// 9개나무의 에너지 상태(나무 상태표시를 위한변수)

		bugState = new int[3][3];
		bugCount = new int[3][3];
		bugDelay = new int[3][3];
		bossAppear = false;
		attackDelay = 10;
		buttonApple = new Rect();
		throwApple = false;
		throwApplePos = 0;

		this.setBugState();
		this.setItemBox();
		this.setAppleTree();
		this.setEnergy();
	}

	/**
	 * 생성자에서 호출되는 helper메소드로써 이미지를 초기화합니다.
	 */
	private void initImage() {
		backGround = Bitmap.createScaledBitmap(backGround, scaleWidth,
				scaleHeight, true);

		tree1 = Bitmap.createScaledBitmap(tree1, scaleWidth / 3,
				scaleHeight / 5, true);
		tree2 = Bitmap.createScaledBitmap(tree2, scaleWidth / 3,
				scaleHeight / 5, true);
		tree3 = Bitmap.createScaledBitmap(tree3, scaleWidth / 3,
				scaleHeight / 5, true);
		// 보통 상태의 나무 이미지(에너지 반이상)
		treeMid1 = Bitmap.createScaledBitmap(treeMid1, scaleWidth / 3,
				scaleHeight / 5, true);
		treeMid2 = Bitmap.createScaledBitmap(treeMid2, scaleWidth / 3,
				scaleHeight / 5, true);
		treeMid3 = Bitmap.createScaledBitmap(treeMid3, scaleWidth / 3,
				scaleHeight / 5, true);
		treeLow1 = Bitmap.createScaledBitmap(treeLow1, scaleWidth / 3,
				scaleHeight / 5, true);
		treeLow2 = Bitmap.createScaledBitmap(treeLow2, scaleWidth / 3,
				scaleHeight / 5, true);
		treeLow3 = Bitmap.createScaledBitmap(treeLow3, scaleWidth / 3,
				scaleHeight / 5, true);
		// 비실한 나무 이미지(에너지 반 이하)

		people1 = Bitmap.createScaledBitmap(people1, scaleWidth / 3,
				scaleHeight / 5, true);
		people2 = Bitmap.createScaledBitmap(people2, scaleWidth / 3,
				scaleHeight / 5, true);
		people3 = Bitmap.createScaledBitmap(people3, scaleWidth / 3,
				scaleHeight / 5, true);
		// 보통의 나무(클릭시 나타나는 이미지)(에너지 반이상)
		peopleMid1 = Bitmap.createScaledBitmap(peopleMid1, scaleWidth / 3,
				scaleHeight / 5, true);
		peopleMid2 = Bitmap.createScaledBitmap(peopleMid2, scaleWidth / 3,
				scaleHeight / 5, true);
		peopleMid3 = Bitmap.createScaledBitmap(peopleMid3, scaleWidth / 3,
				scaleHeight / 5, true);
		// 비실한 나무 (클릭시 나타나는 이미지)(에너지 반이하)
		heal_one1 = Bitmap.createScaledBitmap(heal_one1, scaleWidth / 3,
				scaleHeight / 5, true);
		heal_one2 = Bitmap.createScaledBitmap(heal_one2, scaleWidth / 3,
				scaleHeight / 5, true);
		heal_one3 = Bitmap.createScaledBitmap(heal_one3, scaleWidth / 3,
				scaleHeight / 5, true);
		heal_all1 = Bitmap.createScaledBitmap(heal_all1, scaleWidth / 3,
				scaleHeight / 5, true);
		heal_all2 = Bitmap.createScaledBitmap(heal_all2, scaleWidth / 3,
				scaleHeight / 5, true);
		heal_all3 = Bitmap.createScaledBitmap(heal_all3, scaleWidth / 3,
				scaleHeight / 5, true);
		heal1 = Bitmap.createScaledBitmap(heal1, scaleWidth / 3,
				scaleHeight / 5, true);
		heal2 = Bitmap.createScaledBitmap(heal2, scaleWidth / 3,
				scaleHeight / 5, true);
		heal3 = Bitmap.createScaledBitmap(heal3, scaleWidth / 3,
				scaleHeight / 5, true);

		item1A = Bitmap.createScaledBitmap(item1A, scaleWidth / 10,
				scaleHeight / 15, true);
		item2A = Bitmap.createScaledBitmap(item2A, scaleWidth / 10,
				scaleHeight / 15, true);
		item3A = Bitmap.createScaledBitmap(item3A, scaleWidth / 10,
				scaleHeight / 15, true);

		item1D = Bitmap.createScaledBitmap(item1D, scaleWidth / 10,
				scaleHeight / 15, true);
		item2D = Bitmap.createScaledBitmap(item2D, scaleWidth / 10,
				scaleHeight / 15, true);
		item3D = Bitmap.createScaledBitmap(item3D, scaleWidth / 10,
				scaleHeight / 15, true);

		// gameOver = Bitmap.createScaledBitmap(gameOver, scaleWidth,
		// scaleHeight,
		// true);

		peopleR1 = Bitmap.createScaledBitmap(peopleR1, scaleWidth / 12,
				scaleHeight / 17, true);
		peopleR2 = Bitmap.createScaledBitmap(peopleR2, scaleWidth / 12,
				scaleHeight / 17, true);
		peopleR3 = Bitmap.createScaledBitmap(peopleR3, scaleWidth / 12,
				scaleHeight / 17, true);

		peopleL1 = Bitmap.createScaledBitmap(peopleL1, scaleWidth / 12,
				scaleHeight / 17, true);
		peopleL2 = Bitmap.createScaledBitmap(peopleL2, scaleWidth / 12,
				scaleHeight / 17, true);
		peopleL3 = Bitmap.createScaledBitmap(peopleL3, scaleWidth / 12,
				scaleHeight / 17, true);

		people_boss1 = Bitmap.createScaledBitmap(people_boss1, scaleWidth / 12,
				scaleHeight / 17, true);
		people_boss2 = Bitmap.createScaledBitmap(people_boss2, scaleWidth / 12,
				scaleHeight / 17, true);
		people_boss3 = Bitmap.createScaledBitmap(people_boss3, scaleWidth / 12,
				scaleHeight / 17, true);

		button_attack_1 = Bitmap.createScaledBitmap(button_attack_1,
				scaleWidth / 12, scaleHeight / 17, true);
		button_attack_2 = Bitmap.createScaledBitmap(button_attack_2,
				scaleWidth / 12, scaleHeight / 17, true);
		button_attack_3 = Bitmap.createScaledBitmap(button_attack_3,
				scaleWidth / 12, scaleHeight / 17, true);

		bug1_1 = Bitmap.createScaledBitmap(bug1_1, scaleWidth / 8,
				scaleHeight / 12, true);
		bug1_2 = Bitmap.createScaledBitmap(bug1_2, scaleWidth / 8,
				scaleHeight / 12, true);
		bug1_3 = Bitmap.createScaledBitmap(bug1_3, scaleWidth / 8,
				scaleHeight / 12, true);

		bug2_1 = Bitmap.createScaledBitmap(bug2_1, scaleWidth / 8,
				scaleHeight / 12, true);
		bug2_2 = Bitmap.createScaledBitmap(bug2_2, scaleWidth / 8,
				scaleHeight / 12, true);
		bug2_3 = Bitmap.createScaledBitmap(bug2_3, scaleWidth / 8,
				scaleHeight / 12, true);

		bug3_1 = Bitmap.createScaledBitmap(bug3_1, scaleWidth / 8,
				scaleHeight / 12, true);
		bug3_2 = Bitmap.createScaledBitmap(bug3_2, scaleWidth / 8,
				scaleHeight / 12, true);
		bug3_3 = Bitmap.createScaledBitmap(bug3_3, scaleWidth / 8,
				scaleHeight / 12, true);

		boss1 = Bitmap.createScaledBitmap(boss1, scaleWidth / 3,
				scaleHeight / 7, true);
		boss2 = Bitmap.createScaledBitmap(boss2, scaleWidth / 3,
				scaleHeight / 7, true);
		boss3 = Bitmap.createScaledBitmap(boss3, scaleWidth / 3,
				scaleHeight / 7, true);

		boss_attack1 = Bitmap.createScaledBitmap(boss_attack1, scaleWidth / 3,
				scaleHeight / 5, true);
		boss_attack2 = Bitmap.createScaledBitmap(boss_attack2, scaleWidth / 3,
				scaleHeight / 5, true);
		boss_attack3 = Bitmap.createScaledBitmap(boss_attack3, scaleWidth / 3,
				scaleHeight / 5, true);

		level = Bitmap.createScaledBitmap(level, scaleWidth / 1,
				scaleHeight / 4, true);
	}

	/**
	 * 9개의 사과나무를 위한 객체생성과 클릭을 위한 사각형 영역을 위한 객체를 생성해주는 helper메소드 입니다.
	 */
	private void setItemBox() {
		gameOverBtn[0] = new Rect();
		gameOverBtn[1] = new Rect();
		for (int i = 0; i < 3; i++) {
			box_Item[i] = new Rect();
			itemAvailable[i] = false;
			itemUse[i] = false;

		}
	}

	/**
	 * 사과나무들의 상태를 초기화 시켜주는 메소드입니다.
	 */
	private void setAppleTree() {
		// 초기 나무의 상태를 클릭이 일어나지 않음으로 설정, 초기 사과나무의 박스를 설정.
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arrayTree[i][j] = new AppleTree(AppleTree.STATE_CLICK_OFF);
				prevTree[i][j] = new AppleTree(AppleTree.STATE_CLICK_OFF);
				box_Tree[i][j] = new Rect();
				bugDelay[i][j] = 10;
			}
		}
	}

	/**
	 * 초기의 벌레상태를 초기화 합니다.
	 */
	private void setBugState() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int x = (int) (Math.random() * 2.0);
				bugState[i][j] = x;

				if (bugState[i][j] == 0) {
					bugCount[i][j] = 0;
				}
				if (bugState[i][j] == 1) {
					bugCount[i][j] = 1;
				}
			}
		}
	}

	/**
	 * 벌레가 붙어있지 않은 사과나무에 벌레를 붙입니다.
	 */
	private void setEmptyBug() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (bugState[x][y] == 0 && bugDelay[x][y]==0) {

					if (timeOfMin >= 0 && timeOfMin < 20) {
						int i = (int) (Math.random() * 2.0);
						bugState[x][y] = i;
					} else if (timeOfMin >= 20 && timeOfMin < 40) {
						int i = (int) (Math.random() * 3.0);

						bugState[x][y] = i;
					} else if (timeOfMin >= 40) {
						int i = (int) (Math.random() * 4.0);

						bugState[x][y] = i;
					}
					if (bugState[x][y] == 0) {
						bugCount[x][y] = 0;
					}
					if (bugState[x][y] == 1) {
						bugCount[x][y] = 1;
					}
					if (bugState[x][y] == 2) {
						bugCount[x][y] = 3;
					}
					if (bugState[x][y] == 3) {
						bugCount[x][y] = 5;
					}
				}
			}
		}
	}

	/**
	 * 9개의 사과나무의 에너지바를 위한 객체생성과 에너지에 따른 나무 모양을 위한 boolean변수를 초기화하는 helper
	 * 메소드입니다.
	 */
	public void setEnergy() {
		// 초기 사과나무의 에너지바를 생성.
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Pnt[i][j] = new Paint();
				HP[i][j] = scaleWidth / 15;
				fullEnergy[i][j] = false;
				lowEnergy[i][j] = false;
				midEnergy[i][j] = false;
			}
		}
	}

	/**
	 * 아이템1 효과의 움직임을 위한 메소드입니다.
	 */
	public void setItem1(int state) {
		if (HEALONE_STATE_1 == state) {
			heal_one = heal_one1;
		}
		if (HEALONE_STATE_2 == state) {
			heal_one = heal_one2;
		}
		if (HEALONE_STATE_3 == state) {
			heal_one = heal_one3;
		}
	}

	/**
	 * 아이템2의 움직임을 위한 메소드입니다.
	 */
	public void setItem2(int state) {
		if (HEALALL_STATE_1 == state) {
			heal_all = heal_all1;
		}
		if (HEALALL_STATE_2 == state) {
			heal_all = heal_all2;
		}
		if (HEALALL_STATE_3 == state) {
			heal_all = heal_all3;
		}
	}

	/**
	 * 아이템3 효과의 움직임을 위한 메소드입니다.
	 */
	public void setHeal(int state) {
		if (HEAL_STATE_1 == state) {
			heal = heal1;
		}
		if (HEAL_STATE_2 == state) {
			heal = heal2;
		}
		if (HEAL_STATE_3 == state) {
			heal = heal3;
		}
	}

	/**
	 * 하단에 우측으로 이동하는 사람의 움직임을 위한 메소드
	 */
	public void setPeopleR(int state) {
		if (PEOPLE_RIGHT_1 == state) {
			peopleR = peopleR1;
		}
		if (PEOPLE_RIGHT_2 == state) {
			peopleR = peopleR2;
		}
		if (PEOPLE_RIGHT_3 == state) {
			peopleR = peopleR3;
		}
	}

	/**
	 * 하단에 좌측으로 이동하는 사람의 움직임을 위한 메소드
	 */
	public void setPeopleL(int state) {
		if (PEOPLE_LEFT_1 == state) {
			peopleL = peopleL1;
		}
		if (PEOPLE_LEFT_2 == state) {
			peopleL = peopleL2;
		}
		if (PEOPLE_LEFT_3 == state) {
			peopleL = peopleL3;
		}
	}

	/**
	 * 땀방울의 움직임을 위한 메소드
	 */
	public void setBallon(int state) {

		if (BALLON_STATE_1 == state) {
			ballon = ballon1;
		}
		if (BALLON_STATE_2 == state) {
			ballon = ballon2;
		}
		if (BALLON_STATE_3 == state) {
			ballon = ballon3;
		}
	}

	/**
	 * 보스 출현시 사람의 움직임을 위한 메소드
	 */
	public void setPeopleBoss(int state) {
		if (PEOPLE_BOSS_1 == state) {
			people_boss = people_boss1;
		}
		if (PEOPLE_BOSS_2 == state) {
			people_boss = people_boss2;
		}
		if (PEOPLE_BOSS_3 == state) {
			people_boss = people_boss3;
		}
	}

	/**
	 * 보스 출현시 말풍선의 움직임을 위한 메소드
	 */
	public void setBallonBoss(int state) {
		if (BALLON_BOSS_1 == state) {
			ballon_boss = ballon_boss1;
		}
		if (BALLON_BOSS_2 == state) {
			ballon_boss = ballon_boss2;
		}
		if (BALLON_BOSS_3 == state) {
			ballon_boss = ballon_boss3;
		}
	}

	/**
	 * 사과던지기 버튼의 움직임을 위한 메소드
	 */
	public void setButtonBoss(int state) {
		if (BUTTON_ATTACK_1 == state) {
			button = button_attack_1;
		}
		if (BUTTON_ATTACK_2 == state) {
			button = button_attack_2;
		}
		if (BUTTON_ATTACK_3 == state) {
			button = button_attack_3;
		}
	}

	/**
	 * 벌레1의 움직임을 위한 메소드
	 */
	public void setBug1(int state) {
		if (BUG1_STATE_1 == state) {
			bug1 = bug1_1;
		}
		if (BUG1_STATE_2 == state) {
			bug1 = bug1_2;
		}
		if (BUG1_STATE_3 == state) {
			bug1 = bug1_3;
		}
	}

	/**
	 * 벌레2의 움직임을 위한 메소드
	 */
	public void setBug2(int state) {
		if (BUG2_STATE_1 == state) {
			bug2 = bug2_1;
		}
		if (BUG2_STATE_2 == state) {
			bug2 = bug2_2;
		}
		if (BUG2_STATE_3 == state) {
			bug2 = bug2_3;
		}
	}

	/**
	 * 벌레3의 움직임을 위한 메소드
	 */
	public void setBug3(int state) {
		if (BUG3_STATE_1 == state) {
			bug3 = bug3_1;
		}
		if (BUG3_STATE_2 == state) {
			bug3 = bug3_2;
		}
		if (BUG3_STATE_3 == state) {
			bug3 = bug3_3;
		}
	}

	/**
	 * surfaceView의 쓰레드에서 계속해서 호출되어 사과나무가 움직이는 효과를 주는 메소드입니다. (보통의 나무)(에너지 반이상)
	 */
	public void setTree(int state) {
		// 사과나무의 세가지 상태를 결정해주는 setter
		if (TREE_STATE_1 == state) {
			tree = tree1;
		}
		if (TREE_STATE_2 == state) {
			tree = tree2;
		}
		if (TREE_STATE_3 == state) {
			tree = tree3;
		}
	}

	/**
	 * surfaceView의 쓰레드에서 계속해서 호출되어 사과나무가 움직이는 효과를 주는 메소드입니다. (비실한 나무)(에너지 반이하)
	 */
	public void setMidTree(int state) {
		// 사과나무의 세가지 상태를 결정해주는 setter
		if (TREE_STATE_MID1 == state) {
			treeMid = treeMid1;
		}
		if (TREE_STATE_MID2 == state) {
			treeMid = treeMid2;
		}
		if (TREE_STATE_MID3 == state) {
			treeMid = treeMid3;
		}
	}

	/**
	 * surfaceView의 쓰레드에서 계속해서 호출되어 사과나무가 움직이는 효과를 주는 메소드입니다. (죽은 나무)(에너지 없음)
	 */
	public void setLowTree(int state) {
		// 사과나무의 세가지 상태를 결정해주는 setter
		if (TREE_STATE_LOW1 == state) {
			treeLow = treeLow1;
		}
		if (TREE_STATE_LOW2 == state) {
			treeLow = treeLow2;
		}
		if (TREE_STATE_LOW3 == state) {
			treeLow = treeLow3;
		}
	}

	/**
	 * surfaceView의 쓰레드에서 계속해서 호출되어 사과나무가 움직이는 효과를 주는 메소드입니다. (클릭시 보통나무)
	 */
	public void setPeople(int state) {
		// 사람이 있는 사과나무의 상태를 결정해주는 setter
		if (PEOPLE_STATE_1 == state) {
			people = people1;
		}
		if (PEOPLE_STATE_2 == state) {
			people = people2;
		}
		if (PEOPLE_STATE_3 == state) {
			people = people3;
		}
	}

	/**
	 * surfaceView의 쓰레드에서 계속해서 호출되어 사과나무가 움직이는 효과를 주는 메소드입니다. (클릭시 비실한나무)
	 */
	public void setMidPeople(int state) {
		if (PEOPLE_STATE_MID1 == state) {
			peopleMid = peopleMid1;
		}
		if (PEOPLE_STATE_MID2 == state) {
			peopleMid = peopleMid2;
		}
		if (PEOPLE_STATE_MID3 == state) {
			peopleMid = peopleMid3;
		}
	}

	/**
	 * 보스 몬스터의 움직임을 위한 메소드
	 */
	public void setBoss(int state) {
		if (BOSS_STATE_1 == state) {
			boss = boss1;
		}
		if (BOSS_STATE_2 == state) {
			boss = boss2;
		}
		if (BOSS_STATE_3 == state) {
			boss = boss3;
		}
	}

	/**
	 * 보스 몬스터의 공격의 움직임을 위한 메소드
	 */
	public void setBossAttack(int state) {
		if (BOSS_ATTACK_1 == state) {
			boss_attack = boss_attack1;
		}
		if (BOSS_ATTACK_2 == state) {
			boss_attack = boss_attack2;
		}
		if (BOSS_ATTACK_3 == state) {
			boss_attack = boss_attack3;
		}
	}

	/**
	 * 아이템 클릭에 대한 이벤트를 받는 메소드입니다.
	 */
	private void itemClickEvent(MotionEvent event) {
		int px = (int) event.getX();
		int py = (int) event.getY();

		box_Item[0].set(scaleWidth / 3 * 2, scaleHeight / 20, scaleWidth / 3
				* 2 + item1A.getWidth(), scaleHeight / 20 + item1A.getHeight());
		box_Item[1].set(scaleWidth / 3 * 2 + item1A.getWidth(),
				scaleHeight / 20, scaleWidth / 3 * 2 + item1A.getWidth()
						+ item2A.getWidth(),
				scaleHeight / 20 + item2A.getHeight());
		box_Item[2].set(
				scaleWidth / 3 * 2 + item1A.getWidth() + item2A.getWidth(),
				scaleHeight / 20, scaleWidth / 3 * 2 + +item1A.getWidth()
						+ item2A.getWidth() + item3A.getWidth(), scaleHeight
						/ 20 + item3A.getHeight());
		// 아이템 클릭을 위한 상자.

		if (box_Item[0].contains(px, py) && itemAvailable[0] == true) {
			/*
			 * 만일 선택한 구름 아이템이 활성화 되어있다면
			 */

			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:

				break;

			case MotionEvent.ACTION_UP:
				while (true) {
					int x = (int) (3.0 * Math.random());
					int y = (int) (3.0 * Math.random());
					if (arrayTree[x][y].getState() == AppleTree.STATE_LOW
							|| arrayTree[x][y].getState() == AppleTree.STATE_FULL) {
						/*
						 * 만일 죽은 나무혹은 가득찬 나무라면 아이템 사용이 안됩니다.
						 */
						continue;
					} else {
						numOfApple -= 3;
						m_Sound_Effect_HealOne.start();
//						if (HP[x][y] - 80.0 <= scaleWidth / 15) {
//							HP[x][y] = scaleWidth / 15;
//							arrayTree[x][y].setState(AppleTree.STATE_CLOUD_ON);
//
//						} else {
//							HP[x][y] = scaleWidth / 15;
//							arrayTree[x][y].setState(AppleTree.STATE_CLOUD_ON);
//						}
						if (HP[x][y] - 30.0 <= scaleWidth / 15) {
							arrayTree[x][y]
									.setState(AppleTree.STATE_WATER_ON);

							HP[x][y] = scaleWidth / 15;
						} else {
							arrayTree[x][y]
									.setState(AppleTree.STATE_WATER_ON);
							HP[x][y] -= 30.0;
						}
						break;
					}
				}
				break;
			}

		}
		if (box_Item[1].contains(px, py) && itemAvailable[1] == true) {
			/*
			 * 만일 물폭탄 아이템이 활성화 되었다면
			 */

			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				break;

			case MotionEvent.ACTION_UP:
				m_Sound_Effect_HealAll.start();
				numOfApple -= 5;
				for (int x = 0; x < 3; x++) {
					for (int y = 0; y < 3; y++) {
						if (arrayTree[x][y].getState() == AppleTree.STATE_LOW
								|| arrayTree[x][y].getState() == AppleTree.STATE_FULL) {
							/*
							 * 만일 죽은 나무혹은 가득찬 나무라면 아이템 사용이 안됩니다.
							 */
							continue;
						} else {

							if (HP[x][y] - 30.0 <= scaleWidth / 15) {
								arrayTree[x][y]
										.setState(AppleTree.STATE_WATER_ON);

								HP[x][y] = scaleWidth / 15;
							} else {
								arrayTree[x][y]
										.setState(AppleTree.STATE_WATER_ON);
								HP[x][y] -= 30.0;
							}

						}
					}
				}
				break;
			}

		}
		if (box_Item[2].contains(px, py) && itemAvailable[2] == true) {
			/*
			 * 만일 수호자 아이템이 활성화 되었다면
			 */

			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:

				break;

			case MotionEvent.ACTION_UP:
				m_Sound_Effect_Heal.start();
				numOfApple -= 9;
				for (int x = 0; x < 3; x++) {
					for (int y = 0; y < 3; y++) {
						if (arrayTree[x][y].getState() == AppleTree.STATE_LOW) {
							arrayTree[x][y].setState(AppleTree.STATE_HEAL_ON);
							HP[x][y] -= 60.0;

						}
					}
				}
				break;
			}

		}
	}

	/**
	 * 보스 몬스터를 그리는 메소드(onDraw에서 호출)
	 */
	private void drawBoss(Canvas canvas) {
		Paint number = new Paint();
		number.setTextSize(scaleWidth / 20);
		if (bossPosRX >= scaleWidth / 2 + scaleWidth / 7) {
			canvas.drawBitmap(boss, 0 + bossPosLX, scaleHeight / 15, null);
			canvas.drawText(Integer.toString(bossHP), 0 + bossPosLX,
					scaleHeight / 15, number);
			bossPosLX -= scaleWidth / 30;
		} else {
			canvas.drawBitmap(boss, 0 + bossPosRX, scaleHeight / 15, null);
			canvas.drawText(Integer.toString(bossHP), 0 + bossPosRX,
					scaleHeight / 15, number);
			bossPosRX += scaleWidth / 30;
		}

		if (bossPosLX <= 0) {
			/*
			 * 위치 바꾸기
			 */
			bossPosRX = 0;
			bossPosLX = scaleWidth / 2 + scaleWidth / 7;
		}

	}

	/**
	 * 날라가는 사과를 그리는 메소드(onDraw에서 호출)
	 */
	private void drawThrowApple(Canvas canvas) {
		if (peopleRPosX >= scaleWidth / 2 + scaleWidth / 3) {
			if (throwApple == true) {

				canvas.drawBitmap(apple_throw, throwInitPos, scaleHeight / 4
						* 3 + scaleWidth / 5 - throwApplePos, null);
				throwApplePos += 200;
			}
		} else {
			if (throwApple == true) {
				canvas.drawBitmap(apple_throw, throwInitPos, scaleHeight / 4
						* 3 + scaleWidth / 5 - throwApplePos, null);
				throwApplePos += 200;
			}
		}
		if (scaleHeight / 4 * 3 + scaleWidth / 5 - throwApplePos <= scaleHeight / 15) {
			throwApplePos = 0;
			// 보스가 사과에 맞으면
			if (bossPosRX >= scaleWidth / 2 + scaleWidth / 7) {
				if (bossPosLX <= throwInitPos
						&& boss.getWidth() + bossPosLX >= throwInitPos) {
					m_Sound_boss_dam.start();
					canvas.drawBitmap(boss_damage, 0 + bossPosLX,
							scaleHeight / 15, null);
					bossHP -= 1;
					if (bossHP <= 0) {
						m_Sound_boss_die.start();
						bossAppear = false;
						bossHP = 5;
					}
				}
			} else {
				// 보스가 사과에 맞으면
				if (bossPosRX <= throwInitPos
						&& boss.getWidth() + bossPosRX >= throwInitPos) {
					m_Sound_boss_dam.start();
					canvas.drawBitmap(boss_damage, 0 + bossPosRX,
							scaleHeight / 15, null);
					bossHP -= 1;
					if (bossHP <= 0) {
						m_Sound_boss_die.start();
						bossAppear = false;
						bossHP = 5;
					}
				}
			}
			throwApple = false;
		}

	}

	/**
	 * 사과 던지기 버튼의 이벤트를 담당하는 메소드(onTouchEvent 메소드에서 호출)
	 */
	private void buttonClickEvent(MotionEvent event) {
		int px = (int) event.getX();
		int py = (int) event.getY();

		buttonApple.set(scaleWidth / 2 + scaleWidth / 3 + scaleWidth / 20,
				scaleHeight / 4 * 3 + scaleWidth / 5, scaleWidth / 2
						+ scaleWidth / 3 + scaleWidth / 20 + button.getWidth(),
				scaleHeight / 4 * 3 + scaleWidth / 5 + button.getHeight());

		if (buttonApple.contains(px, py)) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				break;
			case MotionEvent.ACTION_UP:
				if (numOfApple == 0) {
				} else if (numOfApple != 0) {
					numOfApple--;
					m_Sound_throw.start();
					throwApple = true;
					if (peopleRPosX >= scaleWidth / 2 + scaleWidth / 3) {
						throwInitPos = peopleLPosX;
					} else {
						throwInitPos = peopleRPosX;
					}
					break;
				}
			}
		}
	}

	/**
	 * 사과나무 클릭에 대한 이벤트를 받는 메소드입니다.
	 */
	private void treeClickEvent(MotionEvent event) {
		int px = (int) event.getX();
		int py = (int) event.getY();
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				box_Tree[x][y].set(scaleWidth / 3 * x, scaleHeight / 5
						* (y + 1), scaleWidth / 3 * x + tree.getWidth(),
						scaleHeight / 5 * (y + 1) + tree.getHeight());
				// 사과나무 클릭을 위한 상자

				if (box_Tree[x][y].contains(px, py) && lowEnergy[x][y] == false) {
					/*
					 * 만일 선택한 사과나무의 에너지가 가득차있지 않다면, (에너지가 가득차있을때와 모두 달았을때는 클릭이
					 * 안됩니다.)
					 */
					if (HP[x][y] <= scaleWidth / 15) {
					} else {
						// 에너지 채우기
						switch (event.getAction()) {
						case MotionEvent.ACTION_DOWN:
							break;
						case MotionEvent.ACTION_UP:
							if (bugState[x][y] == 1) {
								if (bugCount[x][y] != 0) {
									m_Sound_Effect.start();
									bugCount[x][y]--;
								}
								if (bugCount[x][y] == 0) {
									m_Sound_Effect_GetApple.start();
									numOfApple++;
									saveApple = true;
									bugState[x][y] = 0;
								}
							} else if (bugState[x][y] == 2) {
								if (bugCount[x][y] != 0) {
									m_Sound_Effect.start();
									bugCount[x][y]--;
								}
								if (bugCount[x][y] == 0) {
									m_Sound_Effect_GetApple.start();
									numOfApple++;
									saveApple = true;
									bugState[x][y] = 0;
								}
							} else if (bugState[x][y] == 3) {
								if (bugCount[x][y] != 0) {
									m_Sound_Effect.start();
									bugCount[x][y]--;
								}
								if (bugCount[x][y] == 0) {
									m_Sound_Effect_GetApple.start();
									numOfApple++;
									saveApple = true;
									bugState[x][y] = 0;
								}
							} else {
								m_Sound_Effect_Damage.start();
								HP[x][y] += 25.0;
							}
							break;
						}
					}
					if (midEnergy[x][y] == false) {
						// 에너지 반이상
						if (prevTree[x][y].getState() != AppleTree.STATE_CLICK_OFF) {
							// 이전 사과나무의 상태가 있을때, 사과나무 상태를 사람이 없는 것으로 수정.
							prevTree[x][y].setState(AppleTree.STATE_CLICK_OFF);
						}
						if (arrayTree[x][y].getState() == AppleTree.STATE_CLICK_OFF) {
							// 사과 나무의 상태를 사람이 잇는 것으로 수정.
							prevTree[x][y] = arrayTree[x][y];
							arrayTree[x][y].setState(AppleTree.STATE_CLICK_ON);
						}
					}
					if (midEnergy[x][y] == true) {
						if (prevTree[x][y].getState() != AppleTree.STATE_CLICK_OFF) {
							// 이전 사과나무의 상태가 있을때, 사과나무 상태를 사람이 없는 것으로 수정.
							prevTree[x][y]
									.setState(AppleTree.STATE_CLICK_OFF_MID);
						}
						if (arrayTree[x][y].getState() == AppleTree.STATE_CLICK_OFF_MID) {
							// 사과나무의 상태를 사람이 있는것으로 수정
							prevTree[x][y] = arrayTree[x][y];
							arrayTree[x][y]
									.setState(AppleTree.STATE_CLICK_ON_MID);
						}
					}
				}
			}
		}
	}

	private void btnClickEvent(MotionEvent event) {
		int px = (int) event.getX();
		int py = (int) event.getY();

		gameOverBtn[0].set(scaleWidth / 3, scaleHeight / 2, scaleWidth / 3
				+ ranking.getWidth(), scaleHeight / 2 + ranking.getHeight());
		gameOverBtn[1].set(scaleWidth / 3, (scaleHeight / 3 + scaleHeight / 3),
				scaleWidth / 3 + exit.getWidth(),
				(scaleHeight / 3 + scaleHeight / 3) + exit.getHeight());

		if (gameOverBtn[0].contains(px, py)) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				m_Sound_Effect.start();
				m_Sound_Effect_GameOver.stop();
				break;
			case MotionEvent.ACTION_UP:
				if (this != null) {	
					AppleTreeThread.isPause = true;
					this.surfaceDestroyed(null);
				}
				Intent intent = new Intent(this.getContext(), UpdateRanking.class);
				intent.putExtra("SCORE", timeOfMin);
				((Activity) this.getContext()).startActivityForResult(intent,1);
				break;
			}
		}
		if (gameOverBtn[1].contains(px, py)) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				m_Sound_Effect.start();
				break;
			case MotionEvent.ACTION_UP:

				if (this != null) {
					AppleTreeThread.isPause = true;
					this.surfaceDestroyed(null);
				}
				System.exit(0);
				break;
			}
		}
	}

	/**
	 * 사과나무를 터치하였을때 효과를 줍니다. 9개의 사각형영역을 표시하고 그영역에 터치를햇을시 이벤트가 발생합니다.
	 */
	public boolean onTouchEvent(MotionEvent event) {
		// 사과나무를 클릭했을때, 일어나는 이벤트를 일으키는 메소드
		if (AppleTreeThread.isPause == false) {
			this.itemClickEvent(event);
			this.treeClickEvent(event);
		}
		if (bossAppear == true && throwApple == false) {
			this.buttonClickEvent(event);
		}
		if (isOver == true) {
			this.btnClickEvent(event);
		}
		return true;
	}

	/**
	 * 시계에의 초와 분을 늘려주는 메소드입니다.
	 */
	private void time() {
		// currentTime이 문제!!!!!!(진짜시간은 가고잇다 ㅠㅠ)
		if (AppleTreeThread.isPause == false) {

			if (bossAppear == false) {
				bossTime = sumOfBossTime + (System.currentTimeMillis() - bossStartTime) / 1000;
			} else if (bossAppear == true) {
				bossStartTime = System.currentTimeMillis();
				bossTime = 0;
			}
			timeOfMin = sumOfTime+(System.currentTimeMillis() - startTime) / 1000;
		} else if (AppleTreeThread.isPause == true) {			 
			 
		}
	}

	/**
	 * 에너지가 가득찬 트리의 시간을 체크해줍니다.
	 */

	private void drawLevelUp(Canvas canvas) {
		if (timeOfMin == 20) {
			m_Sound_Level_Up.start();
			canvas.drawBitmap(level, scaleWidth / 2 - scaleWidth / 2,

			scaleHeight / 3, null);

		} else if (timeOfMin == 40) {

			m_Sound_Level_Up.start();
			canvas.drawBitmap(level, scaleWidth / 2 - scaleWidth / 2,
					scaleHeight / 3, null);

		} else if (bossTime == 60 && bossAppear == false) {
			m_Sound_Level_Up.start();

			canvas.drawBitmap(level, scaleWidth / 2 - scaleWidth / 2,
					scaleHeight / 3, null);
			bossAppear = true;
		}

		// else if (timeOfMin == 7) {
		// bossHP = 10;
		// m_Sound_Level_Up.start();
		// canvas.drawBitmap(level, scaleWidth / 2 - scaleWidth / 2,
		// scaleHeight / 3, null);
		// if(bossAppear !=true)
		// {
		// bossAppear = true;
		// }
		// } else if (timeOfMin == 9) {
		// bossHP = 15;
		// m_Sound_Level_Up.start();
		// canvas.drawBitmap(level, scaleWidth / 2 - scaleWidth / 2,
		// scaleHeight / 3, null);
		// if(bossAppear !=true)
		// {
		// bossAppear = true;
		// }
		// }

	}

	private void drawPeople(Canvas canvas) {
		canvas.drawBitmap(manyApple, 0, scaleHeight / 4 * 3 + scaleWidth / 5
				+ scaleWidth / 31, null);
		// 쌓여잇는 사과

		if (bossAppear == true) {

			canvas.drawBitmap(button, scaleWidth / 2 + scaleWidth / 3
					+ scaleWidth / 20, scaleHeight / 4 * 3 + scaleWidth / 5,
					null);

		} else {
			canvas.drawBitmap(basket, scaleWidth / 2 + scaleWidth / 3
					+ scaleWidth / 10, scaleHeight / 4 * 3 + scaleWidth / 5
					+ scaleWidth / 20, null);
		}
		// 바구니
		if (peopleRPosX >= scaleWidth / 2 + scaleWidth / 3) {
			// 우에서 좌로 움직이는 사람
			if (bossAppear == false) {
				canvas.drawBitmap(apple, scaleWidth / 2 + scaleWidth / 3
						+ scaleWidth / 10, scaleHeight / 4 * 3 + scaleWidth / 5
						+ scaleWidth / 20, null);
			}
			// 바구니 안에 사과
			if (bossAppear == true) {
				canvas.drawBitmap(people_boss, 0 + peopleLPosX, scaleHeight / 4
						* 3 + scaleWidth / 5, null);
				// 왼쪽사람
				canvas.drawBitmap(ballon_boss, scaleWidth / 22 + peopleLPosX,
						scaleHeight / 4 * 3 + scaleWidth / 7, null);
				// 느낌표 풍선
			} else {
				canvas.drawBitmap(peopleL, 0 + peopleLPosX, scaleHeight / 4 * 3
						+ scaleWidth / 5, null);
				// 왼쪽사람
				canvas.drawBitmap(ballon, scaleWidth / 22 + peopleLPosX,
						scaleHeight / 4 * 3 + scaleWidth / 7, null);
				// 땀방울 풍선
			}
			peopleLPosX -= 70;

		} else {
			if (bossAppear == true) {
				canvas.drawBitmap(apple, scaleWidth / 30 + peopleRPosX,
						scaleHeight / 4 * 3 + scaleWidth / 5 + scaleWidth / 20,
						null);
				// 들고다니는 사과
				canvas.drawBitmap(people_boss, 0 + peopleRPosX, scaleHeight / 4
						* 3 + scaleWidth / 5, null);
				// 왼쪽사람
				canvas.drawBitmap(ballon_boss, scaleWidth / 22 + peopleRPosX,
						scaleHeight / 4 * 3 + scaleWidth / 7, null);
				// 땀방울 풍선
			} else {
				// 좌에서 우로 움직이는 사람
				canvas.drawBitmap(peopleR, 0 + peopleRPosX, scaleHeight / 4 * 3
						+ scaleWidth / 5, null);
				// 오른쪽사람
				canvas.drawBitmap(ballon, scaleWidth / 22 + peopleRPosX,
						scaleHeight / 4 * 3 + scaleWidth / 7, null);
				// 땀방울 풍선
				canvas.drawBitmap(apple, scaleWidth / 30 + peopleRPosX,
						scaleHeight / 4 * 3 + scaleWidth / 5 + scaleWidth / 20,
						null);
				// 들고다니는 사과
			}
			peopleRPosX += 70;
		}
		if (peopleLPosX <= 0) {
			/*
			 * 위치 바꾸기
			 */
			peopleRPosX = 0;
			peopleLPosX = scaleWidth / 2 + scaleWidth / 3;
		}
	}

	/**
	 * 벌레를 그리는 메소드(onDraw메소드에서 호출)
	 */
	private void drawBug(Canvas canvas) {
		Paint number = new Paint();
		number.setTextSize(scaleWidth / 20);

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (bugDelay[x][y] == 0) {
					this.setEmptyBug();
					bugDelay[x][y] = 10;
				} else if (bugState[x][y] == 0) {
					bugDelay[x][y]--;
				}
				if (arrayTree[x][y].getState() != AppleTree.STATE_LOW) {
					if (bugState[x][y] == 1) {

						canvas.drawBitmap(bug1, scaleWidth / 3 * x, scaleHeight
								/ 5 * (y + 1), null);
						canvas.drawText(Integer.toString(bugCount[x][y]),
								scaleWidth / 3 * x + scaleWidth / 50,
								scaleHeight / 5 * (y + 1), number);
					}
					if (bugState[x][y] == 2) {

						canvas.drawBitmap(bug2, scaleWidth / 3 * x, scaleHeight
								/ 5 * (y + 1), null);
						canvas.drawText(Integer.toString(bugCount[x][y]),
								scaleWidth / 3 * x + scaleWidth / 50,
								scaleHeight / 5 * (y + 1), number);
					}
					if (bugState[x][y] == 3) {

						canvas.drawBitmap(bug3, scaleWidth / 3 * x, scaleHeight
								/ 5 * (y + 1), null);
						canvas.drawText(Integer.toString(bugCount[x][y]),
								scaleWidth / 3 * x + scaleWidth / 50,
								scaleHeight / 5 * (y + 1), number);
					}
					if (bugState[x][y] == 0) {

					}
				}
			}
		}

	}

	/**
	 * 실제 사과나무를 그려주는 메소드입니다. 쓰레드에의해 반복적으로 호출됩니다.
	 */
	private void drawSubMenu(Canvas canvas) {
		int startLineHP;
		float endLineHP;

		Paint txtOfApple = new Paint();// paint는 그려지는 객체의 속성값을 가지는 것.
		txtOfApple.setColor(Color.BLACK);
		txtOfApple.setTextSize(scaleWidth / 30);
		// 사과나무 갯수 표시칸의 속성
		Paint txtOfTime = new Paint();
		txtOfTime.setColor(Color.BLACK);
		txtOfTime.setTextSize(scaleWidth / 4);
		// 시계 텍스트의 속성

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				// 에너지바속성
				canvas.drawText("사과 갯수   :    " + numOfApple,
						scaleWidth / 3 * 2, scaleHeight / 7 * 1, txtOfApple);
				// 사과의 갯수를 나타내는 텍스트 상자를 그려줍니다.

				if (numOfApple >= 3) {
					canvas.drawBitmap(item1A, scaleWidth / 3 * 2,
							scaleHeight / 20, null);
					itemAvailable[0] = true;
				} else {
					canvas.drawBitmap(item1D, scaleWidth / 3 * 2,
							scaleHeight / 20, null);
					itemAvailable[0] = false;
				}
				// 아이템1(먹구름) 사과 3개이상 활성화
				if (numOfApple >= 5) {
					canvas.drawBitmap(item2A,
							scaleWidth / 3 * 2 + item1A.getWidth(),
							scaleHeight / 20, null);
					itemAvailable[1] = true;
				} else {
					canvas.drawBitmap(item2D,
							scaleWidth / 3 * 2 + item1A.getWidth(),
							scaleHeight / 20, null);
					itemAvailable[1] = false;
				}
				// 아이템 2(물폭탄) 사과 5개이상 활성화
				if (numOfApple >= 9) {
					canvas.drawBitmap(
							item3A,
							scaleWidth / 3 * 2 + item1A.getWidth()
									+ item2A.getWidth(), scaleHeight / 20, null);
					itemAvailable[2] = true;
				} else {
					canvas.drawBitmap(
							item3D,
							scaleWidth / 3 * 2 + item1A.getWidth()
									+ item2A.getWidth(), scaleHeight / 20, null);
					itemAvailable[2] = false;
				}
				// 아이템3(초인) 사과 9개이상 활성화

				canvas.drawText(Long.toString(timeOfMin), scaleWidth / 60,
						scaleHeight / 8, txtOfTime);
				// canvas.drawText(
				// Long.toString(timeOfMin) + " "
				// + Long.toString(bossTime), scaleWidth / 60,
				// scaleHeight / 8, txtOfTime);
				// 시계
				startLineHP = (scaleWidth / 3 * 0) + scaleWidth / 15;// 시작점
				endLineHP = (scaleWidth / 3 * 0) + tree1.getWidth() - HP[x][y];// 끝점
				// 에너지바의 시작점과 끝점을 위한 변수입니다.
				if (startLineHP > (int) endLineHP) {
					/*
					 * 만일 에너지가 모두 달았다면
					 */
					arrayTree[x][y].setState(AppleTree.STATE_LOW);
					// 죽은나무로 이미지를 교체해줍니다.
					lowEnergy[x][y] = true;
					// 이 나무는 더이상 클릭이 불가능하도록 죽은나무라 표시해줍니다.
				} else {
					/*
					 * 만일 에너지가 아직 남이있다면
					 */
					lowEnergy[x][y] = false;
					if (fullEnergy[x][y] == false) {
						/*
						 * 만일 사과나무 게이지가 가득 차있지 않다면 에너지가 단다.
						 */
						int centerOfEnergy = tree1.getWidth() / 2;
						// 에너지바의 중간위치를 나타내는 변수값
						if ((int) endLineHP <= centerOfEnergy) {
							/*
							 * 만일 에너지가 중간 이하라면
							 */
							midEnergy[x][y] = true;
							// 이미지를 중간에너지 이미지로 교체해주기위해 변수값을 true로 설정합니다.

							arrayTree[x][y]
									.setState(AppleTree.STATE_CLICK_OFF_MID);
							// 이미지를 교체해줍니다.
						}
						if ((int) endLineHP > centerOfEnergy) {
							/*
							 * 에너지가 반 이상일경우
							 */
							midEnergy[x][y] = false;
							arrayTree[x][y].setState(AppleTree.STATE_CLICK_OFF);
							// 변수값을 다시 false로 바꾸어줍니다.
						}
						if (bugState[x][y] == 1) {
							HP[x][y] += scaleWidth / 450;
						}
						if (bugState[x][y] == 2) {
							HP[x][y] += scaleWidth / 450;
						}
						if (bugState[x][y] == 3) {
							HP[x][y] += scaleWidth / 450;
						}

						// 에너지가 조금씩 닳게 설정합니다.
					}
				}

				if (saveApple == true) {
					/*
					 * 만일 사과를 획득했다면.
					 */
					canvas.drawBitmap(apple, scaleWidth / 3 * 2,
							scaleHeight / 7 * 1, null);

					saveApple = false;

					// 사과 갯수 텍스트옆에 사과 이미지를 보여줍니다.
					//
				}

			}
		}
	}

	/**
	 * 9개의 사과나무를 그리는 메소드(onDraw 메소드에서 호출)
	 */
	private void drawTree(Canvas canvas) {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				Pnt[x][y].setStrokeWidth(scaleWidth / 70);
				Pnt[x][y].setStrokeCap(Paint.Cap.ROUND);
				Pnt[x][y].setColor(Color.RED);
				if (arrayTree[x][y].getState() == AppleTree.STATE_CLICK_OFF) {
					/*
					 * 사람이 없을때.
					 */
					canvas.drawBitmap(tree, scaleWidth / 3 * x, scaleHeight / 5
							* (y + 1), null);
					// drawLine(시작점 x, 시작점 y, 끝점 x, 끝점 y);
					canvas.drawLine((scaleWidth / 3 * x) + scaleWidth / 15,
							scaleHeight / 5 * (y + 1) + tree1.getHeight()
									- scaleWidth / 30, (scaleWidth / 3 * x)
									+ tree1.getWidth() - HP[x][y], scaleHeight
									/ 5 * (y + 1) + tree1.getHeight()
									- scaleWidth / 30, Pnt[x][y]);

				} else if (arrayTree[x][y].getState() == AppleTree.STATE_CLICK_ON) {
					/*
					 * 사람이 있을때.
					 */
					canvas.drawBitmap(people, scaleWidth / 3 * x,
							(scaleHeight / 5 * (y + 1)), null);
					canvas.drawLine((scaleWidth / 3 * x) + scaleWidth / 15,
							scaleHeight / 5 * (y + 1) + tree1.getHeight()
									- scaleWidth / 30, (scaleWidth / 3 * x)
									+ tree1.getWidth() - HP[x][y], scaleHeight
									/ 5 * (y + 1) + tree1.getHeight()
									- scaleWidth / 30, Pnt[x][y]);
				} else if (arrayTree[x][y].getState() == AppleTree.STATE_LOW) {
					/*
					 * 나무가 죽었을때
					 */

					canvas.drawBitmap(treeLow, scaleWidth / 3 * x,
							(scaleHeight / 5 * (y + 1)), null);
					if (lowEnergy[x][y] == false) {
						canvas.drawLine((scaleWidth / 3 * x) + scaleWidth / 15,
								scaleHeight / 5 * (y + 1) + tree1.getHeight()
										- scaleWidth / 30, (scaleWidth / 3 * x)
										+ tree1.getWidth() - HP[x][y],
								scaleHeight / 5 * (y + 1) + tree1.getHeight()
										- scaleWidth / 30, Pnt[x][y]);
					}
				} else if (arrayTree[x][y].getState() == AppleTree.STATE_CLICK_ON_MID) {
					/*
					 * 중간에너지이하의 나무(클릭시)
					 */
					canvas.drawBitmap(peopleMid, scaleWidth / 3 * x,
							(scaleHeight / 5 * (y + 1)), null);
					if (lowEnergy[x][y] == false) {
						canvas.drawLine((scaleWidth / 3 * x) + scaleWidth / 15,
								scaleHeight / 5 * (y + 1) + tree1.getHeight()
										- scaleWidth / 30, (scaleWidth / 3 * x)
										+ tree1.getWidth() - HP[x][y],
								scaleHeight / 5 * (y + 1) + tree1.getHeight()
										- scaleWidth / 30, Pnt[x][y]);
					}
				} else if (arrayTree[x][y].getState() == AppleTree.STATE_CLICK_OFF_MID) {
					/*
					 * 중간에너지 이하의 나무(평상시)
					 */
					canvas.drawBitmap(treeMid, scaleWidth / 3 * x,
							(scaleHeight / 5 * (y + 1)), null);
					if (lowEnergy[x][y] == false) {
						canvas.drawLine((scaleWidth / 3 * x) + scaleWidth / 15,
								scaleHeight / 5 * (y + 1) + tree1.getHeight()
										- scaleWidth / 30, (scaleWidth / 3 * x)
										+ tree1.getWidth() - HP[x][y],
								scaleHeight / 5 * (y + 1) + tree1.getHeight()
										- scaleWidth / 30, Pnt[x][y]);
					}
				} else if (arrayTree[x][y].getState() == AppleTree.STATE_CLOUD_ON) {
					canvas.drawBitmap(heal_one, scaleWidth / 3 * x,
							(scaleHeight / 5 * (y + 1)), null);
					if (lowEnergy[x][y] == false) {
						canvas.drawLine((scaleWidth / 3 * x) + scaleWidth / 15,
								scaleHeight / 5 * (y + 1) + tree1.getHeight()
										- scaleWidth / 30, (scaleWidth / 3 * x)
										+ tree1.getWidth() - HP[x][y],
								scaleHeight / 5 * (y + 1) + tree1.getHeight()
										- scaleWidth / 30, Pnt[x][y]);
					}
				} else if (arrayTree[x][y].getState() == AppleTree.STATE_WATER_ON) {
					canvas.drawBitmap(heal_all, scaleWidth / 3 * x,
							(scaleHeight / 5 * (y + 1)), null);
					if (lowEnergy[x][y] == false) {
						canvas.drawLine((scaleWidth / 3 * x) + scaleWidth / 15,
								scaleHeight / 5 * (y + 1) + tree1.getHeight()
										- scaleWidth / 30, (scaleWidth / 3 * x)
										+ tree1.getWidth() - HP[x][y],
								scaleHeight / 5 * (y + 1) + tree1.getHeight()
										- scaleWidth / 30, Pnt[x][y]);
					}
				} else if (arrayTree[x][y].getState() == AppleTree.STATE_HEAL_ON) {
					canvas.drawBitmap(heal, scaleWidth / 3 * x,
							(scaleHeight / 5 * (y + 1)), null);
					if (lowEnergy[x][y] == false) {
						canvas.drawLine((scaleWidth / 3 * x) + scaleWidth / 15,
								scaleHeight / 5 * (y + 1) + tree1.getHeight()
										- scaleWidth / 30, (scaleWidth / 3 * x)
										+ tree1.getWidth() - HP[x][y],
								scaleHeight / 5 * (y + 1) + tree1.getHeight()
										- scaleWidth / 30, Pnt[x][y]);
					}
				}
			}
		}
	}

	/**
	 * 게임이 끝났을때, 호출되는 메소드입니다. (쓰레드 안정적 종료 해결 과제)
	 */

	private void gameOver(Canvas canvas) {
		Paint txtOfTime = new Paint();
		txtOfTime.setColor(Color.WHITE);
		txtOfTime.setTextSize(scaleWidth / 8);

		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arrayTree[i][j].getState() == AppleTree.STATE_LOW) {
					count++;
				}
			}
		}

		if (count == 9) {
			isOver = true;

			AppleTreeThread.isPause = true;
			//canvas.drawColor(Color.WHITE);
			canvas.drawBitmap(gameOver, scaleWidth / 11, scaleHeight / 7, null);
			canvas.drawBitmap(ranking, scaleWidth / 3, scaleHeight / 2, null);
			canvas.drawBitmap(exit, scaleWidth / 3, scaleHeight / 3
					+ scaleHeight / 3, null);

			AppleTreeThread.m_Sound_Background.stop();
			m_Sound_Effect_GameOver.start();

			if (m_Sound_Effect_GameOver.isPlaying() == false) {
				this.surfaceDestroyed(null);
			}

		}
	}

	/**
	 * 배경을 그리는 메소드(onDraw메소드에서 호출)
	 */
	private void drawBackGround(Canvas canvas) {
		canvas.drawBitmap(backGround, 0, 0, null);
	}

	/**
	 * 보스몬스터의 공격을 그리는 메소드(onDraw에서 호출 보스 출현시에만 호출된다.)
	 */
	private void drawAttack(Canvas canvas) {
		while (true) {

			int x = (int) (Math.random() * 3.0);
			int y = (int) (Math.random() * 3.0);

			if (arrayTree[x][y].getState() != AppleTree.STATE_LOW) {
				m_Sound_attack.start();
				canvas.drawBitmap(boss_attack, scaleWidth / 3 * x, scaleHeight
						/ 5 * (y + 1), null);
				HP[x][y] += 50.0;
				break;
			}
		}

	}

	/**
	 * 실제 개체를 그려주는 메소드입니다. 쓰레드에 의해서 연속적으로 호출되어집니다.
	 */
	public void onDraw(Canvas canvas) {
		// 실제 객체를 그려주는 메소드
		canvas.drawColor(Color.WHITE);
		this.drawBackGround(canvas);
		this.drawTree(canvas);
		this.drawSubMenu(canvas);
		this.time();
		this.drawPeople(canvas);
		this.drawLevelUp(canvas);
		this.drawBug(canvas);
		this.drawThrowApple(canvas);
		if (bossAppear == true) {
			this.drawBoss(canvas);
			if (attackDelay == 0) {
				this.drawAttack(canvas);
				attackDelay = 30;
			} else {
				attackDelay--;
			}
		}
		this.gameOver(canvas);

	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		movingTree.isEnd = false;
		movingTree.start();
	}

	public void destroy() {
		this.destroyDrawingCache();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		movingTree.isEnd = true;

		while (true) {
			try {
				movingTree.join();
				break;
			} catch (InterruptedException e) {
			}
		}
	}

}
