/*
 * To change this license header, choose License Headers 
 * in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TennisSet;
/**
 *
 * @author qnd6212
 */
import static TennisSet.TennisGame.FinalScore;
//import  static TennisSet.TennisGame.pointServer;
import static TennisSet.TennisSet.TG;
import  static TennisSet.TennisSet.currentGame;
import static TennisSet.TennisSet.gameScores;
import static TennisSet.TennisSet.jp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import static java.lang.System.exit;
import java.math.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static jdk.nashorn.internal.objects.NativeString.substring;
import static java.util.Formatter.*;
import javax.swing.JButton;
public class TennisGame {
     static  int pointServer=0;
     static  int pointReceiver=0;
     public static final int  SERVER  = 1;
     public static final int  RECEIVER = 2;
    static  boolean Session =false;
     static boolean winner = false;
     static int serverLength,receiverLength =0;
     static String playerServer="";
     static String playerReceiver="";
     static int receiverCount =0;
     static int serverCount = 0;
     static String printScore,printFinal,printString;
    public static TennisSet Tennisset; 
    public static TennisGame1 FinalScore1;
    public static JTextField  FinalScore;
    public JTextField Display;
    public static NewJFrame Frame;
    static int serveCount=0;
    static String Winner;
    static boolean  setCount  = true;
    static Color c = new Color(187,157,177); 


   
    public TennisGame() {
  
    }
  
    public static void getrandomBoolean() {
       // To get the random boolean tru or false
       // true - SERVER false RECEIVER and call the the givePoint() method
 
             if (winner) {
                 pointServer = 0;
                 pointReceiver=0;
                //pointReceiver=15;
             }
             winner = false;
             Session = Math.random() <0.5;
      //   System.out.println("Session "+ Session);
           if (Session) {
               givePoint(SERVER); 
           }else {givePoint(RECEIVER);
           }
     
    }

   public static String getScore() {
   // Set the score for each player
       
          serverLength = playerServer.length();
          receiverLength =  playerReceiver.length();
      //    System.out.println("server Initial Length "+Tennisset.serverInitialLength + " "+playerReceiver);
         if ((pointServer==0)&&(pointReceiver==0)){
                 TG.scoresDisplay("Love","All");  
                  serveCount=0;
                return "Love all"; }
        switch (pointServer){
            case 0:
                 playerServer = playerServer +" Love" ; break;
            case 1:
                playerServer = playerServer +" 15" ; break;
            case 2:
                playerServer = playerServer +" 30"; break; // playerServer +" 30" ;break;    
            case 3:
               playerServer = playerServer+ " 40"; break;
           case 4:
               playerServer = playerServer+ " ADV1"; break;
           case 5:
               playerServer = playerServer + " ADV2"; break;
        }       
            switch (pointReceiver){
            case 0:
                playerReceiver = playerReceiver +" Love" ; break;
            case 1:
                playerReceiver = playerReceiver +" 15" ; break;
            case 2:
                playerReceiver = playerReceiver +" 30" ;break;    
            case 3:
               playerReceiver =  playerReceiver+ " 40"; break;
           case 4:
               playerReceiver = playerReceiver+ " ADV1"; break;
           case 5:
               playerReceiver = playerReceiver + " ADV2"; break;
         }
        
        TG.scoresDisplay(playerReceiver,playerServer);          
         return (playerServer+" "+playerReceiver);
 }
  
