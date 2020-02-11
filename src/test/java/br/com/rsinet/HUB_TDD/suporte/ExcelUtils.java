package br.com.rsinet.HUB_TDD.suporte;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtils {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFCell cell;
	private String stringCellValue;
	private int totalRows;
	private int totalColums;

	public ExcelUtils() throws IOException {
		File file = new File("src/test/resources/TDD_AdvantageOnlineShoppingData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
	}

	@DataProvider(name = "excelData")
	public Object[][] readExcel(Method testMethod) throws IOException {
		String methodName = testMethod.getName();
		System.out.println(">>>>>>>>>>>>>>>>>>>" + methodName);
//		switch (methodName) {
//		case "deveCadastrarUmUsuario":
//		planilha = "CadastrarNovoCliente_Po";

		sheet = workbook.getSheet("CadastrarNovoCliente_Po");
		totalRows = sheet.getLastRowNum();
		totalColums = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(">>>>>>>>>>>>>>linhas " + totalRows);
		System.out.println(">>>>>>>>>>>>>>colunas " + totalColums);

		Object deveCadastrarUmUsuario[][] = new Object[totalRows][totalColums];

		for (int i = 0; i < totalRows; i++) {
			Row row = sheet.getRow(i + 1);
			for (int j = 0; j < row.getLastCellNum(); j++) {

				cell = sheet.getRow(i + 1).getCell(j);
				try {
					stringCellValue = cell.getStringCellValue();
				} catch (Exception e) {
					stringCellValue = String.valueOf((int) cell.getNumericCellValue());
				}

				System.out.print(stringCellValue + "|| ");
				deveCadastrarUmUsuario[i][j] = (stringCellValue);

			}
			System.out.println();
		}

		sheet = workbook.getSheet("CadastrarNovoCliente_Ne");
		totalRows = sheet.getLastRowNum();
		totalColums = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(">>>>>>>>>>>>>>linhas " + totalRows);
		System.out.println(">>>>>>>>>>>>>>colunas " + totalColums);

		Object naoDeveCadastrarUsuarioJaCadastrado[][] = new Object[totalRows][totalColums];

		for (int i = 0; i < totalRows; i++) {
			Row row = sheet.getRow(i + 1);
			for (int j = 0; j < row.getLastCellNum(); j++) {

				cell = sheet.getRow(i + 1).getCell(j);
				try {
					stringCellValue = cell.getStringCellValue();
				} catch (Exception e) {
					stringCellValue = String.valueOf((int) cell.getNumericCellValue());
				}

				System.out.print(stringCellValue + "|| ");
				naoDeveCadastrarUsuarioJaCadastrado[i][j] = (stringCellValue);

			}
			System.out.println();
		}

		if (methodName.equalsIgnoreCase("deveCadastrarUmUsuario")) {
			return deveCadastrarUmUsuario;
		} else if (methodName.equalsIgnoreCase("naoDeveCadastrarUsuarioJaCadastrado")) {
			return naoDeveCadastrarUsuarioJaCadastrado;
		} else {
			return null;
		}

	}

}