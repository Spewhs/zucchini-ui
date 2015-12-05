package example.reporting.testrun.domain;

import example.reporting.testrun.model.TestRun;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestRunDAO extends BasicDAO<TestRun, String> {

    @Autowired
    public TestRunDAO(final Datastore ds) {
        super(ds);
    }

}
