package m11d3.project6;

/**
 * PerformanceComparator - 字符串处理性能比较工具类
 * 
 * 用于比较String和StringBuffer在各种操作下的性能差异，提供详细的性能测试结果。
 * 此类主要用于教育目的，展示在不同场景下使用String和StringBuffer的效率差异。
 * 
 * @author Java Education
 * @version 1.0
 */
public class PerformanceComparator {
    
    /**
     * 比较字符串拼接操作的性能
     * 
     * @param count 执行次数
     * @param baseStr 基础字符串
     * @param appendStr 要追加的字符串
     * @return 包含测试结果的字符串
     */
    public String compareConcatenationPerformance(int count, String baseStr, String appendStr) {
        StringBuilder result = new StringBuilder();
        
        // String拼接测试
        long startTime = System.currentTimeMillis();
        String stringResult = baseStr;
        for (int i = 0; i < count; i++) {
            stringResult = stringResult + appendStr;
        }
        long stringTime = System.currentTimeMillis() - startTime;
        
        // StringBuffer拼接测试
        startTime = System.currentTimeMillis();
        StringBuffer buffer = new StringBuffer(baseStr);
        for (int i = 0; i < count; i++) {
            buffer.append(appendStr);
        }
        long bufferTime = System.currentTimeMillis() - startTime;
        
        // 计算效率差异
        double ratio = 0;
        if (bufferTime > 0) {
            ratio = (double) stringTime / bufferTime;
        } else if (stringTime > 0) {
            ratio = (double) bufferTime / stringTime;
        }
        
        // 构建结果
        result.append("===== 字符串拼接性能测试 =====\n");
        result.append("测试次数: ").append(count).append("次\n");
        result.append("基础字符串: \"").append(baseStr).append("\"\n");
        result.append("追加字符串: \"").append(appendStr).append("\"\n\n");
        result.append("String拼接耗时: ").append(stringTime).append(" 毫秒\n");
        result.append("StringBuffer拼接耗时: ").append(bufferTime).append(" 毫秒\n\n");
        
        if (stringTime > bufferTime) {
            result.append("结论: StringBuffer比String快 ").append(String.format("%.2f", ratio)).append(" 倍\n");
            result.append("原因: String是不可变的，每次拼接都会创建新的字符串对象，导致内存分配和垃圾回收开销\n");
        } else if (bufferTime > stringTime) {
            result.append("结论: String比StringBuffer快 ").append(String.format("%.2f", ratio)).append(" 倍\n");
            result.append("原因: 操作次数较少时，String优化后的拼接可能比StringBuffer的方法调用开销小\n");
        } else {
            result.append("结论: 性能相当\n");
        }
        
        return result.toString();
    }
    
