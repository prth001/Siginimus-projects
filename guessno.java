import java.util.Scanner;
import java.util.Random;
class game 
{
    int random;
    int inputno;
    int noofgusses=0;
    void setnoofgusses(int noofgusses){
        this.noofgusses=noofgusses;
    }
    int getnoofgusses(){
        return noofgusses;
}
    
    
    game(){
        
        Random r=new Random();
          this.random=r.nextInt(100);
 }
   
   
  
   void takeUserInput()
   {
       Scanner sc=new Scanner (System.in);
    System.out.println("Enter the number ");
    this.inputno=sc.nextInt();
  }
 
 
 
 
  boolean Iscorrectno(){
    noofgusses++;
    if(inputno==random){
        System.out.format("Yes you guessed it right, it was %d\nYou guessed it in %d attempts",inputno,noofgusses);
        return true;
    }
        else if(inputno<random)
        {
            System.out.println("Less number");
        } else if(inputno>random){
            System.out.println("Large number");
        } 
            return false;
  }
}


 public class guessno {
    public static void main(String [] agrs){
        Random r=new Random();
        Scanner sc=new Scanner (System.in);
       
        game g=new game();
        boolean b=false;
       
       while(b!=true){
         try{
        
            g.takeUserInput();
            b=g.Iscorrectno();


       }
    
    
    catch(Exception e){
        System.out.println(e);
    }
}

    
 
    }


    }
    

