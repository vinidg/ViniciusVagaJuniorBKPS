package br.com.Vinicius.VagaJunior.BKPS.beans;

public enum Estados {

	RO("Rond�nia"),
	AC("Acre"),
	AM("Amazonas"),
	RR("Roraima"),
	PA("Par�"),
	AP("Amap�"),
	TO("Tocantins"),
	MA("Maranh�o"),
	PI("Piau�"),
	CE("Cear�"),
	RN("Rio Grande do Norte"),
	PB("Para�ba"),
	PE("Pernambuco"),
	AL("Alagoas"),
	SE("Sergipe"),
	BA("Bahia"),
	MG("Minas Gerais"),
	ES("Esp�rito Santo"),
	RJ("Rio de Janeiro"),
	SP("S�o Paulo"),
	PR("Paran�"),
	SC("Santa Catarina"),
	RS("Rio Grande do Sul"),
	MS("Mato Grosso do Sul"),
	MT("Mato Grosso"),
	GO("Goi�s"),
	DF("Distrito Federal");

	private final String nome;

	Estados(String nome) {
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	

}
