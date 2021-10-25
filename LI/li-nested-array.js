const flatten = (targetArray) => {
  let result = [];

  targetArray.forEach((eachSub) => {
    if (Array.isArray(eachSub)) {
      result = result.concat(flatten(eachSub));
    } else {
      result.push(eachSub);
    }
  });

  return result;
};
