/**

Description:
This program supports a person who is selling cookies for a specific event. The user will be required to input the event name and the event type (for profit or not for profit).
The user will then be prompted to input a maximum number of cookies allowed to be sold. If they dont' know that number, they will be instructed to enter '0' which will be a 
code for 206 as a default. The program will validate the event name to make sure it is not null or blank. It will validate the event type to be 'for profit' or 'not for profit'. It will validate
the maximum number of cookies allowed to be sold from 1 to 923 inclusive, or 0 for a dafault value of 216. The program will continue to prompt the user for these values until the user enters a valid
input, clicks no, or exits the program manually. The program will then prompt the user if they would like to make a sale. If yes, the program will ask the user how many cookies they are willing to 
sell for that specific sale. The program will double that specific sale amount if the event type is 'for profit'. The program will compare that sale amount with the amount of cookies that are 
in stock. The program will prompt the user whether the sale was successful or not. The program will continue to ask the user if they would like to try a sale until the user selects no. The program will 
count the number of sales made.The program will then display a message with the event name, event type, maximum number of cookies allowed to be sold, the actual cookies sold, and the number of sales 
made. The program will then ask the user if they would like to make a cookie event again. 
*/
import javax.swing.JOptionPane;
public class ACookieEvent{
   public static void main(String[] args){
   // CookieEvent object that will be continuously used
      CookieEvent aCookieEvent;
      //loop that will continuously prompt the user until they select 'no'.
      while(JOptionPane.showConfirmDialog(null, "Do you want to make a cookie event?", "Cookie Event Question", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        //try/catch method will catch an error if the user enters null or nothing for eventName or something other than 'for profit' or 'not for profit' for eventType. This is set up
        //because they are the required inputs for the program to move on. 
         try {
            aCookieEvent = randomCookieEvent();
         }
         catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "The event could not be created: " + e.getMessage());
         }
         
      }
     
      
   }
   /**
   Method Purpose: to create a random cookie event object. It will allow the user to input anything they would like to input. The required inputs are eventName and eventType. The maxCookiesSold will
   default to 206 if the user enter 0. The user may enter the amount of cookies they are willing to sell for a particular sale event. 
   Parameter: none.
   Return Type: object address 
   */
   public static CookieEvent randomCookieEvent() {
      CookieEvent aCookieEvent = new CookieEvent(JOptionPane.showInputDialog("Enter the name of the event: "), JOptionPane.showInputDialog("Enter the type of the event, either 'for profit' or 'not for profit'"));
      //check for maxCookiesSold
      boolean maxCookiesSoldSet = false;
      //loop used to enter maxCookiesSold
      do {
         try{
            aCookieEvent.setMaxCookiesSold(Integer.parseInt(JOptionPane.showInputDialog("Enter the maximum number of cookies allowed to be sold.\nEnter '0' if you don't know.")));
            maxCookiesSoldSet = true;
         }
         catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "You didn't enter a number. Please try again.");
         }
         catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
         }
      }while(!maxCookiesSoldSet);
      //checker for saleTracker (how many cookies the user would like to sell for one sale event)
      boolean saleTracker = false;
      //loop used to enter saleTracker
      do {
         try{
         //This will pass the amount of cookies willing to be sold into the objects cookieSale method and return a boolean value.
            saleTracker = aCookieEvent.cookieSale(Integer.parseInt(JOptionPane.showInputDialog("Enter the amount of cookies you'd like to sell: ")));
         }
         catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "You didn't enter a number. Please try again.");
         }
         catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
         }
         if(saleTracker == true) {
            JOptionPane.showMessageDialog(null, "The sale went through!");
         }
         else {
            JOptionPane.showMessageDialog(null, "The sale did not go through! There is not enough cookies to sell.");
         }
         
      }while(JOptionPane.showConfirmDialog(null, "Would you like to try another cookie sale?", "Cookie Sale Question", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
      printEvent(aCookieEvent); 
      return aCookieEvent;
   }
   /**Method purpose: To call the class that return the string that has the required output: eventName, eventType, maxCookiesSold, cookiesSold, saleCounter.
   Parameters: aCookieEvent object
   Return Type: Void
   */
   public static void printEvent(CookieEvent aCookieEvent){
      JOptionPane.showMessageDialog(null, aCookieEvent.toString());
   }
}
