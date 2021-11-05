package br.com.calculador;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Toolkit;

public class CalculadorDeDatas extends JFrame {
	
	/*
	 * Inicializando variáveis
	 * 
	 */
	
	TratamentoDeEntradas tratamento = new TratamentoDeEntradas();
	int diasParaSomar = 0;
	LocalDate dataAtual = LocalDate.now();	
	String dataFormataEmString = tratamento.formataData(dataAtual);
	
	
	
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadorDeDatas frame = new CalculadorDeDatas();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculadorDeDatas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CalculadorDeDatas.class.getResource("/br/com/calculador/icons/calendar.png")));
		setTitle("Calculador de datas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataAtual = new JLabel(dataFormataEmString);
		lblDataAtual.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataAtual.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDataAtual.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblDataAtual.setBounds(50, 50, 100, 30);
		contentPane.add(lblDataAtual);
		
		JLabel lblTextDataAtual = new JLabel("Data atual:");
		lblTextDataAtual.setBounds(50, 30, 98, 14);
		contentPane.add(lblTextDataAtual);
		
		JLabel lblDataResultante = new JLabel("");
		lblDataResultante.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataResultante.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDataResultante.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblDataResultante.setBounds(350, 50, 100, 30);
		contentPane.add(lblDataResultante);
		
		JLabel lblTextDataResultante = new JLabel("Data resultante:");
		lblTextDataResultante.setBounds(350, 30, 98, 14);
		contentPane.add(lblTextDataResultante);
		
		JTextField txtFieldSomarDias = new JTextField();
		txtFieldSomarDias.setBounds(85, 140, 80, 20);
		txtFieldSomarDias.setColumns(10);
		contentPane.add(txtFieldSomarDias);
		
		
		JLabel lblTextSomarDias = new JLabel("Somar dias:");
		lblTextSomarDias.setBounds(10, 143, 80, 14);
		contentPane.add(lblTextSomarDias);
		
		JLabel lblmensagemCorrecao = new JLabel("");
		lblmensagemCorrecao.setForeground(Color.RED);
		lblmensagemCorrecao.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblmensagemCorrecao.setBounds(85, 125, 80, 14);
		contentPane.add(lblmensagemCorrecao);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tratamento.calcula(txtFieldSomarDias, dataAtual, diasParaSomar, lblDataResultante, lblmensagemCorrecao);
			}
		});
		
		btnCalcular.setBounds(435, 377, 89, 23);
		contentPane.add(btnCalcular);
		
		
	}
}












