var HorasPagar=0;
var HorasExtras=0;
var Extras=0;
var Pagar=0;

function validarn(e){
    var teclado = (document.all)?e.keycode:e.which;
    if(teclado==8)return true;

    var patron= /[0-9\d .]/;
    var prueba= String.fromCharCode(teclado);
    return patron.test(prueba);
}
function CalcuEx(){
    var hr=document.formulario.ht.value;
    var result=parseInt(hr);
    var sueldB= document.formulario.sueldoB.value;
    var result2=parseInt(sueldB);
    if(result<=40)
    total=result2*result;
    else if(result>40&&result<=48){
        HorasExtras=result - 40;
        Extras=HorasExtras*2;
        
        HorasPagar=40+Extras;
        
        Pagar=HorasPagar*result2;
        }else if(result>48){
            HorasExtras=result-48;
            Extras=HorasExtras*3;

            HorasPagar=((result-48)*3)+56;
            Pagar=(((result-48)*3)+56)*result2;
        }else
        Pagar="invalido"

    
    document.formulario.final.value="$"+Pagar;
    return Pagar;
}
function borrarI()
{
    document.formulario.final.value="";
    document.formulario.ht.value="";
    document.formulario.sueldoB.value="";
}