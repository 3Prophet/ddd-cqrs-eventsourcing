package com.cinemax.domain.events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EventStore {

    private List<DomainEvent> _events = Arrays.asList(
            new CardCreated("Luke"),
            new ItemAddedToCard("Luke", "PowerConverter"),
            new ItemAddedToCard("Luke", "PodEngine"),
            new ItemRemovedFromTheCard("Luke", "PowerConverter")
    );

    public List<DomainEvent> getEvents(String customerId) {
        return new ArrayList<>(
                _events.stream()
                        .filter(e -> e.getItemId().equals(customerId))
                        .collect(Collectors.toList())
        );
    }

    public void storeEvents(List<DomainEvent> publishedEvents) {
        _events.addAll(publishedEvents);
    }
}
