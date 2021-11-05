package br.com.calculador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TratamentoDeEntradas {

	/*
	 * método que formata a data para dia/mes/ano
	 * retorna em String
	 */
	
	public String formataData(LocalDate dataParaFormatar) {
		
		DateTimeFormatter formatoDeData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		return dataParaFormatar.format(formatoDeData);
		
	}
	
	/*
	 * método que soma os dias na data passada
	 * retorna uma data resultante LocalDate
	 */
	
	public LocalDate somarDias(LocalDate dataParaSomar, int diasParaSomar) {
		
		return dataParaSomar.plusDays(diasParaSomar);
		
	}
	
	/*
	 * 
	 * Método que checa se teve alguma entrada no textfield que não seja número
	 * Se sim, retora true
	 * 
	 */
	
	public boolean checaNumero(JTextField txtFieldSomarDias) {
		long valor = 0;
		try {
			valor = Long.parseLong(txtFieldSomarDias.getText());
			return false;
		} catch (NumberFormatException ex) {
			return true;	
		}
	}
	
	
	/*
	 * 
	 * Método que checa se o textField de entrada de dados está vazio
	 * Se sim, retorna true
	 * 
	 */
	
	public boolean checaTextField(JTextField jTextField) {
		
		boolean estaVazio = jTextField.getText().trim().isEmpty();
		return estaVazio;
		
	}
	
	/*
	 * 
	 * Método que realiza o cálculo de acordo com a entrada válida
	 * mostra o resultado no JLabel lblDataResultante
	 * 
	 */
	
	public void calcula(JTextField txtFieldSomarDias, LocalDate dataAtual, int diasParaSomar, 
			JLabel lblDataResultante, JLabel lblmensagemCorrecao) {
		
		if (checaTextField(txtFieldSomarDias) || checaNumero(txtFieldSomarDias)) {
			lblmensagemCorrecao.setText("Dados Inválidos");
		} else {
			String entradaDoField = txtFieldSomarDias.getText();
			diasParaSomar = Integer.parseInt(entradaDoField);
			lblDataResultante.setText(formataData(somarDias(dataAtual, diasParaSomar)));
			lblmensagemCorrecao.setText("");
		}
	}
	
}



