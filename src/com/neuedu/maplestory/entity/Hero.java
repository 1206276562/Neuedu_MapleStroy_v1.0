package com.neuedu.maplestory.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import com.neuedu.maplestory.client.MapleStoryClient;
import com.neuedu.maplestory.constant.Constant;
import com.neuedu.maplestory.util.ImageUtil;

public class Hero extends MapleStoryObject {

	public static Image[] imgs = new Image[100];
	static {
		// hero右走
		for (int i = 0; i < 5; i++) {
			imgs[i] = ImageUtil.get("hero_walk_right" + i);
		}
		// hero左走
		for (int i = 5; i < 10; i++) {
			imgs[i] = ImageUtil.get("hero_walk_left" + (i - 5));
		}
		// 向右攻击
		for (int i = 10; i < 14; i++) {
			imgs[i] = ImageUtil.get("hero_shoot_right" + (i - 10));
		}
		// 向左攻击
		for (int i = 14; i < 18; i++) {
			imgs[i] = ImageUtil.get("hero_shoot_left" + (i - 14));
		}
		// 攀爬
		for (int i = 18; i < 20; i++) {
			imgs[i] = ImageUtil.get("hero_ladder" + (i - 18));
		}
	}
	public boolean left, up, right, down, walk, jump, shoot, pick, prone;
	public int live_times;
	public int hero_att = new Random().nextInt(50) + 10;
	public boolean tool_up = false;
	public boolean tool_up_right = false;
	public int EXP_FULL;

	/**
	 * 
	 * @param msc 传入参数msc
	 */
	public Hero(MapleStoryClient msc) {
		this.msc = msc;
		this.img = ImageUtil.get("hero_stand_right");
		this.speed = Constant.HERO_SPEED;
		this.dir = Direction.RIGHT;
		this.action = Action.STAND;
		this.height = img.getHeight(null);
		this.width = img.getWidth(null);
		this.x = 200;
		this.y = Constant.GAME_HEIGHT - height - 100;
		this.MP = 1000;
		this.MP_FULL = MP;
		this.HP = 1000;
		this.HP_FULL = HP;
		this.live_times = 3;
		this.level = 1;
		this.EXP = 0;
		this.EXP_FULL = 100 + (level - 1) * 100;

	}