    /**
     * 比较字符串替换操作的性能
     * 
     * @param count 执行次数
     * @param baseStr 基础字符串
     * @param target 要替换的目标字符串
     * @param replacement 替换字符串
     * @return 包含测试结果的字符串
     */
    public String compareReplacementPerformance(int count, String baseStr, String target, String replacement) {
        StringBuilder result = new StringBuilder();
        
        // String替换测试
        long startTime = System.currentTimeMillis();
        String stringResult = "";
        for (int i = 0; i < count; i++) {
            stringResult = baseStr.replace(target, replacement);
        }
        long stringTime = System.currentTimeMillis() - startTime;
        
        // StringBuffer替换测试
        startTime = System.currentTimeMillis();
        StringBuffer bufferResult = null;
        for (int i = 0; i < count; i++) {
            bufferResult = new StringBuffer(baseStr);
            int index = bufferResult.indexOf(target);
            while (index >= 0) {
                bufferResult.replace(index, index + target.length(), replacement);
                // 继续查找下一个匹配位置
                index = bufferResult.indexOf(target, index + replacement.length());
            }
        }
        long bufferTime = System.currentTimeMillis() - startTime;
        
        // 计算效率差异
        double ratio = 0;
        if (Math.min(stringTime, bufferTime) > 0) {
            ratio = (double) Math.max(stringTime, bufferTime) / Math.min(stringTime, bufferTime);
        }
        
        // 构建结果
        result.append("===== 字符串替换性能测试 =====\n");
        result.append("测试次数: ").append(count).append("次\n");
        result.append("基础字符串: \"").append(baseStr).append("\"\n");
        result.append("目标字符串: \"").append(target).append("\"\n");
        result.append("替换字符串: \"").append(replacement).append("\"\n\n");
        result.append("String替换耗时: ").append(stringTime).append(" 毫秒\n");
        result.append("StringBuffer替换耗时: ").append(bufferTime).append(" 毫秒\n\n");
        
        if (stringTime > bufferTime) {
            result.append("结论: StringBuffer比String快 ").append(String.format("%.2f", ratio)).append(" 倍\n");
            result.append("原因: String每次替换都会创建新对象，而StringBuffer可以在原对象上进行修改\n");
        } else if (bufferTime > stringTime) {
            result.append("结论: String比StringBuffer快 ").append(String.format("%.2f", ratio)).append(" 倍\n");
            result.append("原因: String的replace方法是经过优化的原生实现，可能比手动在StringBuffer上操作更高效\n");
        } else {
            result.append("结论: 性能相当\n");
        }
        
        return result.toString();
    }
    
    /**
     * 比较字符串插入操作的性能
     * 
     * @param count 执行次数
     * @param baseStr 基础字符串
     * @param insertStr 要插入的字符串
     * @param insertIndex 插入位置
     * @return 包含测试结果的字符串
     */
    public String compareInsertionPerformance(int count, String baseStr, String insertStr, int insertIndex) {
        StringBuilder result = new StringBuilder();
        
        // String插入测试
        long startTime = System.currentTimeMillis();
        String stringResult = "";
        for (int i = 0; i < count; i++) {
            stringResult = baseStr.substring(0, insertIndex) + insertStr + baseStr.substring(insertIndex);
        }
        long stringTime = System.currentTimeMillis() - startTime;
        
        // StringBuffer插入测试
        startTime = System.currentTimeMillis();
        StringBuffer buffer = null;
        for (int i = 0; i < count; i++) {
            buffer = new StringBuffer(baseStr);
            buffer.insert(insertIndex, insertStr);
        }
        long bufferTime = System.currentTimeMillis() - startTime;
        
        // 计算效率差异
        double ratio = 0;
        if (Math.min(stringTime, bufferTime) > 0) {
            ratio = (double) Math.max(stringTime, bufferTime) / Math.min(stringTime, bufferTime);
        }
        
        // 构建结果
        result.append("===== 字符串插入性能测试 =====\n");
        result.append("测试次数: ").append(count).append("次\n");
        result.append("基础字符串: \"").append(baseStr).append("\"\n");
        result.append("插入字符串: \"").append(insertStr).append("\"\n");
        result.append("插入位置: ").append(insertIndex).append("\n\n");
        result.append("String插入耗时: ").append(stringTime).append(" 毫秒\n");
        result.append("StringBuffer插入耗时: ").append(bufferTime).append(" 毫秒\n\n");
        
        if (stringTime > bufferTime) {
            result.append("结论: StringBuffer比String快 ").append(String.format("%.2f", ratio)).append(" 倍\n");
            result.append("原因: String插入需要创建多个临时对象（两个substring和最终拼接），而StringBuffer可以直接在原数组上操作\n");
        } else {
            result.append("结论: String比StringBuffer快 ").append(String.format("%.2f", ratio)).append(" 倍\n");
            result.append("原因: 对于短字符串或操作次数较少时，String的插入可能比StringBuffer的方法调用开销小\n");
        }
        
        return result.toString();
    }
    
