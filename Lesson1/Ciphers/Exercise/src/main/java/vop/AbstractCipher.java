package vop;

public abstract class AbstractCipher implements CipherInterface {

    int index;

    public int findCharIndex(char ch){
        for (int i = 0; i < ALPHABETH.length; i++) {
            if (ch == ALPHABETH[i]){
                return i;
            }
        }
        return -1;

    }
}