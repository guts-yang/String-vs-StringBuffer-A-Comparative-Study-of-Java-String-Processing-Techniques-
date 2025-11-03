package m11d3.project6;

/**
 * StringBufferProcessor - StringBuffer处理工具类
 * 
 * 提供StringBuffer类常用方法的封装和演示，用于教育目的，展示StringBuffer类的可变性和各种字符串操作。
 * 
 * @author Java Education
 * @version 1.0
 */
public class StringBufferProcessor {
    
    /**
     * 追加字符串内容
     * 
     * @param buffer StringBuffer对象
     * @param str 要追加的字符串
     * @return 修改后的StringBuffer对象（支持链式调用）
     */
    public StringBuffer append(StringBuffer buffer, String str) {
        // 注意：StringBuffer的append方法直接修改原对象，不会创建新对象
        // 这展示了StringBuffer的可变性
        return buffer.append(str);
    }
    
    /**
     * 追加字符
     * 
     * @param buffer StringBuffer对象
     * @param c 要追加的字符
     * @return 修改后的StringBuffer对象
     */
    public StringBuffer append(StringBuffer buffer, char c) {
        return buffer.append(c);
    }
    
    /**
     * 追加整数
     * 
     * @param buffer StringBuffer对象
     * @param i 要追加的整数
     * @return 修改后的StringBuffer对象
     */
    public StringBuffer append(StringBuffer buffer, int i) {
        return buffer.append(i);
    }
    
    /**
     * 在指定位置插入字符串
     * 
     * @param buffer StringBuffer对象
     * @param index 插入位置的索引
     * @param str 要插入的字符串
     * @return 修改后的StringBuffer对象
     * @throws StringIndexOutOfBoundsException 如果索引越界
     */
    public StringBuffer insert(StringBuffer buffer, int index, String str) {
        return buffer.insert(index, str);
    }
    
    /**
     * 在指定位置插入字符
     * 
     * @param buffer StringBuffer对象
     * @param index 插入位置的索引
     * @param c 要插入的字符
     * @return 修改后的StringBuffer对象
     * @throws StringIndexOutOfBoundsException 如果索引越界
     */
    public StringBuffer insert(StringBuffer buffer, int index, char c) {
        return buffer.insert(index, c);
    }
    
    /**
     * 删除指定范围的字符
     * 
     * @param buffer StringBuffer对象
     * @param start 起始索引（包含）
     * @param end 结束索引（不包含）
     * @return 修改后的StringBuffer对象
     * @throws StringIndexOutOfBoundsException 如果索引越界
     */
    public StringBuffer delete(StringBuffer buffer, int start, int end) {
        return buffer.delete(start, end);
    }
    
    /**
     * 删除指定位置的字符
     * 
     * @param buffer StringBuffer对象
     * @param index 要删除的字符索引
     * @return 修改后的StringBuffer对象
     * @throws StringIndexOutOfBoundsException 如果索引越界
     */
    public StringBuffer deleteCharAt(StringBuffer buffer, int index) {
        return buffer.deleteCharAt(index);
    }
    
    /**
     * 替换指定范围的字符
     * 
     * @param buffer StringBuffer对象
     * @param start 起始索引（包含）
     * @param end 结束索引（不包含）
     * @param str 替换的字符串
     * @return 修改后的StringBuffer对象
     * @throws StringIndexOutOfBoundsException 如果索引越界
     */
    public StringBuffer replace(StringBuffer buffer, int start, int end, String str) {
        return buffer.replace(start, end, str);
    }
    
    /**
     * 反转字符串
     * 
     * @param buffer StringBuffer对象
     * @return 修改后的StringBuffer对象
     */
    public StringBuffer reverse(StringBuffer buffer) {
        return buffer.reverse();
    }
    
    /**
     * 获取当前容量
     * 
     * @param buffer StringBuffer对象
     * @return 当前容量
     */
    public int capacity(StringBuffer buffer) {
        return buffer.capacity();
    }
    
    /**
     * 设置容量大小
     * 
     * @param buffer StringBuffer对象
     * @param newCapacity 新的容量大小
     * @return 修改后的StringBuffer对象
     * @throws NegativeArraySizeException 如果newCapacity为负数
     */
    public void ensureCapacity(StringBuffer buffer, int newCapacity) {
        buffer.ensureCapacity(newCapacity);
    }
    
