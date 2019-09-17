package com.neuedu.maplestory.util;
/**
 * 加载游戏中所有的图片
 * @author Administrator
 *
 */

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.neuedu.maplestory.constant.Constant;

public final class ImageUtil {
	/**
	 * 存放项目中所有图片的键值对
	 */
	private static Map<String, Image> imgs = new HashMap<>();

	static {
		// icon对象
		imgs.put("icon", ImageUtil.getImage("icon/1"));
		// map
		imgs.put("map", ImageUtil.getImage("map/map"));
		// bottom
		imgs.put("bottom", ImageUtil.getImage("map/bottom"));
		// hero stand
		imgs.put("hero_stand_right", ImageUtil.getImage("hero/stand/right/stand1_0_right"));
		imgs.put("hero_stand_left", ImageUtil.getImage("hero/stand/left/stand1_0_left"));
		// hero prone
		imgs.put("hero_prone_left", ImageUtil.getImage("hero/prone/left/prone_0_left"));
		imgs.put("hero_prone_right", ImageUtil.getImage("hero/prone/right/prone_0_right"));
		// hero walk left
		for (int i = 0; i < 5; i++) {
			imgs.put("hero_walk_left" + i, ImageUtil.getImage("hero/walk/left/walk_left" + i));
		}
		// hero walk right
		for (int i = 0; i < 5; i++) {
			imgs.put("hero_walk_right" + i, ImageUtil.getImage("hero/walk/right/walk_right" + i));
		}
		// 跳 向左
		imgs.put("hero_jump_left", ImageUtil.getImage("hero/jump/left/jump_0"));
		// 跳 向右
		imgs.put("hero_jump_right", ImageUtil.getImage("hero/jump/right/jump_0"));
		// 攻击 向左
		for (int i = 0; i < 4; i++) {
			imgs.put("hero_shoot_left" + i, ImageUtil.getImage("hero/shoot/left/shoot_left" + i));
		}
		// 攻击向右
		for (int i = 0; i < 4; i++) {
			imgs.put("hero_shoot_right" + i, ImageUtil.getImage("hero/shoot/right/shoot_right" + i));
		}
		// 弓箭---武器向左
		imgs.put("hero_arrow_left", ImageUtil.getImage("bullet/arrow/left/arrow_left"));
		// 武器向右
		imgs.put("hero_arrow_right", ImageUtil.getImage("bullet/arrow/right/arrow_right"));
		// 子弹爆炸效果
		for (int i = 0; i < 7; i++) {
			imgs.put("shoot_boom" + i, ImageUtil.getImage("boom/boom" + i));
		}
		// 怪物 mob 向左站立
		for (int i = 0; i < 5; i++) {
			imgs.put("mob1_stand_left" + i, ImageUtil.getImage("mob/mob1/stand/left/" + i));
		}
		// 怪物 mob 向右站立
		for (int i = 0; i < 5; i++) {
			imgs.put("mob1_stand_right" + i, ImageUtil.getImage("mob/mob1/stand/right/" + i));
		}
		// 怪物的血块
		imgs.put("mob_blood", ImageUtil.getImage("mob/mob1/blood/blood"));
		// 怪物的移动 向左
		for (int i = 0; i < 5; i++) {
			imgs.put("mob1_walk_left" + i, ImageUtil.getImage("mob/mob1/walk/left/" + i));
		}
		// 怪物的移动 向右
		for (int i = 0; i < 5; i++) {
			imgs.put("mob1_walk_right" + i, ImageUtil.getImage("mob/mob1/walk/right/" + i));
		}
		// 怪物死亡 向左
		for (int i = 0; i < 9; i++) {
			imgs.put("mob1_die_left" + i, ImageUtil.getImage("mob/mob1/die/left/" + i));
		}
		// 怪物死亡 向右
		for (int i = 0; i < 9; i++) {
			imgs.put("mob1_die_right" + i, ImageUtil.getImage("mob/mob1/die/right/" + i));
		}
		// 掉落物体---药瓶
		for (int i = 1; i < 11; i++) {
			imgs.put("item1_" + i, ImageUtil.getImage("item/" + i));
		}
		// 怪物攻击 ---左边攻击
		for (int i = 0; i < 21; i++) {
			imgs.put("mob1_hit_left" + i, ImageUtil.getImage("mob/mob1/hit/left/" + i));
		}
		// 怪物攻击 ---右边攻击
		for (int i = 0; i < 21; i++) {
			imgs.put("mob1_hit_right" + i, ImageUtil.getImage("mob/mob1/hit/right/" + i));
		}
		// 台阶1
		imgs.put("target1", ImageUtil.getImage("target/1"));
		imgs.put("target2", ImageUtil.getImage("target/2"));
		imgs.put("target3", ImageUtil.getImage("target/3"));
		imgs.put("target4", ImageUtil.getImage("target/4"));
		imgs.put("target5", ImageUtil.getImage("target/5"));
		imgs.put("target6", ImageUtil.getImage("target/6"));
		imgs.put("target7", ImageUtil.getImage("target/7"));
//		imgs.put("target8", ImageUtil.getImage("target/8"));

		// hero攀爬动作
		for (int i = 0; i < 2; i++) {
			imgs.put("hero_ladder" + i, ImageUtil.getImage("hero/ladder/ladder_" + i));
		}
		// hero的等级显示图片
		imgs.put("level_0", ImageUtil.getImage("hero/level/0"));
		imgs.put("level_1", ImageUtil.getImage("hero/level/1"));
		imgs.put("level_2", ImageUtil.getImage("hero/level/2"));
		imgs.put("level_3", ImageUtil.getImage("hero/level/3"));
		imgs.put("level_4", ImageUtil.getImage("hero/level/4"));
		imgs.put("level_5", ImageUtil.getImage("hero/level/5"));
		imgs.put("level_6", ImageUtil.getImage("hero/level/6"));
		imgs.put("level_7", ImageUtil.getImage("hero/level/7"));
		imgs.put("level_8", ImageUtil.getImage("hero/level/8"));
		imgs.put("level_9", ImageUtil.getImage("hero/level/9"));
		// hero血条框
		imgs.put("HP", ImageUtil.getImage("hero/live/HP"));
		// hero蓝条框
		imgs.put("MP", ImageUtil.getImage("hero/live/MP"));
		// hero血条块
		imgs.put("hp_blood", ImageUtil.getImage("hero/live/hp_blood"));
		// hero蓝条块
		imgs.put("mp_blood", ImageUtil.getImage("hero/live/mp_blood"));
		// hero经验框
		imgs.put("EXP", ImageUtil.getImage("hero/live/EXP"));
		// hero经验块
		imgs.put("exp_blood", ImageUtil.getImage("hero/live/exp_blood"));
		//hero死亡
		imgs.put("hero_die", ImageUtil.getImage("hero/die/die"));
		//加载背景
		imgs.put("bc", ImageUtil.getImage("icon/bc"));

	}

//	List list = new AbstractList() {};

	/**
	 * 根据图片名称加载图片对象
	 * 
	 * @param path  路径
	 * @return img对象
	 */
	private static Image getImage(String path) {
		URL u = ImageUtil.class.getClassLoader().getResource(Constant.IMG_PRE + path + ".png");
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}

	/**
	 * 从Map中取图片对象
	 * 
	 * @param key 传进图片的key值，k,v
	 * @return 图片对象Image
	 */
	public static Image get(String key) {
		return imgs.get(key);
	}
}
