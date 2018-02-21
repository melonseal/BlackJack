import java.util.Scanner;

public class Runner {

    public static void main(String[] args){
        Player you = new Player();
        startGame(you);
    }

    public static void startGame(Player you){
        you.hand.clear();
        Deck deck = new Deck();
        Dealer dealer = new Dealer();
        you.newCard(deck);
        you.newCard(deck);
        dealer.newCard(deck);
        dealer.newCard(deck);
        System.out.println("You have " + you.money + " in imaginary currency! How much do you want to bet (must be at least 1)?");
        betRoutine(you);
        System.out.println("Your hand is: " + you + "/ It is worth " + you.valueOfHand() + ".");
        System.out.println("One of the dealer's cards is the " + dealer);
        if(you.valueOfHand() == 21){
            endRoutine(you, dealer);
        }else{
            System.out.println("Do you wish to bet again? Answer y or n.");
            Scanner betAgain = new Scanner(System.in);
            String wantBet = betAgain.nextLine().toLowerCase();
            if(wantBet.equals("y")){
                System.out.println("How much do you want to bet?");
                betRoutine(you);
            }
            System.out.println("Do you wish to draw another card? If you get over 21, you lose :(. Reply y or n.");

            boolean inputValid = false;
            while(!inputValid){
                Scanner scan = new Scanner(System.in);
                String userInput = scan.nextLine().toLowerCase();
                if(userInput.equals("y")){
                    you.newCard(deck);
                    System.out.println("Your hand is: " + you + "/ It is worth " + you.valueOfHand() + ".");
                    dealerPlays(dealer, deck);
                    endRoutine(you, dealer);
                    inputValid = true;
                }else if(userInput.equals("n")){
                    dealerPlays(dealer, deck);
                    endRoutine(you, dealer);
                    inputValid = true;
                }else{
                    System.out.println("Input not valid. Try again.");
                }
            }
        }
    }

    public static void betRoutine(Player you){
        boolean goodBet = false;
        while(!goodBet){
            Scanner better = new Scanner(System.in);
            String userBet = better.nextLine();
            if(Integer.parseInt(userBet) >= 1 && Integer.parseInt(userBet) <= you.money){
                you.placeBet(Integer.parseInt(userBet));
                System.out.println("You placed a bet of " + userBet);
                goodBet = true;
            }else{
                System.out.println("Bet not valid. Try again.");
            }
        }
    }

    public static void dealerPlays(Dealer dealer, Deck deck){
        while(dealer.valueOfHand() <= 16){
            dealer.newCard(deck);
        }
    }

    public static void endRoutine(Player player, Dealer dealer){
        int haveWon = 0;
        System.out.println("The dealer's hand was " + dealer.revealHand() + " / It was worth " + dealer.valueOfHand() + ".");
        if(player.valueOfHand() == 21){
            if(dealer.valueOfHand() != 21){
                System.out.println("You got blackjack and have won!");
                haveWon = 2;
            }else{
                System.out.println("You and the dealer both got blackjack.");
                haveWon++;
            }
        }
        if(player.valueOfHand() < 21 && dealer.valueOfHand() <= 21){
            if(player.valueOfHand() > dealer.valueOfHand()){
                System.out.println("You beat the dealer and won!");
                haveWon = 2;
            }
            if(player.valueOfHand() == dealer.valueOfHand()){
                System.out.println("You and the dealer tied.");
                haveWon++;
            }
            if(player.valueOfHand() < dealer.valueOfHand()){
                System.out.println("You lost :(.");
            }
        }else if(player.valueOfHand() > 21){
            System.out.println("You bust. :(.");
        }else if(dealer.valueOfHand() > 21){
            System.out.println("The dealer bust, so you won!");
            haveWon = 2;
        }
        player.receiveBet(haveWon);
        System.out.println("You now have " + player.money + " in imaginary currency!");
        System.out.println("Want to play again? Answer y or n");

        boolean goodInput = false;
        while(!goodInput){
            Scanner again = new Scanner(System.in);
            String playAgain = again.nextLine().toLowerCase();
            if(playAgain.equals("y")){
                startGame(player);
                goodInput = true;
            }else if(!playAgain.equals("n")){
                System.out.println("Input not valid. Try again.");
            }else{
                System.out.println("Goodbye!");
                goodInput = true;
            }
        }

    }

}
