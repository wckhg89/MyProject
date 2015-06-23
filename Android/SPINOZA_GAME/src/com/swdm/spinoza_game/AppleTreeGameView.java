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
	// ����̽��� ���̸� �����´�.
	private int scaleHeight = display.getHeight() + 50;
	// ����̽��� ���̸� �����´�.

	MediaPlayer m_Sound_Effect;
	// Ŭ���� ȿ����
	MediaPlayer m_Sound_Effect_GetApple;
	// ����� �������, ȿ����
	MediaPlayer m_Sound_Effect_HealOne;
	// ������1ȿ���� (���� �ѱ׷� ü��ȸ��)
	MediaPlayer m_Sound_Effect_HealAll;
	// ������2ȿ���� (��� ���� ü��ȸ��)
	MediaPlayer m_Sound_Effect_Heal;
	// ������3ȿ���� (���� ���� �츮��)
	MediaPlayer m_Sound_Level_Up;
	// ���̵� ��� ȿ����
	MediaPlayer m_Sound_Effect_GameOver;
	// ���ӿ��� ȿ����
	MediaPlayer m_Sound_Effect_Damage;
	// �������� ���� Ŭ���� ȿ����
	MediaPlayer m_Sound_attack;
	// ���� ���� ȿ����
	MediaPlayer m_Sound_throw;
	// ��� ������ ȿ����
	MediaPlayer m_Sound_boss_dam;
	// ���� ��� �¾�����, ȿ����
	MediaPlayer m_Sound_boss_die;
	// ���� �׾�����, ȿ����

	/*
	 * �����������
	 */
	private static final int TREE_STATE_1 = 1;
	private static final int TREE_STATE_2 = 2;
	private static final int TREE_STATE_3 = 3;
	// ��������� ���� ���� 3����
	private static final int TREE_STATE_MID1 = 1;
	private static final int TREE_STATE_MID2 = 2;
	private static final int TREE_STATE_MID3 = 3;
	// ��������� ���� ���� 3����(�߰�������)
	private static final int TREE_STATE_LOW1 = 1;
	private static final int TREE_STATE_LOW2 = 2;
	private static final int TREE_STATE_LOW3 = 3;
	// ��������� ���� ���� 3����(����������)

	private static final int PEOPLE_STATE_1 = 1;
	private static final int PEOPLE_STATE_2 = 2;
	private static final int PEOPLE_STATE_3 = 3;
	// Ŭ���� ������� ���� 3����(������ ���� ����)
	private static final int PEOPLE_STATE_MID1 = 1;
	private static final int PEOPLE_STATE_MID2 = 2;
	private static final int PEOPLE_STATE_MID3 = 3;
	// Ŭ���� ������� ���� 3����(�߰�������)

	/*
	 * ������ ����
	 */
	private static final int HEALONE_STATE_1 = 1;
	private static final int HEALONE_STATE_2 = 2;
	private static final int HEALONE_STATE_3 = 3;
	// ������1(���� 1�׷� ü�� ȸ��)�� ���� 3����
	private static final int HEALALL_STATE_1 = 1;
	private static final int HEALALL_STATE_2 = 2;
	private static final int HEALALL_STATE_3 = 3;
	// ������2(��糪�� ü�� ȸ��)�� ���� 3����

	private static final int HEAL_STATE_1 = 1;
	private static final int HEAL_STATE_2 = 2;
	private static final int HEAL_STATE_3 = 3;
	// ������3(�������� �츮��)�� ���� 3����

	/*
	 * �ϴܿ� �����̴� ��� ����
	 */
	private static final int PEOPLE_RIGHT_1 = 1;
	private static final int PEOPLE_RIGHT_2 = 2;
	private static final int PEOPLE_RIGHT_3 = 3;
	// �������� �����̴� ��� ���� 3����
	private static final int PEOPLE_LEFT_1 = 1;
	private static final int PEOPLE_LEFT_2 = 2;
	private static final int PEOPLE_LEFT_3 = 3;
	// �������� �����̴� ��� ���� 3����
	private static final int BALLON_STATE_1 = 1;
	private static final int BALLON_STATE_2 = 2;
	private static final int BALLON_STATE_3 = 3;
	// ����� ���� 3����
	private static final int PEOPLE_BOSS_1 = 1;
	private static final int PEOPLE_BOSS_2 = 2;
	private static final int PEOPLE_BOSS_3 = 3;
	// ���������� ����� ���� 3����
	private static final int BALLON_BOSS_1 = 1;
	private static final int BALLON_BOSS_2 = 2;
	private static final int BALLON_BOSS_3 = 3;
	// ���������� ����ǥ ��ǳ�� ���� 3����
	private static final int BUTTON_ATTACK_1 = 1;
	private static final int BUTTON_ATTACK_2 = 2;
	private static final int BUTTON_ATTACK_3 = 3;
	// ���������� ��������� ��ư ���� 3����

	/*
	 * 3���� ������ ���� ���� 3����
	 */
	private static final int BUG1_STATE_1 = 1;
	private static final int BUG1_STATE_2 = 2;
	private static final int BUG1_STATE_3 = 3;
	// 1��Ŭ�� ���� ���� 3����
	private static final int BUG2_STATE_1 = 1;
	private static final int BUG2_STATE_2 = 2;
	private static final int BUG2_STATE_3 = 3;
	// 3��Ŭ�� ���� ���� 3����
	private static final int BUG3_STATE_1 = 1;
	private static final int BUG3_STATE_2 = 2;
	private static final int BUG3_STATE_3 = 3;
	// 5��Ŭ�� ���� ���� 3����

	/*
	 * ���� ����
	 */
	private static final int BOSS_STATE_1 = 1;
	private static final int BOSS_STATE_2 = 2;
	private static final int BOSS_STATE_3 = 3;
	// ���� ���� ���� 3����
	private static final int BOSS_ATTACK_1 = 1;
	private static final int BOSS_ATTACK_2 = 2;
	private static final int BOSS_ATTACK_3 = 3;
	// ���� ���ݽ� ȿ�� ���� 3����

	private AppleTreeThread movingTree;
	// ������ ��ü

	private Bitmap tree;
	private Bitmap people;
	// ���볪��
	private Bitmap treeMid;
	private Bitmap peopleMid;
	// �߰� ������ ����
	private Bitmap treeLow;
	// ���� ������ ����

	private Bitmap heal_one;
	// ������ 1
	private Bitmap heal_all;
	// ������ 2
	private Bitmap heal;
	// ������ 3

	private Bitmap peopleR;
	// ���� ���
	private Bitmap peopleL;
	// ���� ���
	private Bitmap ballon;
	// �����
	private Bitmap people_boss;
	// ���������� ���
	private Bitmap ballon_boss;
	// ���������� �����
	private Bitmap button;
	// ��������� ��ư

	private Bitmap bug1;
	// ����1
	private Bitmap bug2;
	// ����2
	private Bitmap bug3;
	// ����3

	private Bitmap boss;
	// ���� ����
	private Bitmap boss_attack;
	// ���� ���� ����

	private Bitmap ranking = BitmapFactory.decodeResource(getResources(),
			R.drawable.ranking);
	private Bitmap exit = BitmapFactory.decodeResource(getResources(),
			R.drawable.exit);

	private Bitmap backGround = BitmapFactory.decodeResource(getResources(),
			R.drawable.background_image);
	// ��� ȭ��

	private Bitmap tree1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree);
	private Bitmap tree2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree2);
	private Bitmap tree3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree3);
	// �Ϲ� ����
	private Bitmap treeMid1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree_mid);
	private Bitmap treeMid2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree_mid2);
	private Bitmap treeMid3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree_mid3);
	// �߰� ������ ����
	private Bitmap treeLow1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree_low);
	private Bitmap treeLow2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree_low2);
	private Bitmap treeLow3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.appletree_low3);
	// ���� ������ ����

	private Bitmap people1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people);
	private Bitmap people2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people2);
	private Bitmap people3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people3);
	// Ŭ���� ����(���� ������)
	private Bitmap peopleMid1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_mid);
	private Bitmap peopleMid2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_mid2);
	private Bitmap peopleMid3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_mid3);
	// Ŭ���� ����(�߰� ������)

	private Bitmap apple = BitmapFactory.decodeResource(getResources(),
			R.drawable.apple);
	// ���
	private Bitmap apple_throw = BitmapFactory.decodeResource(getResources(),
			R.drawable.apple_throw);

	private Bitmap item1A = BitmapFactory.decodeResource(getResources(),
			R.drawable.item1_a);
	private Bitmap item1D = BitmapFactory.decodeResource(getResources(),
			R.drawable.item1_d);
	// �ϳ� ������ Ǯ
	private Bitmap item2A = BitmapFactory.decodeResource(getResources(),
			R.drawable.item2_a);
	private Bitmap item2D = BitmapFactory.decodeResource(getResources(),
			R.drawable.item2_d);
	// ��ü ������ ����
	private Bitmap item3A = BitmapFactory.decodeResource(getResources(),
			R.drawable.item3_a);
	private Bitmap item3D = BitmapFactory.decodeResource(getResources(),
			R.drawable.item3_d);
	// �������� �츮��

	private Bitmap heal_one1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal_full1);
	private Bitmap heal_one2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal_full1);
	private Bitmap heal_one3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal_full1);
	// ���� �ϳ� ü�°���ü��� ����Ʈ
	private Bitmap heal_all1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal_all1);
	private Bitmap heal_all2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal_all2);
	private Bitmap heal_all3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal_all3);
	// ��ü���� ü��ȸ�� ����Ʈ
	private Bitmap heal1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal1);
	private Bitmap heal2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal2);
	private Bitmap heal3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.heal3);
	// �츮�� ����Ʈȿ��
	private Bitmap gameOver = BitmapFactory.decodeResource(getResources(),
			R.drawable.gameover);

	private Bitmap peopleR1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_right1);
	private Bitmap peopleR2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_right2);
	private Bitmap peopleR3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_right3);
	// ������� �̹���
	private Bitmap peopleL1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_left1);
	private Bitmap peopleL2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_left2);
	private Bitmap peopleL3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_left3);
	// ������� �̹���
	private Bitmap ballon1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.ballon1);
	private Bitmap ballon2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.ballon2);
	private Bitmap ballon3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.ballon3);
	// ����� �̹���
	private Bitmap people_boss1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_boss1);
	private Bitmap people_boss2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_boss2);
	private Bitmap people_boss3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.people_boss3);
	// ���� ���� ������ ����̹���
	private Bitmap ballon_boss1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.ballon_boss1);
	private Bitmap ballon_boss2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.ballon_boss2);
	private Bitmap ballon_boss3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.ballon_boss3);
	// ���� ���� ������ ��ǳ�� �̹���
	private Bitmap button_attack_1 = BitmapFactory.decodeResource(
			getResources(), R.drawable.button1);
	private Bitmap button_attack_2 = BitmapFactory.decodeResource(
			getResources(), R.drawable.button2);
	private Bitmap button_attack_3 = BitmapFactory.decodeResource(
			getResources(), R.drawable.button3);
	// ��������� ��ư �̹���
	private Bitmap basket = BitmapFactory.decodeResource(getResources(),
			R.drawable.basket);
	// ����ٱ��� �̹���
	private Bitmap manyApple = BitmapFactory.decodeResource(getResources(),
			R.drawable.many_apple);
	// �׿��ִ� ��� �̹���
	private Bitmap bug1_1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug1_1);
	private Bitmap bug1_2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug1_2);
	private Bitmap bug1_3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug1_3);
	// ����1 �̹���
	private Bitmap bug2_1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug2_1);
	private Bitmap bug2_2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug2_2);
	private Bitmap bug2_3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug2_3);
	// ����2 �̹���
	private Bitmap bug3_1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug3_1);
	private Bitmap bug3_2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug3_2);
	private Bitmap bug3_3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.bug3_3);
	// ����3 �̹���

	private Bitmap boss1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.boss1);
	private Bitmap boss2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.boss2);
	private Bitmap boss3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.boss3);
	// ���� ���� �̹���

	private Bitmap boss_attack1 = BitmapFactory.decodeResource(getResources(),
			R.drawable.boss_attack1);
	private Bitmap boss_attack2 = BitmapFactory.decodeResource(getResources(),
			R.drawable.boss_attack2);
	private Bitmap boss_attack3 = BitmapFactory.decodeResource(getResources(),
			R.drawable.boss_attack3);
	// ���� ���� ���� �̹���
	private Bitmap boss_damage = BitmapFactory.decodeResource(getResources(),
			R.drawable.boss_dam);
	// �������� ��� �¾����� �̹���
	private Bitmap level = BitmapFactory.decodeResource(getResources(),
			R.drawable.level);
	// ���̵� ��� �̹���
	private Rect[] box_Item;
	// ������ Ŭ���� ���� �簢��
	private Rect[] gameOverBtn;
	private Rect[][] box_Tree;
	// ��� ���� Ŭ���� ���� �簢��
	private AppleTree[][] arrayTree;
	// ���� ���¸� ǥ���ϱ� ���� ������ ��ü ���� ����
	private AppleTree[][] prevTree;
	// ������� ��Ʈ���� ������ ���� ,Ŭ���� ������ ������ ������ ���� �����մϴ�.

	private Paint[][] Pnt;
	// ü�¹ٸ� �׸������� ����Ʈ ��ü�Դϴ�.
	private float[][] HP;
	// 9���� ������ ü���� ���� ǥ���մϴ�.
	private boolean[][] fullEnergy;
	// �������� �������� �ƴ��� Ȯ���մϴ�.
	private boolean[][] lowEnergy;
	// �������� �� ���� ���� �������� Ȯ���մϴ�.
	private boolean[][] midEnergy;
	// �������� �߰����Ϸ� ������ �������� Ȯ���մϴ�.
	private boolean[] itemAvailable;
	private boolean[] itemUse;
	private boolean saveApple = false;
	// ����� ������ ������ üũ�մϴ�.
	private int numOfApple;
	// �� ���� ����� ������ ǥ���մϴ�.
	public static long currentTime = 0;
	public static long sumOfTime = 0;
	public static long sumOfBossTime = 0;
	public static long startTime = 0;
	public static long bossStartTime = 0;
	public static long timeOfMin = 0;
	public static long bossTime = 0;
	// public int timeOfSec = 0;
	// �ð�
	public static int recordMin;
	public static int recordSec;
	// ��� �ð�

	private int peopleRPosX = 0;
	private int peopleLPosX = scaleWidth / 2 + scaleWidth / 3;
	// �ϴܿ� �����̴� ����� ���� ����
	private int bossPosRX = 0;
	private int bossPosLX = scaleWidth / 2 + scaleWidth / 7;
	private boolean bossAppear = false;
	private int bossHP = 5;
	// �������͸� ���� ����
	private Rect buttonApple;
	private int attackDelay = 10;
	private boolean throwApple = false;
	private int throwApplePos = 0;
	private int throwInitPos = 0;
	// ������ ����� ���� ����
	private int[][] bugState;
	private int[][] bugCount;
	private int[][] bugDelay;

	// ������ ���¸� ��Ÿ���� ����

	/**
	 * �����ڷν� ������ �̹������� �ʱ�ȭ ���ָ�, surfaceView�� �̿��ϱ� ���� ��ü�� �����մϴ�.
	 */
	public AppleTreeGameView(Context context) {
		// ������
		super(context);
		this.initVariable();
		// ���� �ʱ�ȭ
		this.initImage();
		// �̹��� �ʱ�ȭ

		getHolder().addCallback(this);
		movingTree = new AppleTreeThread(getHolder(), this);
		// surfaceView�� ���� ��ü��.
	}

	/**
	 * �����ڿ��� ȣ��Ǵ� helper�޼ҵ�ν� ������ �ʱ�ȭ�մϴ�.
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
		// ȿ����
		m_Sound_Effect_GameOver = MediaPlayer.create(getContext(),
				R.raw.gameover);

		m_Sound_Effect_Damage = MediaPlayer.create(getContext(), R.raw.damage);
		m_Sound_Level_Up = MediaPlayer.create(getContext(), R.raw.levelup);
		m_Sound_attack = MediaPlayer.create(getContext(), R.raw.attack);
		m_Sound_throw = MediaPlayer.create(getContext(), R.raw.throw_apple);
		m_Sound_boss_dam = MediaPlayer.create(getContext(), R.raw.boss_damage);
		m_Sound_boss_die = MediaPlayer.create(getContext(), R.raw.boss_die);
		numOfApple = 0;
		// �� ��� ����.
		arrayTree = new AppleTree[3][3];
		prevTree = new AppleTree[3][3];
		// 9���� ������ ������� ��ü
		box_Tree = new Rect[3][3];
		box_Item = new Rect[3];
		gameOverBtn = new Rect[2];
		itemAvailable = new boolean[3];
		itemUse = new boolean[3];
		// 9���� �簢�� Ŭ���� ���ؼ�
		// ��������� ���� �ʱ�ȭ.

		Pnt = new Paint[3][3];
		// 9���� ������ �������� �Ӽ�
		HP = new float[3][3];
		// 9���� ������ ��������
		fullEnergy = new boolean[3][3];
		midEnergy = new boolean[3][3];
		lowEnergy = new boolean[3][3];
		// 9�������� ������ ����(���� ����ǥ�ø� ���Ѻ���)

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
	 * �����ڿ��� ȣ��Ǵ� helper�޼ҵ�ν� �̹����� �ʱ�ȭ�մϴ�.
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
		// ���� ������ ���� �̹���(������ ���̻�)
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
		// ����� ���� �̹���(������ �� ����)

		people1 = Bitmap.createScaledBitmap(people1, scaleWidth / 3,
				scaleHeight / 5, true);
		people2 = Bitmap.createScaledBitmap(people2, scaleWidth / 3,
				scaleHeight / 5, true);
		people3 = Bitmap.createScaledBitmap(people3, scaleWidth / 3,
				scaleHeight / 5, true);
		// ������ ����(Ŭ���� ��Ÿ���� �̹���)(������ ���̻�)
		peopleMid1 = Bitmap.createScaledBitmap(peopleMid1, scaleWidth / 3,
				scaleHeight / 5, true);
		peopleMid2 = Bitmap.createScaledBitmap(peopleMid2, scaleWidth / 3,
				scaleHeight / 5, true);
		peopleMid3 = Bitmap.createScaledBitmap(peopleMid3, scaleWidth / 3,
				scaleHeight / 5, true);
		// ����� ���� (Ŭ���� ��Ÿ���� �̹���)(������ ������)
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
	 * 9���� ��������� ���� ��ü������ Ŭ���� ���� �簢�� ������ ���� ��ü�� �������ִ� helper�޼ҵ� �Դϴ�.
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
	 * ����������� ���¸� �ʱ�ȭ �����ִ� �޼ҵ��Դϴ�.
	 */
	private void setAppleTree() {
		// �ʱ� ������ ���¸� Ŭ���� �Ͼ�� �������� ����, �ʱ� ��������� �ڽ��� ����.
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
	 * �ʱ��� �������¸� �ʱ�ȭ �մϴ�.
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
	 * ������ �پ����� ���� ��������� ������ ���Դϴ�.
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
	 * 9���� ��������� �������ٸ� ���� ��ü������ �������� ���� ���� ����� ���� boolean������ �ʱ�ȭ�ϴ� helper
	 * �޼ҵ��Դϴ�.
	 */
	public void setEnergy() {
		// �ʱ� ��������� �������ٸ� ����.
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
	 * ������1 ȿ���� �������� ���� �޼ҵ��Դϴ�.
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
	 * ������2�� �������� ���� �޼ҵ��Դϴ�.
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
	 * ������3 ȿ���� �������� ���� �޼ҵ��Դϴ�.
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
	 * �ϴܿ� �������� �̵��ϴ� ����� �������� ���� �޼ҵ�
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
	 * �ϴܿ� �������� �̵��ϴ� ����� �������� ���� �޼ҵ�
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
	 * ������� �������� ���� �޼ҵ�
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
	 * ���� ������ ����� �������� ���� �޼ҵ�
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
	 * ���� ������ ��ǳ���� �������� ���� �޼ҵ�
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
	 * ��������� ��ư�� �������� ���� �޼ҵ�
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
	 * ����1�� �������� ���� �޼ҵ�
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
	 * ����2�� �������� ���� �޼ҵ�
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
	 * ����3�� �������� ���� �޼ҵ�
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
	 * surfaceView�� �����忡�� ����ؼ� ȣ��Ǿ� ��������� �����̴� ȿ���� �ִ� �޼ҵ��Դϴ�. (������ ����)(������ ���̻�)
	 */
	public void setTree(int state) {
		// ��������� ������ ���¸� �������ִ� setter
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
	 * surfaceView�� �����忡�� ����ؼ� ȣ��Ǿ� ��������� �����̴� ȿ���� �ִ� �޼ҵ��Դϴ�. (����� ����)(������ ������)
	 */
	public void setMidTree(int state) {
		// ��������� ������ ���¸� �������ִ� setter
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
	 * surfaceView�� �����忡�� ����ؼ� ȣ��Ǿ� ��������� �����̴� ȿ���� �ִ� �޼ҵ��Դϴ�. (���� ����)(������ ����)
	 */
	public void setLowTree(int state) {
		// ��������� ������ ���¸� �������ִ� setter
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
	 * surfaceView�� �����忡�� ����ؼ� ȣ��Ǿ� ��������� �����̴� ȿ���� �ִ� �޼ҵ��Դϴ�. (Ŭ���� ���볪��)
	 */
	public void setPeople(int state) {
		// ����� �ִ� ��������� ���¸� �������ִ� setter
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
	 * surfaceView�� �����忡�� ����ؼ� ȣ��Ǿ� ��������� �����̴� ȿ���� �ִ� �޼ҵ��Դϴ�. (Ŭ���� ����ѳ���)
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
	 * ���� ������ �������� ���� �޼ҵ�
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
	 * ���� ������ ������ �������� ���� �޼ҵ�
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
	 * ������ Ŭ���� ���� �̺�Ʈ�� �޴� �޼ҵ��Դϴ�.
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
		// ������ Ŭ���� ���� ����.

		if (box_Item[0].contains(px, py) && itemAvailable[0] == true) {
			/*
			 * ���� ������ ���� �������� Ȱ��ȭ �Ǿ��ִٸ�
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
						 * ���� ���� ����Ȥ�� ������ ������� ������ ����� �ȵ˴ϴ�.
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
			 * ���� ����ź �������� Ȱ��ȭ �Ǿ��ٸ�
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
							 * ���� ���� ����Ȥ�� ������ ������� ������ ����� �ȵ˴ϴ�.
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
			 * ���� ��ȣ�� �������� Ȱ��ȭ �Ǿ��ٸ�
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
	 * ���� ���͸� �׸��� �޼ҵ�(onDraw���� ȣ��)
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
			 * ��ġ �ٲٱ�
			 */
			bossPosRX = 0;
			bossPosLX = scaleWidth / 2 + scaleWidth / 7;
		}

	}

	/**
	 * ���󰡴� ����� �׸��� �޼ҵ�(onDraw���� ȣ��)
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
			// ������ ����� ������
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
				// ������ ����� ������
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
	 * ��� ������ ��ư�� �̺�Ʈ�� ����ϴ� �޼ҵ�(onTouchEvent �޼ҵ忡�� ȣ��)
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
	 * ������� Ŭ���� ���� �̺�Ʈ�� �޴� �޼ҵ��Դϴ�.
	 */
	private void treeClickEvent(MotionEvent event) {
		int px = (int) event.getX();
		int py = (int) event.getY();
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				box_Tree[x][y].set(scaleWidth / 3 * x, scaleHeight / 5
						* (y + 1), scaleWidth / 3 * x + tree.getWidth(),
						scaleHeight / 5 * (y + 1) + tree.getHeight());
				// ������� Ŭ���� ���� ����

				if (box_Tree[x][y].contains(px, py) && lowEnergy[x][y] == false) {
					/*
					 * ���� ������ ��������� �������� ���������� �ʴٸ�, (�������� �������������� ��� �޾������� Ŭ����
					 * �ȵ˴ϴ�.)
					 */
					if (HP[x][y] <= scaleWidth / 15) {
					} else {
						// ������ ä���
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
						// ������ ���̻�
						if (prevTree[x][y].getState() != AppleTree.STATE_CLICK_OFF) {
							// ���� ��������� ���°� ������, ������� ���¸� ����� ���� ������ ����.
							prevTree[x][y].setState(AppleTree.STATE_CLICK_OFF);
						}
						if (arrayTree[x][y].getState() == AppleTree.STATE_CLICK_OFF) {
							// ��� ������ ���¸� ����� �մ� ������ ����.
							prevTree[x][y] = arrayTree[x][y];
							arrayTree[x][y].setState(AppleTree.STATE_CLICK_ON);
						}
					}
					if (midEnergy[x][y] == true) {
						if (prevTree[x][y].getState() != AppleTree.STATE_CLICK_OFF) {
							// ���� ��������� ���°� ������, ������� ���¸� ����� ���� ������ ����.
							prevTree[x][y]
									.setState(AppleTree.STATE_CLICK_OFF_MID);
						}
						if (arrayTree[x][y].getState() == AppleTree.STATE_CLICK_OFF_MID) {
							// ��������� ���¸� ����� �ִ°����� ����
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
	 * ��������� ��ġ�Ͽ����� ȿ���� �ݴϴ�. 9���� �簢�������� ǥ���ϰ� �׿����� ��ġ�������� �̺�Ʈ�� �߻��մϴ�.
	 */
	public boolean onTouchEvent(MotionEvent event) {
		// ��������� Ŭ��������, �Ͼ�� �̺�Ʈ�� ����Ű�� �޼ҵ�
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
	 * �ð迡�� �ʿ� ���� �÷��ִ� �޼ҵ��Դϴ�.
	 */
	private void time() {
		// currentTime�� ����!!!!!!(��¥�ð��� �����մ� �Ф�)
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
	 * �������� ������ Ʈ���� �ð��� üũ���ݴϴ�.
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
		// �׿��մ� ���

		if (bossAppear == true) {

			canvas.drawBitmap(button, scaleWidth / 2 + scaleWidth / 3
					+ scaleWidth / 20, scaleHeight / 4 * 3 + scaleWidth / 5,
					null);

		} else {
			canvas.drawBitmap(basket, scaleWidth / 2 + scaleWidth / 3
					+ scaleWidth / 10, scaleHeight / 4 * 3 + scaleWidth / 5
					+ scaleWidth / 20, null);
		}
		// �ٱ���
		if (peopleRPosX >= scaleWidth / 2 + scaleWidth / 3) {
			// �쿡�� �·� �����̴� ���
			if (bossAppear == false) {
				canvas.drawBitmap(apple, scaleWidth / 2 + scaleWidth / 3
						+ scaleWidth / 10, scaleHeight / 4 * 3 + scaleWidth / 5
						+ scaleWidth / 20, null);
			}
			// �ٱ��� �ȿ� ���
			if (bossAppear == true) {
				canvas.drawBitmap(people_boss, 0 + peopleLPosX, scaleHeight / 4
						* 3 + scaleWidth / 5, null);
				// ���ʻ��
				canvas.drawBitmap(ballon_boss, scaleWidth / 22 + peopleLPosX,
						scaleHeight / 4 * 3 + scaleWidth / 7, null);
				// ����ǥ ǳ��
			} else {
				canvas.drawBitmap(peopleL, 0 + peopleLPosX, scaleHeight / 4 * 3
						+ scaleWidth / 5, null);
				// ���ʻ��
				canvas.drawBitmap(ballon, scaleWidth / 22 + peopleLPosX,
						scaleHeight / 4 * 3 + scaleWidth / 7, null);
				// ����� ǳ��
			}
			peopleLPosX -= 70;

		} else {
			if (bossAppear == true) {
				canvas.drawBitmap(apple, scaleWidth / 30 + peopleRPosX,
						scaleHeight / 4 * 3 + scaleWidth / 5 + scaleWidth / 20,
						null);
				// ���ٴϴ� ���
				canvas.drawBitmap(people_boss, 0 + peopleRPosX, scaleHeight / 4
						* 3 + scaleWidth / 5, null);
				// ���ʻ��
				canvas.drawBitmap(ballon_boss, scaleWidth / 22 + peopleRPosX,
						scaleHeight / 4 * 3 + scaleWidth / 7, null);
				// ����� ǳ��
			} else {
				// �¿��� ��� �����̴� ���
				canvas.drawBitmap(peopleR, 0 + peopleRPosX, scaleHeight / 4 * 3
						+ scaleWidth / 5, null);
				// �����ʻ��
				canvas.drawBitmap(ballon, scaleWidth / 22 + peopleRPosX,
						scaleHeight / 4 * 3 + scaleWidth / 7, null);
				// ����� ǳ��
				canvas.drawBitmap(apple, scaleWidth / 30 + peopleRPosX,
						scaleHeight / 4 * 3 + scaleWidth / 5 + scaleWidth / 20,
						null);
				// ���ٴϴ� ���
			}
			peopleRPosX += 70;
		}
		if (peopleLPosX <= 0) {
			/*
			 * ��ġ �ٲٱ�
			 */
			peopleRPosX = 0;
			peopleLPosX = scaleWidth / 2 + scaleWidth / 3;
		}
	}

	/**
	 * ������ �׸��� �޼ҵ�(onDraw�޼ҵ忡�� ȣ��)
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
	 * ���� ��������� �׷��ִ� �޼ҵ��Դϴ�. �����忡���� �ݺ������� ȣ��˴ϴ�.
	 */
	private void drawSubMenu(Canvas canvas) {
		int startLineHP;
		float endLineHP;

		Paint txtOfApple = new Paint();// paint�� �׷����� ��ü�� �Ӽ����� ������ ��.
		txtOfApple.setColor(Color.BLACK);
		txtOfApple.setTextSize(scaleWidth / 30);
		// ������� ���� ǥ��ĭ�� �Ӽ�
		Paint txtOfTime = new Paint();
		txtOfTime.setColor(Color.BLACK);
		txtOfTime.setTextSize(scaleWidth / 4);
		// �ð� �ؽ�Ʈ�� �Ӽ�

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				// �������ټӼ�
				canvas.drawText("��� ����   :    " + numOfApple,
						scaleWidth / 3 * 2, scaleHeight / 7 * 1, txtOfApple);
				// ����� ������ ��Ÿ���� �ؽ�Ʈ ���ڸ� �׷��ݴϴ�.

				if (numOfApple >= 3) {
					canvas.drawBitmap(item1A, scaleWidth / 3 * 2,
							scaleHeight / 20, null);
					itemAvailable[0] = true;
				} else {
					canvas.drawBitmap(item1D, scaleWidth / 3 * 2,
							scaleHeight / 20, null);
					itemAvailable[0] = false;
				}
				// ������1(�Ա���) ��� 3���̻� Ȱ��ȭ
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
				// ������ 2(����ź) ��� 5���̻� Ȱ��ȭ
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
				// ������3(����) ��� 9���̻� Ȱ��ȭ

				canvas.drawText(Long.toString(timeOfMin), scaleWidth / 60,
						scaleHeight / 8, txtOfTime);
				// canvas.drawText(
				// Long.toString(timeOfMin) + " "
				// + Long.toString(bossTime), scaleWidth / 60,
				// scaleHeight / 8, txtOfTime);
				// �ð�
				startLineHP = (scaleWidth / 3 * 0) + scaleWidth / 15;// ������
				endLineHP = (scaleWidth / 3 * 0) + tree1.getWidth() - HP[x][y];// ����
				// ���������� �������� ������ ���� �����Դϴ�.
				if (startLineHP > (int) endLineHP) {
					/*
					 * ���� �������� ��� �޾Ҵٸ�
					 */
					arrayTree[x][y].setState(AppleTree.STATE_LOW);
					// ���������� �̹����� ��ü���ݴϴ�.
					lowEnergy[x][y] = true;
					// �� ������ ���̻� Ŭ���� �Ұ����ϵ��� ���������� ǥ�����ݴϴ�.
				} else {
					/*
					 * ���� �������� ���� �����ִٸ�
					 */
					lowEnergy[x][y] = false;
					if (fullEnergy[x][y] == false) {
						/*
						 * ���� ������� �������� ���� ������ �ʴٸ� �������� �ܴ�.
						 */
						int centerOfEnergy = tree1.getWidth() / 2;
						// ���������� �߰���ġ�� ��Ÿ���� ������
						if ((int) endLineHP <= centerOfEnergy) {
							/*
							 * ���� �������� �߰� ���϶��
							 */
							midEnergy[x][y] = true;
							// �̹����� �߰������� �̹����� ��ü���ֱ����� �������� true�� �����մϴ�.

							arrayTree[x][y]
									.setState(AppleTree.STATE_CLICK_OFF_MID);
							// �̹����� ��ü���ݴϴ�.
						}
						if ((int) endLineHP > centerOfEnergy) {
							/*
							 * �������� �� �̻��ϰ��
							 */
							midEnergy[x][y] = false;
							arrayTree[x][y].setState(AppleTree.STATE_CLICK_OFF);
							// �������� �ٽ� false�� �ٲپ��ݴϴ�.
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

						// �������� ���ݾ� ��� �����մϴ�.
					}
				}

				if (saveApple == true) {
					/*
					 * ���� ����� ȹ���ߴٸ�.
					 */
					canvas.drawBitmap(apple, scaleWidth / 3 * 2,
							scaleHeight / 7 * 1, null);

					saveApple = false;

					// ��� ���� �ؽ�Ʈ���� ��� �̹����� �����ݴϴ�.
					//
				}

			}
		}
	}

	/**
	 * 9���� ��������� �׸��� �޼ҵ�(onDraw �޼ҵ忡�� ȣ��)
	 */
	private void drawTree(Canvas canvas) {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				Pnt[x][y].setStrokeWidth(scaleWidth / 70);
				Pnt[x][y].setStrokeCap(Paint.Cap.ROUND);
				Pnt[x][y].setColor(Color.RED);
				if (arrayTree[x][y].getState() == AppleTree.STATE_CLICK_OFF) {
					/*
					 * ����� ������.
					 */
					canvas.drawBitmap(tree, scaleWidth / 3 * x, scaleHeight / 5
							* (y + 1), null);
					// drawLine(������ x, ������ y, ���� x, ���� y);
					canvas.drawLine((scaleWidth / 3 * x) + scaleWidth / 15,
							scaleHeight / 5 * (y + 1) + tree1.getHeight()
									- scaleWidth / 30, (scaleWidth / 3 * x)
									+ tree1.getWidth() - HP[x][y], scaleHeight
									/ 5 * (y + 1) + tree1.getHeight()
									- scaleWidth / 30, Pnt[x][y]);

				} else if (arrayTree[x][y].getState() == AppleTree.STATE_CLICK_ON) {
					/*
					 * ����� ������.
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
					 * ������ �׾�����
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
					 * �߰������������� ����(Ŭ����)
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
					 * �߰������� ������ ����(����)
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
	 * ������ ��������, ȣ��Ǵ� �޼ҵ��Դϴ�. (������ ������ ���� �ذ� ����)
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
	 * ����� �׸��� �޼ҵ�(onDraw�޼ҵ忡�� ȣ��)
	 */
	private void drawBackGround(Canvas canvas) {
		canvas.drawBitmap(backGround, 0, 0, null);
	}

	/**
	 * ���������� ������ �׸��� �޼ҵ�(onDraw���� ȣ�� ���� �����ÿ��� ȣ��ȴ�.)
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
	 * ���� ��ü�� �׷��ִ� �޼ҵ��Դϴ�. �����忡 ���ؼ� ���������� ȣ��Ǿ����ϴ�.
	 */
	public void onDraw(Canvas canvas) {
		// ���� ��ü�� �׷��ִ� �޼ҵ�
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
