package com.cinemax.handler;

import com.cinemax.command.PutItemIntoCard;
import com.cinemax.domain.aggregate.Customer;
import com.cinemax.domain.events.DomainEvent;
import com.cinemax.domain.events.EventStore;

import java.util.List;
import java.util.function.Consumer;

public class CardOrderHandler implements Handler {

    private EventStore _eventStore = new EventStore();

    private Consumer<DomainEvent> publisher;

    private List<DomainEvent> history;

    public class AcceptOrder {
        private final String customerId;
        private final List<String> items;

        public AcceptOrder(String customerId, List<String> items) {
            this.customerId = customerId;
            this.items = items;
        }
    }

    public CardOrderHandler(List<DomainEvent> history, Consumer<DomainEvent> publisher) {
        this.history = history;
        this.publisher = publisher;
    }


/*    public void handle(Object command) {
        AcceptOrder cmd = (AcceptOrder) command;
        List<DomainEvent> storedEvents = _eventStore.getEvents(cmd.customerId);
        Customer customer = new Customer(storedEvents);
        customer.acceptNewOrder(cmd.items);
        _eventStore.storeEvents(customer.publishedEvents());
    }*/

    public void handle(Object command) {
        if (command instanceof PutItemIntoCard) {
            PutItemIntoCard cmd = (PutItemIntoCard) command;
            CardState cardState = new CardState(history.stream().filter(e -> e.getCard().equals(cmd.customerId)));
            Card card = new Card(cardState,
                    e -> {
                cardState.apply(e);
                publisher.accept(e);
            });
        }
    }

}
