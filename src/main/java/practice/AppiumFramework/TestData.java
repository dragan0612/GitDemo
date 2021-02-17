package practice.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="InputData")
	public Object[][] getDataForEditField()
	{
		//2sets of data, "hello", "!@@#$$"
		Object[][] obj = new Object[][]
				{
					{"hello"},{"!@@#$$"}
				};
				return obj;
	}
	
	@DataProvider(name="InputData1")
	public Object[][] getDataUpdate4234()
	{
		//2sets of data, "hello", "!@@#$$"
		Object[][] obj = new Object[][]
				{
					{"hello"},{"!@@#$$"}
				};
				return obj;
	}

}
