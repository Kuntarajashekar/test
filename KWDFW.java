package kywrddriven;

import java.io.FileInputStream;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class KWDFW 
{
	
	
	@Test
     
	public void KWFramework() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		  
		FileInputStream fis=new FileInputStream("C:\\Users\\Dell_owner\\Desktop\\kywrd.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		int st=wb.getSheetIndex("Sheet1");
		Sheet s=wb.getSheetAt(st);
		
		int rowcount=s.getLastRowNum();
		
		for(int i=0;i<rowcount+1;i++)
			
		{//row
			Row r=s.getRow(i+1);
			
			int cellcount=r.getLastCellNum();
			
			for(int j=2;j<cellcount;j++)
			{//1stcell
				Cell c=r.getCell(j);
				
				String str=c.getStringCellValue();
				
				if(str.equals("Y"))
				{
					
					for(j=1;j<cellcount;j++)
					{//2ndcell
						c=r.getCell(j);
						
						String kwrd=c.getStringCellValue();
						
						Method m=RefApi.class.getMethod(kwrd);
						
						m.invoke(m);
						break;
						
						
					}//2nd
					
				}//if
			
				else
				{
					
					System.out.println("keyworrd is not matching");
				}
				break;
			}//1st
			
			
			
			
			
		}//row
		
		
	}
	

}
