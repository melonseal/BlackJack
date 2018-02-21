import java.util.ArrayList;
public class Person {

    ArrayList<Card> hand = new ArrayList<Card>();

    public int valueOfHand(){
        int result = 0;
        int numAces = 0;
        for(int i = 0; i < this.hand.size(); i++){
            if(this.hand.get(i).face >= 10) {
                result += 10;
            }else if(this.hand.get(i).face == 1){
                numAces++;
            }else{
                result += this.hand.get(i).face;
            }
        }
        if(numAces > 0){
            if(result + 11 + (numAces - 1) > 21){
                result = result + numAces;
            }else{
                result = result + 11 + (numAces - 1);
            }
        }
        return result;
    }


    public void newCard(Deck deck){
        this.hand.add(deck.dealCard());
    }

}
