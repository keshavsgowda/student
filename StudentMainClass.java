import java.util.*;
import ResultsPackage.Results;
import ResultsPackage.StudentPackage.RegisterStudent;

class StudentMainClass
{
	public static void main(String[] args)
	{
		Results RS = new Results();
		RS.enterGrades();
		RS.displayDetails();
	}
}