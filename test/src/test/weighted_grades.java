package test;

import java.util.Scanner;

public class weighted_grades {
	private double pointTotal;
	private double earnedPoints;
	private  double assignPercentage;
	

	public double getPointTotal() {
		return pointTotal;
	}


	public void setPointTotal(double pointTotal) {
		this.pointTotal = pointTotal;
	}


	public double getEarnedPoints() {
		return earnedPoints;
	}


	public void setEarnedPoints(double earnedPoints) {
		this.earnedPoints = earnedPoints;
	}


	public double getAssignPercentage() {
		return assignPercentage;
	}


	public void setAssignPercentage(double assignPercentage) {
		this.assignPercentage = assignPercentage;
	}
   public  double weightedGrade() {
	   return this.earnedPoints/this.pointTotal*this.assignPercentage;

	   
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		weighted_grades wg=new weighted_grades();
		Scanner sc=new Scanner (System.in);
		System.out.print("Input your total point");
		double pointTotal=sc.nextDouble();
		wg.pointTotal=pointTotal;
		System.out.print("Input the point you have got");
		double earnedPoints=sc.nextDouble();
		wg.earnedPoints=earnedPoints;
		System.out.print("Input assignment percentage %");
		double assignPercentage=sc.nextDouble();
		wg.assignPercentage=assignPercentage;
		double x=wg.weightedGrade();
		System.out.println(x);
		
	}

}
