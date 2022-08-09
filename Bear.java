// Rhea Toves
// 3/12/2021
// TA: Jeremy Chen
// Assignment #8: Guess.java

import java.awt.*;

public class Bear extends Critter {
   private String display;
   private int count;
   boolean polar;
   
   // This intitally displays the bear as a "/" and also once the boolean is true
   // this will return the bear as the color white, and false will return black.
   public Bear(boolean polar) {
      display = "/";
      this.polar = polar;
   }
   
   // This causes the bear to infect always if enemy is in front. Otherwise,
   // the bear should hop if possible and otherwise turn left.
   public Action getMove(CritterInfo info) {
      count++;
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
      } else {
         return Action.LEFT;
      }
   }
   
   // Once the boolean is true this will return the bear as the color white,
   // and false will return the bear as black.
   public Color getColor() {
      if (polar == true) {
         return Color.WHITE;
      } else {
         return Color.BLACK;
      }
   }
   
   // This alternates the display of bear as a "/" and a "\" each step.
   public String toString() {
      if (count % 2 == 0) {
         return "\\";
      } else {
         return "/";
      }
   }
}