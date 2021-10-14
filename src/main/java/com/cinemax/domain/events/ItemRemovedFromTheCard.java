package com.cinemax.domain.events;

public class ItemRemovedFromTheCard extends DomainEvent {
    protected ItemRemovedFromTheCard(String card, String itemId) {
        super(card, itemId);
    }
}
