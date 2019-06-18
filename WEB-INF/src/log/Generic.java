package log;

import java.io.File;
import java.io.FileWriter;
import java.security.MessageDigest;


public class Generic {
    /** Name of this class */
    private final static String classname = "Utils.Generic";

    /** File in cui scrivere i log */
    static String logFileName = "/tmp/log.txt";

    /**
     * Scrive i dati in input sul file di log Generico (se questo esiste valido)
     *
     * @param type Tipo di log
     * @param data Testo del log
     */
    public static void log(String type, String from, String data){
        writeLogOn(logFileName,"Type: "+type+"\nFrom: "+from+"\nMessage: "+data);
    }

    /**
     * Scrive i dati in input sul file passato come parametro
     *
     * @param f nome del file
     * @param data dati
     */
    private static void writeLogOn(String f, String data){
        File ff = new File(f);
        try{
            if(ff.exists()){
                ff.setReadable(true);
                ff.setWritable(true);
            }
        }catch(Exception e){}
        try{
            FileWriter fr = new FileWriter(f,ff.exists());
            fr.write("\n***** "+new java.util.Date()+" *****\n"+data+"\n\n");
            fr.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }

    /**
     * Converte un array di byte in una stringa esadecimale
     *
     * @param data [] dati
     * @return String dati in forma esadecimale
     */
    private static String convertToHex(byte[] data){
        final String funcname = "convertToHex";
        try
        {
            StringBuffer buf = new StringBuffer();
            for (int i = 0; i < data.length; i++) {
                int halfbyte = (data[i] >>> 4) & 0x0F;
                int two_halfs = 0;
                do {
                    if ((0 <= halfbyte) && (halfbyte <= 9))
                        buf.append((char) ('0' + halfbyte));
                    else
                        buf.append((char) ('a' + (halfbyte - 10)));
                    halfbyte = data[i] & 0x0F;
                } while(two_halfs++ < 1);
            }
            return buf.toString();
        }
        catch(Exception e){
            log("Error",classname+"."+funcname,e+"");
            return "";
        }
    }

    /**
     * Converte una stringa nel corrispondente HASH SHA-1 in forma esadecimale
     * @param text dati
     * @return String Hash SHA-1 dei dati in forma esadecimale
     */
    public static String hash_sha(String text){
        final String funcname = "hash_sha";
        try
        {
            MessageDigest md;
            md = MessageDigest.getInstance("SHA-1");
            byte[] sha1hash = new byte[40];
            md.update(text.getBytes("iso-8859-1"), 0, text.length());
            sha1hash = md.digest();
            return convertToHex(sha1hash).toUpperCase();
        }
        catch(Exception e){
            log("Error",classname+"."+funcname,e+"");
            return "";
        }
    }

}

