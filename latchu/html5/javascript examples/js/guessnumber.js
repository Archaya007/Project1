function guessnumber(){
    //generate a random from 1 to 10
    const randomNumber=Math.floor(Math.random()*10)+1;
    alert(randomNumber);
    //get a value from the user
    let number=prompt('gusee a number 1 to 10');
    if(number==randomNumber){
        alert('You guess the right NUmber');
    }
    else{
        alert('Better luck next time');
    }
    
}