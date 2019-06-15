package ExercicioArquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//Ler o caminho de um arquivo CSV
//Cada item possui Nome, quantidade e preço.
//Gerar novo arquivo em subpasta "out"
//Arquivo "summary.csv"
//Contendo nome e valor total (qtd * preco)


public class Program {

	public static void main(String[] args) throws IOException {

		/* Definir uma string caminho. BufferedReader para ler esse caminho - armazenar cada linha num vetor separado por "split" */

		List<Produto> lista = new ArrayList<>();
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Entre com o caminho do arquivo CSV: ");
		String path = sc.nextLine();
		File f = new File(path);
		String parentpath = f.getParent();		
		new File(parentpath + "\\out").mkdir();
		String targetFileStr = parentpath + "\\out\\summary.csv";



		try(BufferedReader br = new BufferedReader(new FileReader(path)))
		{
			String line = br.readLine();


			while(line != null)
			{

				String[] v = line.split(";");
				String name = v[0];
				double price = Double.parseDouble(v[1]);
				int qtd = Integer.parseInt(v[2]);

				Produto p = new Produto(name,price,qtd);

				lista.add(p);

				line = br.readLine();

			}


			try(BufferedWriter bw = new BufferedWriter (new FileWriter(targetFileStr)))
			{
				for(Produto p : lista)
				{
					bw.write(p.getNome() + "," + " " + p.sum());
					bw.newLine();
				}
			}catch(IOException e)
			{
				System.out.println("Erro ao escrever " + e.getMessage());
			}
		}catch(IOException e)
		{
			System.out.println("Erro ao ler " + e.getMessage());
		}

		sc.close();


	}
}
