package com.cinemax.domain.events;

public class ItemAddedToCard extends DomainEvent {
    public ItemAddedToCard(String card, String itemId) {
        super(card, itemId);
    }
}
