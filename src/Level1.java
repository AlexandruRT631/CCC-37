import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Level1 {
    public void solve() throws IOException {
        File file = new File("input1.txt");
        FileWriter out = new FileWriter("output.txt");

        Scanner in = new Scanner(file);
        int a = Integer.parseInt(in.nextLine());

        for (int i = 0; i < a; i++) {
            String input = in.nextLine();
            char style1 = input.charAt(0);
            char style2 = input.charAt(1);
            if (style1 == 'P') {
                if (style2 == 'S') {
                    out.write("S\n");
                }
                else {
                    out.write("P\n");
                }
            }
            else if (style1 == 'S') {
                if (style2 == 'R') {
                    out.write("R\n");
                } else {
                    out.write("S\n");
                }
            }
            else if (style1 == 'R') {
                if (style2 == 'P') {
                    out.write("P\n");
                } else {
                    out.write("R\n");
                }
            }
        }

        in.close();
        out.close();
    }
}
