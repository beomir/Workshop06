package pl.coderslab.springboot02.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LoadFixtures {
    private BookFixture bookFixture;

    @Autowired
    public LoadFixtures(BookFixture bookFixture) {
        this.bookFixture = bookFixture;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        bookFixture.loadIntoDB();
    }
}
