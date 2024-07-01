// 1
let numbers=[2,5,12,13,15,18,22];
for(let i=0; i<numbers.length;i++){
    if(numbers[i]%2===0){
        console.log(numbers[i]+"は偶数です。");
    }
}

// 2
class car{
    constructor(gas,num){
        this.gas=gas;
        this.num=num;
    }
    getNumGas(){
        console.log(`ガソリンは${this.gas}です。ナンバーは${this.num}です`);

    }
}
const mycar=new car("77ℓ","川崎［さ・３１５］");
mycar.getNumGas();