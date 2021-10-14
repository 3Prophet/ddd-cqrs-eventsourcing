package com.cinemax.domain.events;

public class CardCreated extends DomainEvent {
    public CardCreated(String card) {
        super(card);
    }
}
