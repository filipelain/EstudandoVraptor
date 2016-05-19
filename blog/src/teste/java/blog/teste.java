package blog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.blog.model.Postagem;

public class teste {

	
	public static void main(String[] args) {
		
		Postagem postagem = new Postagem();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		String d = "21/12/2015";
		System.out.println(d+"\n");
		try {
			c.setTime((dateFormat.parse((d))));
		} catch (Exception e) {}
			postagem.setDataPost(c);
			c = null;
			c=postagem.getDataPost();
			String de = dateFormat.format(c.getTime());
			System.out.println(d);
	}
}
