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
	 * 构造方法（默认不循环播放）
	 * 
	 * @param musicPath 传入参数音乐路径
	 */
	public MusicUtil(String musicPath) {
		this.musicPath = musicPath;
	}

	/**
	 * 构造方法(是否循环)
	 * 
	 * @param musicpath 音乐文件所在路径
	 * @param loop      是否循环
	 */
	public MusicUtil(String musicpath, boolean loop) {
		this(musicpath);
		this.loop = loop;
	}

	/**
	 * 重写run方法
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
	 * 播放方法
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
	 * 测试类
	 * 
	 * @param args 主函数规定一般书写
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
