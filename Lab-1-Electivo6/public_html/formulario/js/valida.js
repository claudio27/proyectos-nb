	      function valida()
	         { 
	         
	         var tamNom = document.getElementById('idNombre').value;
	         var tamCla = document.getElementById('idClave').value;
	         nom=document.getElementById('idNombre');
		     cla=document.getElementById('idClave');
			 if (nom.value=="" || tamNom.length < 6||  cla.value=="" || tamCla.length < 6)
			   { window.alert("Los campos nombre y clave deben tener al menos 6 caracteres");
			   
			   return false;
			   }else{
			   
			   return true;
			   }
			 
		   
		   
		   }
	 
