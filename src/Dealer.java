public class Dealer extends Person{

    public String toString(){
        String result = super.hand.get(0).toString();
        if(super.hand.get(0).face >= 10){
            result += " / It is worth 10.";
        }else if(this.hand.get(0).face == 1){
            result += " / It is worth either 11 or 1.";
        }else{
            result += " / It is worth " + this.hand.get(0).face + ".";

        }
        return result;
    }

    public String revealHand(){
        String result = "";
        for(int i = 0; i < super.hand.size(); i++){
            result += super.hand.get(i).toString();
            result += " ";
        }
        return result;
    }


}
