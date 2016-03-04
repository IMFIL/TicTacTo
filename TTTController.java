import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class TTTController implements ActionListener{
	
	TTTView tttv;
	int ind;
	public TTTController(){
		tttv = new TTTView(this);
		ind = 0;
		firstmove();
	}
	
	private void NEW(){
		tttv.Update();
		firstmove();
		ind++;
	}
	
	private boolean isWinX(){
		
		 if(tttv.getArr()[0][0].GetChosenX() && tttv.getArr()[1][1].GetChosenX() && tttv.getArr()[2][2].GetChosenX()){
			 return true;
		
		 }
		 
		 if(tttv.getArr()[0][2].GetChosenX() && tttv.getArr()[1][1].GetChosenX() && tttv.getArr()[2][0].GetChosenX()){
			 return true;
		
		 }
		 
		 for (int i = 0; i < 3;i++){
			 if(tttv.getArr()[i][0].GetChosenX() && tttv.getArr()[i][1].GetChosenX() && tttv.getArr()[i][2].GetChosenX()){
				 return true;
			 }
		 }
		 
		 for (int i = 0; i < 3;i++){
			 if(tttv.getArr()[0][i].GetChosenX() && tttv.getArr()[1][i].GetChosenX() && tttv.getArr()[2][i].GetChosenX()){
				 return true;
			 }
		 }
		
		return false;
	}
	
	private boolean isWinO(){
		
		 if(tttv.getArr()[0][0].GetChosenO() && tttv.getArr()[1][1].GetChosenO() && tttv.getArr()[2][2].GetChosenO()){
			 return true;
		
		 }
		 
		 if(tttv.getArr()[0][2].GetChosenO() && tttv.getArr()[1][1].GetChosenO() && tttv.getArr()[2][0].GetChosenO()){
			 return true;
		
		 }
		 
		 for (int i = 0; i < 3;i++){
			 if(tttv.getArr()[i][0].GetChosenO() && tttv.getArr()[i][1].GetChosenO() && tttv.getArr()[i][2].GetChosenO()){
				 return true;
			 }
		 }
		 
		 for (int i = 0; i < 3;i++){
			 if(tttv.getArr()[0][i].GetChosenO() && tttv.getArr()[1][i].GetChosenO() && tttv.getArr()[2][i].GetChosenO()){
				 return true;
			 }
		 }
		
		return false;
	}
	
	private TTTButton canWinO(){
		TTTButton tb = null;
		 if(tttv.getArr()[0][0].GetChosenO() && tttv.getArr()[1][1].GetChosenO() && !tttv.getArr()[2][2].GetChosenX()){
			 return (tttv.getArr()[2][2]);
		 }
		 
		 if(tttv.getArr()[0][2].GetChosenO() && tttv.getArr()[1][1].GetChosenO() && !tttv.getArr()[2][0].GetChosenX()){
			 return (tttv.getArr()[2][0]);
		 }
		 return tb;
	}
	
	private boolean isDraw(){
		int ind =0;
		for (int i = 0; i < 3; i ++){
			for (int j = 0; j < 3; j ++){
				if(tttv.getArr()[i][j].GetChosenO() || tttv.getArr()[i][j].GetChosenX()){
					ind++;
				}
			}
		}
		if(ind == 9){
			return true;
		}
		return false;
	}
	
	private void firstmove(){
		Random num = new Random();
		int choose = num.nextInt(3);
		int choose1 = num.nextInt(3);
		TTTButton fm = tttv.getArr()[choose][choose1];

		ImageIcon image1 = new ImageIcon("/Users/filipslatinac/Desktop/TTT/O.png");
		
		fm.setIcon(image1);
		fm.setBorderPainted(false);
		fm.setFocusPainted(false);
		fm.setContentAreaFilled(false);
		fm.SetChosenO();
		fm.setEnabled(false);
	}
	
	private boolean compMove(){
		
		Random rd = new Random();
		int ind1 = rd.nextInt(3);
		int ind2 = rd.nextInt(3);
		
		TTTButton tb = canWinO();
		if (tb != null){
			chooseO(tb);
			return true;
		}

		else{
			
		
			for(int i = 0; i < 3;i++){
				if(tttv.getArr()[i][0].GetChosenX() && tttv.getArr()[i][2].GetChosenX() && !tttv.getArr()[i][1].GetChosenO()){
					TTTButton ftmp = tttv.getArr()[i][1];
	                chooseO(ftmp);
	                return true;
				}
			}
			for(int i = 0; i < 3;i++){
				if(tttv.getArr()[0][i].GetChosenX() && tttv.getArr()[2][i].GetChosenX() && !tttv.getArr()[1][i].GetChosenO()){
					TTTButton ftmp = tttv.getArr()[1][i];
	                chooseO(ftmp);
	                return true;
				}
			}
			
			if (tttv.getArr()[2][0].GetChosenX() && !tttv.getArr()[0][2].GetChosenO()){
				TTTButton ftmp = tttv.getArr()[0][2];
                chooseO(ftmp);
                return true;
			}
			if (tttv.getArr()[0][2].GetChosenX() && !tttv.getArr()[2][0].GetChosenO()){
				TTTButton ftmp = tttv.getArr()[2][0];
                chooseO(ftmp);
                return true;
			}
			if (tttv.getArr()[2][2].GetChosenX() && !tttv.getArr()[0][0].GetChosenO()){
				TTTButton ftmp = tttv.getArr()[0][0];
                chooseO(ftmp);
                return true;
			}
			if (tttv.getArr()[0][0].GetChosenX() && !tttv.getArr()[2][2].GetChosenO()){
				TTTButton ftmp = tttv.getArr()[2][2];
                chooseO(ftmp);
                return true;
			}
		
		
		for(int i = 0; i < 3;i++){
			if(tttv.getArr()[i][0].GetChosenX() && tttv.getArr()[i][2].GetChosenX() && !tttv.getArr()[i][1].GetChosenO()){
				TTTButton ftmp = tttv.getArr()[i][1];
                chooseO(ftmp);
                return true;
			}
			for (int j = 0; j < 2; j++){
				if(tttv.getArr()[i][j].GetChosenX() && tttv.getArr()[i][j+1].GetChosenX()){
				if ((j + 1== 1)&& !tttv.getArr()[i][j+2].GetChosenO()){
				TTTButton ftmp = tttv.getArr()[i][j+2];
                chooseO(ftmp);
                return true;
				}
				else if((j + 1 == 2) && !tttv.getArr()[i][0].GetChosenO()){
				TTTButton ftmp = tttv.getArr()[i][0];
	            chooseO(ftmp);
	            return true;	
				}
				
				
				}
			}
		}
		for(int i = 0; i < 2;i++){
			for (int j = 0; j < 3; j++){
				if(tttv.getArr()[i+1][j].GetChosenX() && tttv.getArr()[i][j].GetChosenX()){
				if (i + 1 == 1 && !tttv.getArr()[i+2][j].GetChosenO()){
				TTTButton ftmp = tttv.getArr()[i+2][j];
                chooseO(ftmp);
                return true;
				}
				else if(i + 1 == 2 && !tttv.getArr()[0][j].GetChosenO()){
				TTTButton ftmp = tttv.getArr()[0][j];
	            chooseO(ftmp);
	            return true;	
				}
				}
			}
		}
				while ((tttv.getArr()[ind1][ind2].GetChosenX() || tttv.getArr()[ind1][ind2].GetChosenO())){
					ind1 = rd.nextInt(3);
					ind2 = rd.nextInt(3);
				}
				TTTButton ftmp = tttv.getArr()[ind1][ind2];
	            chooseO(ftmp);
	            return true;
		}

	}
	
	private void chooseO(TTTButton tttb){
		ImageIcon image1 = new ImageIcon("/Users/filipslatinac/Desktop/TTT/O.png");
		
		tttb.setIcon(image1);
		tttb.setBorderPainted(false);
		tttb.setFocusPainted(false);
		tttb.setContentAreaFilled(false);
		tttb.SetChosenO();
		tttb.setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand() == "Quit"){
			System.exit(0);
		}
		
		else if (e.getActionCommand() == "New"){
			NEW();
			
		}
		
		else{
			TTTButton x = (TTTButton)e.getSource();
			if (!x.GetChosenO()){
			ImageIcon image = new ImageIcon("/Users/filipslatinac/Desktop/TTT/X.png");
			
			x.setIcon(image);
			x.setBorderPainted(false);
			x.setFocusPainted(false);
			x.setContentAreaFilled(false);
			x.SetChosenX();
			x.setEnabled(false);
			}
			if (!isWinX()){
				compMove();
				if (isWinO()){
					{
						JOptionPane.showMessageDialog(null, "DO NOT TALK TO ME OR MY SON EVER AGAIN", "RESULTS", JOptionPane.INFORMATION_MESSAGE);
				        NEW();
					}
				}
				if(isDraw()){
					{
					JOptionPane.showMessageDialog(null, "DRAW", "RESULTS", JOptionPane.INFORMATION_MESSAGE);
					 NEW();
					}
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "WINNER", "RESULTS", JOptionPane.INFORMATION_MESSAGE);
				 NEW();
			}
			
			
		}
		
	}
	public static void main (String [] args){
		TTTController ttt = new TTTController();
	}

}
