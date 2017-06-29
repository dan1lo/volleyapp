package volley.brasil;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import model.Item;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import volley.brasil.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class VolleyRSS extends Activity {
	public Button lerConteudoGlobo;
	public Button lerConteudoMeusport;
	public TextView cabecalho;
	public ArrayList<Item> itemList = new ArrayList<Item>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rss);
        //pegando instância do cabecalho
        cabecalho = (TextView) findViewById(R.id.TextView01);
        
        //click da listview
        final ListView listView = (ListView) findViewById(R.id.ListView01);
        listView.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				Item item = itemList.get(position);
				
				Intent intent = new Intent(Intent.ACTION_VIEW);
				
				intent.setData(Uri.parse(item.getUrl()));
				
				startActivity(intent);
			}
        	
        });
        
        
        //Button Click
        lerConteudoGlobo = (Button) findViewById(R.id.Button01);
        lerConteudoGlobo.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {			
				try {
					
					String url = "http://globoesporte.globo.com/dynamo/semantica/editorias/plantao/volei/feed.rss";
					
					DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
					DocumentBuilder db = dbf.newDocumentBuilder();
					Document doc = db.parse(url);
					
					NodeList listItem = doc.getElementsByTagName("item");

					String[] arrayTitles = new String[listItem.getLength()];
					
					for(int x = 0; x < listItem.getLength(); x++){
						
						String title = listItem.item(x).getChildNodes().item(0).getChildNodes().item(0).getNodeValue();
						
						//link
						String link = listItem.item(x).getChildNodes().item(1).getChildNodes().item(0).getNodeValue();
						
						Item item = new Item();
						
						item.setTitle(title);
						item.setUrl(link);
						
						arrayTitles[x] = item.getTitle();
						
						itemList.add(item);
					}
					

					listView.setAdapter(
							new ArrayAdapter<String>(getBaseContext(), 
									android.R.layout.simple_list_item_1, arrayTitles)
					);
					
					cabecalho.setText("RSS do - Globo Esporte");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG);
				}
				
			}
        });
        
        lerConteudoMeusport = (Button) findViewById(R.id.btn_meusport);
        lerConteudoMeusport.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {

			try {	
				
				//cabecalho.setText("RSS do Sport Recife - meu sport");
				String url = "http://feeds.feedburner.com/cbv";
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(url);
				//String url = "http://www.gazetaesportiva.net/rss/48.xml";
				
				//String url = "http://globoesporte.globo.com/dynamo/semantica/editorias/plantao/futebol/times/nautico/feed.rss";

			
				NodeList listItem = doc.getElementsByTagName("title");
				NodeList listLink = doc.getElementsByTagName("link");
				String[] arrayTitles = new String[listItem.getLength()];
				
				for(int x = 0; x < listItem.getLength(); x++){
					
					
					Element aE = (Element) listItem.item(x);
					String title = aE.getFirstChild().getNodeValue();
				
					
					Element aLink = (Element) listLink.item(x);
					String link = aLink.getFirstChild().getNodeValue();
					
					Item item = new Item();
					
					item.setTitle(title);
					item.setUrl(link);
				
					arrayTitles[x] = item.getTitle();
					
					itemList.add(item);
				}
				

				listView.setAdapter(
						new ArrayAdapter<String>(getBaseContext(), 
								android.R.layout.simple_list_item_1, arrayTitles)
				);
				
				cabecalho.setText("RSS da CBV");
			}
				
				catch (Exception e) {
					// TODO Auto-generated catch block
					Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG);
				}
				
			}
        }); 
        
    }
}