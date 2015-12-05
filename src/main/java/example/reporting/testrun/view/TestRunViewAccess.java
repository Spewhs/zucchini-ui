package example.reporting.testrun.view;

import example.reporting.testrun.domain.TestRunDAO;
import example.reporting.testrun.model.TestRun;
import example.reporting.testrun.model.TestRunStatus;
import ma.glasnost.orika.BoundMapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class TestRunViewAccess {

    private final TestRunDAO testRunDAO;

    private final TestRunViewMapper mapper = new TestRunViewMapper();

    private final BoundMapperFacade<TestRun, TestRunListItemView> testRunListItemViewMapper = mapper.dedicatedMapperFor(
            TestRun.class,
            TestRunListItemView.class,
            false
    );

    @Autowired
    public TestRunViewAccess(final TestRunDAO testRunDAO) {
        this.testRunDAO = testRunDAO;
    }

    public List<TestRunListItemView> getLatests() {
        return testRunDAO.createQuery()
                .field("status").equal(TestRunStatus.CLOSED)
                .order("-date")
                .retrievedFields(true, "id", "env", "date")
                .limit(50) // FIXME With params ?!
                .asList()
                .stream()
                .map(testRunListItemViewMapper::map)
                .collect(Collectors.toList());
    }

}