	/**
	 * 
	 * @param x   hero的x坐标
	 * @param y   hero的y坐标
	 * @param msc 调停者模式msc
	 */
	public Hero(int x, int y, MapleStoryClient msc) {
		this(msc);
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 * @param x   hero的x坐标
	 * @param y   hero的y坐标
	 * @param img hero的图片img
	 * @param msc 调停者模式msc
	 */
	public Hero(int x, int y, Image img, MapleStoryClient msc) {
		this(x, y, msc);
		this.img = img;
	}

	private int walk_right_count = 0; // [0,4]
	private int walk_left_count = 5; // [5,9]
	private int shoot_right_count = 10; // [10,13]
	private int shoot_left_count = 14; // [14,17]
	private int hero_ladder_count = 18; // [18,19]

	@Override
	public void draw(Graphics g) {
		if (walk_right_count > 4) {
			walk_right_count = 0;
		}
		if (walk_left_count > 9) {
			walk_left_count = 5;
		}
		if (shoot_right_count > 13) {
			shoot_right_count = 10;
		}
		if (shoot_left_count > 17) {
			shoot_left_count = 14;
		}
		if (hero_ladder_count > 19) {
			hero_ladder_count = 18;
		}
		switch (dir) {
		case LEFT:
			switch (action) {
			case STAND:
				g.drawImage(ImageUtil.get("hero_stand_left"), x, y, null);
				break;
			case WALK:
				g.drawImage(imgs[walk_left_count++], x, y, null);
				break;
			case JUMP:
				g.drawImage(ImageUtil.get("hero_jump_left"), x, y, null);
				break;
			case SHOOT:
				g.drawImage(imgs[shoot_left_count++], x, y, null);
				break;
			case PRONE:
				g.drawImage(ImageUtil.get("hero_prone_left"), x, y, null);
				break;
			case DIE:
				g.drawImage(ImageUtil.get("hero_die"), x, y, null);
				break;
			default:
				break;
			}

			break;
		case RIGHT:
			switch (action) {
			case STAND:
				g.drawImage(ImageUtil.get("hero_stand_right"), x, y, null);
				break;
//				g.drawImage(Image, speed, height, observer)
			case WALK:
				g.drawImage(imgs[walk_right_count++], x, y, null);
				break;
			case JUMP:
				g.drawImage(ImageUtil.get("hero_jump_right"), x, y, null);
				break;
			case SHOOT:
				g.drawImage(imgs[shoot_right_count++], x, y, null);
				break;
			case PRONE:
				g.drawImage(ImageUtil.get("hero_prone_right"), x, y, null);
				break;
			case DIE:
				g.drawImage(ImageUtil.get("hero_die"), x, y, null);
				break;
			default:
				break;
			}
		case UP:
			switch (action) {
			case LADDER:
				g.drawImage(imgs[hero_ladder_count++], x, y, null);
				break;

			default:
				break;
			}
		}

		if (shoot) {
			shoot();
		}

		switch (level) {
		case 1:
			g.drawImage(ImageUtil.get("level_1"), 95, 677, null);
			break;
		case 2:
			g.drawImage(ImageUtil.get("level_2"), 95, 677, null);
			break;
		case 3:
			g.drawImage(ImageUtil.get("level_3"), 95, 677, null);
			break;
		case 4:
			g.drawImage(ImageUtil.get("level_4"), 95, 677, null);
			break;
		case 5:
			g.drawImage(ImageUtil.get("level_5"), 95, 677, null);
			break;
		case 6:
			g.drawImage(ImageUtil.get("level_6"), 95, 677, null);
			break;
		default:
			break;
		}

		// 判断移动方向的方法
		confirmDirection();
		// 切换图片
//		if (test) {
//			getNewLocation();
//		}

		changeImage();
		// hero移动的方法
		move();
//		drop();
		drawBloodBar(g);
	}

	public void changeImage() {
		if (walk) {
			this.action = Action.WALK;
			if (shoot) {
				this.action = Action.SHOOT;
			}
			if (jump) {
				this.action = Action.JUMP;
				jump();
				if (shoot) {
					this.action = Action.SHOOT;
				}
			}
		} else if (jump) {
			this.action = Action.JUMP;
			jump();
		}
		// 原地射击
		else if (shoot) {
			this.action = Action.SHOOT;
		}
		// y原地趴下
		else if (prone) {
			this.action = Action.PRONE;
			if (shoot) {
				this.action = Action.SHOOT;
			}
		}
		// 原地站立
		else {
			this.action = Action.STAND;
		}

	}

	@Override
	public void move() {
		if (left) {
			this.x -= speed;
		}
		if (right) {
			this.x += speed;
		}
		OutOfBound();

		if (walk) {
			goDown();
		}
	}

	private void confirmDirection() {
		if (left) {
			this.dir = Direction.LEFT;

		}
		if (right) {
			this.dir = Direction.RIGHT;
		}
	}

	private void OutOfBound() {
		if (x <= 0) {
			x = 0;
		}
		if (x >= Constant.GAME_WIDTH - width) {
			x = Constant.GAME_WIDTH - width;
		}
		if (y <= 0) {
			y = 0;
		}
		if (y >= Constant.GAME_HEIGHT - height) {
			y = Constant.GAME_HEIGHT - height;
		}
	}
	/**
	 * 按键控制人物移动
	 * 
	 * @param e 键盘事件对象---那个键
	 */
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 37:
			left = true;
			walk = true;
			break;
		case 39:
			right = true;
			walk = true;
			break;
		case KeyEvent.VK_C:
			jump = true;
			break;
		case KeyEvent.VK_X:
			shoot = true;
			break;
		// 拾取道具
		case KeyEvent.VK_Z:
			pick = true;
			break;
		case KeyEvent.VK_SPACE:
			prone = true;
			break;
		default:
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 37:
			left = false;
			walk = false;
			break;
		case 39:
			right = false;
			walk = false;
			break;
		case KeyEvent.VK_X:
			shoot = false;
			break;
		case KeyEvent.VK_Z:
			pick = false;
			break;
		case KeyEvent.VK_SPACE:
			prone = false;
		default:
			break;
		}

	}

	/**
	 * 跳的算法
	 */
	private double v0 = Constant.HERO_JUMP_SPEED;
	private double vt = 0;
	private double delta_h = 0;
	private static final double g = 9.8;
	private double t = 0.5;
	private boolean jump_up = true; // 默认值为向上
	Rectangle r1 = new Rectangle(546, 560, ImageUtil.get("target1").getWidth(null),
			ImageUtil.get("target1").getHeight(null));
	Rectangle r2 = new Rectangle(88, 386, ImageUtil.get("target2").getWidth(null),
			ImageUtil.get("target2").getHeight(null));
	Rectangle r3 = new Rectangle(276, 334, ImageUtil.get("target3").getWidth(null),
			ImageUtil.get("target3").getHeight(null));
	Rectangle r4 = new Rectangle(871, 358, ImageUtil.get("target4").getWidth(null),
			ImageUtil.get("target4").getHeight(null));
	Rectangle r5 = new Rectangle(240, 264, ImageUtil.get("target5").getWidth(null),
			ImageUtil.get("target5").getHeight(null));
	Rectangle r6 = new Rectangle(460, 200, ImageUtil.get("target6").getWidth(null),
			ImageUtil.get("target6").getHeight(null));
	Rectangle r7 = new Rectangle(0, 122, ImageUtil.get("target7").getWidth(null),
			ImageUtil.get("target7").getHeight(null));

	/**
	 * 跳的算法
	 */
	public void jump() { // 竖直上抛
		if (jump_up) {
			vt = v0 - g * t;
			v0 = vt;
			delta_h = v0 * t;
			y -= delta_h;
			if (vt <= 0) {
				vt = 0;
				v0 = 0;
				jump_up = false;
			}
		} else {
			vt = v0 + g * t;
			v0 = vt;
			delta_h = v0 * t;
			y += delta_h;
			if (this.x > 510 && this.x < 650 && this.y >= 385 && this.y <= 405) {
				this.y = 425;
				jump_up = true;
				v0 = Constant.HERO_JUMP_SPEED;
				vt = 0;
				jump = false;
				this.action = Action.STAND;
			}
			if (this.x > 60 && this.x < 620 && this.y >= 240 && this.y <= 270) {
				this.y = 270;
				jump_up = true;
				v0 = Constant.HERO_JUMP_SPEED;
				vt = 0;
				jump = false;
				this.action = Action.STAND;
			}
			if (this.x > 200 && this.x < 330 && this.y >= 120 && this.y <= 160) {
				this.y = 155;
				jump_up = true;
				v0 = Constant.HERO_JUMP_SPEED;
				vt = 0;
				jump = false;
				this.action = Action.STAND;
			}
			if (this.x >= 0 && this.x < 170 && this.y <= 55) {
				this.y = 55;
				jump_up = true;
				v0 = Constant.HERO_JUMP_SPEED;
				vt = 0;
				jump = false;
				this.action = Action.STAND;
			}
			if (this.x >= 430 && this.x < 750 && this.y >= 30 && this.y <= 100) {
				this.y = 100;
				jump_up = true;
				v0 = Constant.HERO_JUMP_SPEED;
				vt = 0;
				jump = false;
				this.action = Action.STAND;
			}
			if (this.x >= 850 && this.x < 1300 && this.y >= 220 && this.y <= 250) {
				this.y = 245;
				jump_up = true;
				v0 = Constant.HERO_JUMP_SPEED;
				vt = 0;
				jump = false;
				this.action = Action.STAND;
			}
			if (this.x >= 980 && this.x <= 1200 && this.y <= 35) {
				this.y = 35;
				jump_up = true;
				v0 = Constant.HERO_JUMP_SPEED;
				vt = 0;
				jump = false;
				this.action = Action.STAND;
			}
			if (y > Constant.GAME_HEIGHT - height - 100) {
				y = Constant.GAME_HEIGHT - height - 100;
				// System.out.println("到这了");
				jump_up = true;
				v0 = Constant.HERO_JUMP_SPEED;
				vt = 0;
				jump = false;
				this.action = Action.STAND;
			}
		}
	}

	/**
	 * 向下掉落
	 */
	public void goDown() {
		if (this.x < 510 && this.y == 425 || this.x > 640 && this.y == 425) {
			v0 = 0;
			jump = true;
			jump();
		}
		if (this.x < 60 && this.y == 270 || this.x > 620 && this.y == 270) {
			v0 = 0;
			jump = true;
			jump();
		}
		if (this.x < 210 && this.y == 155 || this.x > 340 && this.y == 155) {
			v0 = 0;
			jump = true;
			jump();
		}
		if (this.x < 0 && this.y == 55 || this.x > 170 && this.y == 55) {
			v0 = 0;
			jump = true;
			jump();
		}
		if (this.x < 430 && this.y == 100 || this.x > 750 && this.y == 100) {
			v0 = 0;
			jump = true;
			jump();
		}
		if (this.x <= 860 && this.y == 245 || this.x > 1237 && this.y == 245) {
			v0 = 0;
			jump = true;
			jump();
		}
		if (this.x <= 977 && this.y == 35 || this.x >= 1197 && this.y == 35) {
			v0 = 0;
			jump = true;
			jump();
		}
	}

	/**
	 * 人物血条
	 * 
	 * @param g
	 */
	private void drawBloodBar(Graphics g) {
		/**
		 * 用血块图片来表示血条
		 */
		g.drawImage(ImageUtil.get("HP"), 350, 680, null);
		for (int i = 0; i < 177 * HP / HP_FULL; i++) {
			BloodBar HP = new BloodBar(350 + (i * 1), 675, ImageUtil.get("hp_blood"));
			HP.draw(g);
		}
		g.drawImage(ImageUtil.get("EXP"), 715, 680, null);
		for (int i = 0; i < 177 * EXP / EXP_FULL; i++) {
			BloodBar EXP = new BloodBar(718 + (i * 1), 680, ImageUtil.get("exp_blood"));
			EXP.draw(g);
		}
		g.drawImage(ImageUtil.get("MP"), 532, 680, null);
		for (int i = 0; i < 177 * MP / MP_FULL; i++) {
			BloodBar MP = new BloodBar(532 + (i * 1), 680, ImageUtil.get("mp_blood"));
			MP.draw(g);
		}
	}

