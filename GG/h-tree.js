// config
// https://mccarthydanielle.medium.com/constructing-an-h-tree-with-javascript-29d0f46932d6
let depth = 2;

const canvas = document.getElementById("c");
const context = c.getContext("2d");
context.strokeStyle = "#00386B";

const center = {
  x: canvas.width / 2.0,
  y: canvas.height / 2.0,
};

// constants
const sqrt2 = Math.sqrt(2);
const len = canvas.width / sqrt2 / sqrt2;

// recursive func
const hTree = (point, len, depth) => {
  if (depth === 0) {
    return;
  }

  // draw horizontal line
  const h1 = { x: point.x - len / 2.0, y: point.y };
  const h2 = { x: point.x + len / 2.0, y: point.y };
  drawLine(h1, h2);

  // draw vertical lines
  len = len / sqrt2;

  const v1 = { x: h1.x, y: h1.y - len / 2.0 };
  const v2 = { x: h1.x, y: h1.y + len / 2.0 };
  drawLine(v1, v2);

  const v3 = { x: h2.x, y: h2.y - len / 2.0 };
  const v4 = { x: h2.x, y: h2.y + len / 2.0 };
  drawLine(v3, v4);

  // compute new length, depth
  depth--;
  len = len / sqrt2;

  // recurse recurse recurse recurse
  hTree(v1, len, depth);
  hTree(v2, len, depth);
  hTree(v3, len, depth);
  hTree(v4, len, depth);
};

// line helper
const drawLine = (from, to) => {
  context.beginPath();
  context.moveTo(from.x, from.y);
  context.lineTo(to.x, to.y);
  context.stroke();
};

// paint helper
const paint = () => {
  context.clearRect(0, 0, canvas.width, canvas.height);
  hTree(center, len, depth);
};

// increase depth, to a reasonable point
const plus = document.getElementById("plus");
plus.addEventListener("click", () => {
  depth <= 7 && depth++ && paint();
});

// decrease depth
const minus = document.getElementById("minus");
minus.addEventListener("click", () => {
  depth !== 1 && depth-- && paint();
});

// fire away
paint();
