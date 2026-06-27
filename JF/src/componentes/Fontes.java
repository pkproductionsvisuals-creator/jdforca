package componentes;

import java.awt.Font;
import java.io.InputStream;

public class Fontes {
    
    public static Font tW(float tamanho){
        try{
            InputStream is = Fontes.class.getResourceAsStream("/fonts/TW.ttf");
            Font fonte = Font.createFont(Font.TRUETYPE_FONT,is);
            return fonte.deriveFont(tamanho);
        }catch(Exception e){
            e.printStackTrace();
            return new Font("Arial", Font.PLAIN, (int) tamanho);
        }
    }

     // Fonte Inter Regular
    public static Font inter(float tamanho) {
        try {
            InputStream is = Fontes.class.getResourceAsStream("/fonts/Inter-Regular.ttf");

            Font fonte = Font.createFont(Font.TRUETYPE_FONT, is);

            return fonte.deriveFont(Font.PLAIN, tamanho);

        } catch (Exception e) {
            e.printStackTrace();
            return new Font("Arial", Font.PLAIN, (int) tamanho);
        }
    }

    // Fonte Inter Bold
    public static Font interBold(float tamanho) {
        try {
            InputStream is = Fontes.class.getResourceAsStream("/fonts/Inter-Bold.ttf");

            Font fonte = Font.createFont(Font.TRUETYPE_FONT, is);

            return fonte.deriveFont(Font.BOLD, tamanho);

        } catch (Exception e) {
            e.printStackTrace();
            return new Font("Arial", Font.BOLD, (int) tamanho);
        }
    }
}
