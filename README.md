# org.groupkt.epam.jbehave
task

There still issue for test scenario running - some steps are not proccessed: (PENDING) or (NOT PERFORMED)

Using           
            return new MostUsefulConfiguration()
              .usePendingStepStrategy(new FailingUponPendingStep())
 I confirmed that there issue on side of step faluire:
org.jbehave.core.failures.PendingStepFound: Then server return response with code 200 (PENDING)


I suspect that the problem is in the syntax delegation steps. But I did not have enough time to solve the problem.
