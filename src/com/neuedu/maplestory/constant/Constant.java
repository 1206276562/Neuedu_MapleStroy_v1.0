package com.neuedu.maplestory.constant;
/**
 * 存放项目中所有的常量
 * @author Administrator
 *
 */

import java.io.IOException;
import java.util.Properties;

public class Constant {
	private static Properties props = new Properties();
	
	static {
		try {
			props.load(Constant.class.getClassLoader().getResourceAsStream("maplestory.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据key返回int类型的属性值
	 * @param key properties中的name
	 * @return	int类型的属性值
	 */
	public static int getProperty(String key) {
		return Integer.parseInt(props.getProperty(key));
	}
	/**
	 * 窗口宽度
	 */
	public static int GAME_WIDTH = getProperty("GAME_WIDTH");
	/**
	 * 窗口高度
	 */
	public static int GAME_HEIGHT = getProperty("GAME_HEIGHT");
	/**
	 * 图片前缀
	 */
	public static String IMG_PRE = props.getProperty("IMG_PRE");
	/**
	 * hero的移动速度
	 */
	public static int HERO_SPEED = getProperty("HERO_SPEED");

	public static int HERO_JUMP_SPEED = getProperty("HERO_JUMP_SPEED");
	/**
	 * hero攻击力
	 */
	public static int HERO_ATT = getProperty("HERO_ATT");
	/**
	 * mob的攻击力
	 */
	public static int MOB_ATT = getProperty("MOB_ATT");
}

