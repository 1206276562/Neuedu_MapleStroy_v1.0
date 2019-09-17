package com.neuedu.maplestory.entity;

import java.awt.Graphics;
import java.awt.Image;
import com.neuedu.maplestory.client.MapleStoryClient;
import com.neuedu.maplestory.util.ImageUtil;

public class Map extends MapleStoryObject {
	/**
	 * Map���вι���
	 */
	public Map() {

	}

	/**
	 * 
	 * @param x   map��x����
	 * @param y   map��y����
	 * @param img map��ͼƬimg
	 * @param msc ��ͣ��ģʽ msc
	 */
	public Map(int x, int y, Image img, MapleStoryClient msc) {
		this.x = 0;
		this.y = 0;
		this.img = img;
		this.msc = msc;
		this.speed = 10;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(ImageUtil.get("map"), 0, 0, null);
		g.drawImage(ImageUtil.get("bottom"), 0, 630, null);
		move();

	}

	@Override
	public void move() {
		if (msc.hero.walk) {
			if (msc.hero.left || msc.hero.jump) {
				if (msc.hero.x <= 400 && x < 0) {
					msc.hero.x = 400;
					this.x += speed;
				} else {
					this.x += 0;
				}

			}

			if (msc.hero.right || msc.hero.jump) {
				if (msc.hero.x >= 1400 && x > -width + 1850) {
					msc.hero.x = 1400;
					this.x -= speed;
				} else {
					this.x -= 0;
				}

			}
		}
	}

}
