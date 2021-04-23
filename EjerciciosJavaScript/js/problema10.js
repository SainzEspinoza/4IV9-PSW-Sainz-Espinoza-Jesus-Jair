function validarn(e){
    var teclado = (document.all)?e.keycode:e.which;
    if(teclado==8)return true;

    var patron= /[0-9\d]/;
    var prueba= String.fromCharCode(teclado);
    return patron.test(prueba);
}
function CalcuUti(){
    var sueldobase= document.formulario.sueldoB.value;
    var result= parseInt(sueldobase);
    var anti=document.formulario.antiguedad.value;
    var result2=parseInt(anti)
    
    if(result2<1)
        ultilidad=result*.05;
    else if(result2>=1&&result2<2)
        ultilidad=result*.07;
    else if(result2>=2&&result2<5)
        ultilidad=result*.10;
    else if(result2>=5&&result2<10)
        ultilidad=result*.15;
    else
        ultilidad=result*.20;
    document.formulario.cantidadi.value="$"+ultilidad;
}
function borrarI()
{
    document.formulario.cantidadi.value="";
    document.formulario.sueldoB.value="";
    document.formulario.antiguedad.value="";
}