package main;
import java.io.*;
import java.io.FileReader;

public class ReadObject {

    public static void main(String[] args) {
        System.out.println("要讀取的學生成績檔檔名");
        System.out.print("->");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String filename = br.readLine();

            int counter = 0;
            double Esum = 0;
            double Msum = 0;
            double Jsum = 0;

            System.out.println("姓名\t英文\t數學\tJAVA\t平均");
            System.out.println("-------------------------------");

            try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
                while (true) {
                    String name = dis.readUTF();
                    short e = dis.readShort();
                    short m = dis.readShort();
                    short j = dis.readShort();
                    counter++;

                    Esum += e;
                    Msum += m;
                    Jsum += j;

                    double avg = (e + m + j) / 3.0;
                    System.out.println(name + '\t' + e + '\t' + m + '\t' + j + '\t' + avg);
                }
            } catch (EOFException e) {
                System.out.println("\n已從檔案 " + filename + " 讀取 " + counter + " 筆學生資料");
                System.out.println("\n全員英文平均: " + (Esum / counter));
                System.out.println("\n全員數學平均: " + (Msum / counter));
                System.out.println("\n全員JAVA平均: " + (Jsum / counter));
            } catch (FileNotFoundException e) {
                System.out.println("檔案未找到: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("讀取檔案時發生錯誤: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("輸入錯誤: " + e.getMessage());
        }
    }
}
