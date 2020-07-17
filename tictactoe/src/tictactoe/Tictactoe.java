/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.*;

public class Tictactoe {

    public static void printboard(char[][] board){
        for(char[] row: board)
        {    for(char c : row)
                System.out.print(c);
            System.out.println();
        }
    };
    public static int checkvalidity(int pos,char[][] board,int user){
       // System.out.println("checked");
        char symbol;
        if(user==1)
            symbol='x';
        else symbol='0';
        switch(pos){
            case 1: if(board[0][0]==' '){board[0][0]=symbol;return 0;}break;
            case 2: if(board[0][2]==' '){board[0][2]=symbol;return 0;}break;
            case 3: if(board[0][4]==' '){board[0][4]=symbol;return 0;}break;
            case 4: if(board[2][0]==' '){board[2][0]=symbol;return 0;}break;
            case 5: if(board[2][2]==' '){board[2][2]=symbol;return 0;}break;
            case 6: if(board[2][4]==' '){board[2][4]=symbol;return 0;}break;
            case 7: if(board[4][0]==' '){board[4][0]=symbol;return 0;}break;
            case 8: if(board[4][2]==' '){board[4][2]=symbol;return 0;}break;
            case 9: if(board[4][4]==' '){board[4][4]=symbol;return 0;}break;
            default : return 1;
        }
        return 1;
    };
      
    public static void checkwinner(char [][] board,int user){
        char symbol;
        if(user==1)
            symbol='x';
        else symbol='0';
       
        if((board[0][0]==symbol&&board[0][2]==symbol&&board[0][4]==symbol)||   //top row
           (board[2][0]==symbol&&board[2][2]==symbol&&board[2][4]==symbol)||   //midrow
           (board[4][0]==symbol&&board[4][2]==symbol&&board[4][4]==symbol)||   //downrow
                
           (board[0][0]==symbol&&board[2][0]==symbol&&board[4][0]==symbol)||   //left col
           (board[0][2]==symbol&&board[2][2]==symbol&&board[4][2]==symbol)||   //mid col
           (board[0][4]==symbol&&board[2][4]==symbol&&board[4][4]==symbol)||   //last col
                
           (board[0][0]==symbol&&board[2][2]==symbol&&board[4][4]==symbol)||   //cross1
           (board[4][0]==symbol&&board[2][2]==symbol&&board[0][4]==symbol)     //cross2
          ) {
                if(user==1)System.out.println("player wins");
                else if (user==0) System.out.println("cpu wins :("); printboard(board);
                System.exit(0);
            }
    };
    public static void main(String[] args) {
          char[][] board = {{' ','|',' ','|',' '},
                          {'-','-','-','-','-'},
                          {' ','|',' ','|',' '},
                          {'-','-','-','-','-'},
                          {' ','|',' ','|',' '} };
        printboard(board);
        
        Random rand = new Random();
        Scanner Scan = new Scanner(System.in);
        int cpupos = rand.nextInt(9)+1;
        int playerpos;            
        while(true)
        {   
            
            System.out.print("Enter your position:");
            playerpos = Scan.nextInt();    
            while(checkvalidity(playerpos,board,1)!=0)
            {
                System.out.println("position already occupied,pls enter new:");
                playerpos = Scan.nextInt();    
            }
            checkwinner(board,1);
            printboard(board);
            
            //cpu
          while(checkvalidity(cpupos,board,0)!=0)
            {
                cpupos = rand.nextInt(9)+1;
             
            }
            System.out.println("cpu position:"+cpupos);
            checkwinner(board,0);
            printboard(board);
        }
    }    
}

