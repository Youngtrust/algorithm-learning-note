<body>
  <div id="content"></div>
</body>;

var members = [
  { name: "Bill Denbrough", id: 1 },
  { name: "Ben Hanscom", id: 2 },
  { name: "Mike Hanlon", id: 3 },
  { name: "Richie Tozier", id: 4 },
  { name: "Beverly Marsh", id: 5 },
  { name: "Eddie Kaspbrak", id: 6 },
  { name: "Stan Uris", id: 7 },
];

// Question: insert links for each of the members into the content div
// The link would be like the example below
// <a href="profile.jsp?id=<memeber.id>"><membe‍‌‍‍‍‌‍‍‍‍‌‍‌‍‍‍‌‌‍r.name></a>
// own answer

document.getElementById("content").innerHTML = members
  .map(
    (eachMember) =>
      `<a href="profile.jsp?id=${eachMember.id}">${eachMember.name}</a>`
  )
  .join("");

//follow up:
//use <ul> <li> to implement the same functionality
var customUL = document.createElement("ul");
customUL = members
  .map(
    (eachMember) =>
      `<li><a href="profile.jsp?id=${eachMember.id}">${eachMember.name}</a></li>`
  )
  .join("");

document.getElementById("content").innerHTML = customUL;
