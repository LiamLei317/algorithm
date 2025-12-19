package com.coding.test;

import java.util.Random;

/**
 * 蒙提霍尔三门问题模拟
 */
public class MontyHallSimulation {

    public static void main(String[] args) {
        // 模拟次数：10万次，样本越大结果越接近理论值
        int totalSimulations = 100_000;

        int winsWithSwitch = 0; // 换门赢的次数
        int winsWithStay = 0;   // 不换门赢的次数

        Random random = new Random();

        System.out.println("开始模拟 " + totalSimulations + " 次三门问题...");
        System.out.println("---------------------------------------------");

        for (int i = 0; i < totalSimulations; i++) {
            // 1. 设置奖品位置 (0, 1, 2 代表三扇门)
            int prizeDoor = random.nextInt(3);

            // 2. 玩家随机选择一扇门
            int playerChoice = random.nextInt(3);

            // 3. 主持人开启一扇门
            // 规则：主持人必须打开一扇没有奖品，且不是玩家选择的那扇门
            int hostOpenedDoor;
            do {
                hostOpenedDoor = random.nextInt(3);
            } while (hostOpenedDoor == prizeDoor || hostOpenedDoor == playerChoice);

            // --- 此时玩家面临选择：换门 or 不换 ---

            // 策略 A：不换门 (Stay)
            // 如果玩家一开始选的就是奖品，不换门就赢了
            if (playerChoice == prizeDoor) {
                winsWithStay++;
            }

            // 策略 B：换门 (Switch)
            // 换门后的新选择必须是剩下的那一扇门 (不是玩家选的，也不是主持人打开的)
            int newChoice = 3 - playerChoice - hostOpenedDoor; // 0+1+2=3，利用数学计算剩下那扇门

            if (newChoice == prizeDoor) {
                winsWithSwitch++;
            }
        }

        // 计算胜率
        double stayWinRate = (double) winsWithStay / totalSimulations * 100;
        double switchWinRate = (double) winsWithSwitch / totalSimulations * 100;

        // 输出结果
        System.out.printf("策略 A (不换门) 获胜次数: %d (胜率: %.2f%%)%n", winsWithStay, stayWinRate);
        System.out.printf("策略 B (换  门) 获胜次数: %d (胜率: %.2f%%)%n", winsWithSwitch, switchWinRate);

        System.out.println("---------------------------------------------");
        if (switchWinRate > stayWinRate) {
            System.out.println("结论: 换门能够显著提高胜率！");
        }
    }
}
