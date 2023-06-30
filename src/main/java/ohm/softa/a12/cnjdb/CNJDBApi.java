package ohm.softa.a12.cnjdb;

import ohm.softa.a12.model.JokeDto;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.concurrent.CompletableFuture;

public interface CNJDBApi {
    /**
     * Fetch a random joke
     */
    @GET("/jokes/random")
    JokeDto getRandomJoke();

    /**
     * Fetch a random joke for the given category
     */
    @GET("/jokes/random")
    JokeDto getRandomJokeByCategory(@Query("category") String category);

	/**
	 * Get a list of random jokes matching the search query
	 */
	@GET("/jokes/random")
	JokeDto[] getJokesByQuery(@Query("category") String query);

    /**
     * Fetch the joke corresponding to the given id string
     */
    @GET("/jokes/{id}")
    JokeDto getJoke(@Path("id") String id);
}
