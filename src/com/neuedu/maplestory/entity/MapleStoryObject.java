package com.neuedu.maplestory.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.neuedu.maplestory.client.MapleStoryClient;

/**
 * ð�յ���������ĸ��� 
 * @author Administrator
 *
 */
public abstract class MapleStoryObject implements Moveable,Drawable {
	/**
	 * x  ����
	 */
	public int x;
	/**
	 * y  ����
	 */
	public int y;
	/**
	 * img  ͼƬ����
	 */
	public Image img;
	/**
	 * speed  ������ٶ�
	 */
	public int speed;

	/**
	 * ����MapleStoryClient������
	 * ��ͣ�ߣ��н��ߣ����ģʽ
	 */
	public MapleStoryClient msc;
	/**
	 * ����Ĵ��״̬
	 */
	public boolean live = true;
	/**
	 * ����ĸ߶�
	 */
	public int height;
	/**
	 * ����Ŀ��
	 */
	public int width;
	/**
	 * ����ķ���
	 */
	public Direction dir;
	/**
	 * ����Ķ���״̬
	 */
	public Action action;
	/**
	 * �����name
	 */
	public String name;
	/**
	 * ����ľ���
	 */
	public int EXP;
	/**
	 * �����Ѫ��
	 */
	public double HP;
	/**
	 * �������Ѫ
	 */
	public double HP_FULL;
	/**
	 * ���������
	 */
	public double MP;
	/**
	 * ���������
	 */
	public double MP_FULL;
	/**
	 * ����ĵȼ�
	 */
	public int level;
	@Override
	// ��дΪ���󷽷�
	public abstract void draw(Graphics g);	
	
	@Override
	public abstract void move();
	
	/**
	 * ��ȡ����ͼƬ���ڵľ���
	 * @return ����һ�����Σ����Ͻǵ�����꣬���ߣ�
	 */
	public Rectangle getRectangle() {
		return  new Rectangle(x, y, width, height);
	}
}
