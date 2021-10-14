package com.cinemax.domain.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CardHasBeenOrdered {

    private final String card;

    private final List<String> itemIds;

    public CardHasBeenOrdered(String card, List<String> itemIds) {
        this.card = card;
        this.itemIds = itemIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardHasBeenOrdered that = (CardHasBeenOrdered) o;
        return card.equals(that.card) &&
                itemIds.equals(that.itemIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(card, itemIds);
    }
}
