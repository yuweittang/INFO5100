package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//constructe a class
public class WeightGradesExtend2 {
	//As the input need be stored, so use list store the data
	private  ArrayList<Double> totalPoints;
	private  ArrayList<Double>  percentage;
	
	public ArrayList<Double>  getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(ArrayList<Double>  totalPoints) {
		this.totalPoints = totalPoints;
	}
	public ArrayList<Double>  getPercentage() {
		return percentage;
	}
	public void setPercentage(ArrayList<Double>  percentage) {
		this.percentage = percentage;
	}
	/**
	 * use the input to compute the total grades, it is the sum of total points * percentage of the assignment
	 * @return
	 */
	public double compute() {
		double res=0;
		//for loop to go through the points and percentage
		for (int i=0;i<totalPoints.size();i++) {
			res+=this.percentage.get(i)*this.totalPoints.get(i);
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
	public boolean isUpTo100() {
		int res=0;
		for(double x:this.percentage) {
			res+=x;
		}
		if(res>100) return false;
		return true;
	}
	/**
	 * test if the total methods work
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create a new class
		WeightGradesExtend2 grade=new WeightGradesExtend2();
		grade.totalPoints=new ArrayList<Double>();
		grade.percentage=new ArrayList<Double>();
		Scanner sc=new Scanner (System.in);
		while(true) {
			System.out.print("Input your total points of each assigment, input -1 if there is no more assignment");
			//If the input is -1, jump out the loop
			double point=sc.nextDouble();
			if(point==-1) break;
			grade.totalPoints.add(point);
			System.out.print("Input the percentage of the assignment");
			grade.percentage.add(sc.nextDouble());
		}
		//If the sum of the percentage is more than 100
		if(grade.isUpTo100()) {
			System.out.print(grade.level());
		}else {
		//If the total percentage is more than 100, 
			System.out.println("The total of the percentage is more than 100, please enter agian");
		}
		
		
		
	}


}
