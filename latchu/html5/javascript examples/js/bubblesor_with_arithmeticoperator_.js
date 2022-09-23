let a=prompt('enter the First number');
let b=prompt('enter the second number');
let temp;
//swap the variables algorithm
//[firstNumber,secondNumber]=[secondNumber,firstNumber];
a=a+b;
b=a-b;
a=a-b;
console.log(`The value of first number after swapping ${a}`);
console.log(`The value of second number after swapping ${b}`);