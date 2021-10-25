function wait(delay) {
  return new Promise((resolve) => setTimeout(resolve, delay));
}

function fetchRetry(url, delay, tries, fetchOptions = {}) {
  function onError(err) {
    triesLeft = tries - 1;
    if (!triesLeft) {
      throw err;
    }
    return wait(delay).then(() =>
      fetchRetry(url, delay, triesLeft, fetchOptions)
    );
  }
  return fetch(url, fetchOptions).catch(onError);
}

async function fetchUntilSucceeded() {
  let success = false;
  while (!success) {
    try {
      // let result = await fetch(...);
      success = true;
      //do your stuff with your result here
    } catch {
      //do your catch stuff here
    }
  }
}
