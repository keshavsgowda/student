package ResultsPackage.StudentPackage;

import java.util.*;
import java.io.*;

interface Student
{
	public void getDetails();
}

class Subject
{
	public int semNo, credAl; 
	char grade;
	int gradePointSub;
}

public class RegisterStudent implements Student
{
	public String name, branch;
	public int sems;
	Scanner sc = new Scanner(System.in);
	public ArrayList<Integer> credits;
	public ArrayList<Float> gradePointsList;
	
	public void getDetails()
	{
		System.out.println("Enter name: ");
		name = sc.nextLine();
		System.out.println("Enter branch: ");
		branch = sc.nextLine();
		System.out.println("Enter number of sems: ");
		sems = sc.nextInt();
		credits = new ArrayList<Integer>(sems);
		gradePointsList = new ArrayList<Float>(sems);
		
		for(int i = 0; i < sems; i++)
		{
			float gradePoint = 0;
			int credSem = 0;
			System.out.println("Enter number of subjects for sem " + (i+1) + ": ");
			int numSub = sc.nextInt();
			int subSem = 0;
			Subject[] S = new Subject[numSub];
			for(int j = 0; j < numSub; j++)
			{
				S[j] = new Subject();
				S[j].semNo = i+1;
				System.out.println("Enter number of credits and grade for the subject " + (j+1) + ": ");
				S[j].credAl = sc.nextInt();
				S[j].grade = sc.next().charAt(0);
				switch(S[j].grade)
				{
					case 's':
					case 'S':
						S[j].gradePointSub = 10;
						break;
					case 'a':
					case 'A':
						S[j].gradePointSub = 9;
						break;
					case 'b':
					case 'B':
						S[j].gradePointSub = 8;
						break;
					case 'c':
					case 'C':
						S[j].gradePointSub = 7;
						break;
					case 'd':
					case 'D':
						S[j].gradePointSub = 6;
						break;
					default:
						System.out.println("Wrong value for subject! Defaulting to D!");
						S[j].gradePointSub = 6;
						break;
				}
				subSem += (S[j].gradePointSub * S[j].credAl);
				credSem += S[j].credAl;
				if(j == (numSub-1))
				{
					gradePoint = (float) subSem / credSem;
					gradePoint = (float) (Math.round(gradePoint * 100.0) / 100.0);
				}
			}
			try
			{
				if(credSem > 30 || credSem < 1)
				{
					i--;
					throw new CreditLimitException("Credits Limit Exception!");
				}
				else
				{
					gradePointsList.add(gradePoint);
					credits.add(credSem);
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}

class CreditLimitException extends Exception
{
	CreditLimitException(String S)
	{
		super(S);
	}
}