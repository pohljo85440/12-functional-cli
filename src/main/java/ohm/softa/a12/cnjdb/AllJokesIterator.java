package ohm.softa.a12.cnjdb;

import ohm.softa.a12.model.JokeDto;
import org.apache.commons.lang3.NotImplementedException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Iterator to retrieve all jokes of the ICNDB until collision.
 */
public final class AllJokesIterator implements Iterator<JokeDto> {
	private static final Logger logger = Logger.getLogger(AllJokesIterator.class.getName());


	/* ICNDB API proxy to retrieve jokes */
    private final CNJDBApi icndbApi;
	private final Set<String> ids;
	private JokeDto currentJoke;


    public AllJokesIterator() {
        icndbApi = CNJDBService.getInstance();
		ids = new HashSet<>();
		currentJoke = retrieve();
    }


	private JokeDto retrieve() {
		try {
			JokeDto joke = icndbApi.getRandomJoke().get();
			if (ids.contains(joke.getId())) {
				logger.info("Joke: " +  joke.getId() + " already retrieved.");
				return null;
			}
			else {
				logger.info("Joke: " +  joke.getId() + " added to list.");
				ids.add(joke.getId());
			}
			return joke;
		} catch(Exception e) {
			System.err.println(e);
			return null;
		}
	}


	@Override
	public boolean hasNext() {
		return currentJoke != null;
	}

	@Override
	public JokeDto next() {
		JokeDto tempJoke = currentJoke;
		currentJoke = retrieve();
		return tempJoke;
	}
}
