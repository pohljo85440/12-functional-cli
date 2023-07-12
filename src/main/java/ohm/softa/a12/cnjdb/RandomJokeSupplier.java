package ohm.softa.a12.cnjdb;

import ohm.softa.a12.cnjdb.CNJDBApi;
import ohm.softa.a12.cnjdb.CNJDBService;
import ohm.softa.a12.model.JokeDto;
import org.apache.commons.lang3.NotImplementedException;

import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 * @author Peter Kurfer
 */

public final class RandomJokeSupplier implements Supplier<JokeDto> {
	private static final Logger logger = Logger.getLogger(RandomJokeSupplier.class.getName());

	/* ICNDB API proxy to retrieve jokes */
    private final CNJDBApi icndbApi;

    public RandomJokeSupplier() {
        icndbApi = CNJDBService.getInstance();
    }

    public JokeDto get() {
		try {
			JokeDto joke = icndbApi.getRandomJoke().get();
			logger.info("Joke: " +  joke.getId() + " retrieved.");
			return joke;
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
    }
}
