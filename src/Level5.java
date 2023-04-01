import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Level5 {
    public void solve() throws IOException {
        File file = new File("input5.txt");
        FileWriter out = new FileWriter("output.txt");

        Scanner in = new Scanner(file);
        String[] line1 = in.nextLine().split(" ");
        int t = Integer.parseInt(line1[0]);
        int f = Integer.parseInt(line1[1]);

        for (int i = 0; i < t; i++) {
            int[] fighters = new int[6];
            String[] input = in.nextLine().split(" ");
            String outputS = "";
            for (int j = 0; j < 5; j++) {
                if (input[j].charAt(input[j].length() - 1) == 'R') {
                    fighters[0] = Integer.parseInt(input[j].substring(0, input[j].length() - 1));
                } else if (input[j].charAt(input[j].length() - 1) == 'P') {
                    fighters[1] = Integer.parseInt(input[j].substring(0, input[j].length() - 1));
                } else if (input[j].charAt(input[j].length() - 1) == 'S') {
                    fighters[2] = Integer.parseInt(input[j].substring(0, input[j].length() - 1));
                } else if (input[j].charAt(input[j].length() - 1) == 'Y') {
                    fighters[3] = Integer.parseInt(input[j].substring(0, input[j].length() - 1));
                } else {
                    fighters[4] = Integer.parseInt(input[j].substring(0, input[j].length() - 1));
                }
            }

            int f2 = 1;
            while (f2 < fighters[3] + fighters[4]) {
                f2 = f2 * 2;
            }
            fighters[5] = f2 - fighters[3] - fighters[4];
            int x2 = f2 / 2;
            while (fighters[3] >= x2 - 1 && fighters[3] != 0) {
                for (int j = 0; j < x2 - 1; j++) {
                    outputS = outputS.concat("Y");
                }
                outputS = outputS.concat("L");
                fighters[3] -= (x2 - 1);
                fighters[4]--;
                x2 = x2 / 2;
            }
            for (int j = 0; j < x2 - 1; j++) {
                if (j < x2 - fighters[3] - 1) {
                    if (fighters[5] != 1) {
                        outputS = outputS.concat("R");
                        fighters[5]--;
                    }
                    else {
                        outputS = outputS.concat("L");
                        fighters[4]--;
                    }
                }
                else {
                    outputS = outputS.concat("Y");
                }
            }

            while (fighters[4] != 0) {
                outputS = outputS.concat("L");
                fighters[4]--;
            }
            while (fighters[5] != 0) {
                outputS = outputS.concat("R");
                fighters[5]--;
            }

            fighters[0] = fighters[0] - fighters[5];

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

            char[] output = outputS.toCharArray();

            for (int k = f; k > 1; k = k / 2) {
                for (int j = 0; j < k / 2; j++) {
                    char style1 = output[j * 2];
                    char style2 = output[j * 2 + 1];
                    if (style1 == 'P') {
                        if (style2 == 'S') {
                            output[j] = 'S';
                        } else {
                            output[j] = 'P';
                        }
                    } else if (style1 == 'S') {
                        if (style2 == 'R') {
                            output[j] = 'R';
                        } else {
                            output[j] = 'S';
                        }
                    } else {
                        if (style2 == 'P') {
                            output[j] = 'P';
                        } else {
                            output[j] = 'R';
                        }
                    }
                }
            }
            if (output[0] != 'S') {
                System.out.println(input[0] + " " + input[1] + " " + input[2]);
            }
        }

        in.close();
        out.close();
    }
}
