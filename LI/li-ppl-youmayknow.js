// people you may know
// 一个图片，让你用html写出来。
// 大概是一个linkedin的用户推荐界面。
// 第一行是文字People You May Know 我用div和p，提示让用<h5>tag
// 下面三小行：每一行是一个推荐给你的用户

// 又分三小列：每一列从左到右是：一个图片，两行文字，一个叉叉图标。

// 其中第一行文字是：姓名（加粗的），职位，
// 第二行文字是：一个加号，一个“connect”，要求用<a></a>加在connect旁边。

// 最后右下角有个See more>>> 我还没写，他就问了两个CSS问题
// （前面的代码都不用写JavaScript和CSS，只用html，但他要问你为什么用这个tag）
<body>
  <div class="customCard">
    <div class="row">
      <div class="card-component box"></div>
    </div>
  </div>
</body>;
var userDetail = [
  {
    name: "sunil",
    age: "24",
    place: "delhi",
    avatar: "http://www.gravatar.com/avatar/",
    country: "US",
    background:
      "https://upload.wikimedia.org/wikipedia/commons/9/9a/Gull_portrait_ca_usa.jpg",
  },
  {
    name: "sunil",
    age: "24",
    place: "delhi",
    avatar: "https://i.ytimg.com/vi/fUWrhetZh9M/maxresdefault.jpg",
    country: "US",
    background:
      "https://upload.wikimedia.org/wikipedia/commons/9/9a/Gull_portrait_ca_usa.jpg",
  },
  {
    name: "abishek",
    age: "26",
    place: "kolkata",
    avatar: "./image/abc.jpg",
    country: "India",
  },
  {
    name: "chiranjeev",
    age: "20",
    place: "bangalore",
    avatar: "./image/abc.jpg",
    country: "India",
  },
  {
    name: "sunil",
    age: "24",
    place: "delhi",
    avatar: "http://www.gravatar.com/avatar/",
    country: "US",
    background:
      "https://upload.wikimedia.org/wikipedia/commons/9/9a/Gull_portrait_ca_usa.jpg",
  },
  {
    name: "sunil",
    age: "24",
    place: "delhi",
    avatar: "https://i.ytimg.com/vi/fUWrhetZh9M/maxresdefault.jpg",
    country: "US",
    background:
      "https://upload.wikimedia.org/wikipedia/commons/9/9a/Gull_portrait_ca_usa.jpg",
  },
];

var customUL = document.createElement("ul");

customUL.className = "user-card-ul";
customUL = userDetail
  .map(
    (each) =>
      `
          <div class='each-user-card-component'>
             <div class='delete-btn'>
              <button class='top-right'>X</buttom>
             </div>
  
            <image class='avatar-cycle-image center' src=${each.avatar} />
            <div class='center'><p>${each.name}</p></div>
            <div class='center'>${each.place}, ${each.country}</div>
            <br/>
            <button class='center'>connect</buttom>
            
          </div>
        `
  )
  .join("");

document.querySelector(".box").innerHTML = customUL;
