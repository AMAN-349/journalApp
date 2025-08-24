package net.engineeringdigest.journalApp;

import net.engineeringdigest.journalApp.cache.AppCache;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootTest
@ComponentScan(excludeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = AppCache.class))
class JournalAppApplicationTests {

	@Test
	void contextLoads() {
	}

}
