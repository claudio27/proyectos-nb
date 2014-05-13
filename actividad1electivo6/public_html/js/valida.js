function valida()
{
    nom = document.getElementById('idNombre');
    cla = document.getElementById('idClave');
    if (nom.value == "" || cla.value == "")
    {
        window.alert("Existe uno de los campos vacíos");
        if(nom.value ===""){pinta(nom);}
        if(cla.value === ""){pinta(cla);}
        return false;
    }
    else if (nom.value.length < 6 || cla.value.length < 6
            || nom.value == cla.value)
    {
        window.alert("Nombre y Clave deben tener más de 6 caracteres\ny no ser iguales");
        return false;

    } else {

        return true;
    }
}

function pinta(obj)
{
    obj.className = "Error";
}

function limpia(obj)
{
    obj.className = "noError";
}