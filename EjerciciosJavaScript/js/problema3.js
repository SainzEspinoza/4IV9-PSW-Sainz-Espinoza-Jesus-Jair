function validarn(e){
    var teclado = (document.all)?e.keycode:e.which;
    if(teclado==8)return true;

    var patron= /[0-9\d .]/;
    var prueba= String.fromCharCode(teclado);
    return patron.test(prueba);
}
function CalcuDesc(){
    var valor= document.formulario.cantidad.value;
    var result= parseInt(valor);
    var desc= result * 0.15;
    var total = result-desc;
    document.formulario.cantidadi.value="$"+total;
}
function borrarI()
{
    document.formulario.cantidadi.value="";
    document.formulario.cantidad.value="";
}