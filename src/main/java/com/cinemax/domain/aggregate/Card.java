package com.cinemax.domain.aggregate;

import com.cinemax.domain.events.CardCreated;
import com.cinemax.domain.events.DomainEvent;
import com.cinemax.domain.events.ItemAddedToCard;
import com.cinemax.domain.events.ItemRemovedFromTheCard;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Card {

    CardState cardState;

    Consumer<DomainEvent> publisher;

    public Card(CardState cardState,
                Consumer<DomainEvent> publisher) {
        this.cardState = cardState;
        this.publisher = publisher;
    }

    public void addItemToCard(String itemId) {
        publisher.accept(new ItemAddedToCard(cardState.name, itemId));
    }
}
