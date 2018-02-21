import java.util.ArrayList;
import java.util.Random;

public class Deck {
    ArrayList<Card> cards = new ArrayList<>();

    public Deck(){
        for(int i = 1; i < 14; i++){
            for(int j = 1; j < 5; j++){
                this.cards.add(new Card(i, j));
            }
        }
    }

    public Card dealCard(){
        Random randomCard = new Random();
        int cardNumber = randomCard.nextInt(this.cards.size());
        Card thisCard = this.cards.get(cardNumber);
        this.cards.remove(cardNumber);
        return thisCard;
    }

    public String toString(){
        String result = "";
        for(int i = 0; i < this.cards.size(); i++){
            result += this.cards.get(i).toString();
        }
        return result;
    }

}
