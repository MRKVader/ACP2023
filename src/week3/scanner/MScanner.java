package week3.scanner;

import java.io.*;

public class MScanner implements Closeable {

    private final static int DEFAULT_BUFFER_CAPACITY = 8192;
    private Reader reader;
    private StringBuilder stringBuilder = new StringBuilder();
    private String delimiter = " ";
    private Integer initBuffer;

    public MScanner (InputStream inputSource){reader = new InputStreamReader(inputSource);
    }

    public MScanner(File fileName) throws FileNotFoundException {
        reader = new InputStreamReader(new FileInputStream(fileName));
        readSrteam();
    }

    private void readSrteam() {
        stringBuilder = new StringBuilder();

        char[] buff = new char[DEFAULT_BUFFER_CAPACITY];

        try{
            reader.read(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stringBuilder.append(buff);
    }

    public String nextLine(){
        if (!hasNext()){
            readSrteam();
        }
        String out = stringBuilder.substring(0, stringBuilder.indexOf("\n")-1);
        stringBuilder.delete(0, stringBuilder.indexOf("\n")+1);
        return out;
    }

    private String next() {
        if (!hasNext()){
            readSrteam();
        }
        String out = "";
        try{
            out = stringBuilder.substring(0, stringBuilder.indexOf(delimiter));
            stringBuilder.delete(0, stringBuilder.indexOf(delimiter)+1);
        } catch (StringIndexOutOfBoundsException e) {
            out = stringBuilder.substring(0, stringBuilder.indexOf("\n"));
            stringBuilder.delete(0, stringBuilder.indexOf("\n"));
        }
        return out;
    }

    public void useDelimiter (String newDelimiter) {delimiter = newDelimiter;}

    private int nextInt(){
        if(initBuffer != null){
            int out = initBuffer;
            initBuffer = null;
            return out;
        }
        return Integer.parseInt(next());
    }

    private boolean hasNext() {
        return !(stringBuilder.length() == 0 || stringBuilder.charAt(0) == '\u0000');
    }

    public boolean hasInt(){
        try{
            initBuffer = Integer.parseInt(next());
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public void reset( ){stringBuilder = new StringBuilder();}


    @Override
    public void close() throws IOException {

    }
}
