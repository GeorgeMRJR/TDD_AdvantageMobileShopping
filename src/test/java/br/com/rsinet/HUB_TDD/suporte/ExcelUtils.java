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
	private XSSFCell cell;
	private String stringCellValue;
	private String planilha;

	public ExcelUtils() throws IOException {
		File file = new File("src/test/resources/TDD_AdvantageOnlineShoppingData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
	}

	@DataProvider(name = "excelData")
	public Object[][] readExcel(Method testMethod) throws IOException {
		String methodName = testMethod.getName();
		System.out.print("| nome do metodo: " + methodName);
		switch (methodName) {
		case "deveCadastrarUmUsuario":
			planilha = "CadastrarNovoCliente_Po";
			break;
		case "naoDeveCadastrarUsuarioJaCadastrado":
			planilha = "CadastrarNovoCliente_Ne";
			break;
		case "deveAbrirUmProdutoPelaCategoria":
			planilha = "AbrirUmProdutoPelaHome_Po";
			break;
		case "naoDeveAceitarMaisDeDezItensNoCarrinho":
			planilha = "AbrirUmProdutoPelaHome_Ne";
			break;
		case "deveBuscarUmProdutoExistente":
			planilha = "BuscarUmProdutoPelaBusca_Po";
			break;
		case "deveBuscarUmProdutoInexistente":
			planilha = "BuscarUmProdutoPelaBusca_Ne";
			break;

		default:
			break;
		}
		return populaObj();

	}

	private Object[][] populaObj() {
		XSSFSheet sheet = workbook.getSheet(planilha);
		int totalRows = sheet.getLastRowNum();
		int totalColums = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(" | Nome da planilha: " + planilha + " | linhas: " + totalRows + " | colunas " + totalColums
				+ " | " + "\n");

		Object obj[][] = new Object[totalRows][totalColums];

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
				obj[i][j] = (stringCellValue);

			}
			System.out.println();
		}
		return obj;
	}

}