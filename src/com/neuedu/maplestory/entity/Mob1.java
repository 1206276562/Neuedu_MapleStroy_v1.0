package com.neuedu.maplestory.entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import com.neuedu.maplestory.client.MapleStoryClient;
import com.neuedu.maplestory.constant.Constant;
import com.neuedu.maplestory.util.ImageUtil;

public class Mob1 extends Mob {

	public static Image[] imgs = new Image[200];

	static {
		for (int i = 0; i < 5; i++) {
			imgs[i] = ImageUtil.get("mob1_stand_left" + i);
		}
		for (int i = 5; i < 10; i++) {
			imgs[i] = ImageUtil.get("mob1_stand_right" + (i - 5));
		}
		for (int i = 10; i < 15; i++) {
			imgs[i] = ImageUtil.get("mob1_walk_left" + (i - 10));
		}
		for (int i = 15; i < 20; i++) {
			imgs[i] = ImageUtil.get("mob1_walk_right" + (i - 15));
		}
		for (int i = 20; i < 29; i++) {
			imgs[i] = ImageUtil.get("mob1_die_left" + (i - 20));
		}
		for (int i = 29; i < 38; i++) {
			imgs[i] = ImageUtil.get("mob1_die_right" + (i - 29));
		}
		for (int i = 38; i < 59; i++) {
			imgs[i] = ImageUtil.get("mob1_hit_left" + (i - 38));
		}
		for (int i = 59; i < 80; i++) {
			imgs[i] = ImageUtil.get("mob1_hit_right" + (i - 59));
		}
	}

	public Mob1() {
	}

	public int random = new Random().nextInt(4);

	/**
	 * 
	 * @param x          mob的x坐标
	 * @param y          mob的y坐标
	 * @param actionType	mob的动作状态
	 * @param msc		调停者模式 msc
	 */
	public Mob1(int x, int y, int actionType, MapleStoryClient msc) {
		this.x = x;
		this.y = y;
		this.msc = msc;
		this.name = "长尾山雀";
		this.level = 20;
		switch (actionType) {
		case 0:
			this.dir = Direction.RIGHT;
			this.action = Action.WALK;
			break;
		case 1:
			this.dir = Direction.RIGHT;
			this.action = Action.STAND;
			break;
		case 2:
			this.dir = Direction.LEFT;
			this.action = Action.WALK;
			break;
		case 3:
			this.dir = Direction.LEFT;
			this.action = Action.STAND;
			break;
		default:
			break;
		}
		this.width = imgs[0].getWidth(null);
		this.height = imgs[0].getHeight(null);
		this.HP = 500;
		this.HP_FULL = this.HP;
		this.speed = 5;
//		this.bar = new BloodBar(this.x, this.y-15); 
	}

	private int mob_stand_left_count = 0;// [0,4]
	private int mob_stand_right_count = 5;// [5,9]
	private int mob_walk_left_count = 10;// [10,14]
	private int mob_walk_right_count = 15;// [15,19]
	private int mob_die_left_count = 20; // [20,28]
	private int mob_die_right_count = 29; // [29,37]
	private int mob_hit_left_count = 38; // [38,58]
	private int mob_hit_right_count = 59; // [59,79]
	private int stand_left_count = 0;
	private int stand_right_count = 0;
	private int walk_left_count = 0;
	private int walk_right_count = 0;

