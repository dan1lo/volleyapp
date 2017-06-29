package volley.brasil;



import com.google.ads.Ad;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import volley.brasil.R;

public class Menu extends Activity {
	
	private static final String[] menu = new String[]{
		"Notícias","História", "Calendário CBV", "Campeões da SuperLiga","Links","Redes Sociais do clube","Calendario da SuperLiga","Contato"
		
	};

	//intents para ir a outra pagina	
	
	
	
   //final dos intents	
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu);
		   // AdView adView = (AdView)this.findViewById(R.id.adView);
		   // adView.loadAd(new AdRequest());

	    ListView listview = (ListView) findViewById(R.id.list);
	      listview.setAdapter(	new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, menu));
	    
	      //this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu));
	      //this.setContentView(R.layout.menu);
	      
	        /*setContentView(R.layout.menu);
	        	
	        
	        //botoes da pagina
	        	Button btnHistoria = (Button)findViewById(R.id.btn_historia);
	        	Button btnNoticia = (Button)findViewById(R.id.btn_noticia);
	        	Button btnRedes = (Button)findViewById(R.id.btn_redes);
	        	Button btnPlacar = (Button)findViewById(R.id.btn_placar);
	        	Button btnContato = (Button)findViewById(R.id.btn_contato);
	        	Button btnTitulos = (Button)findViewById(R.id.btn_titulos);
	        	Button btnCampeonato = (Button) findViewById(R.id.btn_campeonatos);
	        	Button btnLinks = (Button) findViewById(R.id.btn_links);
	        	
	        	//testes
	        //final de botes da pagina	
	        	
	        //intents para ir a outra pagina	
	        	
	        	final Intent itTitulos = new Intent(this,Titulos.class);
	        	final Intent itNoticia = new Intent(this,SportRSS.class);
	        	final Intent itContato = new Intent(this,Contato.class);
	        	final Intent itRedes = new Intent(this,RedesSociais.class);
	        	//final Intent itHistoria = new Intent(this,Historia.class);
	        	//final Intent itElenco = new Intent(this,Elenco.class);
	        	final Intent itLinks = new Intent(this,Links.class);
	        	
	        //final dos intents	
	        
	        // inicio dos botoes
	        	btnNoticia.setOnClickListener(new OnClickListener(){

	    			public void onClick(View v) {
	    				
	    				startActivity(itNoticia);
	    			}
	        		
	        	
	        	});
	        	
	        	
	        	
	        	btnContato.setOnClickListener(new OnClickListener(){

	        		public void onClick(View v) {
	        			startActivity(itContato);
			
	        			}
		   
		   
	        	});
	        	
	        btnTitulos.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {
					startActivity(itTitulos);
					
				}
	        	
	        	
	        	
	        	}
	            
	        );
	        
	        
	        btnRedes.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {
					startActivity(itRedes);
					
				}
	        	
	        	
	        	
	        });
	        
	        btnPlacar.setOnClickListener(new OnClickListener(){
	        	
	        	public void onClick(View v){
	        		String url = "http://app.esporte.ig.com.br/temporeal/home.php?campeonato=brasileiroserieb2011" ;
					Uri uri = Uri.parse(url);
					Intent itPlacar = new Intent(Intent.ACTION_VIEW,uri);
					startActivity(itPlacar);
	        	}
	        	
	        });
	        
	    
        	
		       btnCampeonato.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {
					String url = "http://esporte.uol.com.br/futebol/campeonatos/brasileiro/2011/serie-b/classificacao/classificacao.jhtm" ;
					Uri uri = Uri.parse(url);
					Intent itCampeonato = new Intent(Intent.ACTION_VIEW,uri);
					startActivity(itCampeonato);
				}
		    	   
		       	});
		       
		       btnLinks.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {
					// 
					
					startActivity(itLinks);
					
				}
		    	   
		    	   
		       });
		    	
		        
		       btnHistoria.setOnClickListener(new OnClickListener(){
		        	
		        	public void onClick(View v){
		        		String url = "http://pt.wikipedia.org/wiki/Sport_Club_do_Recife" ;
						Uri uri = Uri.parse(url);
						Intent itHistoria = new Intent(Intent.ACTION_VIEW,uri);
						startActivity(itHistoria);
		        	}
		        	
		        });
		       
	        
	        
	        	
	        //final dos botoes	
	        	

	       
	      	        	
	        	
	        	
	        	
	  }*/

	    	final Intent itNoticia = new Intent(this,VolleyRSS.class);
	    	final Intent itContato = new Intent(this,Contato.class);
	    	final Intent itRedes = new Intent(this,RedesSociais.class);
	    	//final Intent itHistoria = new Intent(this,Historia.class);
	    	//final Intent itElenco = new Intent(this,Elenco.class);
	    	final Intent itLinks = new Intent(this,Links.class);
	listview.setOnItemClickListener(new OnItemClickListener(){
	   public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		String url;
		Uri uri;
		
		switch (position) {
		case 0:
			startActivity(itNoticia);
			
			break;
		case 1:
			url = "http://pt.wikipedia.org/wiki/Voleibol" ;
			uri = Uri.parse(url);
			Intent itHistoria = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(itHistoria);
			break;
		case 2:
			url = "http://www.cbv.com.br/v1/competicoes/calendario.asp" ;
			uri = Uri.parse(url);
			Intent itPlacar = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(itPlacar);
			break;
		case 3:
			url = "http://www.cbv.com.br/v1/competicoes/hist_resultados.asp" ;
			uri = Uri.parse(url);
			Intent itCampeonato = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(itCampeonato);
			break;
		case 4:
			startActivity(itLinks);
			break;
		case 5:
			startActivity(itRedes);
			break;
		case 6:
			url = "http://www.cbv.com.br/v1/superliga/superliga.asp" ;
			uri = Uri.parse(url);
			Intent itElenco = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(itElenco);
			break;
		case 7:
			startActivity(itContato);
			break;
		default:
			break;
		}
	}
	});
	
	 
	}
	
}