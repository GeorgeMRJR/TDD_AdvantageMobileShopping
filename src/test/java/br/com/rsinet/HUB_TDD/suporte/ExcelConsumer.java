package br.com.rsinet.HUB_TDD.suporte;

public class ExcelConsumer {

//dados para cadastrar um novo cliente
	public String getNomeUsuario(int row) throws Throwable {
		return ExcelUtils.getCellData(row, 1);
	}

	public String getSenha(int row) throws Throwable {
		return ExcelUtils.getCellData(row, 2);
	}

	public String getReSenha(int row) throws Throwable {
		return ExcelUtils.getCellData(row, 3);
	}

	public String getEmail(int row) throws Throwable {
		return ExcelUtils.getCellData(row, 4);
	}

	public String getPrimeiroNome(int row) throws Throwable {
		return ExcelUtils.getCellData(row, 5);
	}

	public String getSegundoNome(int row) throws Throwable {
		return ExcelUtils.getCellData(row, 6);
	}

	public String getTelefone(int row) throws Throwable {
		return ExcelUtils.getCellData(row, 7);
	}

	public String getContinente(int row) throws Throwable {
		return ExcelUtils.getCellData(row, 8);
	}

	public String getCidade(int row) throws Throwable {
		return ExcelUtils.getCellData(row, 9);
	}

	public String getEstado(int row) throws Throwable {
		return ExcelUtils.getCellData(row, 10);
	}

	public String getEndereco(int row) throws Throwable {
		return ExcelUtils.getCellData(row, 11);
	}

	public String getCodPostal(int row) throws Throwable {
		return ExcelUtils.getCellData(row, 12);
	}
}