	@Override
	public void draw(Graphics g) {
		if (mob_stand_left_count > 4) {
			mob_stand_left_count = 0;
		}
		if (mob_stand_right_count > 9) {
			mob_stand_right_count = 5;
		}
		if (mob_walk_left_count > 14) {
			mob_walk_left_count = 10;
		}
		if (mob_walk_right_count > 19) {
			mob_walk_right_count = 15;
		}
		if (mob_die_left_count > 27) {
//			mob_die_left_count = 20;
			this.live = false;
			// 移除怪物对象
			msc.mobs.remove(this);
		}
		if (mob_die_right_count > 37) {
//			mob_die_right_count = 29;
			this.live = false;

			msc.mobs.remove(this);
		}
		if (mob_hit_left_count > 58) {
			mob_hit_left_count = 38;
		}
		if (mob_hit_right_count > 79) {
			mob_hit_right_count = 59;
		}
		switch (dir) {

		case LEFT:
			switch (action) {
			case STAND:
				g.drawImage(imgs[mob_stand_left_count++], x, y, null);
				int stand_random = new Random().nextInt(2);
				stand_left_count++;
				int stand_change_random = new Random().nextInt(200) + 500;
				if (stand_left_count++ >= stand_change_random) {
					if (stand_random == 0) {
						this.action = Action.WALK;
						stand_left_count = 0;
					}
					if (stand_random == 1) {
						this.action = Action.STAND;
						stand_left_count = 0;
					}
				}
				break;
			case WALK:
				g.drawImage(imgs[mob_walk_left_count++], x, y, null);
				int walk_random = new Random().nextInt(2);
				walk_left_count++;
				int walk_change_random = new Random().nextInt(200) + 350;
				if ((walk_left_count++) >= walk_change_random) {
					if (walk_random == 0) {
						this.action = Action.WALK;
						walk_left_count = 0;
					}
					if (walk_random == 1) {
						this.action = Action.STAND;
						walk_left_count = 0;
					}
				}
				break;
			case DIE:
				g.drawImage(imgs[mob_die_left_count++], x, y, null);
				break;
			case HIT:
				g.drawImage(imgs[mob_hit_left_count++], x - 300, y - 150, null);
				break;
			default:
				break;
			}
			break;
		case RIGHT:
			switch (action) {
			case STAND:
				g.drawImage(imgs[mob_stand_right_count++], x, y, null);
				int random = new Random().nextInt(2);
				stand_right_count++;
				int stand_change_random = new Random().nextInt(200) + 400;
				if ((stand_right_count++) >= stand_change_random) {
					if (random == 0) {
						this.action = Action.WALK;
						stand_right_count = 0;
					}
					if (random == 1) {
						this.action = Action.STAND;
						stand_right_count = 0;
					}
				}
				break;
			case WALK:
				g.drawImage(imgs[mob_walk_right_count++], x, y, null);
				int walk_random = new Random().nextInt(2);
				walk_right_count++;
				int walk_change_random = new Random().nextInt(200) + 600;
				if ((walk_right_count++) >= walk_change_random) {
					if (walk_random == 0) {
						this.action = Action.WALK;
						walk_right_count = 0;
					}
					if (walk_random == 1) {
						this.action = Action.STAND;
						walk_right_count = 0;
					}
				}
				break;
			case DIE:
				g.drawImage(imgs[mob_die_right_count++], x, y, null);
				break;
			case HIT:
				g.drawImage(imgs[mob_hit_right_count++], x - 100, y - 150, null);
				break;
			default:
				break;
			}
			break;

		default:
			break;
		}
		drawBloodBar(g);
		move();
		drawInfo(g);
	}

//mob的名字
	private void drawInfo(Graphics g) {
		int x = this.x;
		int y = this.y + this.height + 5;
		Color c = g.getColor();
		Font f = g.getFont();
		g.setColor(new Color(0.7f, 0.5f, 0.6f, 0.5f));
		g.fillRect(x - 10, y - this.height - 40, 100, 15);
		g.setColor(Color.RED);
		g.setFont(new Font("宋体", Font.BOLD, 12));
		g.drawString("Lv." + level + " " + name, x - 10, y - this.height - 30);
		g.setColor(c);
		g.setFont(f);

	}

	private void drawBloodBar(Graphics g) {
//		Color c =g.getColor();
//		g.setColor(Color.GREEN);
//		g.drawRect(x, y-10, width,8 );
//		double width = HP/HP_FULL*this.width;
//		double HP_Surplus = HP/HP_FULL;
//		if (HP_Surplus<=0.7) {
//			g.setColor(Color.YELLOW);
//		}
//		if (HP_Surplus<=0.3) {
//			g.setColor(Color.RED);
//		}
//		g.fillRect(x, y-10,(int) (width),8);
//		g.setColor(c);
		/**
		 * 用血块图片来表示血条
		 */
		for (int i = 0; i < this.width / 1 * HP / HP_FULL; i++) {
			BloodBar bb = new BloodBar(this.x + (i * 1), this.y - 15);
			bb.draw(g);
		}

	}

	@Override
	public void move() {
		switch (dir) {
		case LEFT:
			switch (action) {
			case WALK:
				this.x -= speed;
				break;
			default:
				break;
			}
			break;

		default:
			break;
		case RIGHT:
			switch (action) {
			case WALK:
				this.x += speed;
				break;

			default:
				break;
			}
			break;

		}
		OutOfBound();
		hit(msc.hero);
//		backward_jump();
	}

