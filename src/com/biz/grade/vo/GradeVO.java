package com.biz.grade.vo;

public class GradeVO {

	private String strNum;
	private String strName;
	private String strtel;
	private String strAddr;
	private int intKor;
	private int intEng;
	private int intMath;
	private int intSum;
	private float floatAvg;
	
	public String getStrNum() {
		return strNum;
	}
	public void setStrNum(String strNum) {
		this.strNum = strNum;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public String getStrtel() {
		return strtel;
	}
	public void setStrtel(String strtel) {
		this.strtel = strtel;
	}
	public String getStrAddr() {
		return strAddr;
	}
	public void setStrAddr(String strAddr) {
		this.strAddr = strAddr;
	}
	public int getIntKor() {
		return intKor;
	}
	public void setIntKor(int intKor) {
		this.intKor = intKor;
	}
	public int getIntEng() {
		return intEng;
	}
	public void setIntEng(int intEng) {
		this.intEng = intEng;
	}
	public int getIntMath() {
		return intMath;
	}
	public void setIntMath(int intMath) {
		this.intMath = intMath;
	}
	public int getIntSum() {
		return intSum;
	}
	public void setIntSum(int intSum) {
		this.intSum = intSum;
	}
	public float getFloatAvg() {
		return floatAvg;
	}
	public void setFloatAvg(float floatAvg) {
		this.floatAvg = floatAvg;
	}
	@Override
	public String toString() {
		return "GradeVO [strNum=" + strNum + ", strName=" + strName + ", strtel=" + strtel + ", strAddr=" + strAddr
				+ ", intKor=" + intKor + ", intEng=" + intEng + ", intMath=" + intMath + ", intSum=" + intSum
				+ ", floatAvg=" + floatAvg + "]";
	}
	
	
	
}