    public static  void givePoint(int player) {
    // add one to the player and set the score
   // find if there is a winner. if no winner call the random method
    JFrame FinalScoreFrame ;
       String gameScores="";
               if (player==SERVER) {pointServer++;}
               if (player==RECEIVER) {pointReceiver++;}
                 setCount = false;
               if (((pointReceiver == 1) &&  (pointServer == 0)) || ((pointReceiver == 0) &&  (pointServer == 1))); {
                     serveCount++;
                     setCount = true;
                }
             gameScores = currentGame.getScore();               
               playerServer= (playerServer.substring(0,serverLength));
               playerReceiver= (playerReceiver.substring(0,receiverLength));
                int  findWinner =0;
                   
                   if ((pointServer>=3)||(pointReceiver>=3)) {
                         if (isWinner())
                         { 

                            winner = true;
                        
                              findWinner = Math.max(pointReceiver,pointServer);
                               isWinner(findWinner);//winner=true;
                               if (findWinner==pointReceiver) 
                                 {
                                       receiverCount++;
                                 }
                               else
                                 { 
                                   serverCount++;
                                 }
                               printString();
                         }
                    } else 
                         { 
                             getrandomBoolean();
                         }
    }          

public  static void printString() {
  //Setting Final Scores to print//
    
   System.out.println("inside printString "+serverCount+receiverCount);
           
    printFinal="";        
    if ((serverCount+receiverCount)==5) {
        String Score =("--         SCORES "+playerServer+" "+serverCount+" "+playerReceiver+" "+receiverCount);
        
           JFrame TennisGame1 = new JFrame();
            TennisGame1.setSize(700,150);
         //   TennisGame1.setBackground(Color.green);
                    TennisGame1.setVisible(true);
             TennisGame1.setLocation(400, 550);
             TennisGame1.setLayout(new BorderLayout());
         //  FinalScore1 = new TennisGame1(0
         Font f = new Font("Copperplate Gothic Bold",Font.BOLD,20);
           FinalScore = new JTextField();   
           FinalScore.setFont(f);
           FinalScore.setSize(250,450);
            JTextField Space = new JTextField(" "+"\n"+" ");
               JButton Close = new JButton("Close");
                   TennisGame1.setLayout(new GridLayout());
                               TennisGame1.setLayout(new GridLayout(3,200));
                                  TennisGame1.add(FinalScore);
             TennisGame1.add(Space);                     
             TennisGame1.add(Close);     
         
          if (serverCount>receiverCount) 
         {
         Score ="\n FINAL WINNER IS "+playerServer+"     "+Score;   
             c = new Color(255,153,51);
             FinalScore.setBackground(c);
              FinalScore.setText(Score);
              TennisGame1.setVisible(true);
               FinalScore.setVisible(true);
            Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt,TennisGame1);
              }
        });
       }          
     else 
       {
           System.out.println("inside inside "+serverCount);
           TennisGame1.setVisible(true);
         Score =("\n FINAL WINNER IS " +playerReceiver+"     "+Score);
         printString= "\u001B[42m"+Score+"\u001B[0m";
         c = new Color(0,153,102);
         FinalScore.setBackground(c);
              FinalScore.setText(Score);
               TennisGame1.setVisible(true); 
               FinalScore.setVisible(true);         
         Close.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt,TennisGame1);
            }              
            
           });
       }
    }
   
}   
    //  printFinal= "\u001B[42m"+Score+"\u001B[0m"; 
    public static void closeActionPerformed(java.awt.event.ActionEvent evt,JFrame FinalScoreFrame) {
                  serverCount =0; receiverCount = 0;
                  FinalScoreFrame.setVisible(false);
                  FinalScoreFrame.dispatchEvent(new WindowEvent(FinalScoreFrame, WindowEvent.WINDOW_CLOSED));
    }

    public static boolean isWinner(){
   // Checking the score to make sure one of the players score is more than other > 2
   // set the Deuce if both are same. 
   
       int diff = 0;
       int result=0;
       int whileFactor =0;
               
           while (Math.max(diff,Math.abs(pointServer-pointReceiver)) <2)  {
              
                   
                  if ((pointServer >= 3) || (pointReceiver >= 3)) {   
               
                    whileFactor =   Math.max(diff,Math.abs(pointServer-pointReceiver));
              
                if (pointServer == pointReceiver) {
                     serveCount++;
                    TG.scoresDisplay("Deuce"," ");            
                      pointServer=3;
                      pointReceiver=3; getrandomBoolean();
                  
                  }else if (whileFactor<2) { getrandomBoolean();}
            }
       }
  
            if (!winner) { 
          
              result = Math.max(diff,Math.abs((pointServer-pointReceiver)));
               
            }
            if (result >= 2) {return true;}else {return false;}
      }

