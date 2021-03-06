import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lirona on 15/04/2017
 **/
public class Encryption {

    private final int bufferSize = 10;
    private Map<Character, Character> key;
    private FileInputStream plainText;
    private byte[] buffer;
    private byte[] IV;

    public boolean encryptCBC(String plainText, String IV, String key, String output){
        try{
            openText(plainText);
            initIV(IV);
            initKey(key);

            buffer = new byte[bufferSize];
            while (-1 != this.plainText.read(buffer)) {

            }

            return true;
        }catch(Exception ex){
            //TODO: Handle exception
        }



    }

    private void openText(String path){
        try{
            this.plainText = new FileInputStream(path);
        }catch(Exception ex){
            //TODO: Handle file not found
        }
    }

    private void initIV(String path){
        try{
            this.IV = new byte[10];
            FileInputStream inputStream = new FileInputStream(path);
            inputStream.read(this.IV);
        }catch (Exception ex){
            //TODO: Handle file not found
        }
    }

    private void initKey(String path){
        this.key = new HashMap<Character, Character>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String s;
            while((s = reader.readLine()) != null){
                String[] var = s.split(" ");
                if (2 == var.length){
                    this.key.put(new Character(var[0].charAt(0)), new Character(var[1].charAt(0)));
                }
                else{
                    //TODO: Handle wrong key
                }
            }

        }catch(Exception ex){
            //TODO: Handle file not found
        }
    }
}
