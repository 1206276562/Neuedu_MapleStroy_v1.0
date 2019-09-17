package com.neuedu.maplestory.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import java.util.Random;

import com.neuedu.maplestory.client.MapleStoryClient;
import com.neuedu.maplestory.constant.Constant;
import com.neuedu.maplestory.util.ImageUtil;
import com.neuedu.maplestory.util.MusicUtil;

/**
 * 箭类----武器
 * 
 * @author Administrator
 *
 */
public class Arrow extends MapleStoryObject {

	public Arrow() {
	}

	public boolean boom;

	public Arrow(int x, int y, Direction dir, MapleStoryClient msc) {
		this.msc = msc;
		this.x = x;
		this.y = y;
		this.speed = 20;
		this.dir = dir;
		if (this.dir == Direction.LEFT) {
			this.img = ImageUtil.get("hero_arrow_left");
		} else {
			this.img = ImageUtil.get("hero_arrow_right");
		}
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);

	}

	public Arrow(int x, int y, Image img, Direction dir, MapleStoryClient msc) {
		this(x, y, dir, msc);
		this.img = img;
		this.msc = msc;

	}

	public static Image imgs[] = new Image[10];
	static {
		for (int i = 0; i < 8; i++) {
			imgs[i] = ImageUtil.get("shoot_boom" + i);
		}
	}
	public int shoot_boom_count = 0;

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
		move();
//		if (this.action==Action.BOOM) {
//			g.drawImage(imgs[shoot_boom_count++],200,200, null);
//		}
		for (int i = 0; i < msc.mobs.size(); i++) {
			if (this.live && msc.mobs.get(i).live && msc.mobs.get(i).action != Action.DIE
					&& this.getRectangle().intersects(msc.mobs.get(i).getRectangle())) {
				if (msc.hero.dir == Direction.LEFT) {
					g.drawImage(imgs[shoot_boom_count++], this.x - this.width - width / 2, this.y - 100, null);
				}
				if (msc.hero.dir == Direction.RIGHT) {
					g.drawImage(imgs[shoot_boom_count++], this.x - width, this.y - 100, null);
				}

			}

		}
//		if (this.x>Constant.GAME_WIDTH-150) {
//			g.drawImage(imgs[shoot_boom_count++],x,y-100, null);
//		}
	}

	@Override
	public void move() {
		if (dir == Direction.LEFT) {
			this.x -= speed;
		} else {
			this.x += speed;
		}
		outOfBound(); // 边界判断
	}

	/**
	 * 边界判断
	 */
	public void outOfBound() {
		if (this.x > Constant.GAME_WIDTH || this.x < -200) {
			msc.arrows.remove(this);

		}
	}

	// 静态随机数生成器
	private static Random r = new Random();

	/**
	 * 碰撞检测
	 * 
	 * @param mob 传入参数mob怪物
	 * @return 击中返回true，否则返回false
	 */
	public boolean hit(Mob mob) {
		if (this.live && mob.live && mob.action != Action.DIE && this.getRectangle().intersects(mob.getRectangle())) {
			this.live = false;
			msc.hero.MP -= 1;
			new MusicUtil("com/neuedu/maplestory/sounds/02.mp3", false).start();
			msc.arrows.remove(this);
			mob.HP -= msc.hero.hero_att;
			if (mob.HP <= 0) {
//				mob.live = false;
				mob.action = Action.DIE;
				msc.hero.EXP += 20;
				if (msc.hero.EXP >= 100) {
					msc.hero.level += 1;
					msc.hero.EXP = 0;
				}
//				msc.mobs.remove(mob);	
				if (r.nextInt(100) >= 70) {
					Item item = new Item(msc, mob.x + mob.width / 2, mob.y + mob.height - 30, r.nextInt(7));
					msc.items.add(item);
				}
			}
			return true;
		}
		return false;

	}

	/**
	 * hit方法的重载 ----需要进行一堆怪物的碰撞检测，需要将mob的List放进去。-----每一只弓箭需要进行每一只怪物的射击 ---
	 * 上面的hit是一个怪物的消失
	 * 
	 * @param mobs 怪物mob的列表集合，一群mob----mobs
	 * @return 击中返回true
	 */
	public boolean hit(List<Mob> mobs) {
		for (int i = 0; i < mobs.size(); i++) {
			Mob mob = mobs.get(i);
			if (this.hit(mob)) {
				return true;

			}
		}
		return false;
	}

	/**
	 * 
	 * @param mob 参数怪物
	 * @return 击中返回true
	 */
	public boolean boom(Mob mob) {
		if (this.live && mob.live && mob.action != Action.DIE && this.getRectangle().intersects(mob.getRectangle())) {
//			this.action = Action.BOOM;
			return true;
		}
		return false;
	}
}
