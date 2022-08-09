// Rhea Toves
// 3/12/2021
// TA: Jeremy Chen
// Assignment #8: Guess.java

import java.awt.*;
import java.util.*;

public class Husky extends Critter {
   private int count;
   private Random r = new Random();
   
   public Husky() {
      r = new Random();
   }
   
   // This causes the Husky to always infect when an enemy is in front. Otherwise if
   // possible, hop. Otherwise choose randomly from the actions, turing left, right, and
   // infecting.
   public Action getMove(CritterInfo info) {
      count++;
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
      } else {
         int next = r.nextInt(3);
         if (next == 0) {
            return Action.LEFT;
         } else if (next == 1) {
            return Action.RIGHT;
         } else {
            return Action.INFECT;
         }
      }
   }
   
   // This alternates between displaying the Husky as the color magenta (purple)
   // and yellow. Alternating between each step.
   public Color getColor() {
      if (count % 2 == 0) {
         return Color.MAGENTA;
      } else {
         return Color.YELLOW;
      }
   }
   
   // This displays the Husky as the name, "Harry".
   public String toString() {
      return "Harry";
      
   }
}