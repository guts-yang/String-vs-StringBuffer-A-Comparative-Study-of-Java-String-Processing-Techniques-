package m11d3.project6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * StringDemoFrame - 字符串处理演示的主界面类
 * 
 * 提供图形用户界面，包含文本输入区域、操作按钮和结果显示区域，
 * 用于演示String类和StringBuffer类的各种操作及性能对比。
 * 
 * @author Java Education
 * @version 1.0
 */
public class StringDemoFrame extends JFrame {
    
    // 组件定义
    private JTextArea inputTextArea;       // 输入文本区域
    private JTextArea resultTextArea;      // 结果显示区域
    private JTabbedPane tabbedPane;        // 选项卡面板
    private JPanel stringPanel;            // String操作面板
    private JPanel stringBufferPanel;      // StringBuffer操作面板
    private JPanel performancePanel;       // 性能对比面板
    private JPanel aboutPanel;             // 关于和说明面板
    
    // 业务逻辑对象
    private StringProcessor stringProcessor;  // String处理工具类
    private StringBufferProcessor bufferProcessor;  // StringBuffer处理工具类
    private PerformanceComparator performanceComparator;  // 性能比较工具类
    
    /**
     * 构造函数 - 初始化界面和组件
     */
    public StringDemoFrame() {
        // 初始化业务逻辑对象
        stringProcessor = new StringProcessor();
        bufferProcessor = new StringBufferProcessor();
        performanceComparator = new PerformanceComparator();
        
        // 设置窗口属性
        setTitle("Java字符串处理演示 - String vs StringBuffer");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // 窗口居中
        
        // 创建主面板
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // 创建输入面板
        JPanel inputPanel = createInputPanel();
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        
        // 创建选项卡面板
        tabbedPane = new JTabbedPane();
        
        // 创建并添加各个功能面板
        stringPanel = createStringPanel();
        stringBufferPanel = createStringBufferPanel();
        performancePanel = createPerformancePanel();
        aboutPanel = createAboutPanel();
        
        tabbedPane.addTab("String操作", stringPanel);
        tabbedPane.addTab("StringBuffer操作", stringBufferPanel);
        tabbedPane.addTab("性能对比", performancePanel);
        tabbedPane.addTab("关于", aboutPanel);
        
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        
        // 创建结果面板
        JPanel resultPanel = createResultPanel();
        mainPanel.add(resultPanel, BorderLayout.SOUTH);
        
        // 添加主面板到窗口
        add(mainPanel);
    }
    
