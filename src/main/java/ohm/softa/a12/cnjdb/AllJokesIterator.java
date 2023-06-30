package ohm.softa.a12.cnjdb;

import ohm.softa.a12.model.JokeDto;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Iterator;

/**
 * Iterator to retrieve all jokes of the ICNDB until collision.
 */
public final class AllJokesIterator implements Iterator<JokeDto> {

    /* ICNDB API proxy to retrieve jokes */
    private final CNJDBApi icndbApi;

    public AllJokesIterator() {
        icndbApi = CNJDBService.getInstance();
    }

	@Override
	public boolean hasNext() {
		throw new NotImplementedException("Method `get()` is not implemented");
	}

	@Override
	public JokeDto next() {
		throw new NotImplementedException("Method `get()` is not implemented");
	}
}
