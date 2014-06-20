package biblioteca_queue_message;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

public class Queue_message {

	public static Boolean enviar(String message) throws Exception {
		
		if(message == null || message.isEmpty()){
			System.out.println("Digite uma mensagem.");
			return false;
		}
		
		long tamanhoMaximoMensagem = 64000;
		if(message.length() > tamanhoMaximoMensagem){
			System.out.println("O tamanho máximo da mensagem é de 64 KB.");
			return false;
		}
		
		HttpClient client = new HttpClient();
		client.getParams().setParameter("http.useragent", "Test Client");

		BufferedReader br = null;

		PostMethod method = new PostMethod(
				"http://queuegeovane.appspot.com/..");
		method.addParameter(new NameValuePair("msg", message));

		try {
			int returnCode = client.executeMethod(method);

			if (returnCode == HttpStatus.SC_NOT_IMPLEMENTED) {
				System.err
						.println("The Post method is not implemented by this URI");
				method.getResponseBodyAsString();
				return false;
			} else {
				br = new BufferedReader(new InputStreamReader(
						method.getResponseBodyAsStream()));
				String readLine;
				while (((readLine = br.readLine()) != null)) {
					System.err.println(readLine);
				}
				return true;
			}
		} catch (Exception e) {
			System.err.println(e);
			return false;
		} finally {
			method.releaseConnection();
			if (br != null)
				try {
					br.close();
				} catch (Exception fe) {
					fe.printStackTrace();
				}
		}
	}
	
	public static String receber(String message) throws Exception {
		
		if(message == null || message.isEmpty()){
			System.out.println("Digite uma mensagem.");
			return null;
		}
		
		long tamanhoMaximoMensagem = 64000;
		if(message.length() > tamanhoMaximoMensagem){
			System.out.println("O tamanho máximo da mensagem é de 64 KB.");
			return null;
		}
		
		HttpClient client = new HttpClient();
		client.getParams().setParameter("http.useragent", "Test Client");

		BufferedReader br = null;

		PostMethod method = new PostMethod(
				"http://queuegeovane.appspot.com/..");
		method.addParameter(new NameValuePair("msg", message));

		try {
			int returnCode = client.executeMethod(method);
			

			if (returnCode == HttpStatus.SC_NOT_IMPLEMENTED) {
				System.err
						.println("The Post method is not implemented by this URI");
				method.getResponseBodyAsString();
				return null;
			} else {
				br = new BufferedReader(new InputStreamReader(
						method.getResponseBodyAsStream()));
				String readLine;
				while (((readLine = br.readLine()) != null)) {
					System.err.println(readLine);
				}
				return readLine;
			}
		} catch (Exception e) {
			System.err.println(e);
			return null;
		} finally {
			method.releaseConnection();
			if (br != null)
				try {
					br.close();
				} catch (Exception fe) {
					fe.printStackTrace();
				}
		}

	}
	
}
