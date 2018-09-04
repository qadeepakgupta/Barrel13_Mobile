package appiumCodePractice;

import java.util.Random;

public class RandomTestDataGenerator {

	public static void main(String[] args) {

		Random r = new Random();
		String fullName ="name"+r.nextInt();
		String gstNo ="DGNG";
		String gstNo1 ="92" + r.nextInt();
		String firmName="firm"+r.nextInt();
		String email ="email"+r.nextInt()+"@gmail.com";
		String password ="pass"+r.nextInt();

		System.out.println("Full Name is : " + fullName);
		System.out.println("gstNo is : " + gstNo + gstNo1);
		System.out.println("Firm Name is : " + firmName);
		System.out.println("Email is : " + email);
		System.out.println("Passeord is : " + password);
		
	}

}
