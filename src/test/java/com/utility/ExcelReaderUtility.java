package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String filename)  {

		File xlsxfile =new File(System.getProperty("user.dir")+"//testData//"+filename);
		
		XSSFWorkbook xssfworkbook = null;
		XSSFSheet xssfsheet=xssfworkbook.getSheet("LoginTestData");
		Iterator<Row> rowIterator=xssfsheet.rowIterator();
		User user;
		Row row;
		List<User> userList = null;
		Cell usernamecell;
		Cell passwordcell;
		rowIterator.next();
		try {
			xssfworkbook = new XSSFWorkbook(xlsxfile);
			userList=new ArrayList<User>();
			while(rowIterator.hasNext()) {
				
				row=rowIterator.next();
				usernamecell=row.getCell(0);
				passwordcell=row.getCell(1);
				user=new User(usernamecell.toString(), passwordcell.toString());
				userList.add(user);
				
			}
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	
		return userList.iterator();
		
	}

}
