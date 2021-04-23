//vamos a tener que obtener los valores de los input

function problema1(){
    var p1_input = document.querySelector('#p1-input').value;

    /*
    tenemos que identificar el espacio
    tenemos que invertir la cadena
    hola como
    como hola
    */ 

    var p1_array = p1_input.split(' ').reverse();

    //contruir una nueva cadena a partir del array invertido

    //comohola

    var p1_res = '';

    p1_array.forEach(function (palabra, i){
        //si estamos al princio o final de la palabra
        // como hola 
        if(i != 0 || i != p1_array.length) p1_res += ' ';
        p1_res += palabra;
    });

    document.querySelector('#p1-output').textContent = p1_res;
}

function problema2(){
    /*
    Para encontrar el minimo producto escalar entre 2 vectores, tenemos que realizar
    las operaciones correspondientes que son el maximo valor de un vector por
    el minimo vector del otro valor 
    
    */ 

    var p2_x1 = document.querySelector('#p2-x1').value;
    var p2_x2 = document.querySelector('#p2-x2').value;
    var p2_x3 = document.querySelector('#p2-x3').value;
    var p2_x4 = document.querySelector('#p2-x4').value;
    var p2_x5 = document.querySelector('#p2-x5').value;

    var p2_y1 = document.querySelector('#p2-y1').value;
    var p2_y2 = document.querySelector('#p2-y2').value;
    var p2_y3 = document.querySelector('#p2-y3').value;
    var p2_y4 = document.querySelector('#p2-y4').value;
    var p2_y5 = document.querySelector('#p2-y5').value;

    //contruir el vector
    var v1 = [p2_x1, p2_x2, p2_x3, p2_x4, p2_x5];
    var v2 = [p2_y1, p2_y2, p2_y3, p2_y4, p2_y5];

    //ordenar los elementos del vector

    v1 = v1.sort(function (a, b){
        return b-a;
    });

    v2 = v2.sort(function (a, b){
        return b-a;
    });

    //invertir el vector
    v2 = v2.reverse();

    //producto
    var p2_producto = 0;

    for(var i = 0; i < v1.length; i++){
        p2_producto += v1[i]*v2[i];
    }

    document.querySelector('#p2-output').textContent = 'Producto escalar minimo :' + p2_producto;


}

/*
problema 3
primero mi alfabeto a - z
identificar la coma   varible.split(',')
eliminar los espacios   
habia, un, patito, que, decia, miau, miau
4 (h, a, b, i)
2 (u, n)
5 (p, a, t, i, o)
variable que se encargue de iterar la palabra
guardando los caracteres unicos
un bucle dentro de otro bucle
wiiiiiiiiiiiiiiii uwu/
*/

function problema3(){
    var p3_input = document.querySelector('#p3-input').value;
    var p3_array = p3_input.split(',').reduce((acc, val) => acc.length > val.length ? acc : val, '');
    var p3_respuesta="";
    
    let texto1 =  p3_array; 
    let texto2 =  
    texto1.split(" ").join(""); 

    for (var x = 0; x < texto2.length; x++) {
        var char = texto2.charAt(x);
        if (p3_respuesta.indexOf(char) == -1 || char == ' ') {
            p3_respuesta += texto2[x];
        }
    }
    p3_respuesta_mayus = p3_respuesta.toUpperCase().match(/.{1,1}/g);
    p3_final = p3_respuesta_mayus.join(", ");
    document.querySelector('#p3-output').textContent = p3_final;
}
function SoloLetras(e){
    key = e.keyCode || e.which;
    var teclado = String.fromCharCode(key);
    var letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ, "
    var especiales = "8-37-38-46-164";
    var teclado_especial = false;
    for(var i in especiales){
        if(key==especiales[i]){
            teclado_especial = true;break;
        }
    }
    if(letras.indexOf(teclado)==-1 && !teclado_especial){
        return false;
    }
}