//	public BloodBar bar;
	/**
	 * 成员内部类 内部类可以直接访问外部类的所有属性和方法，反之不能（外部类不能访问内部类）
	 */
	class BloodBar /* extends MapleStoryObject */ {
		int x;
		int y;
		Image img;

		public BloodBar() {
		}

		public BloodBar(int x, int y, Image img) {
			this.x = x;
			this.y = y;
			this.img = img;
		}

		public void draw(Graphics g) {
			g.drawImage(img, x, y, null);
		}

		public void move() {

		}
	}

	public void shoot() {
		Arrow arrow = null;
		switch (dir) {
		case LEFT:
			arrow = new Arrow(this.x, this.y + height / 2 + 20, this.dir, msc);
			break;
		case RIGHT:
			arrow = new Arrow(this.x + width, this.y + height / 2 + 20, this.dir, msc);
			break;
		default:
			break;
		}
		msc.arrows.add(arrow);

	}

	public boolean eatItem;

	public boolean eatItem(Item item) {
		if (item.live && item.getRectangle().intersects(this.getRectangle())) {
			if (pick) {
				switch (item.itemType) {
				case 0:
					this.HP += HP_FULL * 0.1;
					if (HP >= HP_FULL) {
						HP = HP_FULL;
					}
					break;
				case 1:
					this.HP += HP_FULL * 0.2;
					if (HP >= HP_FULL) {
						HP = HP_FULL;
					}
					break;
				case 2:
					this.HP += HP_FULL * 0.3;
					if (HP >= HP_FULL) {
						HP = HP_FULL;
					}
					break;
				case 3:
					this.HP += HP_FULL * 0.5;
					if (HP >= HP_FULL) {
						HP = HP_FULL;
					}
					break;
				case 4:
					this.HP += HP_FULL;
					if (HP >= HP_FULL) {
						HP = HP_FULL;
					}
					break;
				case 5:
					this.MP += MP_FULL * 0.1;
					if (MP >= MP_FULL) {
						MP = MP_FULL;
					}
					break;
				case 6:
					this.MP += MP_FULL * 0.2;
					if (MP >= MP_FULL) {
						MP = MP_FULL;
					}
					break;
				case 7:
					this.MP += MP_FULL * 0.3;
					if (MP >= MP_FULL) {
						MP = MP_FULL;
					}
					break;
				case 8:
					this.MP += MP_FULL * 0.5;
					if (MP >= MP_FULL) {
						MP = MP_FULL;
					}
					break;
				case 9:
					this.MP += MP_FULL;
					if (MP >= MP_FULL) {
						MP = MP_FULL;
					}
					break;
				default:
					break;
				}
				msc.items.remove(item);
			}
			return true;
		}

		return false;
	}

	public boolean eatItem(List<Item> items) {
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			if (eatItem(item)) {
				return true;
			}
		}
		return false;
	}
}
