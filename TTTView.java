import java.awt.*;

import javax.swing.*;

public class TTTView extends JFrame {
	TTTBoard br;
	public TTTView(TTTController TTT){
		super("Tic Tac To");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout( new BorderLayout());
		
		JButton quit = new JButton("Quit");
		JButton New = new JButton ("New");
		
		quit.setActionCommand("Quit");
		New.setActionCommand("New");
		
		quit.addActionListener(TTT);
		New.addActionListener(TTT);
		
		JPanel bottom = new JPanel();
		
		bottom.add(quit);
		bottom.add(New);
		
		add(bottom,BorderLayout.SOUTH);
		
		TTTBoard b = new TTTBoard(TTT);
		br = b;
		add(b,BorderLayout.CENTER);
		pack();
		setVisible(true);
		
		
		
		
	}

	
	protected void Update(){
		br.Update();
	}
	
	protected TTTButton [][] getArr(){
		return br.setting;
	}
	

}
