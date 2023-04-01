import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Level3 {
    public void solve() throws IOException {
        File file = new File("input3.txt");
        FileWriter out = new FileWriter("output.txt");

        Scanner in = new Scanner(file);
        String[] line1 = in.nextLine().split(" ");
        int t = Integer.parseInt(line1[0]);
        int f = Integer.parseInt(line1[1]);

        for (int i = 0; i < t; i++) {
            int[] fighters = new int[3];
            String[] input = in.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                if (input[j].charAt(input[j].length() - 1) == 'R') {
                    fighters[0] = Integer.parseInt(input[j].substring(0, input[j].length() - 1));
                } else if (input[j].charAt(input[j].length() - 1) == 'P') {
                    fighters[1] = Integer.parseInt(input[j].substring(0, input[j].length() - 1));
                } else {
                    fighters[2] = Integer.parseInt(input[j].substring(0, input[j].length() - 1));
                }
            }

            while (fighters[0] > 2 && fighters[1] > 0) {
                out.write("RRRP");
                fighters[0] -= 3;
                fighters[1]--;
            }
            if (fighters[0] == 2) {
                if (fighters[1] == 1) {
                    out.write("RPRS");
                    fighters[0] -= 2;
                    fighters[1]--;
                    fighters[2]--;
                }
                else {
                    out.write("RPRP");
                    fighters[0] -= 2;
                    fighters[1] -= 2;
                }
            }
            else if (fighters[0] == 1) {
                out.write("RP");
                fighters[0]--;
                fighters[1]--;
            }
            while (fighters[1] != 0) {
                out.write("P");
                fighters[1]--;
            }
            while (fighters[2] != 0) {
                out.write("S");
                fighters[2]--;
            }

            out.write("\n");
        }

        in.close();
        out.close();
    }
}
