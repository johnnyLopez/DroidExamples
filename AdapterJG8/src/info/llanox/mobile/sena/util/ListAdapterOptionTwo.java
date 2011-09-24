package info.llanox.mobile.sena.util;

import info.llanox.mobile.sena.R;
import info.llanox.mobile.sena.model.Data;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Esta clase es un adaptador que nos permite pintar
 * cada item de un ListView de la forma que mejor queramos.
 * 
 * Aqu� el m�todo getView es invocado por el proceso de renderizado
 * de las vistas de Android, por cada dato que haya sido pasado
 * por par�metro.
 * 
 * Para entenderlo mejor piensen en lo siguiente, un escritor puede ser muy
 * h�bil describiendo paisajes usando las palabras pero a veces
 * los libros requieren de ilustraciones, para ello la editorial contrata
 * a un pintor para que basado en la narraci�n del escritor trate de 
 * dibujar lo que �l escribio.
 * 
 * La editorial lo �nico que hace es pasarle la descripci�n de cada
 * uno de los paisajes a dibujar y p�ginas con un formato definido para que
 * el pintor pinte sobre ellas y les devuelva cada hoja despu�s de pintada.
 * 
 * La editorial es el framework android que llama el m�todo getView del adaptador del componente
 * que se esta pintando, el adaptador es el pintor contratado en esta ocaci�n para dibujar 
 * las ilustraciones. Y la  p�gina con formato es el xml que define cada item de la lista.   
 * 
 * @author J.Gabriel G. - llanox
 * **/

public class ListAdapterOptionTwo extends ArrayAdapter<Data>{
    //Lista que contiene objetos de tipo Data
	private List<Data> info;
	//Arreglo de colores disponibles a ser mostrados al azar. 
	private int colors[] ={Color.BLUE,Color.BLACK,Color.CYAN,Color.DKGRAY,Color.GRAY,Color.GREEN,Color.LTGRAY,Color.MAGENTA,Color.RED,Color.WHITE,Color.YELLOW};
	
	public ListAdapterOptionTwo(Context context,int idView, List<Data> info) {
		super(context,  idView, info);
		this.info = info;
		
	}

	
	public View  getView(int position, View convertView, ViewGroup parent) { 
		 
		   
		   View v = convertView;
           if (v == null) {
        	   //Aqu� inflamos el layout xml que representa cada item de la lista
        	   // Inflar significa aca que obtenemos un objeto java que representa el
        	   // layout inflado
               LayoutInflater vi = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               v = vi.inflate(R.layout.item_data, null);
           }
           
           //Traemos el textView del item_data que hemos inflado
           TextView tv = (TextView) v.findViewById(R.id.dataContent);
           
           //verificamos si es par, entonces le aplicamos un color aleatorio
           if( position%2 == 0)
        	   tv.setTextColor(randomColor());
           
           //Obtonemos un objeto data  que corresponda a la posici�n indicada el cual contiene la fecha
           //a ser mostrada
           Data data = info.get(position);
           
           // con el  + estamos concatenando la representaci�n en string de Date
           // con un string vac�o. Esto lo hice para obligar al objeto Date 
           // a mostrar su representaci�n en string y colocarla en el textView
           Date date = data.getActualDate();
           
           tv.setText(date +"");
           
     
		
		return v;
	}


	//Permite seleccionar un color identificado con un entero
	//que se encuentra en un arreglo inicialmente definido
	private int randomColor() {
		Random ran = new Random();
		int n  = colors.length;
		//me devuelve un n�mero al azar entre 0 y n
		int selected = ran.nextInt(n);
		
		return colors[selected];
	}
}
