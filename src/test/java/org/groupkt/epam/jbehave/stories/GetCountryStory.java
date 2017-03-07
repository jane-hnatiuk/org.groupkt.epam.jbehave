package org.groupkt.epam.jbehave.stories;

import org.groupkt.epam.jbehave.steps.GetCountrySteps;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;

import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.*;


import java.text.SimpleDateFormat;

import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.XML;


public class GetCountryStory extends Embedder {
        @Override
        public EmbedderControls embedderControls() {
        return new EmbedderControls().doIgnoreFailureInStories(true).doIgnoreFailureInView(true);
        }

        @Override
        public Configuration configuration() {
            Class<? extends GetCountryStory> embedderClass = this.getClass();
            return new MostUsefulConfiguration()
                    .usePendingStepStrategy(new FailingUponPendingStep())
                    .useParameterControls(new ParameterControls().useDelimiterNamedParameters(true))
                    .useStoryLoader(new LoadFromClasspath(embedderClass.getClassLoader()))
                    .useStoryReporterBuilder(new StoryReporterBuilder()
                            .withCodeLocation(CodeLocations.codeLocationFromClass(embedderClass))
                            .withDefaultFormats()
                            .withFormats(CONSOLE, TXT, HTML, XML)
                            .withCrossReference(new CrossReference()))
                    .useParameterConverters(new ParameterConverters()
                            .addConverters(new ParameterConverters.DateConverter(new SimpleDateFormat("yyyy-MM-dd")))) // use custom date pattern
                    .useStepPatternParser(new RegexPrefixCapturingPatternParser(
                            "%")) // use '%' instead of '$' to identify parameters
                    .useStepMonitor(new SilentStepMonitor());
        }

        @Override
        public InjectableStepsFactory stepsFactory() {
            return new InstanceStepsFactory(configuration(), new GetCountrySteps());
        }

}