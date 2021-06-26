import com.sun.prism.Image;
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class FileHandle {
    public static void main(String[] args) throws IOException {
        String namePath = "D:\\error.txt";
        String imgPath = "D:\\2016\\";
        setNameAtPre(imgPath);
        //setName(namePath, imgPath);
        //deleteFile("D:\\2013\\");
        //findErrorFile(namePath, imgPath);
        //handleBigImageSize(imgPath);
        //handleOutOfWidthImage(imgPath);
        //getFormatOfImg(imgPath);
        //handleBigImageSize(imgPath);
        //handleOutOfWidthImage(imgPath);
    }

    public static void setNameAtPre(String dir){
        File file = new File(dir);
        File[] files = file.listFiles();
        System.out.println(files.length);
        for (File file1 : files) {
            String oldName = file1.getName();
            String newName = dir+"B"+oldName;
            file1.renameTo(new File(newName));
        }
    }

    public static void setName(String namePath,String imgPath) throws FileNotFoundException {
        int length = 0;
        String path = namePath;
        Scanner in;
        in = new Scanner(new File(path));
        Map<String, String> map = new HashMap<>();
        while (in.hasNext()) {
            length++;
            String key = in.next();
            String value = in.next();
            StringBuilder sb = new StringBuilder(value);
            sb.insert(5, '2');
            sb.append(".jpg");
            //System.out.println(sb);
            map.put(key, sb.toString());
        }
        System.out.println(map.size());

        File file = new File(imgPath);
        File[] files = file.listFiles();
        System.out.println(files.length);
        for (File file1 : files) {
            String fileName = file1.getName();
            if (fileName.length() <= 18) {
                //System.out.println(fileName);
            }
            fileName = fileName.substring(0, 18);
            if (!map.containsKey(fileName)) {
                System.out.println(fileName + "未找到对应key");
                continue;
            }
            if (map.get(fileName) == null) {
                System.out.println(fileName+"未找到对应value");
            } else {
                String newFileName = imgPath+map.get(fileName);
                if (newFileName == null) {
                    System.out.println(fileName+"");
                    System.out.println(newFileName);
                }
                System.out.println(newFileName);
                file1.renameTo(new File(newFileName));
            }

        }
    }

    public static void findErrorFile(String namePath,String imgPath) throws FileNotFoundException {
        System.out.println("找出错的图片");
        int length = 0;
        String path = namePath;
        Scanner in;
        in = new Scanner(new File(path));
        Set<String> stringSet = new HashSet<>();
        while (in.hasNext()) {
            length++;
            String s1 = in.next();
            String key = in.next();
            String s2 = in.next();
            stringSet.add(key);
        }
        System.out.println(length);

        File file = new File(imgPath);
        File[] files = file.listFiles();

        for (File file1 : files) {
            if (!stringSet.contains(file1.getName())) {
                System.out.println(file1.getName());
                file1.delete();
            }
        }
    }

    public static void deleteFile(String imgPath) {
        File file = new File(imgPath);
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.length() < 1000 * 100) {
                file1.delete();
            }
        }
    }

    public static void handleBigImageSize(String imgPath) throws IOException {
        System.out.println("处理图片过大");
        File file = new File(imgPath);
        File[] files = file.listFiles();
        for (File file1 : files) {

            if (file1.length() >= 1000 * 100 && file1.length() < 1000 * 200) {
                System.out.println(file1.getName());
                Thumbnails.of(file1).scale(1f).outputQuality(0.25f).toFile(file1.getAbsolutePath());
            }
            if (file1.length() >= 1000 * 200 && file1.length() < 1000 * 1000) {
                System.out.println(file.getName());
                Thumbnails.of(file1).scale(1f).outputQuality(0.10f).toFile(file1.getAbsolutePath());
            }
            if (file1.length() >= 1000 * 1000){
                System.out.println(file.getName());
                Thumbnails.of(file1).scale(1f) .outputQuality(0.05f).toFile(file1.getAbsolutePath());
            }
        }
    }

    public static void handleOutOfWidthImage(String imgPath) throws IOException {
        System.out.println("处理宽高不对");
        File de = new File(imgPath);
        File[] files = de.listFiles();
        for (File file : files) {
            String path = file.getAbsolutePath();
            BufferedImage bufferedImage = ImageIO.read(file);
            int oldWidth = bufferedImage.getWidth();
            int oldHeight = bufferedImage.getHeight();

            if(oldWidth<=90||oldWidth>=480){
                System.out.println(file.getName());
                scale(file.getAbsolutePath());
            }
            if (oldWidth >= oldHeight) {
                System.out.println(file.getName()+"宽大于高");
            }
            if (oldHeight <= 100 || oldHeight >= 720) {
                System.out.println(file.getName());
            }
        }
    }

    public static void scale(String path) throws IOException {
        File file = new File(path);
        Thumbnails.of(file).width(220).toFile(path);
    }


    public static void getFormatOfImg(String path) throws IOException {
        System.out.println("处理格式不对");
        File dir = new File(path);
        File[] files = dir.listFiles();
        for (File file : files) {

            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[1];
            fileInputStream.read(bytes, 0, bytes.length);
            for (byte aByte : bytes) {
                if (aByte != -1) {

                    System.out.println(file.getName()+"格式不对");
                    reFormatImage(file.getAbsolutePath());
                }
            }
        }

    }

    public static void reFormatImage(String path) throws IOException {
        File file = new File(path);
        Thumbnails.of(file).scale(1f).outputFormat("jpg").toFile(path);
    }


}
