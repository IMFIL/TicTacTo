
import javax.swing.*;
public class TTTButton extends JButton{
	ImageIcon image;
	int row;
	int col;
	boolean chosenX = false;
	boolean chosenO = false;
	
	
	public TTTButton(TTTController TTT, int row, int col){
		this.row = row;
		this.col = col;
		

		image = new ImageIcon("/Users/filipslatinac/Desktop/TTT/Button.png");
		setIcon(image);
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		addActionListener(TTT);
	}
	
	public void SetChosenX(){
		if (!chosenO){
		chosenX = true;
		}
	}
	
	
	public boolean GetChosenX(){
		return chosenX;
	}
	public void SetChosenO(){
		chosenO = true;
	}
	
	
	public boolean GetChosenO(){
		return chosenO;
	}
}
