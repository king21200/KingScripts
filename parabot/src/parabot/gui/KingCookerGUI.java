package parabot.gui;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class KingCookerGUI extends JFrame {
	private JPanel contentPane;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public KingCookerGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKingCooker = new JLabel("King_Cooker");
		lblKingCooker.setBounds(10, 10, 320, 45);
		lblKingCooker.setHorizontalAlignment(SwingConstants.CENTER);
		lblKingCooker.setVerticalAlignment(SwingConstants.TOP);
		lblKingCooker.setFont(new Font("Arial", Font.BOLD, 32));
		contentPane.add(lblKingCooker);
		
		JLabel lblSelectFish = new JLabel("Select what would you like to cook?");
		lblSelectFish.setBounds(10, 50, 320, 215);
		lblSelectFish.setVerticalAlignment(SwingConstants.TOP);
		lblSelectFish.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectFish.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblSelectFish);
		       		
		final JComboBox fishToCook = new JComboBox();
		fishToCook.setFont(new Font("Arial", Font.PLAIN, 12));
		fishToCook.setModel(new DefaultComboBoxModel(new String[] {"Shrimp", "Tuna", "Lobster", "Swordfish", "Shark"}));
		fishToCook.setBounds(105, 80, 125, 40);
		contentPane.add(fishToCook);
		
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String chosen = fishToCook.getSelectedItem().toString();
			switch(chosen){
			case "Shrimp":
				parabot.KingCooker.setRawFishId(317);
				break;
			case "Tuna":
				parabot.KingCooker.setRawFishId(359);
				break;
			case "Lobster":
				parabot.KingCooker.setRawFishId(377);
				break;
			case "Swordfish":
				parabot.KingCooker.setRawFishId(371);
				break;
			case "Shark":
				parabot.KingCooker.setRawFishId(383);
				break;
			}
            parabot.KingCooker.setGuiWait(false);
            parabot.KingCooker.getG().dispose();
            }
			
		});
		startButton.setFont(new Font("Arial", Font.BOLD, 11));
		startButton.setBounds(105, 140, 125, 40);
		contentPane.add(startButton);
	}
}