public static  void isWinner(int player) {
        
    // if winner found print the winner with score. 
          int fulllength = 40;
          int charlen, winlenght =0,spacelen=0;
          int set = -1;
          
             String T="";
           winner=true;
            Winner= "THE WINNER IS ";


        if (player==pointReceiver){
             c = new Color(0,153,102);
            Winner =Winner+" "+playerReceiver;
              set = 0; 
         //   Frame.SET1.setText("SET "+TennisSet.game+"--"+ Winner+"\n"+playerReceiver+" "+pointReceiver);
        } else {            
              c = new Color(255,153,51);
             Winner =Winner+" "+playerServer;
             set = 1;
              System.out.print("Player Server"+playerServer);

        }
             printString = "\u001B[34m"+Winner+"\u001B[0m";
            printScore ="\u001B[34m"+Winner+"\u001B[0m";

      if (Frame.SET1.getText().isEmpty()) {
          TennisSet.game = 1;  
          Frame.SET1.setBackground(c);
          Frame.SET1.setText(String.format("SET "+TennisSet.game+"--"+display(set)+"|  Score -  "+getScore(),1)) ;
          playerServer = substring(playerServer,0,Frame.serverInitialLength);
          playerReceiver = substring(playerReceiver,0,Frame.receiverInitialLength);
        return;
       }


       if (Frame.SET2.getText().isEmpty()) {
            TennisSet.game = 2;
            Frame.SET2.setBackground(c);
            Frame.SET2.setText(String.format("SET "+TennisSet.game+ "--"+display(set)+"|  Score -  "+getScore(),1));
            playerServer = substring(playerServer,0,Frame.serverInitialLength);
             playerReceiver = substring(playerReceiver,0,Frame.receiverInitialLength);
         return;
}   
             if (Frame.SET3.getText().isEmpty()) {
          TennisSet.game = 3;
          Frame.SET3.setBackground(c);
           Frame.SET3.setText(String.format("SET "+TennisSet.game+"--" +display(set)+"|  Score -  "+getScore(),1));
           playerServer = substring(playerServer,0,Frame.serverInitialLength);
          playerReceiver = substring(playerReceiver,0,Frame.receiverInitialLength);
          return;
       }
       if (Frame.SET4.getText().isEmpty()) {
            TennisSet.game = 4;
            Frame.SET4.setBackground(c);
            Frame.SET4.setText(String.format("SET "+TennisSet.game+ "--"+display(set)+"|  Score -  "+getScore(),1));
           playerServer = substring(playerServer,0,Frame.serverInitialLength);
             playerReceiver = substring(playerReceiver,0,Frame.receiverInitialLength);
           return;
           
          }   
          if (Frame.SET5.getText().isEmpty()) {
          TennisSet.game = 5;
          Frame.SET5.setBackground(c);
          charlen  = ("SET ").length();  
          spacelen = fulllength - (charlen+winlenght);
           Frame.SET5.setText(String.format("SET "+TennisSet.game+"--"+ display(set)+"|  Score - "+getScore(),1));
           playerServer = substring(playerServer,0,Frame.serverInitialLength);
           playerReceiver = substring(playerReceiver,0,Frame.receiverInitialLength);   
           return;
       } 

   }
@Override
public String toString() {
  // override method toString() to print the scores. 
  // printScore variable and printFinal variable are initialise to null to avid both printing. 
  
    return printScore+""+printFinal;
}

      public static String adspace (int space) {
      String Space = " ";
  
       for (int i =1; i < space+1; i++){
          Space = Space+" ";}
       return Space;
}
   public static String display (int set) {
       int diff =0;
       int winlength = 0;
       String Finaltext;
     
         Winner.trim();
         if (set ==0 ) {
           winlength=(Winner+" "+playerReceiver).length(); 
            if (Frame.serverInitialLength -Frame.receiverInitialLength >= 0) {
                diff =  (Frame.serverInitialLength - Frame.receiverInitialLength);
                 diff++;
                return Finaltext = Winner+adspace(diff+diff);
            } else { diff =0; return Finaltext = Winner+adspace(diff);}
            
         }
            if (set == 1) {
              winlength=(Winner+" "+playerServer).length(); 
                      if  ((Frame.receiverInitialLength -Frame.serverInitialLength) >= 0) {
                              diff =   Frame.receiverInitialLength - Frame.serverInitialLength;
                             diff++;
                    return Finaltext = Winner+adspace(diff+diff);  
         }else { diff = 0; return Finaltext = Winner+adspace(diff);}    
       
            }
            return Finaltext = Winner+adspace(diff+diff);
            }
}
   
