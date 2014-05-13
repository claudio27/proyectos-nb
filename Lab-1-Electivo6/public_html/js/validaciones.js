/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


   function error(obj)
		 { obj.className="Error";}
		
		function noerror(obj)
            {obj.className="noError";}		
		
		
		
		
		function valida(obj,sp)
           { if(obj.value=="")
                {error(obj);
				  document.getElementById(sp).innerHTML="Campo Vacío";
				  document.getElementById(sp).style.visibility="visible";
				  return false;
				  }
              else
                 {noerror(obj);
				 document.getElementById(sp).innerHTML="";
				 document.getElementById(sp).style.visibility="hide";
				 return true;}
            }
        
        function validaTam(){
            
            nombre = document.getElementById('idNombre').value;
            apellido = document.getElementById('idApellido').value;
            asunto = document.getElementById('idAsunto').value;
            
            if(nombre.length > 3 && nombre.length < 20 && apellido.length > 3 && apellido.length < 20 
                    && asunto.length > 5 && asunto.length < 255)
            {
                return true;
                
            }else{
                window.alert('Los valores ingresados deben ser \n nombre > 3 y menor que 20 caracteres\n apellido lo mismo \n y asunto entre 5 y 255 caracteres');
                return false;
            }
            
            
            
        }





		function validarEmail(obj,sp)
		 { re=/^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,3})$/ 
   		     if(!re.exec(obj.value))    
			  {         error(obj);
				  document.getElementById(sp).innerHTML="Formato Incorrecto";
				  document.getElementById(sp).style.visibility="visible";     
				  return false;}
			  else
			  { noerror(obj);
				 document.getElementById(sp).innerHTML="";
				 document.getElementById(sp).style.visibility="hide";
				 return true;}
  	     }
 			
		function leeImagen(obj)
		{ x=document.getElementById('idImagen');
		  x.src=obj.src;
		  }
		  
		  function validaFin()
		  { nom=document.forms['fficha']['idNombre'];
		    ape=document.forms['fficha']['idApellido'];
			cor=document.forms['fficha']['idCorreo'];
			
		     if(valida(nom,'spNombre') && valida(ape,'spApellido') && valida(cor,'spCorreo') && validarEmail(cor,'spCorreo') && validaTam())
			    {return true;}
			else
                {return false;}			
		  }