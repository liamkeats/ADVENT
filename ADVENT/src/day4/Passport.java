package day4;

public class Passport 
{
	int byr;
    int iyr;
    int eyr;
    String hgt;
    String hcl;
    String ecl;
    String pid;
    String cid;
    
	public Passport (String byr, String iyr, String eyr, String hgt, String hcl, String ecl, String pid, String cid) 
	{
		this.byr=Integer.parseInt(byr);
		this.iyr=Integer.parseInt(iyr);
		this.eyr=Integer.parseInt(eyr);
		this.hgt=hgt;
		this.hcl=hcl;
		this.ecl=ecl;
		this.pid=pid;
		this.cid=cid;
	}
	
	public boolean isPassportValid1() 
	{
		
		if (byr==0) 
		{
			return false;
		}
		if (iyr==0) 
		{
			return false;
		}
		if (eyr==0) 
		{
			return false;
		}
		if (hgt.contentEquals("")) 
		{
			return false;
		}
		if (hcl.contentEquals("")) 
		{
			return false;
		}
		if (ecl.contentEquals("")) 
		{
			return false;
		}
		if (pid.contentEquals("")) 
		{
			return false;
		}
		
		return true;
	}
	
public boolean isPassportValid2() 
{
		
		if (byr<1920 || byr>2002 ) 
		{
			return false;
		}
		if (iyr<2010 || iyr>2020) 
		{
			return false;
		}
		if (eyr<2020 || eyr>2030) 
		{
			return false;
		}
		
		if (hgt.contentEquals("")) 
		{
			return false;
		}
		
		if (hgt.substring(hgt.length()-2).contains("cm")) 
		{
			int ihgt = Integer.parseInt(hgt.substring(0, hgt.length()-2));
			 if (ihgt<150 || ihgt>193) 
			 {
				 return false;
			 }
		} 
		else if (hgt.substring(hgt.length()-2).contains("in")) 
		{
			int ihgt = Integer.parseInt(hgt.substring(0, hgt.length()-2));
			 if (ihgt<59 || ihgt>76) 
			 {
				 return false;
			 }
		} 
		else 
		{
			return false;
		}
		
		if (!hcl.matches("^#[0-9abcdef]{6}")) 
		{
			return false;
		}
		
		if (!ecl.matches("amb|blu|brn|gry|grn|hzl|oth")) 
		{
			return false;
		}
		
		if (!pid.matches("[0-9]{9}")) 
		{
			return false;
		}
		
		return true;
	}
}
