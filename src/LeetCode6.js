var convert = function(s, numRows) {
    if (numRows ==1) return s;
    var lineNum = 0;
    var addOrSub = 1;
    var resultArr = [];
    for (let i = 0; i < s.length; i++) {
        if(!resultArr[lineNum]) resultArr[lineNum] = "";
        resultArr[lineNum] += s[i];
        lineNum = lineNum+addOrSub;

        if(lineNum === numRows){
            lineNum =lineNum -2;
            addOrSub = -1;
        }
        if(lineNum === -1){
            lineNum = 1;
            addOrSub = 1;
        }
    }
    return resultArr.join("");
};
console.info(convert("PAYPALISHIRING",100));