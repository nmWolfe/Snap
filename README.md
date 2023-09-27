![](/Users/nmp/Desktop/Screenshot 2023-09-27 at 15.32.44.png)


# Snap!

## Table of Contents

- [About](#about)
- [Gameplay](#gameplay)
  - [Nology Snap](#nology-snap)
  - [Regular Snap](#regular-snap)
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Contributing](#contributing)
- [License](#license)

## About

Snap - a Java-based project that allows you to enjoy two variations of the popular Snap card game.
Offering or a challenging game against the computer or a fun multiplayer experience.

![](/Users/nmp/Desktop/Screenshot 2023-09-27 at 15.33.01.png)

## Gameplay

### _nology Snap

![](/Users/nmp/Desktop/Screenshot 2023-09-27 at 15.33.14.png)

In _nology Snap, the gameplay is as follows:

- Cards are dealt at 1-second intervals.
- If a player hits Enter when a pair of cards match by value, they win, and the game is over.
- If a player hits Enter when two cards don't match, they lose, and the game is over.
- If there are no matching pairs throughout the whole deck (after 52 cards have been drawn), the deck is reshuffled, and the game loop starts over.

### Regular Snap

![](/Users/nmp/Desktop/Screenshot 2023-09-27 at 15.33.25.png)

In Regular Snap, the gameplay differs slightly:

- All the cards are dealt one by one, again in 1-second intervals.
- If there is a snap (a pair of cards with matching values), the player who snaps gets the cards on the table added to their pile.
- The table is then cleared, and the game resumes.
- Whoever has the most cards in their hand at the end of the 52-card deck wins.

## Installation

1. Clone the repository to your local machine:

   ```shell
   git clone https://github.com/nmWolfe/Snap
   ```

2. Open the project in your preferred Java development environment.

3. Compile and run the files to start playing the games.

## Usage

Follow the in-terminal instructions to play the games.

## Features

- Two exciting variations of the Snap card game.
- Single-player mode against the computer.
- Two-player mode for multiplayer fun.
- Interactive gameplay with on-screen instructions.
- A visually appealing command-line interface.
- An easter egg for the true fans!

## Code Snippets

Abstracted class for each game.

```Java
import Card.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

abstract class CardGame {
    protected List<Card> deckOfCards;
    protected String name;
    protected final Random rand;

    public CardGame(String name){
        this.name = name;
        this.deckOfCards = new CardDeck().getDeck();
        this.rand = new Random();
    }

    public List<Card> getDeckOfCards() {
        deckOfCards = new CardDeck().getDeck();
        return deckOfCards;
    }

    public void setDeckOfCards(List<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public void displayDeck(){
        int count = 0;
        for (Card card: deckOfCards) {
            System.out.print(card + " ");
            count++;
            if (count % 13 == 0){
                System.out.println();
            }
        }
        System.out.println();
    }

    public Card dealCard(){
        return deckOfCards.remove(rand.nextInt(deckOfCards.size()));
    }

    public void sortDeck(CardSorting cardSorting){
        switch (cardSorting) {
            case BY_SUIT:
                deckOfCards.sort(Comparator.comparing(Card::getCardSuit));
                break;
            case BY_VALUE:
                deckOfCards.sort(Comparator.comparingInt(Card::getCardValue));
                break;
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(this.deckOfCards);
    }
    
}
```

Snap logic!

```java
    @Override
    public void play(boolean multiplayer) {

        System.out.println("** OK let's play some classic Snap **");

        List<Card> table = new ArrayList<>();

        Snap snap = new Snap("Snap");
        snap.getDeckOfCards();

        List<Card> playerOneCards = new ArrayList<>();
        List<Card> playerTwoCards = new ArrayList<>();

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            Card currentCard;
            int cardCount = 0;

            @Override
            public void run() {

                if (cardCount < 52) {

                    currentCard = snap.dealCard();
                    table.add(currentCard);
                    System.out.println(currentCard);
                    cardCount++;

                } else {

                    timer.cancel();
                    return;

                }

                if (!multiplayer) {

                    if (table.size() > 2 && (table.get(table.size() - 3).getCardValue() == table.get(table.size() - 2).getCardValue())) {

                        System.out.println("Computer SNAPS it up!");
                        playerTwoCards.addAll(table);
                        table.clear();

                    }
                }

            }
        }, 1000, 1000);

        boolean gameOver = false;

        while (!gameOver) {

            String playerInteraction = scanner.nextLine();

            if (playerInteraction.isEmpty()) {

                if (table.get(table.size() - 2).getCardValue() == table.get(table.size() - 1).getCardValue()) {

                    if (!multiplayer) {

                        playerOneCards.addAll(table);
                        table.clear();
                        System.out.println("SNAP - Table cleared!");

                    } else {

                        if (table.size() % 2 != 0) {

                            System.out.println("Player 2 \u001B[31m WHACKS \u001B[0m down a SNAP!");
                            playerTwoCards.addAll(table);

                        } else {

                            System.out.println("Player 1 \u001B[31m WHACKS \u001B[0m down a SNAP!");
                            playerOneCards.addAll(table);

                        }
                        table.clear();
                    }
                }
            } else {

                System.out.println("Nice try,\u001B[31m Bucko!\u001B[0m");

            }

            if (table.size() + playerOneCards.size() + playerTwoCards.size() == 52) {
                gameOver = true;
            }

        }
        timer.cancel();
        scoreChecker(playerOneCards, playerTwoCards, multiplayer);
        replay(multiplayer);
    }
```

_nology Snap logic! 

```java
  @Override
    public void play(boolean multiPlayer) {

        System.out.println("** OK let's play a game of Nology Snap **");

        getDeckOfCards();
        computerWin = false;

        List<Card> table = new ArrayList<>();

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            Card currentCard;
            int cardCount = 0;

            @Override
            public void run() {

                if (cardCount < 52) {
                    currentCard = dealCard();
                    table.add(currentCard);
                    System.out.println(currentCard);
                    cardCount++;
                } else {
                    System.out.println("FLIP THE DECK!");
                    cardCount = 0;
                    getDeckOfCards();
                    table.clear();
                }

                if (!multiPlayer){

                    if (table.size() > 2 && (table.get(table.size() - 3).getCardValue() == table.get(table.size() - 2).getCardValue())) {

                        System.out.println("\b");
                        System.out.println("Computer SNAPS it up!");
                        computerWin = true;
                        timer.cancel();

                    }
                }

            }
        }, 1000, 1000);

        while (true) {

            String playerInteraction = scanner.nextLine();

            if (playerInteraction.isEmpty()) {

                if (computerWin){
                    replay(multiPlayer);
                    return;
                }

                if (table.isEmpty()) {
                    continue;
                }
                if (table.get(table.size() - 2).getCardValue() == table.get(table.size() - 1).getCardValue()) {

                    if (!multiPlayer) {
                        System.out.println("Woweeeee \u001B[31m SNAPPER \u001B[0m you win!");

                    } else {

                        if (table.size() % 2 != 0) {

                            System.out.println("Player 2 \u001B[31m WHACKS \u001B[0m down a SNAP and wins!");

                        } else {

                            System.out.println("Player 1 \u001B[31m WHACKS \u001B[0m down a SNAP and wins!");

                        }
                    }

                } else {
                    System.out.println("Nice try,\u001B[31m Bucko!\u001B[0m You \u001B[31mLooooose!\u001B[0m\n");
                }

                timer.cancel();
                replay(multiPlayer);
                return;
            }
        }
    }
```

## Collaborations

Please reach out if you would like to collaborate on a project, or if you have any comments about this project!
