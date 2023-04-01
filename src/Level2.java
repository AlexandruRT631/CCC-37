import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Level2 {
    public void solve() throws IOException {
        File file = new File("input2.txt");
        FileWriter out = new FileWriter("output.txt");

        Scanner in = new Scanner(file);
        String[] line1 = in.nextLine().split(" ");
        int t = Integer.parseInt(line1[0]);
        int f = Integer.parseInt(line1[1]);

        for (int i = 0; i < t; i++) {
            char[] input = in.nextLine().toCharArray();

            for (int fighters = f; fighters > f / 4; fighters = fighters / 2) {
                for (int j = 0; j < fighters / 2; j++) {
                    char style1 = input[j * 2];
                    char style2 = input[j * 2 + 1];
                    if (style1 == 'P') {
                        if (style2 == 'S') {
                            input[j] = 'S';
                        } else {
                            input[j] = 'P';
                        }
                    } else if (style1 == 'S') {
                        if (style2 == 'R') {
                            input[j] = 'R';
                        } else {
                            input[j] = 'S';
                        }
                    } else {
                        if (style2 == 'P') {
                            input[j] = 'P';
                        } else {
                            input[j] = 'R';
                        }
                    }
                }
            }

            for (int j = 0; j < f / 4; j++) {
                out.write(input[j]);
            }
            out.write("\n");
        }

        in.close();
        out.close();
    }
}
