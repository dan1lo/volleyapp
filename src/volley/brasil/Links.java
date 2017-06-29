package volley.brasil;


import volley.brasil.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Links extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.links);
		
		final String[] menuLinks = new String[]{
			"Melhor do volei","CBV", "Globo Esporte", "Volei para sempre","FIBV"
			
		};
		 ListView listview = (ListView) findViewById(R.id.Lv_links);
	     listview.setAdapter(	new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, menuLinks));
	     listview.setOnItemClickListener(new OnItemClickListener(){
	  	   public void onItemClick(AdapterView<?> parent, View view, int position,
	  			long id) {
	  		String url;
	  		Uri uri;
	  		
	  		switch (position) {
	  		case 0:
	  			url = "http://www.melhordovolei.com.br/"; //findViewById(R.string.lbl_orkut).toString();
	  			uri = Uri.parse(url);
	  			Intent itOrkut = new Intent(Intent.ACTION_VIEW,uri);
	  			startActivity(itOrkut);
	  			
	  			break;
	  		case 1:
	  			url = "http://www.cbv.com.br";
	  			uri = Uri.parse(url);
	  			Intent itForum = new Intent(Intent.ACTION_VIEW,uri);
	  			startActivity(itForum);
	  			break;
	  		case 2:
	  			url = "http://globoesporte.globo.com/volei/";
	  			uri = Uri.parse(url);
	  			Intent itBlog = new Intent(Intent.ACTION_VIEW,uri);
	  			startActivity(itBlog);
	  			break;
	  		case 3:
	  			url = "http://www.volei.org/";
	  			uri = Uri.parse(url);
	  			Intent itMeusport = new Intent(Intent.ACTION_VIEW,uri);
	  			startActivity(itMeusport);
	  			break;
	  		case 4:
	  			url = "http://www.fivb.org/";
	  			uri = Uri.parse(url);
	  			Intent itSport = new Intent(Intent.ACTION_VIEW,uri);
	  			startActivity(itSport);
	  			break;
	  		default:
	  			break;
	  		}
	  	}
	  	});
	  	}
		
		
/*		TextView lbl_sportnet = (TextView)findViewById(R.id.lbl_sportnet);
		TextView lbl_sportclub = (TextView) findViewById(R.id.lbl_sportclub);
		TextView lbl_blogTorcedor = (TextView) findViewById(R.id.lbl_blogtorcedor);
		TextView lbl_meusport = (TextView) findViewById(R.id.lbl_meusport);
		TextView lbl_sportoficial = (TextView) findViewById(R.id.lbl_sportoficial);
		
		
		Linkify.addLinks(lbl_sportnet, Linkify.WEB_URLS);
		Linkify.addLinks(lbl_sportclub, Linkify.WEB_URLS);
		Linkify.addLinks(lbl_blogTorcedor, Linkify.WEB_URLS);
		Linkify.addLinks(lbl_meusport, Linkify.WEB_URLS);
		Linkify.addLinks(lbl_sportoficial,Linkify.WEB_URLS);*/
		
	}
	

