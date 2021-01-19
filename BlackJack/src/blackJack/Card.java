package blackJack;

import java.awt.Image;

public class Card 
{
   protected String shape;
   protected int number,value;
   protected Image img;
   
   public Card()
   {   
       shape = "";
       number = -1;
       value = 0;
   }
   public Card(String shape, int number)
   {
      this.shape = shape;
      this.number = number;
   }
   public void setValue(int value)
   {
      this.value = value;
   }
   public void setCard(String shape, int number)
   {
      this.shape = shape;
      this.number = number;
   }
   public void setImage(Image img)
   {
      this.img = img;
   }
   public String getShape()
   {
   return shape;
   }
   public int getNumber()
   {
   return number;
   }
   public String toString()
   {
   return String.format("%s   %d",shape,number);
   }
}
