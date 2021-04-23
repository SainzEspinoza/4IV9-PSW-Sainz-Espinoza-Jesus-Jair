function validarn(e){
    var teclado = (document.all)?e.keycode:e.which;
    if(teclado==8)return true;

    var patron= /[0-9\d .]/;
    var prueba= String.fromCharCode(teclado);
    return patron.test(prueba);
}
function calcuPor(){
    var cantidad1= document.formulario.cantidadH.value;
    var cantidad2=document.formulario.cantidadM.value;
    var result1= parseInt(cantidad1);
    var result2= parseInt(cantidad2);
    totalA=result1+result2;
    var promF= result2 *100/ totalA;
    var promM = result1*100/totalA;
    document.formulario.cantidadh.value=promM+"%";
    document.formulario.cantidadm.value=promF+"%";
}
function borrarI()
{
    document.formulario.cantidadh.value="";
    document.formulario.cantidadm.value="";
    document.formulario.cantidadH.value="";
    document.formulario.cantidadM.value="";
}