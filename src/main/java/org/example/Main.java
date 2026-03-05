package org.example;
//今回のプロジェクトはJavaの基本です
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // 1. 使用 Label (标签)，方便从深层嵌套直接跳回主菜单
        mainMenu:
        while (true) {
            System.out.println("\n--- 终极日本旅行小助手 ---");
            System.out.println("1. 汇率换算 (JPY -> RMB)");
            System.out.println("2. 五十音挑战 (清音测试)");
            System.out.println("3. 退出系统");
            System.out.print("请选择功能: ");

            String choice = input.next();

            // 2. Switch 语句：Java 支持字符串判断
            switch (choice) {
                case "1":
                    runCurrencyConverter(input);
                    break;
                case "2":
                    runJapaneseQuiz(input);
                    break;
                case "3":
                    System.out.println("再见 (さよなら)!");
                    break mainMenu; // 3. 使用 break label 直接退出最外层循环
                default:
                    System.out.println("无效选择，请重新输入。");
            }
        }
    }

    // 功能模块：汇率换算
    public static void runCurrencyConverter(Scanner input) {
        System.out.println("\n[汇率换算模式]");
        // 4. try-catch：处理输入不是数字的 Bug
        try {
            System.out.print("请输入日元金额 (JPY): ");
            double jpy = input.nextDouble();
            double rmb = jpy * 0.048;
            System.out.printf("折合人民币: %.2f 元\n", rmb);

            // 5. 经典 if-else 判断
            if (rmb > 5000) {
                System.out.println("太贵了，剁手吧！");
            }
        } catch (Exception e) {
            System.out.println("错误：请输入有效的数字！");
            input.nextLine(); // 清空缓冲区，防止死循环
        }
    }

    // 功能模块：日语测试
    public static void runJapaneseQuiz(Scanner input) {
        System.out.println("\n[五十音挑战模式]");
        // 二维数组：{假名, 读音}
        String[][] quizData = {
                {"あ", "a"}, {"い", "i"}, {"う", "u"}, {"え", "e"}, {"お", "o"}
        };

        int score = 0;

        // 6. for-each (神器)：自动遍历数组里的每一行
        for (String[] pair : quizData) {
            System.out.print("请问「" + pair[0] + "」的读音是？ ");
            String answer = input.next();

            if (answer.equalsIgnoreCase(pair[1])) {
                System.out.println("正解 (せいかい)！");
                score++;
            } else {
                System.out.println("可惜！正确答案是: " + pair[1]);
            }
        }
        System.out.println("你的得分是: " + score + "/" + quizData.length);
    }







    }
