package com.neuedu.maplestory.entity;

import java.awt.Graphics;

public abstract class Mob extends MapleStoryObject {
	
	
	@Override
	public abstract void draw(Graphics g) ;
	@Override
	public abstract void move() ;
}
