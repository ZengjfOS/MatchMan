package com.java.matchman;
/** ���ڱ����������������λ�ĳ��� */
public class LengthOfMan {
	
	/** �����X�������ɵĽǶ� */
	private int leftFootLength;
	/** ��С����X�������ɵĽǶ� */
	private int leftCrusLength;
	/** �������X�������ɵĽǶ� */
	private int leftThighLength;
	/** �����X�������ɵĽǶ� */
	private int trunkLength;
	/** �Ҵ�����X�������ɵĽǶ� */
	private int rightThighLength;
	/** ��С����X�������ɵĽǶ� */
	private int rightCrusLength;
	/** �ҽ���X�������ɵĽǶ� */
	private int rightFootLength;
	/** ��첲��X�������ɵĽǶ� */
	private int leftArmLength;
	/** ��ǰ����X�������ɵĽǶ� */
	private int leftForearmLength;
	/** �Ҹ첲��X�������ɵĽǶ� */
	private int rightArmLength;
	/** ��ǰ����X�������ɵĽǶ� */
	private int rightForearmLength;
	public int[] lengths;
	public LengthOfMan() {
	}
	/**
	 * ���캯�����һ��int[]������ڲ����Խ��г�ʼ��,ͬʱ���䱨����lengths��
	 * @param lengths
	 */
	public LengthOfMan(int[] lengths) {
		this.leftFootLength = lengths[0];
		this.leftCrusLength = lengths[1];
		this.leftThighLength = lengths[2];
		this.trunkLength = lengths[3];
		this.rightThighLength = lengths[4];
		this.rightCrusLength = lengths[5];
		this.rightFootLength = lengths[6];
		this.leftArmLength = lengths[7];
		this.leftForearmLength = lengths[8];
		this.rightArmLength = lengths[9];
		this.rightForearmLength = lengths[10];
		this.lengths = new int[]{leftFootLength,leftCrusLength,leftThighLength,
				trunkLength,rightThighLength,rightCrusLength,rightFootLength,
				leftArmLength,leftForearmLength,rightArmLength,rightForearmLength};
	}
	/**
	 * ���캯�����һ��double[]������ڲ����Խ��г�ʼ��,ͬʱ���䱨����lengths��
	 * @param lengths
	 */
	public LengthOfMan(double[] lengths) {
		this.leftFootLength = (int)lengths[0];
		this.leftCrusLength = (int)lengths[1];
		this.leftThighLength = (int)lengths[2];
		this.trunkLength = (int)lengths[3];
		this.rightThighLength = (int)lengths[4];
		this.rightCrusLength = (int)lengths[5];
		this.rightFootLength = (int)lengths[6];
		this.leftArmLength = (int)lengths[7];
		this.leftForearmLength = (int)lengths[8];
		this.rightArmLength = (int)lengths[9];
		this.rightForearmLength = (int)lengths[10];
		this.lengths = new int[]{leftFootLength,leftCrusLength,leftThighLength,
				trunkLength,rightThighLength,rightCrusLength,rightFootLength,
				leftArmLength,leftForearmLength,rightArmLength,rightForearmLength};
	}
	/**
	 * ���캯�����һ��string���ڲ����Խ��г�ʼ��,ͬʱ���䱨����lengths��
	 * @param lengths
	 */
	public LengthOfMan(String string) {
		string.replace("[", "");
		string.replace("]", "");
		String[] strings = string.split(", ");
		this.leftFootLength = Integer.parseInt(strings[0]);
		this.leftCrusLength = Integer.parseInt(strings[1]);
		this.leftThighLength = Integer.parseInt(strings[2]);
		this.trunkLength = Integer.parseInt(strings[3]);
		this.rightThighLength = Integer.parseInt(strings[4]);
		this.rightCrusLength = Integer.parseInt(strings[5]);
		this.rightFootLength = Integer.parseInt(strings[6]);
		this.leftArmLength = Integer.parseInt(strings[7]);
		this.leftForearmLength = Integer.parseInt(strings[8]);
		this.rightArmLength = Integer.parseInt(strings[9]);
		this.rightForearmLength = Integer.parseInt(strings[10]);
		this.lengths = new int[]{leftFootLength,leftCrusLength,leftThighLength,
				trunkLength,rightThighLength,rightCrusLength,rightFootLength,
				leftArmLength,leftForearmLength,rightArmLength,rightForearmLength};
	}
	@Override
	public String toString() {
		return "["+
					leftFootLength+", "+leftCrusLength+", "+leftThighLength+", "+
					trunkLength+", "+
					rightThighLength+", "+rightCrusLength+","+rightFootLength+	
					", "+leftArmLength+", "+leftForearmLength+", "+
					rightArmLength+", "+rightForearmLength+
				"]";
	}
}
