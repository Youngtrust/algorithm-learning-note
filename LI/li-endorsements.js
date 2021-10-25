const endorsements = [
  { sikll: "JS", user: "one" },
  { sikll: "JS", user: "two" },
  { sikll: "JS", user: "three" },
  { sikll: "JS", user: "four" },
  { sikll: "CSS", user: "five" },
  { sikll: "CSS", user: "six" },
];

const output = [
  { sikll: "JS", user: ["one", "2", "3", "4"], count: 4 },
  { sikll: "CSS", user: [5, 6], count: 2 },
];

const formatData = (endorsements) => {
  let res = [];

  if (!Array.isArray(endorsements)) {
    return res;
  }

  const mappedObj = endorsements.reduce(
    (prev, curr) => (
      {
        ...prev,
        [curr.skill]: [...(prev[curr.skill] || []), curr.user],
      },
      {}
    )
  );
  res = Object.entries(mappedObj)
    .map(([key, value]) => ({
      sikll: key,
      users: value,
      count: value.length,
    }))
    .sort((a, b) => a.count - b.count);

  return res;
};
