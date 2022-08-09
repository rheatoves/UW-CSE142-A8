// Rhea Toves
// 3/12/2021
// TA: Jeremy Chen
// Assignment #8: Guess.java

import java.awt.*;

public class Giant extends Critter {
   private int count;
   
   // This causes the Giant to always infect when an enemy is in front. Otherwise
   // hop if possible and otherwise turn right.
   public Action getMove(CritterInfo info) {
      count++;
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
      } else {
         return Action.RIGHT;
      }
   }
   
   // This displays the Giant in the color gray.
   public Color getColor() {
      return Color.GRAY;
      
   }
   
   // This displays the Giant as "fee" for six steps, "fie" for another six, "foe"
   // for another six and "fum" for another six steps. This cycle then repeats.
   public String toString() {
      if (count % 24 < 6) {
         return "fee";
      } else if (count % 24 >= 6 && count % 24 < 12) {
         return "fie";
      } else if (count % 24 >= 12 && count % 24 < 18) {
         return "foe";
      } else {
         return "fum";
      }
   }
}