package projetSocket;

import java.io.*;
import java.net.*;

public class EchoServer {
	private static ServerSocket serveur;

	public static void main(String[] args)
	{
		try	{
			serveur = new ServerSocket(3000);}
		catch (Exception err){
			System.out.println(err);}
		
		try
		{
			while (true)
			{
				Socket client = serveur.accept();
				BufferedReader r = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter w = new PrintWriter(client.getOutputStream(), true);
				w.println("bienvenue sur le Serveur Echo.  tapez 'bye' pour fermer.");
				String line;
				do
				{
					line = r.readLine();
					if ( line != null )
						w.println("Got: "+ line);
				}
				while ( !line.trim().equals("bye") );
				client.close();
			}
		}
		catch (Exception err)
		{
			System.err.println(err);
		}
		

	}

}