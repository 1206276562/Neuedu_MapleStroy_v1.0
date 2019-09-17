package com.neuedu.maplestory.constant;
/**
 * �����Ŀ�����еĳ���
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
	 * ����key����int���͵�����ֵ
	 * @param key properties�е�name
	 * @return	int���͵�����ֵ
	 */
	public static int getProperty(String key) {
		return Integer.parseInt(props.getProperty(key));
	}
	/**
	 * ���ڿ��
	 */
	public static int GAME_WIDTH = getProperty("GAME_WIDTH");
	/**
	 * ���ڸ߶�
	 */
	public static int GAME_HEIGHT = getProperty("GAME_HEIGHT");
	/**
	 * ͼƬǰ׺
	 */
	public static String IMG_PRE = props.getProperty("IMG_PRE");
	/**
	 * hero���ƶ��ٶ�
	 */
	public static int HERO_SPEED = getProperty("HERO_SPEED");

	public static int HERO_JUMP_SPEED = getProperty("HERO_JUMP_SPEED");
	/**
	 * hero������
	 */
	public static int HERO_ATT = getProperty("HERO_ATT");
	/**
	 * mob�Ĺ�����
	 */
	public static int MOB_ATT = getProperty("MOB_ATT");
}

