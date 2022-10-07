package test;

import java.util.Scanner;
//constructe a class
public class WeightGradesExtend {
	//As the input need be stored, so use list store the data
	private  double[] totalPoints;
	private  double[] percentage;
	
	public double[] getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(double[] totalPoints) {
		this.totalPoints = totalPoints;
	}
	public double[] getPercentage() {
		return percentage;
	}
	public void setPercentage(double[] percentage) {
		this.percentage = percentage;
	}
	/**
	 * use the input to compute the total grades, it is the sum of total points * percentage of the assignment
	 * @return
	 */
	public double compute() {
		double res=0;
		//for loop to go through the points and percentage
		for (int i=0;i<totalPoints.length;i++) {
			res+=this.percentage[i]*this.totalPoints[i];
		}
		return res;
	}
	/**
	 * get the result of the total grades and then asssess the level of the total grades
	 * @return a character so use char
	 */
	public char level() {
		//get the result of the totalgrades
		double totalGrades=this.compute();
		if(totalGrades>=90.0) return 'A';
		else if(totalGrades>=80) return 'B';
		else if(totalGrades>=70) return 'C';
		else if (totalGrades>=60) return 'D';
		else return 'F';
	}
	/**
	 * test if the total methods work
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create a new class
		WeightGradesExtend grade=new WeightGradesExtend();
		grade.totalPoints=new double[8];
		grade.percentage=new double[8];
		Scanner sc=new Scanner (System.in);
		for(int i=0;i<8;i++) {
			System.out.print("Input your total points of each assigment");
			grade.totalPoints[i]=sc.nextDouble();
			System.out.print("Input the percentage of the assignment");
			grade.percentage[i]=sc.nextDouble();
		}
		
		System.out.print(grade.level());
		
	}


}
