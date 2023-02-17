import java.util.Scanner;

class InsanityRunner {
    public static void main(String[] args) {
        Insanity insanity = new Insanity();
        Scanner scan = new Scanner(System.in);
        System.out.println(insanity.getBoard());
        while(!(insanity.checkWin())){
            String peg = "";
            while(true){
                System.out.println("What peg do you want to move(Ex: 'rpegX' or 'bpegX') (Enter 'q' to quit or 'r' to restart)");
                peg = scan.nextLine();
                if(peg.contains("rpeg") || peg.contains("bpeg") || peg.equalsIgnoreCase("q") || peg.equalsIgnoreCase("r")){
                    break;
                }
            }
            if(peg.equalsIgnoreCase("q")){
                System.out.println("Thank you for playing!");
                System.exit(0);
            }else if(peg.equalsIgnoreCase("r")){
                insanity.restart();
            }else if(peg.contains("rpeg")){
                insanity.moveRedPeg(peg);
            }else{
                insanity.moveBluePeg(peg);
            }
            System.out.println("Ongoing Attempts: " + insanity.getAttempt());
            System.out.println(insanity.getBoard());
        }
        System.out.println("-------------");
        System.out.println("You won!");
        if(insanity.getAttempt() <= 4){
            System.out.println("You're a genius!");
        }
        System.out.println("Total Attempts: " + insanity.getAttempt());
    }
}