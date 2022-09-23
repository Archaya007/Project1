let root1,root2;
//get values from the user
let a=prompt('enter co-effient of x^2');
let b=prompt('enter co-effient of x');
let c=prompt('enter the constant');
//b^2-4ac
let descriminant=(b*b)-(4*a*c);
console.log(descriminant);

//-b/2a=0
//-b

//calculate root1,r7oot2 based on the discriminant
if(descriminant>0){                                 
    root1= (-b +Math.sqrt(descriminant)) / 2*a;
    root2= (-b -Math.sqrt(descriminant)) / 2*a;
}
else if(descriminant==0){
  root1 = root2 = -b /(2*a);
}
else{
    let realPart=(-b/(2*a));
    let imaginaryPart=Math.sqrt(-descriminant)/(2*a);
}
console.log(`root1 of the equation are ${root1} and ${root2}`);
alert(`root1=`+root1);
alert(`root2=`+root2);
