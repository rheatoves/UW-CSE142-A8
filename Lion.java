// Rhea Toves
// 3/12/2021
// TA: Jeremy Chen
// Assignment #8: Guess.java

import java.awt.*;
import java.util.*;

public class Lion extends Critter {
   private int count;
   private Random r = new Random();
   private Color c;
   
   // This defines the random variable stated above.
   public Lion() {
      r = new Random();
   }
   
   // This causes the Lion to always infect if enemy is in front. Otherwise turn left
   // when wall is in front and to the right. Otherwise if there is anoter Lion in front
   // turn right and other wise hop. This also counts each step and holds a randomly
   // chosen color for three steps and repeats this process.
   public Action getMove(CritterInfo info) {
      count++;
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
         return Action.LEFT;
      } else if (info.getFront() == Neighbor.SAME) {
         return Action.RIGHT;
      } else {
         int next = r.nextInt(3);
         if (next == 0 && count <= 3) {
            count++;
            c = Color.GREEN;
         } else if (next == 1 && count <= 3) {
            count++;
            c = Color.BLUE;
         } else {
            count++;
            count = 0;
            c = Color.RED;
         }
      }
      return Action.HOP;
   }
   
   // This returns the randomly chosen color in the method above.
   public Color getColor() {
      return c;
   }
   
   // This displays the Lion with the letter, "L".
   public String toString() {
      return "L";
      
   }
}