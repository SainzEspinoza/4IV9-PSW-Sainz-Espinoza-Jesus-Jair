function validarn(e){
    var teclado = (document.all)?e.keycode:e.which;
    if(teclado==8)return true;

    var patron= /[0-9\d .]/;
    var prueba= String.fromCharCode(teclado);
    return patron.test(prueba);
}
function calcular(){
    var numero1= document.formulario.num1.value;
    var result= parseInt(numero1);
    var numero2=document.formulario.num2.value;
    var result2= parseInt(numero2);
    var numero3=document.formulario.num3.value;
    var result3=parseInt(numero3)
    if(result>result2&&result>result3){
        mayor=result;
    }else if(result2>result&&result2>result3){
        mayor=result2;
    }else if(result3>result&&result3>result2){
        mayor=result3;
    }
    else{
        mayor="Numeros iguales";
    }
    document.formulario.resultadoF.value=mayor;
    return mayor;
}
function borrarI()
{
    document.formulario.num1.value="";
    document.formulario.num2.value="";
    document.formulario.num3.value="";
    document.formulario.resultadoF.value="";
}