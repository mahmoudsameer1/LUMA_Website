package com.LUMA.dataProvider;

import org.testng.annotations.DataProvider;

import com.LUMA.utility.NewExcelLibrary;


public class DataProviders {

	NewExcelLibrary obj = new NewExcelLibrary();

	@DataProvider(name = "CreateAccount")
	public Object[][] getCreateAccount() {
		int rows = obj.getRowCount("CreateAccount");
		int column = obj.getColumnCount("CreateAccount");
		int actRows = rows - 1;
		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("CreateAccount", j, i + 2);
			}
		}
		return data;
	}
	
	@DataProvider(name = "Login")
	public Object[][] getLogin() {
		int rows = obj.getRowCount("Login");
		int column = obj.getColumnCount("Login");
		int actRows = rows - 1;
		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Login", j, i + 2);
			}
		}
		return data;
	}

}
