package main;
import java.io.*;

public class WriteObject {

    public static void main(String[] args) throws IOException {
        
        System.out.println("請輸入要建立的學生成績檔檔名");
        System.out.print("->");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename = br.readLine();
        
        //FileWriter fw = new FileWriter(filename);
        
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            String str;
            int counter = 0;
            
            do {
                counter++;
                
                System.out.print("請輸入學生名字:");
                String name = br.readLine();
                
                System.out.print("請輸入英文分數:");
                str = br.readLine();
                short e = Short.parseShort(str);
                
                System.out.print("請輸入數學分數:");
                str = br.readLine();
                short m = Short.parseShort(str);
                
                System.out.print("請輸入JAVA分數:");
                str = br.readLine();
                short j = Short.parseShort(str);
                
                dos.writeUTF(name);
                dos.writeShort(e);
                dos.writeShort(m);
                dos.writeShort(j);
                
                System.out.print("還要輸入另一筆資料嗎(y/n):");
                str = br.readLine();
            } while (str.equalsIgnoreCase("Y"));
            
            System.out.println("\n已寫入" + counter + "筆學生資料至檔案" + filename);
        }
    }
}
