// pure js
const bookList = document.querySelector("#custom-class-name ul");

bookList.addEventListener("click", (e) => {
  if (e.target.className == "delete") {
    const removedLi = e.target.parentElement;
    bookList.removeChild(removedLi);
  }
});
