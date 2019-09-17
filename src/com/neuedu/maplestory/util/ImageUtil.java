package com.neuedu.maplestory.util;
/**
 * ������Ϸ�����е�ͼƬ
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
	 * �����Ŀ������ͼƬ�ļ�ֵ��
	 */
	private static Map<String, Image> imgs = new HashMap<>();

	static {
		// icon����
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
		// �� ����
		imgs.put("hero_jump_left", ImageUtil.getImage("hero/jump/left/jump_0"));
		// �� ����
		imgs.put("hero_jump_right", ImageUtil.getImage("hero/jump/right/jump_0"));
		// ���� ����
		for (int i = 0; i < 4; i++) {
			imgs.put("hero_shoot_left" + i, ImageUtil.getImage("hero/shoot/left/shoot_left" + i));
		}
		// ��������
		for (int i = 0; i < 4; i++) {
			imgs.put("hero_shoot_right" + i, ImageUtil.getImage("hero/shoot/right/shoot_right" + i));
		}
		// ����---��������
		imgs.put("hero_arrow_left", ImageUtil.getImage("bullet/arrow/left/arrow_left"));
		// ��������
		imgs.put("hero_arrow_right", ImageUtil.getImage("bullet/arrow/right/arrow_right"));
		// �ӵ���ըЧ��
		for (int i = 0; i < 7; i++) {
			imgs.put("shoot_boom" + i, ImageUtil.getImage("boom/boom" + i));
		}
		// ���� mob ����վ��
		for (int i = 0; i < 5; i++) {
			imgs.put("mob1_stand_left" + i, ImageUtil.getImage("mob/mob1/stand/left/" + i));
		}
		// ���� mob ����վ��
		for (int i = 0; i < 5; i++) {
			imgs.put("mob1_stand_right" + i, ImageUtil.getImage("mob/mob1/stand/right/" + i));
		}
		// �����Ѫ��
		imgs.put("mob_blood", ImageUtil.getImage("mob/mob1/blood/blood"));
		// ������ƶ� ����
		for (int i = 0; i < 5; i++) {
			imgs.put("mob1_walk_left" + i, ImageUtil.getImage("mob/mob1/walk/left/" + i));
		}
		// ������ƶ� ����
		for (int i = 0; i < 5; i++) {
			imgs.put("mob1_walk_right" + i, ImageUtil.getImage("mob/mob1/walk/right/" + i));
		}
		// �������� ����
		for (int i = 0; i < 9; i++) {
			imgs.put("mob1_die_left" + i, ImageUtil.getImage("mob/mob1/die/left/" + i));
		}
		// �������� ����
		for (int i = 0; i < 9; i++) {
			imgs.put("mob1_die_right" + i, ImageUtil.getImage("mob/mob1/die/right/" + i));
		}
		// ��������---ҩƿ
		for (int i = 1; i < 11; i++) {
			imgs.put("item1_" + i, ImageUtil.getImage("item/" + i));
		}
		// ���﹥�� ---��߹���
		for (int i = 0; i < 21; i++) {
			imgs.put("mob1_hit_left" + i, ImageUtil.getImage("mob/mob1/hit/left/" + i));
		}
		// ���﹥�� ---�ұ߹���
		for (int i = 0; i < 21; i++) {
			imgs.put("mob1_hit_right" + i, ImageUtil.getImage("mob/mob1/hit/right/" + i));
		}
		// ̨��1
		imgs.put("target1", ImageUtil.getImage("target/1"));
		imgs.put("target2", ImageUtil.getImage("target/2"));
		imgs.put("target3", ImageUtil.getImage("target/3"));
		imgs.put("target4", ImageUtil.getImage("target/4"));
		imgs.put("target5", ImageUtil.getImage("target/5"));
		imgs.put("target6", ImageUtil.getImage("target/6"));
		imgs.put("target7", ImageUtil.getImage("target/7"));
//		imgs.put("target8", ImageUtil.getImage("target/8"));

		// hero��������
		for (int i = 0; i < 2; i++) {
			imgs.put("hero_ladder" + i, ImageUtil.getImage("hero/ladder/ladder_" + i));
		}
		// hero�ĵȼ���ʾͼƬ
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
		// heroѪ����
		imgs.put("HP", ImageUtil.getImage("hero/live/HP"));
		// hero������
		imgs.put("MP", ImageUtil.getImage("hero/live/MP"));
		// heroѪ����
		imgs.put("hp_blood", ImageUtil.getImage("hero/live/hp_blood"));
		// hero������
		imgs.put("mp_blood", ImageUtil.getImage("hero/live/mp_blood"));
		// hero�����
		imgs.put("EXP", ImageUtil.getImage("hero/live/EXP"));
		// hero�����
		imgs.put("exp_blood", ImageUtil.getImage("hero/live/exp_blood"));
		//hero����
		imgs.put("hero_die", ImageUtil.getImage("hero/die/die"));
		//���ر���
		imgs.put("bc", ImageUtil.getImage("icon/bc"));

	}

//	List list = new AbstractList() {};

	/**
	 * ����ͼƬ���Ƽ���ͼƬ����
	 * 
	 * @param path  ·��
	 * @return img����
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
	 * ��Map��ȡͼƬ����
	 * 
	 * @param key ����ͼƬ��keyֵ��k,v
	 * @return ͼƬ����Image
	 */
	public static Image get(String key) {
		return imgs.get(key);
	}
}
