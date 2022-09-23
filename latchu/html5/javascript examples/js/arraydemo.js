let daily_activities =['sleep','eat','work'];
let new_routine=['exercise'];

//sorting an Array
daily_activities.sort();
console.log(daily_activities);

//find position of a string
const position=daily_activities.indexOf('work');
console.log(position);

//concate to arrays
const newDailyRoutine=daily_activities.concat(new_routine);
console.log(newDailyRoutine);

console.log(daily_activities[2]);

//add new element
daily_activities[3]='learn';
console.log(daily_activities);

//add element using push
daily_activities.push('music');
console.log(daily_activities);

//unshift add begining 
daily_activities.unshift('cook');
console.log(daily_activities);

//shift remove first element
const firstElement=daily_activities.shift();
console.log(daily_activities);

//lastelement remove
const lastElement=daily_activities.pop();
console.log(daily_activities);

//creating array
let games=new Array(10);

