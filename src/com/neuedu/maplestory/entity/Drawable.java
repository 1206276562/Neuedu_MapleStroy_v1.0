package com.neuedu.maplestory.entity;

import java.awt.Graphics;

/**
 * 画的接口
 * @author Administrator
 *
 */
public interface Drawable {
	/**
	 * 所有对象物体都要画出来
	 * @param g  画笔
	 */
	void draw(Graphics g);
}
