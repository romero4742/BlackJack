package blackJack;

import java.awt.Image;
import java.util.*;
import javax.swing.ImageIcon;

/**
 *
 * @author Victor
 */
public class Deck 
{
    
   protected Card [][] deckOfCards;
   protected String suits[];
   protected int numbers[];
   protected Set<Card> s;
   protected Node<Card> currentCard;
    
   public Deck()
   {
      suits = new String[4];
      suits[0]= "clubs";
      suits[1] = "diamonds";
      suits[2] = "hearts";
      suits[3] = "spades";
      
      numbers = new int[13];
      numbers[0] = 1;
      numbers[1] = 2;
      numbers[2] = 3;
      numbers[3] = 4;
      numbers[4] = 5;
      numbers[5] = 6;
      numbers[6] = 7;
      numbers[7] = 8;
      numbers[8] = 9;
      numbers[9] = 10;
      numbers[10] = 11;
      numbers[11] = 12;
      numbers[12] = 13;
      buildDeck();
   }
   
   /**
    * This method creates the standard deck.  The algorithm is to access the
    * first element of the suits array and then go through the numbers array.
    * We then create a new card with the current suit and number and add it to 
    * the deckOfCards array.
    * 
    * Total of 52 cards;
    * suits array = 0 - clubs, 1 - diamonds, 2 - hearts, 3 - spades
    */
   public void buildDeck()
   {
      int row = 4;
      int col = 13;
      deckOfCards = new Card[row][col];
      s = new Set();
      for(int i = 0; i < row; i++)
      {
         for(int j = 0; j < col; j++)
         {
            deckOfCards[i][j] = new Card(suits[i],numbers[j]);
            int value = deckOfCards[i][j].getNumber();
            if(value == 1)
                deckOfCards[i][j].setValue(11);
            else
            if(value > 10)
                deckOfCards[i][j].setValue(10);
            else
                deckOfCards[i][j].setValue(value);
         }
      }
      transfer(deckOfCards,s);
   }

   
   public Card dealCard()
   {
      Node<Card> temp = currentCard;
      currentCard = currentCard.next;
      return temp.data;
   }
   
   public void shuffle()
   {
      firstShuffle();
      secondShuffle();
      currentCard = s.head.next;
   }
   
   public void firstShuffle()
   {
      Random r = new Random();
      int shuffles = r.nextInt(3)+3;
      while(shuffles > 0)
      {
         Set<Card> s1 = new Set<Card>();
         Set<Card> s2 = new Set<Card>();
         Node<Card> t = s.head.getNext();
         for(int i = 1; i < 27; i++)
         {
             s1.addElement(t.data);
             t = t.getNext();
         }
         for(int i =1;i<27;i++)
         {
            s2.addElement(t.data);
            t = t.getNext();
         }
         t = s.head.next;
         Node<Card> t1 = s1.head.next;
         Node<Card> t2 = s2.head.next;
         //refill deck
         for(int i = 1; i < 27; i++)
         {
            t.setData(t2.data);
            t = t.next;
            t2 = t2.next;
            t.setData(t1.data);
            t1 = t1.next;
            t = t.next;
         }
         shuffles--;
      }
   }
   
   public void secondShuffle()
   {
      Random r = new Random();
      int shuffles = r.nextInt(10)+7;
      int cut = 0;
      while(shuffles > 0)
      {
         cut = r.nextInt(51)+1;
         s.cutFrom(cut);
         shuffles--;
      }
   }
   
   public void transfer(Card [][] deck,Set<Card> s)
   {
      for(int row = 0; row < deck.length; row++)
      {
         for(int col = 0; col < deck[row].length; col++)
         {
            s.addElement(deck[row][col]);
         }
      }
   }
   
}
