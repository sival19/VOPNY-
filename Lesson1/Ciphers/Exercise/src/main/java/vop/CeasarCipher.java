package vop;

public class CeasarCipher extends AbstractCipher {

    private int rotFactor;

    public CeasarCipher(int rotFactor){
        if (rotFactor > 0 && rotFactor < ALPHABETH.length){
            this.rotFactor = rotFactor;
        }
        else
            System.out.println("Fejl i Rot Factor");
    }


    @Override
    public String encrypt(String original) {
        String resulet = "";
        for (char c: original.toCharArray()){
            int index = findCharIndex(c);
            if (index>=0){
                index = (index+rotFactor) % ALPHABETH.length;
                resulet += ALPHABETH[index];

            }
            else {
                resulet += c;
            }
        }
        return resulet;
    }

    @Override
    public String decrypt(String encrypted) {
        String result = "";
        for (char c : encrypted.toCharArray()) {
            int index = findCharIndex(c);
            if (index >= 0) {
                index = (index + ALPHABETH.length - rotFactor) % ALPHABETH.length;
                result += ALPHABETH[index];
            } else {
                result += c;
            }
        }
        return result;
    }
}
