package com.poo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class TelaRecarga extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRecarga frame = new TelaRecarga();
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
	public TelaRecarga() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecarregarCarto = new JLabel("RECARREGAR CART�O");
		lblRecarregarCarto.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblRecarregarCarto.setBounds(140, 60, 240, 25);
		contentPane.add(lblRecarregarCarto);
		
		textField = new JTextField();
		textField.setBounds(220, 108, 192, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNmeroCarto = new JLabel("N�mero do cart�o:");
		lblNmeroCarto.setBounds(99, 118, 121, 16);
		contentPane.add(lblNmeroCarto);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(176, 152, 61, 16);
		contentPane.add(lblValor);
		
		textField_1 = new JTextField();
		textField_1.setBounds(220, 142, 134, 36);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSenhaAdm = new JLabel("Senha ADM:");
		lblSenhaAdm.setBounds(142, 184, 78, 16);
		contentPane.add(lblSenhaAdm);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 181, 134, 25);
		contentPane.add(passwordField);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(99, 243, 117, 29);
		contentPane.add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(208, 243, 117, 29);
		contentPane.add(btnLimpar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(318, 243, 117, 29);
		contentPane.add(btnConfirmar);
	}
}