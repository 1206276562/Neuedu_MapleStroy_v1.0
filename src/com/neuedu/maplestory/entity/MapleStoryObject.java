package com.neuedu.maplestory.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.neuedu.maplestory.client.MapleStoryClient;

/**
 * 冒险岛中所有类的父类 
 * @author Administrator
 *
 */
public abstract class MapleStoryObject implements Moveable,Drawable {
	/**
	 * x  坐标
	 */
	public int x;
	/**
	 * y  坐标
	 */
	public int y;
	/**
	 * img  图片对象
	 */
	public Image img;
	/**
	 * speed  物体的速度
	 */
	public int speed;

	/**
	 * 持有MapleStoryClient的引用
	 * 调停者（中介者）设计模式
	 */
	public MapleStoryClient msc;
	/**
	 * 物体的存活状态
	 */
	public boolean live = true;
	/**
	 * 物体的高度
	 */
	public int height;
	/**
	 * 物体的宽度
	 */
	public int width;
	/**
	 * 物体的方向
	 */
	public Direction dir;
	/**
	 * 物体的动作状态
	 */
	public Action action;
	/**
	 * 物体的name
	 */
	public String name;
	/**
	 * 物体的经验
	 */
	public int EXP;
	/**
	 * 物体的血量
	 */
	public double HP;
	/**
	 * 物体的满血
	 */
	public double HP_FULL;
	/**
	 * 物体的蓝量
	 */
	public double MP;
	/**
	 * 物体的满蓝
	 */
	public double MP_FULL;
	/**
	 * 物体的等级
	 */
	public int level;
	@Override
	// 重写为抽象方法
	public abstract void draw(Graphics g);	
	
	@Override
	public abstract void move();
	
	/**
	 * 获取对象图片所在的矩形
	 * @return 返回一个矩形（左上角点的坐标，宽，高）
	 */
	public Rectangle getRectangle() {
		return  new Rectangle(x, y, width, height);
	}
}
