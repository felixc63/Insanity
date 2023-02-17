import java.util.ArrayList;
import java.util.Arrays;

public class Insanity{
    private ArrayList<String> board;
    private int attempt;

    public Insanity(){
        board = new ArrayList<>(Arrays.asList("rpeg1", "rpeg2", "rpeg3", "rpeg4", "empty", "empty", "bpeg1", "bpeg2", "bpeg3", "bpeg4"));
        attempt = 0;
    }

    public ArrayList<String> getBoard(){
        return board;
    }

    public int getAttempt(){
        return attempt;
    }

    public void restart(){
        board = new ArrayList<>(Arrays.asList("rpeg1", "rpeg2", "rpeg3", "rpeg4", "empty", "empty", "bpeg1", "bpeg2", "bpeg3", "bpeg4"));
        attempt = 0;
    }

    public void moveRedPeg(String peg){
        int spaces = 1;
        if(!(board.get(getPegIndex(peg)+1).equals("empty")) && board.get(getPegIndex(peg)+2).equals("empty")){
            spaces = 2;
        }
        boolean check = false;
        if(spaces == 1){
            check = board.get(getPegIndex(peg)+1).equals("empty");
        }else{
            check = board.get(getPegIndex(peg)+2).equals("empty");
        }
        if((getPegIndex(peg) != 0 || getPegIndex(peg) != 9) && check){
            int temp = getPegIndex(peg);
            board.set(getPegIndex(peg)+spaces, peg);
            board.set(temp, "empty");
            attempt++;
        }else{
            System.out.println("Cannot Move " + peg);
        }
    }

    public void moveBluePeg(String peg){
        int spaces = 1;
        if(!(board.get(getPegIndex(peg)-1).equals("empty")) && board.get(getPegIndex(peg)-2).equals("empty")){
            spaces = 2;
        }
        boolean check = false;
        if(spaces == 1){
            check = board.get(getPegIndex(peg)-1).equals("empty");
        }else{
            check = board.get(getPegIndex(peg)-2).equals("empty");
        }
        if((getPegIndex(peg) != 0 || getPegIndex(peg) != 9) && check){
            int temp = getPegIndex(peg);
            board.set(getPegIndex(peg)-spaces, peg);
            board.set(temp, "empty");
            attempt++;
        }else{
            System.out.println("Cannot Move " + peg);
        }
    }


    public boolean checkWin(){
        int successCounter = 0;
        for(int k = 0; k < board.size(); k++){
            if(k < 4){
                if(board.get(k).equals("bpeg1") || board.get(k).equals("bpeg2") ||  board.get(k).equals("bpeg3") || board.get(k).equals("bpeg4")){
                    successCounter++;
                }
            }
            if(k == 4 || k == 5){
                if(board.get(k).equals("empty")){
                    successCounter++;
                }
            }
            if(k > 5){
                if(board.get(k).equals("rpeg1") || board.get(k).equals("rpeg2") ||
                        board.get(k).equals("rpeg3") || board.get(k).equals("rpeg4")){
                    successCounter++;
                }
            }
        }
        if(successCounter == board.size()){
            return true;
        }
        return false;
    }

    public int getPegIndex(String peg){
        for(int i = 0; i < board.size(); i++){
            if(peg.equals(board.get(i))){
                return i;
            }
        }
        return -1;
    }
}