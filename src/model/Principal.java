package model;

import java.time.LocalDate;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Principal {
	
	public static void main(String[] args) {
		
		Colaborador colab1 = new Colaborador("Carlos");
		Colaborador colab2 = new Colaborador("Henrique");
		colab1.setHabilitado(false);
		colab2.setHabilitado(true);
		
		Veiculo carro1 = new Veiculo("Celta", "MCH1010", 14.0);
		Veiculo carro2 = new Veiculo("Mobi", "MCH2020", 16.5);
		carro1.setDisponivel(false);
		
		Chamado ch1 = new Chamado("2022-03-17", "Rua 150", 100.00, colab2, carro2);
		
		System.out.println("Data chamado: " + ch1.getDataInicio());
		System.out.println("Nome colaborador: " + ch1.getColaborador().getNome());
		System.out.println("Modelo: " + ch1.getVeiculo().getModelo() + " Placa: " + ch1.getVeiculo().getPlaca());
		System.out.println("Dist�ncia: " + ch1.getDistancia());
		System.out.println("Emiss�o CO�: " + ch1.getPegadaCarbono());
		
	}

}
