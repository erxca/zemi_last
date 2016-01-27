package makeDeck;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class MakeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  throws IOException {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MakeFrame frame = new MakeFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		MakeDeck.csvinput();
		MakeDeck.calc(args);
	}

	/**
	 * Create the frame.
	 */
	public MakeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u30CA\u30CA\u30B7\u30B9\u30E9\u30A4\u30D6\u30B9\u30C6\u30FC\u30B8\u30C7\u30C3\u30AD\u7DE8\u6210");
		label.setBounds(12, 10, 161, 20);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(106, 40, 28, 19);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setText("\u66F2\u540D");
		textField.setBounds(12, 40, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
