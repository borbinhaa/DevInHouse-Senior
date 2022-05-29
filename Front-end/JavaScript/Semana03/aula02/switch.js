// let expr = prompt('Olá qual fruta você gostaria de levar?');

let expr = 'Banana';

switch (expr) {

    case 'Laranja':
        console.log('As laranjas custam 5.50/kg');
        break;
    case 'Maca':
        console.log('Maçãs custam 9/kg')
        break;
    case 'Banana':
        console.log('Banana custam 9/kg')
        break;
    case 'Mamao':
        console.log('Mamão custam 9/kg')
        break;
    default:
        console.log('Desculpa estamos sem nenhuma ' + expr + '.')
        break;
}