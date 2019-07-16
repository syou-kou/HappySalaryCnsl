package com.gk.itpm.develop.cnsl.happysalary;

import java.util.Scanner;

public class HappySalary {
	private static char engineerRank;
	private static double unitPrice;

	public static void main(String[] args) {
		while (true) {
			// エンジニアランクの入力
			engineerRank = HappySalary.readEngineerRank();
			// 単価の入力
			unitPrice = HappySalary.readUnitPrice();
			// 入力項目の確認
			if (HappySalary.confirmInput()) {
				break;
			}
			System.out.println("もう一度初めから入力してください。");
		}
		// 給料の計算
		Engineer eng = new Engineer(engineerRank, unitPrice);
		System.out.printf("あなたの給料は %4.1f 万円です。", eng.calcSalary());
	}
	
	private static char readEngineerRank() {
		char engineerRank;
		String line;
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("あなたのエンジニアランクを入力してください。");
			System.out.println("（'a', 'b', 'c', 'A', 'B', 'C'のいずれか）");
			System.out.print("入力：");
			line = sc.nextLine();
			if (line.equals("a") || line.equals("A")) {
				engineerRank = EngineerRank.rankA;
			} else if (line.equals("b") || line.equals("B")) {
				engineerRank = EngineerRank.rankB;
			} else if (line.equals("c") || line.equals("C")) {
				engineerRank = EngineerRank.rankC;
			} else {
				System.out.println("入力されたエンジニアランクは不正です。");
				continue;
			}
			break;
		}
		
		return engineerRank;
	}
	
	private static double readUnitPrice() {
		double unitPrice;
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("あなたの単金を入力してください。");
			System.out.print("入力：");
			String line = sc.nextLine();
			try {
				unitPrice = Double.parseDouble(line);
			} catch (Exception e) {
				System.out.println("入力された単価は不正です。");
				continue;
			}
			if (unitPrice <= 0.0) {
				System.out.println("入力された単価は不正です。");
				continue;
			}
			break;
		}
		
		return unitPrice;
	}
	
	private static boolean confirmInput() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("あなたの入力項目は");
			System.out.println("    エンジニアランク：" + HappySalary.engineerRank);
			System.out.printf("    単      価      ：%4.1f万円\n", HappySalary.unitPrice);
			System.out.println("これらの情報からあなたの給料を計算して良いですか？");
			System.out.println("（yes または no のいずれか）");
			System.out.print("入力：");
			String line = sc.nextLine();
			if (line.equals("yes")) {
				return true;
			} else if (line.equals("no")) {
				return false;
			} else {
				System.out.println("入力された文字列は不正です。");
				continue;
			}
		}
	}
}
