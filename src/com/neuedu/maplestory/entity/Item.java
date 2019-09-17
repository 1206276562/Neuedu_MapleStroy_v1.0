package com.neuedu.maplestory.entity;

import java.awt.Graphics;
import java.awt.Image;

import com.neuedu.maplestory.client.MapleStoryClient;
import com.neuedu.maplestory.constant.Constant;
import com.neuedu.maplestory.util.ImageUtil;

public class Item extends MapleStoryObject {
	
	public static Image[] imgs = new Image[20];
	static {
		for (int i = 1; i <11; i++) {
			imgs[i] =ImageUtil.get("item1_"+i);
		}
	}
	/**
	 * Item ���޲ι���
	 */
	public Item() {
	}
	//item����
	public int itemType;
/**
 * Item���вι���
 * @param msc	��ͣ��ģʽmsc
 * @param x		item��x����
 * @param y		item��y����
 * @param itemType	item������
 */
	public Item(MapleStoryClient msc, int x, int y, int itemType) {
		this.x = x;
		this.y = y;
		this.img = ImageUtil.get("item1_1");
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		switch (itemType) {
		case 0:
			this.img = ImageUtil.get("item1_1");
			break;
		case 1:
			this.img = ImageUtil.get("item1_2");
			break;
		case 2:
			this.img = ImageUtil.get("item1_3");
			break;
		case 3:
			this.img = ImageUtil.get("item1_4");
			break;
		case 4:
			this.img = ImageUtil.get("item1_5");
			break;
		case 5:
			this.img = ImageUtil.get("item1_6");
			break;
		case 6:
			this.img = ImageUtil.get("item1_7");
			break;
		case 7:
			this.img = ImageUtil.get("item1_8");
			break;
		case 8:
			this.img = ImageUtil.get("item1_9");
			break;
		case 9:
			this.img = ImageUtil.get("item1_10");
			break;
		default:
			break;
		}
		this.itemType = itemType;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
		move();
	}

	@Override
	public void move() {
		if (jump) {
			jump();
		}

	}

	private double v0 = Constant.HERO_JUMP_SPEED;
	private double vt = 0;
	private double delta_h = 0;
	private static final double g = 9.8;
	private double t = 0.5;
	private boolean jump_up = true; // Ĭ��ֵΪ����
	private boolean jump = true;
/**
 * item����jump����
 */
	public void jump() {
		// ��ֱ����
		if (jump_up) {
			vt = v0 - g * t;
			v0 = vt;
			delta_h = v0 * t;
			y -= delta_h;
			if (vt <= 0) {
				v0 = 0; // Ϊ�´θ�ֵ׼����
				vt = 0;
				jump_up = false;
			}
		}
		// ��������
		else {
			vt = v0 + g * t;
			v0 = vt;
			delta_h = v0 * t;
			y += delta_h;
			if (y > Constant.GAME_HEIGHT - height -100 ) {
				y = Constant.GAME_HEIGHT - height-100;
				jump_up = true;
				// ��һ����ֱ���׵��ٶ�ֵ��
				v0 = Constant.HERO_JUMP_SPEED;
				vt = 0;
				jump = false;
			}
		}
	}
}
