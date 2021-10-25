// build a widget with 4 lists and 3 nested list, \
// nested can be span/collapse when clicking on parents, highlight txt when hover
<table class="gridview">
  <tr>
    <th>Col1</th>
    <th>Col2</th>
    <th>Col3</th>
    <th>Col4</th>
  </tr>
  <tr onclick="toggleClass(this,'selected');">
    <td>Data1</td>
    <td>Data2</td>
    <td>Data3</td>
    <td>Data4</td>
  </tr>
  <tr onclick="toggleClass(this,'selected');">
    <td>Data1</td>
    <td>Data2</td>
    <td>Data3</td>
    <td>Data4</td>
  </tr>
  <tr onclick="toggleClass(this,'selected');">
    <td>Data1</td>
    <td>Data2</td>
    <td>Data3</td>
    <td>Data4</td>
  </tr>
</table>;

let currentSelect = null;

const toggleClass = (el, className) => {
  console.log(el, className);

  if (currentSelect) {
    currentSelect.classList.remove("selected");
  }
  currentSelect = el;

  currentSelect.classList.add("selected");
};
