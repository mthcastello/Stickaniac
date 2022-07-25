import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        
        // Fazer conexão HTTP e buscar os Top 250 filmes
       // String url = "https://api.nasa.gov/planetary/apod?api_key=dWRIIMLUZO0iEm02SiRiMG1baVFLTgM3kfHtwUCa&&start_date=2022-06-12&end_date=2022-06-14";
     //  ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

       // String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
       // ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

       String url = "http://localhost:8080/linguagens";
       ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

      
      
        // Exibir e manipular os dados
       
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        var geradora = new GeradoraDeFigurinhas();
        
        for (int i = 0; i < 5; i++) {
 
            Conteudo conteudo = conteudos.get(i);

    

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo ="saida/" + conteudo.getTitulo().replace(":", "-") + ".png";
           
            geradora.criar(inputStream, nomeArquivo);
            
            System.out.println(conteudo.getTitulo());
            System.out.println();
        }


    }
}
