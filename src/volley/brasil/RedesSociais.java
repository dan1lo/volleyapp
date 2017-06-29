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
public class RedesSociais extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.redes);
		
		final String[] menuRedes = new String[]{
				"Orkut","Facebook", "Twitter", "Youtube"
				
			};
		
		 ListView listview = (ListView) findViewById(R.id.Lv_redes);
	     listview.setAdapter(	new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, menuRedes));
		
	 
		
		listview.setOnItemClickListener(new OnItemClickListener(){
			   public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				String url;
				Uri uri;
				
				switch (position) {
				case 0:
					url = "http://www.orkut.com.br/Main#Community?cmm=90812207";
					uri = Uri.parse(url);
					Intent itOrkut = new Intent(Intent.ACTION_VIEW,uri);
					startActivity(itOrkut);
					
					break;
				case 1:
					url = "http://www.facebook.com/confederacaobrasileiradevoleibol";
					uri = Uri.parse(url);
					Intent itFacebook = new Intent(Intent.ACTION_VIEW,uri);
					startActivity(itFacebook);
					break;
				case 2:
					url = "http://twitter.com/#!/volei";
					uri = Uri.parse(url);
					Intent itTwitter = new Intent(Intent.ACTION_VIEW,uri);
					startActivity(itTwitter);
					break;
				case 3:
					url = "http://www.youtube.com/user/melhordvolei";
					uri = Uri.parse(url);
					Intent itYoutube = new Intent(Intent.ACTION_VIEW,uri);
					startActivity(itYoutube);
					break;
				default:
					break;
				}
			}
			});
			}
	/*
	 *     findViewById(R.id.lbl_orkut);
		(TextView) findViewById(R.id.lbl_face);
		(TextView) findViewById(R.id.lbl_twitter);
		(TextView) findViewById(R.id.lbl_youtube);
		Linkify.addLinks(lbl_orkut, Linkify.WEB_URLS);
		Linkify.addLinks(lbl_face, Linkify.WEB_URLS);
		Linkify.addLinks(lbl_twitter, Linkify.WEB_URLS);
		Linkify.addLinks(lbl_youtube, Linkify.WEB_URLS);
		*/
		
	}


