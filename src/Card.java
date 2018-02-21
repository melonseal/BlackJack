public class Card {
    int face;
    int suit;

    public Card(int face, int suit){
        this.face = face;
        this.suit = suit;
    }

    public String toString(){
        String faceString = "";
        String suitString = "";
        if(this.face == 1){
            faceString = "ace";
        }else if(this.face == 11){
            faceString = "jack";
        }else if(this.face == 12){
            faceString = "queen";
        }else if(this.face == 13){
            faceString = "king";
        }else{
            faceString = Integer.toString(this.face);
        }
        if(this.suit == 1){
            suitString = "spades";
        }else if(this.suit == 2){
            suitString = "clubs";
        }else if(this.suit == 3){
            suitString = "diamonds";
        }else{
            suitString = "hearts";
        }
        return(faceString + " of " + suitString);
    }
}
