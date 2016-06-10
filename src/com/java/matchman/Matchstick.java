package com.java.matchman;

import java.awt.Graphics2D;

public class Matchstick { 
	/** ���ڱ�ʶ���Ļ�����Ǹ����� */
	public final int typeId;
	/** ���,��Ҫ���ڲ�� */
	public static final int LEFT_FOOT = 0;
	/** ��С��,��Ҫ���ڲ�� */
	public static final int LEFT_CRUS = 1;
	/** �����,��Ҫ���ڲ�� */
	public static final int LEFT_THIGH = 2;
	/** ���,��Ҫ���ڲ�� */
	public static final int TRUNK = 3;
	/** �Ҵ���,��Ҫ���ڲ�� */
	public static final int RIGHT_THIGH = 4;
	/** ��С��,��Ҫ���ڲ�� */
	public static final int RIGHT_CRUS = 5;
	/** �ҽ�,��Ҫ���ڲ�� */
	public static final int RIGHT_FOOT = 6;
	/** ��첲,��Ҫ���ڲ�� */
	public static final int LEFT_ARM = 7;
	/** ��ǰ��,��Ҫ���ڲ�� */
	public static final int LEFT_FOREARM = 8;
	/** �Ҹ첲,��Ҫ���ڲ�� */
	public static final int RIGHT_ARM = 9;
	/** ��ǰ��,��Ҫ���ڲ�� */
	public static final int RIGHT_FOREARM = 10;
	/** ͷ */
	public static final int HEAD = 11;
	
	/** ���ڱ�ʾ���õ�һ���� */
	public static final int FOOT_HEAD = 0;
	/** ���ڱ�ʾ���õڶ����� */
	public static final int HEAD_FOOT = 1;
	
