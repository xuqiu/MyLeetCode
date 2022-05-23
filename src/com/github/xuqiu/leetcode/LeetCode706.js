let MyHashMap = function() {

};

/**
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function(key, value) {
    if(!this.values[Math.trunc(key/10000)%100]){
        this.values[Math.trunc(key/10000)%100]={};
    }
    if(!this.values[Math.trunc(key/10000)%100][Math.trunc(key/100)%100]){
        this.values[Math.trunc(key/10000)%100][Math.trunc(key/100)%100]={};
    }
    this.values[Math.trunc(key/10000)%100][Math.trunc(key/100)%100][key%100] = value;
};

/**
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function(key) {
    if(!this.values[Math.trunc(key/10000)%100]){
        return -1;
    }
    if(!this.values[Math.trunc(key/10000)%100][Math.trunc(key/100)%100]){
        return -1;
    }
    if( typeof(this.values[Math.trunc(key/10000)%100][Math.trunc(key/100)%100][key%100])!='number'){
        return -1;
    }
    return this.values[Math.trunc(key/10000)%100][Math.trunc(key/100)%100][key%100];
};

/**
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function(key) {
    if(!this.values[Math.trunc(key/10000)%100]){
        return;
    }
    if(!this.values[Math.trunc(key/10000)%100][Math.trunc(key/100)%100]){
        return;
    }
    this.values[Math.trunc(key/10000)%100][Math.trunc(key/100)%100][key%100] = -1;
};

MyHashMap.prototype.values = {}


let test = ()=>{
    let myHashMap = new MyHashMap();
    myHashMap.put(1,123);
    myHashMap.put(9999,124);
    console.info(myHashMap.get(15));
    console.info(myHashMap.get(9999));
    myHashMap.remove(1);
    console.info(myHashMap.get(9999));
    console.info(myHashMap.get(1));
}
test();