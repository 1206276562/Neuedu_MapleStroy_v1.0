package com.neuedu.maplestory.util;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import com.neuedu.maplestory.constant.Constant;


public class MyFrame extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3444149344833895154L;

	/**
	 * 
	 */
	public void loadFrame() {
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT); // 定框的大小
		this.setLocation(0, 0); // 定位置
		this.setVisible(true); // default false 显示出框
		this.setResizable(false);// default true 使得框大小不可变
		// 设置监听器， 使得关闭按钮生效
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});
		// 增加文字，框的命名
		this.setTitle("睿道冒险岛_作者：四木");
		// 框的相对位置，null相对屏幕居中
		this.setLocationRelativeTo(null);
		// 启动线程
		new MyThread().start();
	}

	// 成员内部类
	class MyThread extends Thread {
		@Override
		public void run() {
			for (;;) {
				repaint();
				//
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} // 每秒40hz
			}
		}
	}
	// 双缓冲防闪烁
	private Image bufferImage = null;

	@Override
	public void update(Graphics g) {
		if (bufferImage == null) {
			bufferImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		}
		Graphics gOff = bufferImage.getGraphics();
		Color c = gOff.getColor();
		gOff.setColor(Color.black);
		gOff.fillRect(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		gOff.setColor(c);
		paint(gOff);
		g.drawImage(bufferImage, 0, 0, null);
	}
}
