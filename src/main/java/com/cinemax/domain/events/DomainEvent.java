package com.cinemax.domain.events;

public abstract class DomainEvent {

    private final String card;

    private final String itemId;

    protected DomainEvent(String card) {
        this.card = card;
        this.itemId = null;
    }

    protected DomainEvent(String card, String itemId) {
        this.card = card;
        this.itemId = itemId;
    }

    public String getCard() {
        return card;
    }

    public String getItemId() {
        return itemId;
    }
}
