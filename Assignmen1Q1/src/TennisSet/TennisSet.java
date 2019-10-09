/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TennisSet;

import static TennisSet.NewJFrame.TennisSet;
import static TennisSet.TennisGame.playerServer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import java.util.Scanner;
import javafx.scene.layout.Border;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.bind.Marshaller.Listener;
import static jdk.nashorn.internal.objects.NativeObject.keys;

/**
 *
 * @author qnd6212
 */
public class TennisSet {  
    static int ScoreA;
    static int ScoreB;

    private static void If(boolean serverReceiver) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     String PlayerA;
     String PlayerB;
     static boolean isGameOn=false;
     static String  currentGamePlayer;
     static TennisGame currentGame;
     public   static NewJFrame TG;
     static int numOfSets = 5;
     private  static JFrame GameStart;  
     public static JPanel jp,jp1,enclosingPanel;
     public static JLabel ServerLabel,ReceiverLabel;
     public static  JTextField server = new JTextField(1);
     public static  JTextField receiver = new JTextField();
     public static int  evt=0;
     public static boolean serverReceiver=false;
     public static int serverInitialLength,receiverInitialLength;
     public static String gameScores;
     public static int game = 1;
     
     
     public static void main (String[] args) {   
      
          ButtonExample();
       
 }
     
        public static void ButtonExample() {
           GameStart  = new JFrame("Tennis Game");
            GameStart.setBounds(600,200,1200,1300);
            JButton Startbutton = new JButton("Start the Game");
            Startbutton.setBounds(600,550,105,30);
            GameStart.add(Startbutton);
            GameStart.setSize(300,300);
            GameStart.setVisible(true); 
          
            Startbutton.addActionListener( new  ActionListener() {
             @Override
             public void actionPerformed (ActionEvent e) {
              GameStart.setVisible(false);                
                 TG = new NewJFrame();
                  TG.setSize(1200,1000);
                  TG.setBounds(300, 50, 1150,900);
                  TG.setName("Tennis Game");
                  TG.setVisible(true); 
                      }
         });     
        }
        public static void serverReceiver() {
                   evt =2;
                  currentGame.playerServer = currentGamePlayer;                   
                  serverInitialLength = currentGame.playerServer.length();
                   if (( currentGame.playerReceiver != null  )&&  (currentGame.playerServer != null )) { serverReceiver=true;} else {serverReceiver= false;}
                        if (serverReceiver) { playGame(); }
                  }
       
        public  static void playSet() {
        currentGame.pointReceiver =0;
        currentGame.pointServer=0;
        TennisGame.serveCount = 0;
    
         gameScores = currentGame.getScore();
         currentGame.Frame.scoresDisplay( TG.Receiver,TG.Server);
         if (isGameOn) {
              ScoreA=1;
              ScoreB=2;
              gameScores = currentGame.getScore();
              currentGame.givePoint(currentGame.SERVER);
              System.out.println("\n");
          } else {
              ScoreB=1;
              ScoreA=2;
                gameScores = currentGame.getScore();
               currentGame.givePoint(currentGame.RECEIVER);
               System.out.println("\n");
    } 
   }    
            
     public  static  void playGame(){
     // loop is set to five and looped for five sets.
  
            game = 0;
              System.out.println("\u001B[32m"+"SET "+game);
              isGameOn = true;
              
             playSet();
                currentGame.printScore = "";
                currentGame.printFinal = "";
         isGameOn = false;
     }
          
 }
