package com.gk.itpm.develop.cnsl.happysalary;

public class Engineer {
	private char engineerRank;				// エンジニアランク
	private double unitPrice;				// 単価
	
	public Engineer(char r, double up) {
		this.engineerRank = r;
		this.unitPrice = up;
	}
	
	public double calcSalary() {
		switch (this.engineerRank) {
			case EngineerRank.rankA:
				return unitPrice * EngineerCoefficient.rankA;
			case EngineerRank.rankB:
				return unitPrice * EngineerCoefficient.rankB;
			case EngineerRank.rankC:
				return unitPrice * EngineerCoefficient.rankC;
			default:
				return 0.0;
		}
	}
}
