function validarn(e){
    var teclado = (document.all)?e.keycode:e.which;
    if(teclado==8)return true;

    var patron= /[0-9\d .]/;
    var prueba= String.fromCharCode(teclado);
    return patron.test(prueba);
}
function CalcuComisiones(){
    var venta1= document.formulario.venta1.value;
    var venta2= document.formulario.venta2.value;
    var venta3= document.formulario.venta3.value;
    var result1= parseInt(venta1);
    var result2= parseInt(venta2);
    var result3= parseInt(venta3);
    var comisionesT= result1*.10+result2*.10+result3*.10;
    var total = comisionesT;
    document.formulario.cantidadCom.value="$"+total;
}
function CalcuTotal(){
   var sueldoB= document.formulario.sueldoB.value;
   var venta1= document.formulario.venta1.value;
    var venta2= document.formulario.venta2.value;
    var venta3= document.formulario.venta3.value;
    var result1= parseInt(venta1);
    var result2= parseInt(venta2);
    var result3= parseInt(venta3);
    var suel= parseInt(sueldoB)
    var comisionesT= result1*.10+result2*.10+result3*.10;
    var total = comisionesT;
   var sueldoT=suel+total;
   document.formulario.cantidadT.value="$"+sueldoT;

}
function borrarI()
{
    document.formulario.cantidadCom.value="";
    document.formulario.cantidadT.value="";
    document.formulario.venta1.value="";
    document.formulario.venta2.value="";
    document.formulario.venta3.value="";
}