    /**
     * 创建输入面板，包含文本输入区域和标题
     * 
     * @return 输入面板
     */
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("输入文本"));
        
        inputTextArea = new JTextArea(3, 80);
        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(inputTextArea);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    /**
     * 创建String操作面板，包含各种String方法的操作按钮
     * 
     * @return String操作面板
     */
    private JPanel createStringPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // 创建操作按钮
        JButton concatBtn = new JButton("字符串拼接");
        JButton substringBtn = new JButton("字符串截取");
        JButton replaceBtn = new JButton("字符串替换");
        JButton containsBtn = new JButton("字符串查找");
        JButton toUpperCaseBtn = new JButton("转换大写");
        JButton toLowerCaseBtn = new JButton("转换小写");
        JButton trimBtn = new JButton("去除空格");
        JButton lengthBtn = new JButton("获取长度");
        
        // 添加事件监听器
        concatBtn.addActionListener(e -> processStringOperation("concat"));
        substringBtn.addActionListener(e -> processStringOperation("substring"));
        replaceBtn.addActionListener(e -> processStringOperation("replace"));
        containsBtn.addActionListener(e -> processStringOperation("contains"));
        toUpperCaseBtn.addActionListener(e -> processStringOperation("toUpperCase"));
        toLowerCaseBtn.addActionListener(e -> processStringOperation("toLowerCase"));
        trimBtn.addActionListener(e -> processStringOperation("trim"));
        lengthBtn.addActionListener(e -> processStringOperation("length"));
        
        // 添加按钮到面板
        panel.add(concatBtn);
        panel.add(substringBtn);
        panel.add(replaceBtn);
        panel.add(containsBtn);
        panel.add(toUpperCaseBtn);
        panel.add(toLowerCaseBtn);
        panel.add(trimBtn);
        panel.add(lengthBtn);
        
        return panel;
    }
    
    /**
     * 创建StringBuffer操作面板，包含各种StringBuffer方法的操作按钮
     * 
     * @return StringBuffer操作面板
     */
    private JPanel createStringBufferPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // 创建操作按钮
        JButton appendBtn = new JButton("追加内容");
        JButton insertBtn = new JButton("插入内容");
        JButton deleteBtn = new JButton("删除内容");
        JButton reverseBtn = new JButton("反转字符串");
        JButton capacityBtn = new JButton("获取容量");
        JButton setCharBtn = new JButton("设置字符");
        JButton indexOfBtn = new JButton("查找索引");
        JButton lengthBtn = new JButton("获取长度");
        
        // 添加事件监听器
        appendBtn.addActionListener(e -> processStringBufferOperation("append"));
        insertBtn.addActionListener(e -> processStringBufferOperation("insert"));
        deleteBtn.addActionListener(e -> processStringBufferOperation("delete"));
        reverseBtn.addActionListener(e -> processStringBufferOperation("reverse"));
        capacityBtn.addActionListener(e -> processStringBufferOperation("capacity"));
        setCharBtn.addActionListener(e -> processStringBufferOperation("setChar"));
        indexOfBtn.addActionListener(e -> processStringBufferOperation("indexOf"));
        lengthBtn.addActionListener(e -> processStringBufferOperation("length"));
        
        // 添加按钮到面板
        panel.add(appendBtn);
        panel.add(insertBtn);
        panel.add(deleteBtn);
        panel.add(reverseBtn);
        panel.add(capacityBtn);
        panel.add(setCharBtn);
        panel.add(indexOfBtn);
        panel.add(lengthBtn);
        
        return panel;
    }
    
    /**
     * 创建性能对比面板，包含性能测试按钮和参数设置
     * 
     * @return 性能对比面板
     */
    private JPanel createPerformancePanel() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // 创建参数设置面板
        JPanel paramPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel countLabel = new JLabel("操作次数: ");
        JTextField countField = new JTextField(10);
        countField.setText("10000");
        paramPanel.add(countLabel);
        paramPanel.add(countField);
        
        // 创建测试按钮
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton concatTestBtn = new JButton("拼接操作性能测试");
        JButton replaceTestBtn = new JButton("替换操作性能测试");
        
        // 添加事件监听器
        concatTestBtn.addActionListener(e -> {
            try {
                int count = Integer.parseInt(countField.getText());
                runConcatenationPerformanceTest(count);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "请输入有效的数字！", "输入错误", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        replaceTestBtn.addActionListener(e -> {
            try {
                int count = Integer.parseInt(countField.getText());
                runReplacementPerformanceTest(count);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "请输入有效的数字！", "输入错误", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        buttonPanel.add(concatTestBtn);
        buttonPanel.add(replaceTestBtn);
        
        // 添加文本说明
        JTextArea infoArea = new JTextArea(5, 40);
        infoArea.setText("性能测试说明：\n" +
                         "1. 拼接测试：比较String和StringBuffer在多次拼接操作中的性能差异\n" +
                         "2. 替换测试：比较String和StringBuffer在多次替换操作中的性能差异\n" +
                         "3. 操作次数越大，差异越明显\n" +
                         "4. 测试结果显示每种操作的执行时间（毫秒）");
        infoArea.setEditable(false);
        infoArea.setLineWrap(true);
        infoArea.setWrapStyleWord(true);
        
        panel.add(paramPanel);
        panel.add(buttonPanel);
        panel.add(new JLabel("性能测试结果将显示在下方结果区域"));
        panel.add(new JScrollPane(infoArea));
        
        return panel;
    }
    
    /**
     * 创建关于和说明面板，包含String和StringBuffer的特性说明
     * 
     * @return 关于面板
     */
    private JPanel createAboutPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JTextArea aboutArea = new JTextArea();
        aboutArea.setEditable(false);
        aboutArea.setLineWrap(true);
        aboutArea.setWrapStyleWord(true);
        
        // 添加说明文本
        aboutArea.setText("String vs StringBuffer 教育演示程序\n\n" +
                         "String类特性：\n" +
                         "- 不可变性（Immutable）：一旦创建，内容不可修改\n" +
                         "- 每次修改都会创建新的字符串对象\n" +
                         "- 适用于内容不经常变化的场景\n" +
                         "- 线程安全（因其不可变特性）\n\n" +
                         "StringBuffer类特性：\n" +
                         "- 可变性（Mutable）：可以修改其内容而不创建新对象\n" +
                         "- 提供了append、insert、delete等方法进行修改操作\n" +
                         "- 适用于需要频繁修改字符串内容的场景\n" +
                         "- 线程安全（方法带有synchronized关键字）\n\n" +
                         "使用场景建议：\n" +
                         "- 如果字符串内容基本不变，优先使用String\n" +
                         "- 如果需要频繁修改字符串（如循环拼接），优先使用StringBuffer\n" +
                         "- 在单线程环境下，StringBuilder（非线程安全）性能优于StringBuffer\n\n" +
                         "常见错误提示：\n" +
                         "1. 避免在循环中使用String进行拼接操作\n" +
                         "2. 不要使用==运算符比较字符串内容，应使用equals()方法\n" +
                         "3. 注意StringBuffer的容量自动扩容机制，必要时可预先设置容量\n\n" +
                         "版本：1.0\n" +
                         "作者：Java Education");
        
        panel.add(new JScrollPane(aboutArea), BorderLayout.CENTER);
        
        return panel;
    }
    
    /**
     * 创建结果显示面板
     * 
     * @return 结果面板
     */
    private JPanel createResultPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("操作结果"));
        
        resultTextArea = new JTextArea(5, 80);
        resultTextArea.setEditable(false);
        resultTextArea.setLineWrap(true);
        resultTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    /**
     * 处理String操作，根据操作类型调用相应的处理方法
     * 
     * @param operation 操作类型
     */
    private void processStringOperation(String operation) {
        String input = inputTextArea.getText();
        
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请先输入文本！", "输入错误", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String result = "";
        String description = "";
        
        switch (operation) {
            case "concat":
                String concatStr = JOptionPane.showInputDialog(this, "请输入要拼接的字符串：");
                if (concatStr != null) {
                    result = stringProcessor.concat(input, concatStr);
                    description = "字符串拼接：将\"" + input + "\" 和 \"" + concatStr + "\" 拼接在一起";
                }
                break;
            case "substring":
                String startStr = JOptionPane.showInputDialog(this, "请输入起始索引：");
                String endStr = JOptionPane.showInputDialog(this, "请输入结束索引（可选）：");
                try {
                    int start = Integer.parseInt(startStr);
                    if (endStr != null && !endStr.isEmpty()) {
                        int end = Integer.parseInt(endStr);
                        result = stringProcessor.substring(input, start, end);
                        description = "字符串截取：从索引" + start + "到索引" + end;
                    } else {
                        result = stringProcessor.substring(input, start);
                        description = "字符串截取：从索引" + start + "到末尾";
                    }
                } catch (NumberFormatException | StringIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(this, "索引输入错误！", "操作失败", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
            case "replace":
                String target = JOptionPane.showInputDialog(this, "请输入要替换的字符串：");
                String replacement = JOptionPane.showInputDialog(this, "请输入替换后的字符串：");
                if (target != null && replacement != null) {
                    result = stringProcessor.replace(input, target, replacement);
                    description = "字符串替换：将\"" + target + "\" 替换为 \"" + replacement + "\"";
                }
                break;
            case "contains":
                String searchStr = JOptionPane.showInputDialog(this, "请输入要查找的字符串：");
                if (searchStr != null) {
                    boolean contains = stringProcessor.contains(input, searchStr);
                    result = "" + contains;
                    description = "字符串查找：检查\"" + input + "\" 是否包含 \"" + searchStr + "\"";
                }
                break;
            case "toUpperCase":
                result = stringProcessor.toUpperCase(input);
                description = "转换大写：将字符串转换为大写形式";
                break;
            case "toLowerCase":
                result = stringProcessor.toLowerCase(input);
                description = "转换小写：将字符串转换为小写形式";
                break;
            case "trim":
                result = stringProcessor.trim(input);
                description = "去除空格：去除字符串两端的空白字符";
                break;
            case "length":
                result = "" + stringProcessor.length(input);
                description = "获取长度：字符串\"" + input + "\" 的长度";
                break;
        }
        
        if (!result.isEmpty()) {
            displayResult("String操作结果", description, result);
        }
    }
    
    /**
     * 处理StringBuffer操作，根据操作类型调用相应的处理方法
     * 
     * @param operation 操作类型
     */
    private void processStringBufferOperation(String operation) {
        String input = inputTextArea.getText();
        
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请先输入文本！", "输入错误", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        StringBuffer buffer = new StringBuffer(input);
        String result = "";
        String description = "";
        
        switch (operation) {
            case "append":
                String appendStr = JOptionPane.showInputDialog(this, "请输入要追加的内容：");
                if (appendStr != null) {
                    bufferProcessor.append(buffer, appendStr);
                    result = buffer.toString();
                    description = "追加内容：在字符串末尾添加\"" + appendStr + "\"";
                }
                break;
            case "insert":
                try {
                    String insertStr = JOptionPane.showInputDialog(this, "请输入要插入的内容：");
                    String indexStr = JOptionPane.showInputDialog(this, "请输入插入位置：");
                    if (insertStr != null && indexStr != null) {
                        int index = Integer.parseInt(indexStr);
                        bufferProcessor.insert(buffer, index, insertStr);
                        result = buffer.toString();
                        description = "插入内容：在位置" + index + "插入\"" + insertStr + "\"";
                    }
                } catch (NumberFormatException | StringIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(this, "位置输入错误！", "操作失败", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
            case "delete":
                try {
                    String startStr = JOptionPane.showInputDialog(this, "请输入起始位置：");
                    String endStr = JOptionPane.showInputDialog(this, "请输入结束位置：");
                    if (startStr != null && endStr != null) {
                        int start = Integer.parseInt(startStr);
                        int end = Integer.parseInt(endStr);
                        bufferProcessor.delete(buffer, start, end);
                        result = buffer.toString();
                        description = "删除内容：删除从位置" + start + "到位置" + end + "之间的字符";
                    }
                } catch (NumberFormatException | StringIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(this, "位置输入错误！", "操作失败", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
            case "reverse":
                bufferProcessor.reverse(buffer);
                result = buffer.toString();
                description = "反转字符串：将字符串顺序反转";
                break;
            case "capacity":
                result = "" + bufferProcessor.capacity(buffer);
                description = "获取容量：当前StringBuffer的容量";
                break;
            case "setChar":
                try {
                    String indexStr = JOptionPane.showInputDialog(this, "请输入字符位置：");
                    String charStr = JOptionPane.showInputDialog(this, "请输入要设置的字符：");
                    if (indexStr != null && charStr != null && charStr.length() == 1) {
                        int index = Integer.parseInt(indexStr);
                        char ch = charStr.charAt(0);
                        bufferProcessor.setCharAt(buffer, index, ch);
                        result = buffer.toString();
                        description = "设置字符：将位置" + index + "的字符设置为\"" + ch + "\"";
                    }
                } catch (NumberFormatException | StringIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(this, "位置或字符输入错误！", "操作失败", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
            case "indexOf":
                String searchStr = JOptionPane.showInputDialog(this, "请输入要查找的字符串：");
                if (searchStr != null) {
                    int index = bufferProcessor.indexOf(buffer, searchStr);
                    result = index >= 0 ? "" + index : "-1（未找到）";
                    description = "查找索引：查找\"" + searchStr + "\" 首次出现的位置";
                }
                break;
            case "length":
                result = "" + bufferProcessor.length(buffer);
                description = "获取长度：字符串的长度";
                break;
        }
        
        if (!result.isEmpty()) {
            displayResult("StringBuffer操作结果", description, result);
        }
    }
    
    /**
     * 运行拼接操作性能测试
     * 
     * @param count 测试次数
     */
    private void runConcatenationPerformanceTest(int count) {
        String baseStr = "测试";
        String appendStr = "追加内容";
        
        // String拼接测试
        long startTime = System.currentTimeMillis();
        String result = baseStr;
        for (int i = 0; i < count; i++) {
            result = result + appendStr;
        }
        long stringTime = System.currentTimeMillis() - startTime;
        
        // StringBuffer拼接测试
        startTime = System.currentTimeMillis();
        StringBuffer buffer = new StringBuffer(baseStr);
        for (int i = 0; i < count; i++) {
            buffer.append(appendStr);
        }
        long bufferTime = System.currentTimeMillis() - startTime;
        
        // 显示结果
        String performanceResult = "拼接操作性能测试（" + count + "次操作）\n" +
                                 "String拼接耗时: " + stringTime + " 毫秒\n" +
                                 "StringBuffer拼接耗时: " + bufferTime + " 毫秒\n" +
                                 "效率差异: " + String.format("%.2f", (double)stringTime / bufferTime) + " 倍\n\n" +
                                 "结论: 在需要频繁拼接字符串时，StringBuffer比String效率高得多！";
        
        resultTextArea.setText(performanceResult);
    }
    
    /**
     * 运行替换操作性能测试
     * 
     * @param count 测试次数
     */
    private void runReplacementPerformanceTest(int count) {
        String baseStr = "这是一个测试字符串，用于测试替换操作的性能。这是一个测试字符串。";
        
        // String替换测试
        long startTime = System.currentTimeMillis();
        String result = baseStr;
        for (int i = 0; i < count; i++) {
            result = result.replace("测试", "替换");
        }
        long stringTime = System.currentTimeMillis() - startTime;
        
        // StringBuffer替换测试
        startTime = System.currentTimeMillis();
        StringBuffer buffer = null;
        for (int i = 0; i < count; i++) {
            buffer = new StringBuffer(baseStr);
            int index = buffer.indexOf("测试");
            while (index >= 0) {
                buffer.replace(index, index + 2, "替换");
                index = buffer.indexOf("测试", index + 2);
            }
        }
        long bufferTime = System.currentTimeMillis() - startTime;
        
        // 显示结果
        String performanceResult = "替换操作性能测试（" + count + "次操作）\n" +
                                 "String替换耗时: " + stringTime + " 毫秒\n" +
                                 "StringBuffer替换耗时: " + bufferTime + " 毫秒\n" +
                                 "效率差异: " + String.format("%.2f", (double)Math.max(stringTime, bufferTime) / Math.min(stringTime, bufferTime)) + " 倍\n\n" +
                                 "结论: 替换操作的性能取决于具体实现方式和操作复杂度！";
        
        resultTextArea.setText(performanceResult);
    }
    
    /**
     * 显示操作结果
     * 
     * @param title 标题
     * @param description 描述
     * @param result 结果
     */
    private void displayResult(String title, String description, String result) {
        String output = title + "\n" +
                      "操作: " + description + "\n" +
                      "结果: " + result + "\n";
        
        resultTextArea.setText(output);
    }
}