// 1 6 7 12 13
// 2 5 8 11 14
// 3 4 9 10 15
// width: 5, height 3
import React from "react";

const range = (start, stop) =>
  Array.from({ length: stop - start }, (_, i) => start + i);

const mapTable = (width, height) => {
  // map vertical first
  let arrayVertical = new Array(width);
  let count = 1;

  for (let w = 0; w < width; w++) {
    arrayVertical[w] = range(count, count + height);
    count += height;
  }
  // [[1,2,3], [4,5,6],[7,8,9],[10,11,12]]
  for (let i = 0; i < width; i++) {
    if (i % 2 !== 0) {
      arrayVertical[i].sort((a, b) => b - a);
    }
  }
  // [[1,2,3], [6,5,4],[7,8,9],[12,11,10]]
  return arrayVertical;
};
// O(2width)

const resArray = mapTable(3, 5);

// O(w*h)
const resTable = resArray.map((eachtr, index) => {
  return (
    <tr key={index}>
      {resArray[eachtr].map((eachtd) => {
        return <td>{resArray[eachtr][eachtd]}</td>;
      })}
    </tr>
  );
});

// <!DOCTYPE html>

const tableComponent = () => {
  return (
    <html lang="en">
      <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
      </head>
      <body>
        <table>{resTable}</table>
      </body>
    </html>
  );
};
export default tableComponent;
/* <table>
  <tr>
    <th>Month</th>
    <th>Savings</th>
  </tr>
  <tr>
    <td>January</td>
    <td>$100</td>
  </tr>
</table> */

function createTable(rowCnt, colCnt) {
  const frag = document.createDocumentFragment();
  for (let i = 0; i < rowCnt; i++) {
    frag.append(document.createElement("tr"));
  }
  for (let y = 0, inc = -1, val = 1; y < colCnt; y++) {
    inc *= -1;
    for (
      let i = 0, x = y % 2 === 0 ? 0 : rowCnt - 1;
      i < rowCnt;
      i++, x += inc
    ) {
      const td = document.createElement("td");
      td.textContent = val++;
      frag.children[x].append(td);
    }
  }
  const table = document.createElement("table");
  table.append(frag);
  return table;
}
