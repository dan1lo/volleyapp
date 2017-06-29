package volley.brasil;




import android.app.Activity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

public class Contato extends Activity {
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contato);
        TextView lbl_email = (TextView) findViewById(R.id.lbl_mail);
        Linkify.addLinks(lbl_email, Linkify.EMAIL_ADDRESSES);
		
		
		
	}

}
