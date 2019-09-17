package com.neuedu.maplestory.entity;
/**
 * 移动的接口
 * @author Administrator
 *
 */
public interface Moveable {
	/**
	 * 所有物体对象都要动（即使原地不动也要实现该接口）
	 */
	void move();
}
