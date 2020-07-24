package testNG;

import org.testng.annotations.Test;

public class Grouping

{
	
@Test (groups= {"apple"})
public void apple1()
{
	System.out.println("1st apple");
}

@Test (groups= {"apple"})
public void apple2()
{
	System.out.println("2nd apple");
}

@Test (groups= {"apple"})
public void apple3()
{
	System.out.println("3rd apple");
}

@Test (groups= {"oppo"})
public void oppo1()
{
	System.out.println("1st Oppo");
}

@Test (groups= {"oppo"})
public void oppo2()
{
	System.out.println("2nd Oppo");
}

@Test (groups= {"oppo"})
public void oppo3()
{
	System.out.println("3rd Oppo");
}
@Test (groups= {"moto"})
public void moto1()
{
	System.out.println("1st moto");
}
@Test (groups= {"moto"})
public void moto2()
{
	System.out.println("2nd moto");
}
@Test (groups= {"moto"})
public void moto3()
{
	System.out.println("3rd moto");
}

}
