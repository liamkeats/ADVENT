package day4;

import java.util.ArrayList;

public class PassportCollection 
{
	ArrayList<Passport> passports;
	public PassportCollection()
	{
		passports = new ArrayList<Passport>();
	}
	
	public void add (Passport passport) 
	{
		passports.add(passport);
	}
	
	public int numOfvalidPassports1() 
	{
		int number = 0;
		for (Passport passport : passports) 
		{
			if (passport.isPassportValid1()) 
			{
				number++;
			}
		}
		return number;
	}
	
	public int numOfvalidPassports2() 
	{
		int number = 0;
		for (Passport passport : passports) 
		{
			if (passport.isPassportValid2()) 
			{
				number++;
			}
		}
		return number;
	}
}
