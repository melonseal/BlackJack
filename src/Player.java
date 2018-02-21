public class Player extends Person{

    int money = 10;
    int currentBet = 0;

    public String toString(){
        String result = "";
        for(int i = 0; i < super.hand.size(); i++){
            result += super.hand.get(i).toString();
            result += " ";
        }
        return result;
    }

    public void placeBet(int size) {
         this.money = this.money - size;
         this.currentBet += size;
    }

    public void receiveBet(int winCode){
        if(winCode == 1){
            this.money += this.currentBet;
        }
        if(winCode == 2){
            this.money += (this.currentBet * 2);
        }
        this.currentBet = 0;
    }


}
