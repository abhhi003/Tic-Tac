/*
TIC TAC game
Code written by Abhishek.
*/


import java.util.*;

class TicTac
{
    TicTac()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++){
                matrix[i][j] = String.valueOf(i)+String.valueOf(j);
            }
        }
    }
    static String[][] matrix = new String[3][3];
    static int count = 0;
    public static void draw()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(matrix[i][j]+"  "+"|"+"  ");
            }
            System.out.println();
            System.out.print("-------------------");
            System.out.println();
        }
        
    }

    static void fill(String s)
    {
        count++;
        int i = Character.getNumericValue(s.charAt(0));
        int j = Character.getNumericValue(s.charAt(1));
    
        if(!matrix[i][j].equals("O") && !matrix[i][j].equals("X")){
            if(count%2!=0)
                matrix[i][j] = "O";
            else
                matrix[i][j] = "X";
        }
        else{
            System.out.println("Wrong Input");
            count--;
        }
    }

    static void check()
    {
        if(allFilled())
        {
            System.out.println("Game Draw.");
            System.exit(0);
        }
        String res = checkWinner();
        if(res.equals("O"))
        {
            System.out.println("P1 wins");
            System.exit(0);
        }
        else if(res.equals("X"))
        {
            System.out.println("P2 wins");
            System.exit(0);
        }
        
    }
    static boolean allFilled()
    {
        boolean res=true;
        int c=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(matrix[i][j].equals("X") || matrix[i][j].equals("O"))
                {
                    c++;
                }
            }
        }
        if(c==9)
        {
            res=true;
        }
        else
        {
            res=false;
        }
        return res;
    }

    static String checkWinner() {
        String ans = "";
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = matrix[0][0] + matrix[0][1] + matrix[0][2];
				break;
			case 1:
				line = matrix[1][0] + matrix[1][1] + matrix[1][2];
				break;
			case 2:
				line = matrix[2][0] + matrix[2][1] + matrix[2][2];
				break;
			case 3:
				line = matrix[0][0] + matrix[1][0] + matrix[2][0];
				break;
			case 4:
				line = matrix[0][1] + matrix[1][1] + matrix[2][1];
				break;
			case 5:
				line = matrix[0][2] + matrix[1][2] + matrix[2][2];
				break;
			case 6:
				line = matrix[0][0] + matrix[1][1] + matrix[2][2];
				break;
			case 7:
				line = matrix[0][2] + matrix[1][1] + matrix[2][0];
				break;
            }
            
			if (line.equals("XXX")) {
				ans =  "X";
            } 
            else if (line.equals("OOO")){
				ans = "O";
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("            TIC TAC GAME           ");
        System.out.println("-----------------------------------");
        System.out.println("Player 1 : O \nPlayer 2: X");
        System.out.println("-----------------------------------");
        System.out.println("Type coordinates to fill the board.");
        System.out.println("-----------------------------------");

        new TicTac();
        draw();
        while(true)
        {
            if(count%2!=0)
            {
                System.out.print("Player 2 : ");
            }
            else
            {
                System.out.print("Player 1 : ");
            }
            String input = sc.next();
            System.out.println("----------------------------------------------");
            if(input.equals("q"))
            {
                break;
            }
            else{
                fill(input);
                draw();
                check();
            }
            
        }
    }
}