import com.cinemax.command.OrderCard;
import com.cinemax.domain.aggregate.Card;
import com.cinemax.domain.events.CardCreated;
import com.cinemax.domain.events.CardHasBeenOrdered;
import com.cinemax.domain.events.DomainEvent;
import com.cinemax.domain.events.ItemAddedToCard;
import com.cinemax.handler.CardOrderHandler;
import com.cinemax.handler.Handler;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReactiveTestingFramework {

    private CardCreated Card_created(String name) {
        return new CardCreated(name);
    }

    private ItemAddedToCard Item_added_to_card(String name, String item) {
        return new ItemAddedToCard(name, item);
    }

    private CardHasBeenOrdered Card_has_been_ordered(String name, List<String> itemIds) {
        return new CardHasBeenOrdered(name, itemIds);
    }

    private OrderCard Order_card(String id) {
        return new OrderCard(id);
    }

    List<DomainEvent> _history;
    List<DomainEvent> _published_events;

    @Test
    public void a_shopping_card_can_be_ordered() {
        Given(
                Card_created("Luke"),
                Item_added_to_card("Luke", Items.Podengine)
        );

        When(Order_card("Luke"));

        Then_expect(
                Card_has_been_ordered("Luke", Arrays.asList(Items.Podengine))
        );

    }

    void Given(DomainEvent ... events) {
        _history = Arrays.asList(events);
    }

    void When(Object cmd) {
        Handler handler = new CardOrderHandler(_history, e -> _published_events.add(e));
        handler.handle(cmd);
    }

    void Then_expect(DomainEvent... publishedEvents) {
        assertThat(publishedEvents, is(_published_events));
    }

}


