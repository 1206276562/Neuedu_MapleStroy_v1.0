package com.neuedu.maplestory.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import com.neuedu.maplestory.constant.Constant;
import com.neuedu.maplestory.entity.Arrow;
import com.neuedu.maplestory.entity.Hero;
import com.neuedu.maplestory.entity.Item;
import com.neuedu.maplestory.entity.Map;
import com.neuedu.maplestory.entity.Mob;
import com.neuedu.maplestory.entity.Mob1;
import com.neuedu.maplestory.util.ImageUtil;
import com.neuedu.maplestory.util.MusicUtil;
import com.neuedu.maplestory.util.MyFrame;

public class MapleStoryClient extends MyFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -454444055859601182L;

	public Hero hero = new Hero(this);
//	public static Hero hero_left = new Hero(hero_right.x,hero_right.y,ImageUtil.get("hero_stand_left"));
	public Map map = new Map(0, 0, ImageUtil.get("map"), this);
	public Map bottom = new Map(0, 630, ImageUtil.get("bottom"), this);

//	public static Arrow arrow = new Arrow(300, 300);
	/**
	 * �����Ź���������
	 */
	public List<Arrow> arrows = new ArrayList<>();
	/**
	 * ��Ź�������������ܹ�������ࣩ
	 */
	public List<Mob> mobs = new ArrayList<>();
//	public Mob mob = new Mob1(400,Constant.GAME_HEIGHT-92,this);
	public List<Item> items = new ArrayList<>();

//	public Steps step = new Step();
	// 6ֻ����
	{
		for (int i = 0; i < 6; i++) {
			int random = new Random().nextInt(4);
			Mob mob = new Mob1(400 + i * 100, Constant.GAME_HEIGHT - 170, random, this);
			mobs.add(mob);
		}
	}

	@Override
	public void paint(Graphics g) {
		map.draw(g);
		bottom.draw(g);
		if (hero.live) {
			hero.draw(g);
		} else {
			g.drawImage(ImageUtil.get("hero_die"), hero.x, hero.y, null);
		}
//		arrow.draw(g);
//		mob.draw(g);
		// ������������ ��
		for (int i = 0; i < arrows.size(); i++) {
			Arrow arrow = arrows.get(i);
			arrow.draw(g);
			new MusicUtil("com/neuedu/maplestory/sounds/03.mp3", false).start();
			arrow.hit(mobs);

		}
		for (int i = 0; i < mobs.size(); i++) {
			Mob mob = mobs.get(i);
			mob.draw(g);
		}
		// ��������
		Iterator<Item> it = items.iterator();
		while (it.hasNext()) {
			Item item = it.next();
			item.draw(g);
		}
		hero.eatItem(items);

		Font f = g.getFont();
		g.setFont(new Font("΢���ź�", Font.BOLD, 20));
		Color c = g.getColor();
		g.setColor(Color.WHITE);
//		g.drawString("Ӣ�۵�ǰ�ķ���Ϊ��" + hero.dir, 200, 100);
//		g.drawString("Ӣ�۵�ǰ�Ķ���Ϊ��" + hero.action, 200, 140);
//		g.drawString("Ӣ�����Ķ���Ϊ��" + hero.jump, 200, 180);
//		g.drawString("��������Ϊ��"+arrows.size(), 200, 220);
//		g.drawString("��������Ϊ��"+mobs.size(), 200, 260);
//		g.drawString("hero��Ѫ��Ϊ��"+hero.HP, 200, 300);
//		g.drawString("Ӣ�۵�ǰ��Ѫ��Ϊ��" + hero.HP, 200, 100);
//		g.drawString("Ӣ�۵�ǰ������Ϊ��" + hero.MP, 200, 140);
//		g.drawString("Ӣ�۵�ǰ��ʣ������Ϊ��" + hero.live_times, 200, 180);
//		g.drawString("Ӣ�۵�ǰ��xΪ��" + hero.x, 200, 100);
//		g.drawString("Ӣ�۵�ǰ��yΪ��" + hero.y, 200, 150);
//		g.drawString("��ͼ��xΪ" + map.x, 200, 300);
		g.drawString("Ӣ��ʣ������Ϊ��" + hero.live_times, 100, 100);

		g.setFont(f);
		g.setColor(c);
	}

	@Override
	public void loadFrame() {
		// TODO Auto-generated method stub
		super.loadFrame();
		this.setIconImage(ImageUtil.get("icon"));
		// ���̼�����
		this.addKeyListener(new KeyAdapter() {
			@Override
			// e.getKeyCode() ������ȡ���µ��Ǹ�����ASCII��
			// sSystem.out.println(e.getKeyCode());
			/*
			 * if (e.getKeyCode() == KeyEvent.VK_LEFT) { System.out.println("xia"); } else {
			 * System.out.println("shang"); }
			 */
			public void keyPressed(KeyEvent e) {
				hero.keyPressed(e);
//				hero_left.keyPressed(e);

			}

			@Override
			public void keyReleased(KeyEvent e) {
				hero.keyReleased(e);
//				hero_left.keyReleased(e);
			}

		});
		new MusicUtil("com/neuedu/maplestory/sounds/01.mp3", true).start();

	}

	public static void main(String[] args) {
		new MapleStoryClient().loadFrame();
	}

}
