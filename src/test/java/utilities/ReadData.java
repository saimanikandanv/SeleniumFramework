package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadData {
	
	static FileInputStream fis=null;
	static Properties prop =null;	
	static Workbook wb=null;
	static File file=null;
	static Sheet sheet=null;	
	static Row row=null;
	static Cell cell=null;
	public static String getProp(String Propname)
	{
		file=new File("./src/test/java/config/config.properties");
		try
		{	
			 fis=new FileInputStream(file);
			 prop =new Properties();
			 prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return prop.getProperty(Propname);
	}
	public static String readExcelData(String sheetName,String colName) throws IOException
	{
		String testData=null;
		file = new File("./TestData//TestData.xlsx");
		fis=new FileInputStream(file);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(sheetName);
		row=sheet.getRow(0);
		int cellNum=row.getPhysicalNumberOfCells();
		int colNumber=0;
		for(int i=0;i<cellNum;i++)
		{
			if(row.getCell(i).getStringCellValue().equals(colName))
			{
				colNumber=i;
			}
		}
		row=sheet.getRow(1);
		cell=row.getCell(colNumber);	
		testData=cell.getStringCellValue();
//		System.out.println(testData);
		wb.close();
		fis.close();
		return testData;
	}
}
