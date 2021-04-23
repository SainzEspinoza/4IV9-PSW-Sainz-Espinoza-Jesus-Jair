function validarF(e){
    var txt= document.fechaN.value;
    var patron= /[12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01])/;
    alert("fechaN"+(patron.test(txt)?"":"no")+"valido");
    
    return patron.test(txt);
}
function Edad(){
    var nac= document.formulario.fechaN.value;
    result1=parseInt(nac);
    var hoy=document.formulario.fechaH.value;
    result2=parseInt(hoy);
    EdadR=result2- result1;
    document.formulario.edad.value=EdadR;
}
function borrarI()
{
    document.formulario.fechaH.value="";
    document.formulario.fechaN.value="";
    document.formulario.edad.value="";
}