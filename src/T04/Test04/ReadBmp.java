package src.T04.Test04;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class ReadBmp {
    public static void main(String[] args) {
        ReadBmp bmp = new ReadBmp("./src/T04/Test04.bmp");
        bmp.printInfo();
    }

    private short bfType;
    private int bfSize;
    private int bfOffBits;
    private int biSize;
    private int biWidth;
    private int biHeight;
    private short biPlanes;
    private short biBitCount;
    private int biCompression;
    private int biSizeImage;
    private int biXPelsPerMeter;
    private int biYPelsPerMeter;
    private int biClrUsed;
    private int biClrImportant;

    public ReadBmp(String sourceFile) {
        try {
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            byte[] fileHead = new byte[14];
            bufferedInputStream.read(fileHead, 0, 14);

            byte[] fileInfo = new byte[40];
            bufferedInputStream.read(fileInfo, 0, 40);

            this.bfType = _2BytestoShort(fileHead, 1);
            this.bfSize = _4BytestoInt(fileHead, 5);
            this.bfOffBits = _4BytestoInt(fileHead, 13);

            this.biSize = _4BytestoInt(fileInfo, 3);
            this.biWidth = _4BytestoInt(fileInfo, 7);
            this.biHeight = _4BytestoInt(fileInfo, 11);
            this.biPlanes = _2BytestoShort(fileInfo, 13);
            this.biBitCount = _2BytestoShort(fileInfo, 15);
            this.biCompression = _4BytestoInt(fileInfo, 19);
            this.biSizeImage = _4BytestoInt(fileInfo, 23);
            this.biXPelsPerMeter = _4BytestoInt(fileInfo, 27);
            this.biYPelsPerMeter = _4BytestoInt(fileInfo, 31);
            this.biClrUsed = _4BytestoInt(fileInfo, 35);
            this.biClrImportant = _4BytestoInt(fileInfo, 39);

            fileInputStream.close();
            bufferedInputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public short _2BytestoShort(byte[] brr, int start) {
        return (short) (((brr[start] & 0xff) << 8) | (brr[start - 1] & 0xff));
    }

    // 好像还是小端方式存储的
    public int _4BytestoInt(byte[] brr, int start) {
        return (int) (((brr[start] & 0xff) << 24) | 
                      ((brr[start - 1] & 0xff) << 16) | 
                      ((brr[start - 2] & 0xff) << 8) | 
                      (brr[start - 3] & 0xff));
    }

    public void printInfo() {
        System.out.println("bfType=" + this.bfType);
        System.out.println("bfSize=" + this.bfSize);
        System.out.println("bfOffBits=" + this.bfOffBits);
        System.out.println("biSize=" + this.biSize);
        System.out.println("biWidth=" + this.biWidth);
        System.out.println("biHeight=" + this.biHeight);
        System.out.println("biPlanes=" + this.biPlanes);
        System.out.println("biBitCount=" + this.biBitCount);
        System.out.println("biCompression=" + this.biCompression);
        System.out.println("biSizeImage=" + this.biSizeImage);
        System.out.println("biXPelsPerMeter=" + this.biXPelsPerMeter);
        System.out.println("biYPelsPerMeter=" + this.biYPelsPerMeter);
        System.out.println("biClrUsed=" + this.biClrUsed);
        System.out.println("biClrImportant=" + this.biClrImportant);
    }
}