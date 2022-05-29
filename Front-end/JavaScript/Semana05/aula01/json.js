let a = {
    name: 'name',
    idade: 1
};

console.log(a);
console.log(typeof a);

let b = JSON.stringify(a);

console.log(b);
console.log(typeof b);

console.log('-----------------------------');

let a2 = '{"nome": "Nome", "idade": 3}';

console.log(a2);
console.log(typeof a2);

let b2 = JSON.parse(a2);

console.log(b2);
console.log(typeof b2);