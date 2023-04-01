import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Level4 {
    public void solve() throws IOException {
        File file = new File("input4.txt");
        FileWriter out = new FileWriter("output.txt");

        Scanner in = new Scanner(file);
        String[] line1 = in.nextLine().split(" ");
        int t = Integer.parseInt(line1[0]);
        int f = Integer.parseInt(line1[1]);

        for (int i = 0; i < t; i++) {
            int[] fighters = new int[3];
            String[] input = in.nextLine().split(" ");
            String outputS = "";
            for (int j = 0; j < 3; j++) {
                if (input[j].charAt(input[j].length() - 1) == 'R') {
                    fighters[0] = Integer.parseInt(input[j].substring(0, input[j].length() - 1));
                } else if (input[j].charAt(input[j].length() - 1) == 'P') {
                    fighters[1] = Integer.parseInt(input[j].substring(0, input[j].length() - 1));
                } else {
                    fighters[2] = Integer.parseInt(input[j].substring(0, input[j].length() - 1));
                }
            }

            int x = f / 2;
            while (fighters[0] >= x - 1 && fighters[0] != 0) {
                for (int j = 0; j < x - 1; j++) {
                    outputS = outputS.concat("R");
                }
                outputS = outputS.concat("P");
                fighters[0] -= (x - 1);
                fighters[1]--;
                x = x / 2;
            }
            for (int j = 0; j < x - 1; j++) {
                if (j < x - fighters[0] - 1) {
                    if (fighters[2] != 1) {
                        outputS = outputS.concat("S");
                        fighters[2]--;
                    }
                    else {
                        outputS = outputS.concat("P");
                        fighters[1]--;
                    }
                }
                else {
                    outputS = outputS.concat("R");
                }
            }

            while (fighters[1] != 0) {
                outputS = outputS.concat("P");
                fighters[1]--;
            }
            while (fighters[2] != 0) {
                outputS = outputS.concat("S");
                fighters[2]--;
            }
            out.write(outputS);
            out.write("\n");
        }

        in.close();
        out.close();
    }
}
