/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lecturas;
import java.io.*;
/**
 *
 * @author claudio
 */


public class Filtro implements FilenameFilter{
    String extension;
    Filtro(String extension){
        this.extension=extension;
    }
    public boolean accept(File dir, String name){
        return name.endsWith(extension);
    }
}