    /**
     * 比较字符串多次操作的综合性能
     * 
     * @param count 执行次数
     * @return 包含测试结果的字符串
     */
    public String compareComprehensivePerformance(int count) {
        StringBuilder result = new StringBuilder();
        String baseData = "abcdefghijklmnopqrstuvwxyz";
        
        // String综合操作测试
        long startTime = System.currentTimeMillis();
        String stringData = "";
        for (int i = 0; i < count; i++) {
            stringData = baseData;
            stringData = stringData.toUpperCase();
            stringData = stringData.replace("A", "Z");
            stringData = stringData + "123";
            stringData = stringData.substring(3, stringData.length() - 2);
        }
        long stringTime = System.currentTimeMillis() - startTime;
        
        // StringBuffer综合操作测试
        startTime = System.currentTimeMillis();
        StringBuffer bufferData = null;
        for (int i = 0; i < count; i++) {
            bufferData = new StringBuffer(baseData);
            bufferData.append("123");
            bufferData.replace(0, 1, "Z");
            bufferData.delete(3, bufferData.length() - 2);
        }
        long bufferTime = System.currentTimeMillis() - startTime;
        
        // 计算效率差异
        double ratio = 0;
        if (Math.min(stringTime, bufferTime) > 0) {
            ratio = (double) Math.max(stringTime, bufferTime) / Math.min(stringTime, bufferTime);
        }
        
        // 构建结果
        result.append("===== 字符串综合性能测试 =====\n");
        result.append("测试次数: ").append(count).append("次\n");
        result.append("测试操作: 大小写转换、替换、拼接、截取等综合操作\n\n");
        result.append("String综合操作耗时: ").append(stringTime).append(" 毫秒\n");
        result.append("StringBuffer综合操作耗时: ").append(bufferTime).append(" 毫秒\n\n");
        
        if (stringTime > bufferTime) {
            result.append("结论: StringBuffer比String快 ").append(String.format("%.2f", ratio)).append(" 倍\n");
            result.append("原因: 在多次修改字符串的场景下，StringBuffer的可变性避免了创建大量临时对象\n");
        } else {
            result.append("结论: String比StringBuffer快 ").append(String.format("%.2f", ratio)).append(" 倍\n");
            result.append("原因: 对于某些特定的综合操作，String的优化实现可能比StringBuffer更高效\n");
        }
        
        result.append("\n===== 最佳实践建议 =====\n");
        result.append("1. 如果字符串内容很少变化，优先使用String\n");
        result.append("2. 如果需要在循环中多次修改字符串，优先使用StringBuffer\n");
        result.append("3. 在单线程环境下，可以使用StringBuilder代替StringBuffer以获得更好的性能\n");
        result.append("4. 对于复杂的字符串操作，可以根据实际情况选择最适合的类\n");
        
        return result.toString();
    }
    
    /**
     * 内存使用对比分析
     * 
     * @param stringCount 字符串数量
     * @return 内存使用分析结果
     */
    public String analyzeMemoryUsage(int stringCount) {
        StringBuilder result = new StringBuilder();
        
        result.append("===== 内存使用对比分析 =====\n");
        result.append("分析场景: 创建和修改").append(stringCount).append("个字符串\n\n");
        
        result.append("String类内存特性:\n");
        result.append("- 不可变性导致每次修改都会创建新对象\n");
        result.append("- 在多次拼接操作中，会产生大量临时对象\n");
        result.append("- 垃圾回收器需要处理更多的对象，增加系统开销\n");
        result.append("- 对于").append(stringCount).append("次拼接操作，可能产生");
        result.append(stringCount).append("个临时字符串对象\n\n");
        
        result.append("StringBuffer类内存特性:\n");
        result.append("- 可变性允许在原对象上进行修改，避免创建临时对象\n");
        result.append("- 内部使用可扩展数组实现，具有预分配容量的机制\n");
        result.append("- 可以通过ensureCapacity()方法预先设置容量，减少扩容开销\n");
        result.append("- 对于").append(stringCount).append("次拼接操作，只需要1个StringBuffer对象\n\n");
        
        result.append("结论: 在需要频繁修改字符串的场景下，StringBuffer比String更节省内存\n");
        
        return result.toString();
    }
}