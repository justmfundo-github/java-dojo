//list of vertices + list of edges
const vertices = ["A", "B", "C", "D", "E"];

const edges = [
  ["A", "B"],
  ["A", "D"],
  ["B", "C"],
  ["C", "D"],
  ["C", "E"],
  ["D", "E"],
];

// findAdjacentNodes function
const findAdjacentNodes = (node) => {
  //loop through edges array
  //check if node is in the connection
  //if yes, push the other node in the pair to adjacentNodes array
  //if no, keep looping
  const adjacentNodes = [];

  for (let edge of edges) {
    //where each edge consists of ['A','B'] type of array
    const nodeIndex = edge.indexOf(node); //if it's there a 0 or 1 is returned. If it's not there then -1 is returned
    if (nodeIndex > -1) {
      //if nodeIndex is 0, then return the other node because we want the adjacent nodes and not the search node itself
      const adjacentNode = nodeIndex === 0 ? edge[1] : edge[0];
      adjacentNodes.push(adjacentNode);
    }
  }

  return adjacentNodes;
};

console.log(findAdjacentNodes("A"));
console.log(findAdjacentNodes("C"));
console.log(findAdjacentNodes("E"));
