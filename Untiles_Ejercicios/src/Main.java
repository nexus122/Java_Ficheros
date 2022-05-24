import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner read = new Scanner(System.in);
        System.out.print("Escribe la ruta de la carpeta: ");
        String rutaIn = read.next();

        File fichero  = new File("C:\\Users\\formación\\Desktop\\listado.txt");
        PrintWriter pw = new PrintWriter(fichero);

        listar(rutaIn, pw);

        pw.close();
    }
    public static void listar(String directorio, PrintWriter pw){
        File dir = new File(directorio);
        String[] ficheros = dir.list();

        if(ficheros == null){
            System.out.println("No hay ficheros en "+directorio);
        }else{
            for(int x=0; x<ficheros.length; x++){
                File pepe = new File(directorio+"\\"+ficheros[x]);
                if(pepe.isDirectory()) {
                    System.out.println("<DIR> " + ficheros[x]);
                    pw.println("<DIR> " + ficheros[x]);
                    listar(directorio+"\\"+ficheros[x], pw);
                }
                else {
                    System.out.println("<FILE> " + ficheros[x]);
                    pw.println("<File> " + ficheros[x]);
                }
            }
        }
    }
}
