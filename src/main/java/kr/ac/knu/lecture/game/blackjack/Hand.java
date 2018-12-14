package kr.ac.knu.lecture.game.blackjack;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rokim on 2018. 5. 26..
 */
public class Hand {
    private Deck deck;
    @Getter
    private List<Card> cardList = new ArrayList<>();

    public Hand(Deck deck) {
        this.deck = deck;
    }

    public Card drawCard() {
        Card card = deck.drawCard();
        cardList.add(card);
        return card;
    }

    public int getCardSum() {
        int sum = 0;
        int aceCount = 0;
        //ace는 보류
        for(int i = 0; i<cardList.size(); i++){
            int rank = cardList.get(i).getRank();
            if(rank > 10) sum+=10;
            else if(rank == 1) aceCount++;
            else sum+=rank;
        }
        //ace가 두개 이상이라도 어차피 ace는 두개 이상 추가해줄 수 없으므로 하나 11점, 나머지 1점으로 가정해줘도 되는지 확인한 후 안되면 모두 1점
        if(aceCount>0) {
            if (sum + (aceCount - 1) + 11 <= 21)
                sum += (aceCount - 1) + 11;
            else
                sum += aceCount;
        }
        return sum;

    }

    public void reset() {
        cardList.clear();
    }
}
