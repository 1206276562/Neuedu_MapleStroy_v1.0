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
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT); // ����Ĵ�С
		this.setLocation(0, 0); // ��λ��
		this.setVisible(true); // default false ��ʾ����
		this.setResizable(false);// default true ʹ�ÿ��С���ɱ�
		// ���ü������� ʹ�ùرհ�ť��Ч
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});
		// �������֣��������
		this.setTitle("�ð�յ�_���ߣ���ľ");
		// ������λ�ã�null�����Ļ����
		this.setLocationRelativeTo(null);
		// �����߳�
		new MyThread().start();
	}

	// ��Ա�ڲ���
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
				} // ÿ��40hz
			}
		}
	}
	// ˫�������˸
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
