package com.java.matchman;

import java.awt.Graphics2D;

public class Head {
	/** ͷ��X����� */
	public int headPositionX;
	/** ͷ��Y����� */
	public int headPositionY;
	/** ͷ�İ뾶 */
	public int headCircleSemi;
	/**
	 * ͷ����ɽӴ���X
	 */
	public int touchPositionX;
	/**
	 * ͷ����ɽӴ���Y
	 */
	public int touchPositionY;
	/**
	 * ��ͼ������ͷ
	 */
	public static final int FOOT_HEAD = 0;
	/**
	 * ���
	 */
	public static final int HEAD_FOOT = 1;
	public Head(int headPositionX, int headPositionY, int headCircleSemi) {
		this.headPositionX = headPositionX;
		this.headPositionY = headPositionY;
		this.headCircleSemi = headCircleSemi;
	}
	public Head(Matchstick matchstick, int headCircleSemi) {
		double angle = matchstick.angle+180;
		headPositionX = matchstick.secondPositionX-(int)(headCircleSemi*Math.cos(Math.PI*angle/180));
		headPositionY = matchstick.secondPositionY-(int)(headCircleSemi*Math.sin(Math.PI*angle/180));
		this.headCircleSemi = headCircleSemi;
		
	}
	public void changedHead(int direction, Matchstick matchstick){
		if (direction == FOOT_HEAD) {
			double angle = matchstick.angle;
			touchPositionX = matchstick.secondPositionX;
			touchPositionY = matchstick.secondPositionY;
			headPositionX = matchstick.secondPositionX+(int)(headCircleSemi*Math.cos(Math.PI*angle/180));
			headPositionY = matchstick.secondPositionY+(int)(headCircleSemi*Math.sin(Math.PI*angle/180));
		}else if (direction == HEAD_FOOT) {
			double angle = matchstick.angle+180;
			touchPositionX = this.headPositionX+(int)(headCircleSemi*Math.cos(Math.PI*angle/180));
			touchPositionY = this.headPositionY+(int)(headCircleSemi*Math.sin(Math.PI*angle/180));
		}
	}
	public void changedHead(int direction, Object angleOfMan, Matchstick matchstick){
		if (direction == HEAD_FOOT) {
			double angle = 0.0;
			if (angleOfMan instanceof double[]) {
				angle = -((double[])angleOfMan)[Matchstick.TRUNK]+180;
			}else if (angleOfMan instanceof int[]) {
				angle = -(double)((int[])angleOfMan)[Matchstick.TRUNK]+180;
			}else {
				angle = matchstick.angle+180;
			}
			touchPositionX = this.headPositionX+(int)(headCircleSemi*Math.cos(Math.PI*angle/180));
			touchPositionY = this.headPositionY+(int)(headCircleSemi*Math.sin(Math.PI*angle/180));
		}
	}
	public void showHead(Graphics2D graphics2d) {
		graphics2d.fillOval(headPositionX-headCircleSemi, headPositionY-headCircleSemi, headCircleSemi*2, headCircleSemi*2);
	}
	@Override
	public String toString() {
		return 	"headPositionX:"+headPositionX+
				"\nheadPositionY:"+headPositionY+
				"\nheadCircleSemi:"+headCircleSemi;
	}
}
