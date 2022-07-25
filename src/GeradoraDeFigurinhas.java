import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
public class GeradoraDeFigurinhas {
    

    public void criar (InputStream inputStream, String nomeArquivo) throws Exception {
            // leitura da imagem
            //InputStream inputStream = new FileInputStream(new File("entrada/filme-maior.jpg"));
            // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMTc5NTk2OTU1Nl5BMl5BanBnXkFtZTcwMDc3NjAwMg@@.jpg").openStream();
             BufferedImage imageOriginal = ImageIO.read(inputStream);
            
             //criar nova imagem com transparencia e com tamanho novo
            int largura = imageOriginal.getWidth();
            int altura = imageOriginal.getHeight();
            int novaAltura = altura + 200 ;

            BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);


            //copiar a imagem original para nova imagem (em memória)
            Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
            graphics.drawImage(imageOriginal, null, 0, 0);


            //configurar a fonte
            var fonte = new Font(Font.SANS_SERIF,Font.BOLD, 40);
            graphics.setColor(Color.WHITE);
            graphics.setFont(fonte);

            //escrever uma frase na nova imagem

            graphics.drawString("Assista esse filme", 100, novaAltura - 100);

            //escrever a nova imagem em um arquivo

            ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

    

}
