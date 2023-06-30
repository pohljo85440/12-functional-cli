package ohm.softa.a12.cnjdb;

import ohm.softa.a12.model.JokeDto;
import org.apache.commons.lang3.NotImplementedException;

import java.util.stream.Stream;

/**
 * Generator instance to provide streams of jokes
 */

public final class JokeGenerator {

    /**
     * Generate an infinite Stream of random jokes using the RandomJokeSupplier
     */
    public Stream<JokeDto> randomJokesStream() {
        throw new NotImplementedException("Method `randomJokeStream()` is not implemented");
    }

    /**
     * Generator a finite Stream of jokes using the AllJokesIterator
     */
    public Stream<JokeDto> allJokesStream() {
        throw new NotImplementedException("Method `allJokesStream()` is not implemented");
    }
}
