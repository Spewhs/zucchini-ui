import queryString from 'query-string';


class TestRunsApi {

  constructor(baseUri) {
    this.baseUri = baseUri;
  }

  getLatests({ withStats, type }) {
    const queryParams = queryString.stringify({
      withStats,
      type,
    });

    return fetch(`${this.baseUri}/api/testRuns?${queryParams}`)
      .then(response => {
        return response.json();
      });
  }

  getTestRun({ testRunId }) {
    return fetch(`${this.baseUri}/api/testRuns/${testRunId}`)
      .then(response => {
        return response.json();
      });
  }

  createTestRun({ type }) {
    const fetchParams = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ type }),
    };

    return fetch(`${this.baseUri}/api/testRuns/create`, fetchParams)
      .then(response => {
        return response.json();
      });
  }

  deleteTestRun({ testRunId }) {
    const fetchParams = {
      method: 'DELETE',
    };

    return fetch(`${this.baseUri}/api/testRuns/${testRunId}`, fetchParams)
      .then(() => {
        return null;
      });
  }

}

const testRuns = new TestRunsApi(configuration.ui.backendBaseUri);

export default testRuns;
