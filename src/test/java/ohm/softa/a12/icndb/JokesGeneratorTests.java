package ohm.softa.a12.icndb;

import ohm.softa.a12.cnjdb.JokeGenerator;
import ohm.softa.a12.model.JokeDto;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JokesGeneratorTests {

    private JokeGenerator jokeGenerator = new JokeGenerator();

    @Test
    void testRandomStream() {
		List<JokeDto> collect = jokeGenerator.randomJokesStream().limit(100).collect(Collectors.toList());
		assert(collect.size() == 500);
    }


    @Test
    void testAllJokesStream() {
		List<JokeDto> jokes = jokeGenerator.allJokesStream().limit(100).collect(Collectors.toList());
		long distinctCount = jokes.stream().distinct().count();
		long totalCount = jokes.stream().count();
		assertEquals(distinctCount, totalCount);
    }
}
