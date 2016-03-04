import java.awt.*;
import javax.swing.*;

public class TTTBoard extends JPanel {
	TTTController TTT;
	TTTButton [][] setting = new TTTButton [3][3];
	int indx = 0;
	int indy = 0;
	public TTTBoard(TTTController TTT){
		this.TTT = TTT;
		runTTTV();

	}
	
	
	protected void Update(){
	 indy = 0;
	 indx = 0;
   	 removeAll();
   	 runTTTV();
   	 revalidate();
   	 repaint();

	}
	
	private void runTTTV(){
		
		JPanel R1 = new JPanel();
		R1.setPreferredSize(new Dimension (600,200));
		for (int i = 0; i < 3; i++){
			TTTButton b = new TTTButton(TTT,0,i);
			R1.add(b);
			setting[indx][indy] = b ;
			indy++;
		}
		JPanel R2 = new JPanel();
		indx += 1;
		indy = 0;
		R2.setPreferredSize(new Dimension (600,200));
		for (int i = 0; i < 3; i++){
			TTTButton b = new TTTButton(TTT,0,i);
			R2.add(b);
			setting[indx][indy] = b ;
			indy++;
		}
		JPanel R3 = new JPanel();
		indx += 1;
		indy = 0;
		R3.setPreferredSize(new Dimension (600,200));
		for (int i = 0; i < 3; i++){
			TTTButton b = new TTTButton(TTT,0,i);
			R3.add(b);
			setting[indx][indy] = b ;
			indy++;
		}
		
		setLayout(new GridLayout(3,0));
		add(R1);
		add(R2);
		add(R3);
		setVisible(true);
	}
	

	


}
