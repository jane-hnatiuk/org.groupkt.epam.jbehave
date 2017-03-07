package org.groupkt.epam.jbehave.stories;

import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.junit.Test;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class GetCountryStoryRunner {

    @Test
    public void runClasspathLoadedStoriesAsJUnit() {
        Embedder embedder = new GetCountryStory();
        embedder.embedderControls().doIgnoreFailureInStories(true);
        List<String> storyPaths = new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "");
        embedder.runStoriesAsPaths(storyPaths);
    }

}