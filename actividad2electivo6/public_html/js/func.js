
function valida(f) {
    nom = f['idNombre'];
    ing = f['chIngre[]'];
    tip = f['rdTipo'];
    beb = f['bebida'];
    ali = f['alitas'];

    mje = '';
    mje1 = '';
    // para contar los ingredientes
    selec = 0;
    x = 0;
    suma = 0;
    sw = true;

    for (i = 0; i < tip.length; i++)
    {
        if (tip[i].checked)
        {
            tipo = tip[i].value;
        }
    }

    switch (tipo)
    {
        case "Individual":
            valor = 1500;
            break;
        case "Mediana":
            valor = 3000;
            break;
        case "Familiar":
            valor = 5000;
            break;
    }

    suma += valor;


    if (nom.value === "")
    {
        sw = false;
        mje += "El campo Nombre está vacío";
      pinta(nom);
    }
    else {
       limpia(nom);
        mje1 += "Pizza " + tipo + " a Nombre de : " + nom.value +
                "\n Ingredientes\n:";
    }

    while (x < ing.length)
    {
        if (ing[x].checked)
        {
            mje1 += "\n" + ing[x].value;
            selec++; // para contar los ingredientes


        }
        x++;
    }
    // errores en la seleccion de ingredientes
    if (selec === 0 || selec > 4)
    {
        mje += "\n Debe corregir la selección de ingredientes (Máx. 4)";
        sw = false;
    }

    suma += beb.value * 1500;
    suma += ali.value * 2000;

    mje1 += "\nEl total a pagar es: " + suma;

    if (sw)
    {
        alert(mje1);
    } else
    {
        alert(mje); // error
    }

    return sw;
}

function pinta(obj)
{
    obj.className = "Error";
}

function limpia(obj)
{
    obj.className = "noError";
}