	/** ��һ����X����� */
	public int firstPositionX;
	/** ��һ����Y����� */
	public int firstPositionY;
	/** �ڶ�����X����� */
	public int secondPositionX;
	/** �ڶ�����Y����� */
	public int secondPositionY;
	/** ���� */
	public int length;
	/** ����Ļ���ϵ�еĽǶ� */
	public double angle;
	/**
	 * ��һ�����(x, y),ֱ�ߵĳ���,ֱ����x����ɵĽǶ�,�ö���������������
	 * @param firstPositionX
	 * @param firstPositionY
	 * @param length
	 * @param angle
	 * @param typeId
	 */
	public Matchstick(	int firstPositionX, int firstPositionY,
						int length, double angle, int typeId) {
		this.firstPositionX = firstPositionX;
		this.firstPositionY = firstPositionY;
		this.length = length;
		this.angle = -angle;
		this.typeId = typeId;
		this.secondPositionX = firstPositionX+MatchstickCosX(length, this.angle);
		this.secondPositionY = firstPositionY+MatchstickSinX(length, this.angle);
	}
	/**
	 * ���Matchstick�Ӵ����Matchstick�ĵڶ���㿪ʼ,���ȴ�LengthOfMan��ȡ,
	 * �Ƕȴ�AngleOfMan��ȡ,�����´����Ķ����typeId����
	 * @param matchstick
	 * @param lengthOfMan
	 * @param angleOfMan
	 * @param typeId
	 */
	public Matchstick(	Matchstick matchstick,
			int[] lengthOfMan, double[] angleOfMan, int typeId) {
		if (typeId == Matchstick.RIGHT_THIGH) {
			this.firstPositionX = matchstick.firstPositionX;
			this.firstPositionY = matchstick.firstPositionY;
		}else if (typeId == Matchstick.LEFT_ARM || typeId == Matchstick.RIGHT_ARM) {
			this.firstPositionX = matchstick.secondPositionX;
			this.firstPositionY = matchstick.secondPositionY;
		}else {
			this.firstPositionX = matchstick.secondPositionX;
			this.firstPositionY = matchstick.secondPositionY;
		}
		this.length = lengthOfMan[typeId];
		this.angle = -angleOfMan[typeId];
		this.typeId = typeId;
		this.secondPositionX = firstPositionX+MatchstickCosX(length, this.angle);
		this.secondPositionY = firstPositionY+MatchstickSinX(length, this.angle);
	}
	public Matchstick(	Matchstick matchstick,
			int[] lengthOfMan, int[] angleOfMan, int typeId) {
		if (typeId == Matchstick.RIGHT_THIGH) {
			this.firstPositionX = matchstick.firstPositionX;
			this.firstPositionY = matchstick.firstPositionY;
		}else if (typeId == Matchstick.LEFT_ARM || typeId == Matchstick.RIGHT_ARM) {
			this.firstPositionX = matchstick.secondPositionX;
			this.firstPositionY = matchstick.secondPositionY;
		}else {
			this.firstPositionX = matchstick.secondPositionX;
			this.firstPositionY = matchstick.secondPositionY;
		}
		this.length = lengthOfMan[typeId];
		this.angle = -angleOfMan[typeId];
		this.typeId = typeId;
		this.secondPositionX = firstPositionX+MatchstickCosX(length, this.angle);
		this.secondPositionY = firstPositionY+MatchstickSinX(length, this.angle);
	}
	public Matchstick(	int firstPositionX, int firstPositionY,
			int[] lengthOfMan, double[] angleOfMan, int typeId) {
		this.firstPositionX = firstPositionX;
		this.firstPositionY = firstPositionY;
		this.length = lengthOfMan[typeId];
		this.angle = -angleOfMan[typeId];
		this.typeId = typeId;
		this.secondPositionX = firstPositionX+MatchstickCosX(length, this.angle);
		this.secondPositionY = firstPositionY+MatchstickSinX(length, this.angle);
	}
	public Matchstick(	int  firstPositionX, int firstPositionY,
			int[] lengthOfMan, int[] angleOfMan, int typeId) {
		this.firstPositionX = firstPositionX;
		this.firstPositionY = firstPositionY;
		this.length = lengthOfMan[typeId];
		this.angle = -angleOfMan[typeId];
		this.typeId = typeId;
		this.secondPositionX = firstPositionX+MatchstickCosX(length, this.angle);
		this.secondPositionY = firstPositionY+MatchstickSinX(length, this.angle);
	}
	public Matchstick(	int firstPositionX, int firstPositionY,
						int secondPositionX, int secondPositionY, int typeId) {
		this.firstPositionX = firstPositionX;
		this.firstPositionY = firstPositionY;
		this.secondPositionX = secondPositionX;
		this.secondPositionY = secondPositionY;
		this.length = MatchstickLength(firstPositionX, firstPositionY, 
			secondPositionX, secondPositionY);
		this.angle = MatchstickAngleOfDecare(firstPositionX, firstPositionY, 
			secondPositionX, secondPositionY);
		this.typeId = typeId;
	}	
	/** ��ȡlength��X���ϵ�ӳ�䳤�� */
	public int MatchstickCosX(int length, double angle) {
		return (int)(length*Math.cos(Math.PI*angle/180));
	}
	/** ��ȡlength��Y���ϵ�ӳ�䳤�� */
	public int MatchstickSinX(int length, double angle) {
		return (int)(length*Math.sin(Math.PI*angle/180));
	}
	/** ��ȡ������֮��ĳ��� */
	public int MatchstickLength(int firstPositionX, int firstPositionY,
								int secondPositionX, int secondPositionY) {
		return (int)Math.sqrt(
				(secondPositionX-firstPositionX)*
				(secondPositionX-firstPositionX)+
				(secondPositionY-firstPositionY)*
				(secondPositionY-firstPositionY));
	}
	/** ��ȡ����������Ļ���ϵ�ϵĽǶ� */
	public static double MatchstickAngle(	int firstPositionX, int firstPositionY,
									int secondPositionX, int secondPositionY) {
		return Math.atan((secondPositionY-firstPositionY)/
				(secondPositionX-firstPositionX))*180/Math.PI;
	}
	/** ��ȡ����������Ļ���ϵ�ϵĽǶ� */
	public static double MatchstickAngleOfDecare(	int firstPositionX, int firstPositionY,
											int secondPositionX, int secondPositionY) {
		return -Math.atan((secondPositionY-firstPositionY)/
				(secondPositionX-firstPositionX))*180/Math.PI;
	}
	/**
	 * �ı�Ƕ�
	 */
	public void changedAngle(int direction, double angle){
		this.angle = -angle;
		if (direction == FOOT_HEAD) {
			this.secondPositionX = firstPositionX+MatchstickCosX(length, this.angle);
			this.secondPositionY = firstPositionY+MatchstickSinX(length, this.angle);
		}else if (direction == HEAD_FOOT) {
			this.firstPositionX = secondPositionX+MatchstickCosX(length, this.angle+180);
			this.firstPositionY = secondPositionY+MatchstickSinX(length, this.angle+180);
		} 
	}
	public void changedAngle(int direction){
		if (direction == FOOT_HEAD) {
			this.secondPositionX = firstPositionX+MatchstickCosX(length, this.angle);
			this.secondPositionY = firstPositionY+MatchstickSinX(length, this.angle);
		}else if (direction == HEAD_FOOT) {
			this.firstPositionX = secondPositionX+MatchstickCosX(length, this.angle+180);
			this.firstPositionY = secondPositionY+MatchstickSinX(length, this.angle+180);
		} 
	}
	public void changedAngle(int direction, Object matchstick){
		if (direction == FOOT_HEAD) {
//			if (matchstick instanceof Matchstick) {
//				this.firstPositionX = ((Matchstick)matchstick).secondPositionX;
//				this.firstPositionY = ((Matchstick)matchstick).secondPositionY;
//				this.secondPositionX = firstPositionX+MatchstickCosX(length, this.angle);
//				this.secondPositionY = firstPositionY+MatchstickSinX(length, this.angle);
//			}else if (matchstick instanceof double[] || matchstick instanceof int[]) {
//				if (matchstick instanceof double[]) {
//					this.angle = -((double[])matchstick)[this.typeId];
//				}else if (matchstick instanceof int[]){
//					this.angle = -(double)((int[])matchstick)[this.typeId];
//				}
//				this.secondPositionX = firstPositionX+MatchstickCosX(length, this.angle);
//				this.secondPositionY = firstPositionY+MatchstickSinX(length, this.angle);	
//			}else if (matchstick == null) {
//				this.secondPositionX = firstPositionX+MatchstickCosX(length, this.angle);
//				this.secondPositionY = firstPositionY+MatchstickSinX(length, this.angle);
//			}
			if (matchstick instanceof Matchstick) {
				if (this.typeId == Matchstick.RIGHT_THIGH) {
					this.firstPositionX = ((Matchstick)matchstick).firstPositionX;
					this.firstPositionY = ((Matchstick)matchstick).firstPositionY;
				}else {
					this.firstPositionX = ((Matchstick)matchstick).secondPositionX;
					this.firstPositionY = ((Matchstick)matchstick).secondPositionY;
				}	
			}else if (matchstick instanceof double[]) {
				this.angle = -((double[])matchstick)[this.typeId];	
			}else if (matchstick instanceof int[]){
				this.angle = -(double)((int[])matchstick)[this.typeId];	
			}
			this.secondPositionX = firstPositionX+MatchstickCosX(length, this.angle);
			this.secondPositionY = firstPositionY+MatchstickSinX(length, this.angle);		
		}else if (direction == HEAD_FOOT) {
			if (matchstick instanceof Matchstick) {
				this.secondPositionX = ((Matchstick)matchstick).secondPositionX;
				this.secondPositionY = ((Matchstick)matchstick).secondPositionY;
//				this.firstPositionX = secondPositionX+MatchstickCosX(length, this.angle+180);
//				this.firstPositionY = secondPositionY+MatchstickSinX(length, this.angle+180);
			}else if (matchstick instanceof Head) {
				this.secondPositionX = ((Head)matchstick).touchPositionX;
				this.secondPositionY = ((Head)matchstick).touchPositionY;
//				this.firstPositionX = secondPositionX+MatchstickCosX(length, this.angle+180);
//				this.firstPositionY = secondPositionY+MatchstickSinX(length, this.angle+180);
			}else if (matchstick instanceof double[] || matchstick instanceof int[]) {
				if (matchstick instanceof double[]) {
					this.angle = -((double[])matchstick)[this.typeId];
				}else if (matchstick instanceof int[]) {
					this.angle = -(double)((int[])matchstick)[this.typeId];
				}
			}
			this.firstPositionX = secondPositionX+MatchstickCosX(length, this.angle+180);
			this.firstPositionY = secondPositionY+MatchstickSinX(length, this.angle+180);
		} 
	}
	public void changedAngle(int direction, Object angleOfMan, Object matchstick){
		if (angleOfMan instanceof double[]) {
			this.angle = -((double[])angleOfMan)[this.typeId];
		}else if (angleOfMan instanceof int[]) {
			this.angle = -((int[])angleOfMan)[this.typeId];
		}
		if (direction == FOOT_HEAD) {
			if (matchstick instanceof Matchstick) {
				Matchstick matchstick2 = ((Matchstick)matchstick);
				if (typeId == Matchstick.RIGHT_THIGH && matchstick2.typeId == Matchstick.TRUNK) {
					this.firstPositionX = matchstick2.firstPositionX;
					this.firstPositionY = matchstick2.firstPositionY;
				}else {
					this.firstPositionX = matchstick2.secondPositionX;
					this.firstPositionY = matchstick2.secondPositionY;
				}
				this.secondPositionX = firstPositionX+MatchstickCosX(length, this.angle);
				this.secondPositionY = firstPositionY+MatchstickSinX(length, this.angle);
			}
			
		}else if (direction == HEAD_FOOT) {
			if (matchstick instanceof Matchstick) {
				Matchstick matchstick2 = ((Matchstick)matchstick);
				if (typeId == Matchstick.RIGHT_THIGH && matchstick2.typeId == Matchstick.TRUNK) {
					this.firstPositionX = matchstick2.firstPositionX;
					this.firstPositionY = matchstick2.firstPositionY;
				}else {
					this.secondPositionX = matchstick2.firstPositionX;
					this.secondPositionY = matchstick2.firstPositionY;
				}
//				this.firstPositionX = secondPositionX+MatchstickCosX(length, this.angle+180);
//				this.firstPositionY = secondPositionY+MatchstickSinX(length, this.angle+180);
			} else if (matchstick instanceof Head) {
				this.secondPositionX = ((Head)matchstick).touchPositionX;
				this.secondPositionY = ((Head)matchstick).touchPositionY;
	
			}
			this.firstPositionX = secondPositionX+MatchstickCosX(length, this.angle+180);
			this.firstPositionY = secondPositionY+MatchstickSinX(length, this.angle+180);
		} 	
	}
	/**
	 * �ı�λ��
	 */
	public void moveRelative(int positonX, int positionY){
		this.firstPositionX += positonX;
		this.firstPositionY += positionY;
		this.secondPositionX += positonX;
		this.secondPositionY += positionY;
	}
	public void moveTo(int positonX, int positionY){
		this.firstPositionX = positonX;
		this.firstPositionY = positionY;
		this.secondPositionX = firstPositionX+MatchstickCosX(length, this.angle);
		this.secondPositionY = firstPositionY+MatchstickSinX(length, this.angle);
	}
	/**
	 * ��ʾMatchstic
	 * @param graphics2d
	 */
	public void showMatchstick(Graphics2D graphics2d) {
		graphics2d.drawLine(firstPositionX, firstPositionY, secondPositionX, secondPositionY);
	}
	@Override
	public String toString() {
		return 	"\n\n\tfirstPositionX:"+firstPositionX+
				"\n\tfirstPositionY:"+firstPositionY+
				"\n\tsecondPositionX:"+secondPositionX+
				"\n\tsecondPositionY:"+secondPositionY+
				"\n\tLength:"+length+
				"\n\tAngle:"+angle+
				"\n\ttypeId:"+typeId;
	}
}
