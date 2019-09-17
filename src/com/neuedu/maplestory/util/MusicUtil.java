package com.neuedu.maplestory.util;

import java.io.File;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicUtil extends Thread {
	private Player player;
	private File music;

	private String musicPath;
	private boolean loop;

	/**
	 * ���췽����Ĭ�ϲ�ѭ�����ţ�
	 * 
	 * @param musicPath �����������·��
	 */
	public MusicUtil(String musicPath) {
		this.musicPath = musicPath;
	}

	/**
	 * ���췽��(�Ƿ�ѭ��)
	 * 
	 * @param musicpath �����ļ�����·��
	 * @param loop      �Ƿ�ѭ��
	 */
	public MusicUtil(String musicpath, boolean loop) {
		this(musicpath);
		this.loop = loop;
	}

	/**
	 * ��дrun����
	 */
	@Override
	public void run() {
		super.run();
		try {
			if (loop) {
				while (true) {
					play();
				}
			} else {
				play();
			}
		} catch (FileNotFoundException | JavaLayerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���ŷ���
	 * 
	 * @throws FileNotFoundException
	 * @throws JavaLayerException
	 */
	private void play() throws FileNotFoundException, JavaLayerException {
		BufferedInputStream buffer = new BufferedInputStream(
				MusicUtil.class.getClassLoader().getResourceAsStream(musicPath));
		player = new Player(buffer);
		player.play();
	}

	/**
	 * ������
	 * 
	 * @param args �������涨һ����д
	 */
	public static void main(String[] args) {
		MusicUtil bgm = new MusicUtil("com/neuedu/maplestory/sounds/01.mp3", true);
		MusicUtil boom_bgm = new MusicUtil("com/neuedu/maplestory/sounds/02.mp3", false);
		MusicUtil shoot_bgm = new MusicUtil("com/neuedu/maplestory/sounds/03.mp3", false);
		bgm.start();
		boom_bgm.start();
		shoot_bgm.start();
	}
}
