/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author daniel copete
 */
public class Actividad_01_UD3_ED 
{
    private static byte[] intermedia = new byte[1000]; /*Espacio reservado en la memoria que recibe el nombre de buffer pero lo ha sido modificado a intermedia */
    private static String nombreFichero = "fichero.dat"; /* Se refiere al nombre del fichero que vamos a usar en el programa ha sido refactorizado de fileName a nombreFichero*/
    private static FileInputStream flujoEntrada = null;/* variable encargada que gestiona el flujo de la entrada de datos ha sido refactorizado de inputStream a flujo de entrada*/
    private static BufferedInputStream memoriaEntrada = null; /*Se refiere al espacio de la memoria usado para optimizar la lectura de datos leyendo bloques en lugar de byte a byte*/

    public static void inicializateFiles() throws FileNotFoundException
    {
        flujoEntrada = new FileInputStream(nombreFichero);
        memoriaEntrada = new BufferedInputStream(flujoEntrada);
    }
    
    public static int showFileText() throws IOException
    {
        int total = 0;
        int nRead = 0;
        while((nRead = flujoEntrada.read(intermedia)) != -1) 
        {
            System.out.println(new String(intermedia));
            total += nRead;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializateFiles();
            
            int total = showFileText();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( memoriaEntrada != null && flujoEntrada != null )
                {
                    flujoEntrada.close();
                    memoriaEntrada.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