	/**
	 * 边界判断
	 */
	public void OutOfBound() {
		if (x <= 0) {
			this.dir = Direction.RIGHT;
		}
		if (x >= Constant.GAME_WIDTH - width) {
			this.dir = Direction.LEFT;
		}
	}

	/**
	 * 怪物mob攻击
	 * 
	 * @param hero 传入参数英雄hero
	 * @return 击中返回true，否则返回false
	 */
	public boolean hit(Hero hero) {
		if (this.HP > 0 && hero.live && this.getRectangle().intersects(hero.getRectangle())) {
			this.action = Action.HIT;
			hero.HP -= Constant.MOB_ATT;
			if (hero.HP <= 0 && hero.live_times > 0) {
				hero.live_times -= 1;
				hero.HP = hero.HP_FULL;
				hero.MP = hero.MP_FULL;
//					msc.mobs.remove(mob);	
				hero.action = Action.STAND;
			}
			if (hero.live_times == 0) {
				System.out.println("你已经死亡！");
				hero.action = Action.DIE;
				hero.HP = 0;
				hero.MP = 0;
				hero.EXP = 0;
				hero.live = false;
			}
			return true;
		} else if ((hero.action == Action.DIE)
				|| (!(this.getRectangle().intersects(hero.getRectangle())) && this.action != Action.DIE)) {
			this.action = Action.WALK;
//			int action_random = new Random().nextInt(2);
//			if(action_random==0) {
//				this.action = Action.WALK;
//			}
//			if (action_random==1) {
//				this.action = Action.STAND;
//			}
		}
		return false;
	}

	private double v0 = Constant.HERO_JUMP_SPEED - 30;
	private double vt = 0;
	private double delta_h = 0;
	private static final double g = 9.8;
	private double t = 0.01;
	private boolean jump_up = true; // 默认值为向上

	public void backward_jump() {
		if (this.hit(msc.hero)) {
			// 竖直向上
			if (msc.hero.dir == Direction.LEFT) {
				msc.hero.x += 10;
				if (jump_up) {
					vt = v0 - g * t;
					v0 = vt;
					delta_h = v0 * t;
					msc.hero.y -= delta_h;
					if (vt <= 0) {
						v0 = 0; // 为下次赋值准备。
						vt = 0;
						jump_up = false;
					}
				}
				// 自由落体
				else {
					msc.hero.x += 10;
					vt = v0 + g * t;
					v0 = vt;
					delta_h = v0 * t;
					msc.hero.y += delta_h;
					if (msc.hero.y > Constant.GAME_HEIGHT - height - 30) {
						msc.hero.y = Constant.GAME_HEIGHT - height - 30;
						jump_up = true;
						// 下一次竖直上抛的速度值。
						v0 = Constant.HERO_JUMP_SPEED;
						vt = 0;
						msc.hero.jump = false;
						msc.hero.action = Action.STAND;
					}
				}
			}
			this.action = Action.WALK;
			if (msc.hero.dir == Direction.RIGHT) {
				if (jump_up) {
					msc.hero.x -= 10;
					vt = v0 - g * t;
					v0 = vt;
					delta_h = v0 * t;
					msc.hero.y -= delta_h;
					if (vt <= 0) {
						v0 = 0; // 为下次赋值准备。
						vt = 0;
						jump_up = false;
					}
				}
				// 自由落体
				else {
					msc.hero.x -= 10;
					vt = v0 + g * t;
					v0 = vt;
					delta_h = v0 * t;
					msc.hero.y += delta_h;
					if (msc.hero.y > Constant.GAME_HEIGHT - height - 30) {
						msc.hero.y = Constant.GAME_HEIGHT - height - 30;
						jump_up = true;
						// 下一次竖直上抛的速度值。
						v0 = Constant.HERO_JUMP_SPEED;
						vt = 0;
						msc.hero.jump = false;
						msc.hero.action = Action.STAND;
					}
				}
			}
		}
	}

	public BloodBar bar;

	/**
	 * 成员内部类 内部类可以直接访问外部类的所有属性和方法，反之不能（外部类不能访问内部类）
	 */
	class BloodBar /* extends MapleStoryObject */ {
		int x;
		int y;
		Image img;

		public BloodBar() {
		}

		public BloodBar(int x, int y) {
			this.x = x;
			this.y = y;
			this.img = ImageUtil.get("mob_blood");
		}

		public void draw(Graphics g) {

			g.drawImage(img, x, y, null);
		}

		public void move() {

		}
	}
}
