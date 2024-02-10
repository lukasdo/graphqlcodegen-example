package io.github.deweyjose.graphqlcodegen.datafetchers;

import com.acme.types.Comment;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsSubscription;
import com.netflix.graphql.dgs.InputArgument;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

import java.time.Duration;

@DgsComponent
public class Subscriptions {
    @DgsSubscription
    public Publisher<Comment> commentAdded(@InputArgument String postID) {

        //Create a never-ending Flux that emits an item every second
        return Flux.interval(
                Duration.ofSeconds(0),
                Duration.ofSeconds(1)).map(t -> Comment.newBuilder().id(postID).build());
    }
}
