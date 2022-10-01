package com.hansong.instrumentation;

import java.io.*;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Created by xhans on 2016/4/12.
 */
public class Transformer implements ClassFileTransformer{

    public static final String classNumberReturns2 = "TransClass.class.2";

    public static byte[] getByteFromFile(String fileName){
        File file = new File(fileName);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long length = file.length();
        byte[] bytes = new byte[(int) length];

        int offset = 0;
        int numRead = 0;
        try {
            while (offset < bytes.length
                    && (numRead = inputStream.read(bytes, offset, bytes.length - offset)) >= 0){
                offset += numRead;
            }

            if (offset < bytes.length){
                throw new IOException("Could not completely read file" + fileName);
            }
            inputStream.close();
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println("Transform: " + className);
        if (!className.equals("com/hansong/instrumentation/TransClass")){
            return null;
        }
        return getByteFromFile(classNumberReturns2);
    }

}
