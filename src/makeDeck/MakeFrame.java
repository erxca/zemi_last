package makeDeck;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import makeDeck.MakeDeck.SongData;
import javax.swing.JButton;

public class MakeFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	DefaultComboBoxModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		List<SongData> songsList;
		int i = 0;
		final String[] songsData;

		songsList = MakeDeck.Csvinput();
		songsData = new String[songsList.size()];
		for (SongData data : songsList) {
			songsData[i] = data.title;
			i++;
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeFrame frame = new MakeFrame(songsData);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		MakeDeck.Calc2(args);
	}

	/**
	 * Create the frame.
	 */
	public MakeFrame(String[] songsData) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel(
				"\u30CA\u30CA\u30B7\u30B9\u30E9\u30A4\u30D6\u30B9\u30C6\u30FC\u30B8\u30C7\u30C3\u30AD\u7DE8\u6210");
		label.setBounds(12, 10, 220, 20);
		contentPane.add(label);

		comboBox = new JComboBox(songsData);
		comboBox.setBounds(12, 40, 158, 19);
		contentPane.add(comboBox);
//		comboBox.addActionListener(comboBox);
		
		JButton btnButton = new JButton(new BtnAction(comboBox));
		btnButton.setBounds(12, 89, 129, 21);
		contentPane.add(btnButton);
	}
}
