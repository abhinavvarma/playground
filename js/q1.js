

function findTotalCastles(a) {
    var nCastles = 0;
    var i = 0;
    var isHill;
    while(i+1<a.length && a[i] === a[i+1]) {
        i++;
    }
    //check edge case
    isHill = (a[i]>a[i-1]);
    nCastles++;
    for(;i<a.length;i++) {
        if ((isHill &&(a[i]>=a[i-1])) || (!isHill &&(a[i]>=a[i-1]))) {
            // still same hill or valley
        } else {
            // terrain changed
            nCastles++;
            isHill = !isHill;
        }
    }

    return nCastles;
}

console.log(findTotalCastles([2,2,3,4,3,3,2,2,1,1,2,5]));