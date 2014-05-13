/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package labhamming;

public class Hamming {



	public Hamming(){

	}
	public int calculaUnos(String bin, int sec[]){

		int retorno=0;
		for(int i=0;i<sec.length;i++){

			if(bin.subSequence(sec[i], sec[i+1]) =="1"){
				retorno++;
			}
			i++;
		}
		return retorno;
	}
	public char calculaParUno(String bin){
		char binHamming;
		int num_unos;
		int secuencia[]={0,1,1,2,3,4,4,5,6,7};

		num_unos=calculaUnos(bin,secuencia);
		if(num_unos%2==0){
			binHamming='0';
		}else{
			binHamming='1';
		}
			return binHamming;
	}

	public char calculaParDos(String bin){
		char binHamming;
		int num_unos;
		int secuencia[]={0,1,2,3,3,4,5,6,6,7};

		num_unos=calculaUnos(bin,secuencia);
		if(num_unos%2==0){
			binHamming='0';
		}else{
			binHamming='1';
		}

		return binHamming;

	}

	public char calculaParCuatro(String bin){
		char binHamming;
		int num_unos;
		int secuencia[]={1,2,2,3,3,4};

		num_unos=calculaUnos(bin,secuencia);
		if(num_unos%2==0){
			binHamming='0';
		}else{
			binHamming='1';
		}

		return binHamming;
	}


	public char calculaParOcho(String bin){
		char binHamming;
		int num_unos;
		int secuencia[]={4,5,5,6,6,7};

		num_unos=calculaUnos(bin,secuencia);
		if(num_unos%2==0){
			binHamming='0';
		}else{
			binHamming='1';
		}

		return binHamming;
	}



public String transformarCaracter(String caracterbin){

		char car[]=new char[11];
		char binCaracter[]=caracterbin.toCharArray();
		int b=1;
		int c=0;
		String union="";
		for(int i=1;i<car.length;i++){

			if(i+1 == 2*b){
			b=b*2;
			}else{
				car[i]=binCaracter[c];
				c++;
			}
		}
		car[0]=calculaParUno(caracterbin);
		car[1]=calculaParDos(caracterbin);
		car[3]=calculaParCuatro(caracterbin);
		car[7]=calculaParOcho(caracterbin);


		for(int i=0;i<car.length;i++){
			union=union+car[i];
			//System.out.print(car[i]);
		}

		return union;

}
	public String[] transformarCadena(String binario[]){
		String binHamming[]=new String[binario.length];

		System.out.print("Pasando a Hamming....\n");
		System.out.println("Binario\t\tBinarioHamming\n");
		for(int i=0;i<binario.length;i++){
			System.out.print(binario[i]+"\t\t");
			binario[i]=transformarCaracter(binario[i]);
			System.out.println(binario[i]);
		}
                System.out.println("OK");

		binHamming=binario;
		return binHamming;
	}

}