package com.cinemax.domain.aggregate;

import com.cinemax.domain.events.DomainEvent;
import com.cinemax.domain.events.ItemAddedToCard;

import java.util.List;
import java.util.function.Consumer;

public class Customer {

    private Card card;

    private List<DomainEvent> publishedEvents;

    public Customer(List<DomainEvent> events) {
        card = new Card();
        card = Card.state(card, events);
    }

    public void acceptNewOrder(List<String> lines) {
        for (String itemId: lines) {
            card.addItemToCard(itemId, e -> publishedEvents.add(e));
        }
    }

    public List<DomainEvent> publishedEvents() {
        return publishedEvents;
    }
}
