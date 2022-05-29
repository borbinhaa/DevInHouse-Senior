// Só é possivel armazenar string

localStorage.setItem('idade', 12);
localStorage.setItem('Name', 'pedro');

console.log(localStorage.length);

console.log(localStorage.getItem('idade'));

localStorage.sobrenome = "Faria";

localStorage.removeItem('idade');

console.log(localStorage);

localStorage.clear();

console.log(localStorage);