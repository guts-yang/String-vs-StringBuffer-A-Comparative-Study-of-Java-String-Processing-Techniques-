package m11d3.project6;

import javax.swing.SwingUtilities;

/**
 * StringDemoApp - 字符串处理演示应用程序主入口
 * 
 * 本应用程序用于教育目的，演示Java中String类和StringBuffer类的使用
 * 特性、区别及适用场景。通过图形用户界面，用户可以直观地学习和比较
 * 这两种字符串处理类的不同操作和性能表现。
 * 
 * @author Java Education
 * @version 1.0
 */
public class StringDemoApp {
    
    /**
     * 主方法 - 应用程序入口点
     * 使用SwingUtilities.invokeLater确保GUI在事件调度线程中创建
     * 
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        // 在Swing事件调度线程中运行GUI，确保线程安全
        SwingUtilities.invokeLater(() -> {
            // 创建并显示主界面
            StringDemoFrame frame = new StringDemoFrame();
            frame.setVisible(true);
        });
    }
}