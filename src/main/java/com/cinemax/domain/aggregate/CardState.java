package com.cinemax.domain.aggregate;

import com.cinemax.domain.events.CardCreated;
import com.cinemax.domain.events.DomainEvent;
import com.cinemax.domain.events.ItemAddedToCard;
import com.cinemax.domain.events.ItemRemovedFromTheCard;

import java.util.ArrayList;
import java.util.List;

public class CardState {

    String name;

    List<String> itemIds = new ArrayList<>();

    public CardState(List<DomainEvent> history) {
        for (DomainEvent event: history) {
            apply(event);
        }
    }

    public void apply(DomainEvent domainEvent) {
        if (domainEvent instanceof CardCreated) {
            apply((CardCreated) domainEvent);
        } else if (domainEvent instanceof ItemAddedToCard) {
            apply((ItemAddedToCard) domainEvent);
        } else if (domainEvent instanceof ItemRemovedFromTheCard) {
            apply((ItemRemovedFromTheCard) domainEvent);
        }
    }

    public void apply(CardCreated domainEvent) {
        name = domainEvent.getCard();
    }

    public void apply(ItemAddedToCard domainEvent) {
        itemIds.add(domainEvent.getItemId());
    }

    public void apply(ItemRemovedFromTheCard domainEvent) {
        itemIds.remove(domainEvent.getItemId());
    }

}