    /**
     * 设置字符长度
     * 
     * @param buffer StringBuffer对象
     * @param newLength 新的长度
     * @throws StringIndexOutOfBoundsException 如果newLength为负数
     */
    public void setLength(StringBuffer buffer, int newLength) {
        buffer.setLength(newLength);
    }
    
    /**
     * 获取字符长度
     * 
     * @param buffer StringBuffer对象
     * @return 字符长度
     */
    public int length(StringBuffer buffer) {
        return buffer.length();
    }
    
    /**
     * 获取指定位置的字符
     * 
     * @param buffer StringBuffer对象
     * @param index 字符索引
     * @return 指定位置的字符
     * @throws StringIndexOutOfBoundsException 如果索引越界
     */
    public char charAt(StringBuffer buffer, int index) {
        return buffer.charAt(index);
    }
    
    /**
     * 设置指定位置的字符
     * 
     * @param buffer StringBuffer对象
     * @param index 字符索引
     * @param ch 要设置的字符
     * @throws StringIndexOutOfBoundsException 如果索引越界
     */
    public void setCharAt(StringBuffer buffer, int index, char ch) {
        buffer.setCharAt(index, ch);
    }
    
    /**
     * 获取子字符串
     * 
     * @param buffer StringBuffer对象
     * @param start 起始索引（包含）
     * @param end 结束索引（不包含）
     * @return 子字符串
     * @throws StringIndexOutOfBoundsException 如果索引越界
     */
    public String substring(StringBuffer buffer, int start, int end) {
        return buffer.substring(start, end);
    }
    
    /**
     * 从指定索引开始获取子字符串到末尾
     * 
     * @param buffer StringBuffer对象
     * @param start 起始索引（包含）
     * @return 子字符串
     * @throws StringIndexOutOfBoundsException 如果索引越界
     */
    public String substring(StringBuffer buffer, int start) {
        return buffer.substring(start);
    }
    
    /**
     * 查找子串第一次出现的索引位置
     * 
     * @param buffer StringBuffer对象
     * @param str 要查找的子串
     * @return 子串第一次出现的索引位置，如果未找到返回-1
     */
    public int indexOf(StringBuffer buffer, String str) {
        return buffer.indexOf(str);
    }
    
    /**
     * 从指定位置开始查找子串第一次出现的索引位置
     * 
     * @param buffer StringBuffer对象
     * @param str 要查找的子串
     * @param fromIndex 开始查找的索引位置
     * @return 子串第一次出现的索引位置，如果未找到返回-1
     */
    public int indexOf(StringBuffer buffer, String str, int fromIndex) {
        return buffer.indexOf(str, fromIndex);
    }
    
    /**
     * 查找子串最后一次出现的索引位置
     * 
     * @param buffer StringBuffer对象
     * @param str 要查找的子串
     * @return 子串最后一次出现的索引位置，如果未找到返回-1
     */
    public int lastIndexOf(StringBuffer buffer, String str) {
        return buffer.lastIndexOf(str);
    }
    
    /**
     * 从指定位置（反向）查找子串最后一次出现的索引位置
     * 
     * @param buffer StringBuffer对象
     * @param str 要查找的子串
     * @param fromIndex 开始查找的索引位置（反向）
     * @return 子串最后一次出现的索引位置，如果未找到返回-1
     */
    public int lastIndexOf(StringBuffer buffer, String str, int fromIndex) {
        return buffer.lastIndexOf(str, fromIndex);
    }
    
    /**
     * 演示StringBuffer的可变性
     * 
     * @param buffer 原始StringBuffer对象
     * @param str 要执行操作的字符串
     */
    public void demonstrateMutability(StringBuffer buffer, String str) {
        // 所有操作都直接修改原buffer对象，不会创建新对象
        // 这展示了StringBuffer的可变性
        buffer.append(" - 原始");
        buffer.insert(0, "[开始] ");
        buffer.append(" [结束]");
        buffer.replace(buffer.length() - 9, buffer.length() - 1, "<已修改>");
    }
    
    /**
     * 计算当前容量使用率
     * 
     * @param buffer StringBuffer对象
     * @return 容量使用率（百分比）
     */
    public double getCapacityUsage(StringBuffer buffer) {
        return (double) buffer.length() / buffer.capacity() * 100;
    }
    
    /**
     * 压缩StringBuffer容量到实际需要的大小
     * 
     * @param buffer StringBuffer对象
     * @return 压缩后的StringBuffer对象
     */
    public StringBuffer trimToSize(StringBuffer buffer) {
        buffer.trimToSize();
        return buffer;
    }
}