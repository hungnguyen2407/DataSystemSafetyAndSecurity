package cryptography.symmetric.des;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;

public class KeyWriter {

    public static void write(Key key, String keyDes) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File(keyDes));
        fos.write(key.getEncoded());
    }
}
