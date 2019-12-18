package theater;
import java.util.*;

/**
 * Write a description of class TheaterApp here.
 * 
 * @author Thomas McHugh 
 * @version 1.0.0
 */
public class Theater 
{
    //create two deminesional array to use for theater
    static int [][] seats = 
    {  
            {10,10,10,10,10,10,10,10},
            {10,10,10,10,10,10,10,10},
            {10,10,20,20,20,20,10,10},
            {20,20,30,30,30,30,20,20},
            {30,30,40,40,40,40,30,30},
            {30,40,40,50,50,40,40,40}
    };


    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        String ans;
        //while answer does not equal quit, run the program
        do 
        {
            //read user input
            System.out.print("Enter request, please (or 'help' or 'quit') ");
            ans = input.next();
            //if input is help, display input options to user
            if (ans.equals("help")) 
            {
                System.out.println("Possible commands");
                System.out.println("price <price>");
                System.out.println("seat <row> <seat>");
                System.out.println("left");
                System.out.println("remaining <price>");
                System.out.println("print");
                System.out.println("quit");
                System.out.println("help");

                
            } 
            //if input is price
            else if (ans.equals("price")) 
            {
                int p = input.nextInt();
                //if input is not an element of seats, output that there are no seats with that price available
                if(!seats.equals(p))  
                {
                    System.out.println("There is no seat with that price available");
                }
                //search algorithm for matching price
                for (int r = 0; r < seats.length; ++r) 
                {
                    for (int s = 0; s < seats[r].length; ++s) 
                    {
                        if (seats[r][s] == p)
                        {
                            //output row and column that contain the value that matches with the user input 
                            System.out.println("row: " + r);
                            System.out.println("seat: " + s + "\n");
                        }
                    }
                }
                
            } 
            //if input is seat
            else if (ans.equals("seat")) 
            {
                int r = input.nextInt();
                int c = input.nextInt();
                
                //if input is larger than array index, display that the theater is not that size
                if(r >= seats.length || c >= seats[r].length)
                {
                    System.out.println("Theater is not that size");
                }
                //if seat is already reserved, display that it is reserved
                else if(seats[r][c] == -1)
                {
                    System.out.println("Seat is already reserved");
                }
                //set reserved seat to -1
                else
                {
                    seats[r][c] = -1;
                }

            } 
            // if input is left
            else if (ans.equals("left")) 
            {
                
                int total = 0;
                //search array
            	for (int r = 0; r < seats.length; ++r) 
                {
                    for (int s = 0; s < seats[r].length; ++s) 
                    {
                        //if seat is not reserved, increment total 
                        if(seats[r][s] > 0)
                        {
                            total++;
                        }
                    }
                }
                //display total available seats
                System.out.println(total);
            } 
            //if input is remaining
            else if (ans.equals("remaining")) 
            {
                int p = input.nextInt();
                int available = 0;
                //search arrau
                for (int r = 0; r < seats.length; ++r) 
                {
                    for (int s = 0; s < seats[r].length; ++s) 
                    {
                        //if array index contains a value that matches user input, increment total seats available at that price
                        if(seats[r][s] == p)
                        {
                            available++;
                        }
                    }
                }
                System.out.println(available);               
            } 
            //if input is print
            else if (ans.equals("print")) 
            {
                //print array
                for (int r = 0; r < seats.length; ++r) 
                {
                    for (int s = 0; s < seats[r].length; ++s) 
                    {
                        System.out.print(seats[r][s] + " ");
                    }
                    System.out.println();
                }
            } 
            //output error message for when the user does not input one of the above values
            else if (!ans.equals("quit")) 
            {
                System.out.println("Come again?");
            }
        } 
        while (!ans.equals("quit"));
        //when broken from the do while loop, output goodbye message
        System.out.println("Good bye");
    }


}