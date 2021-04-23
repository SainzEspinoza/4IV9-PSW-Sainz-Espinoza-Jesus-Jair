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
    if(result==result2){
        resultado=result2*result;
    }else if(result>result2){
        resultado=result-result2;
    }else{
        resultado=result+result2;
    }
    document.formulario.resultadoF.value=resultado;
    return resultado;
}
function borrarI()
{
    document.formulario.num1.value="";
    document.formulario.num2.value="";
    document.formulario.resultadoF.value="";
}