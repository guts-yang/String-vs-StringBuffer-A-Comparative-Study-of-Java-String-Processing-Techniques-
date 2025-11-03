package m11d3.project6;

/**
 * StringProcessor - 字符串处理工具类
 * 
 * 提供String类常用方法的封装和演示，用于教育目的，展示String类的不可变性和各种字符串操作。
 * 
 * @author Java Education
 * @version 1.0
 */
public class StringProcessor {
    
    /**
     * 字符串拼接
     * 
     * @param str1 第一个字符串
     * @param str2 第二个字符串
     * @return 拼接后的新字符串
     */
    public String concat(String str1, String str2) {
        // 注意：String的concat方法会创建新的字符串对象
        // 这展示了String的不可变性 - 原字符串不会被修改
        return str1.concat(str2);
    }
    
    /**
     * 从指定索引开始截取字符串到末尾
     * 
     * @param str 原字符串
     * @param beginIndex 起始索引（包含）
     * @return 截取后的新字符串
     * @throws StringIndexOutOfBoundsException 如果索引越界
     */
    public String substring(String str, int beginIndex) {
        return str.substring(beginIndex);
    }
    
    /**
     * 截取指定范围的字符串
     * 
     * @param str 原字符串
     * @param beginIndex 起始索引（包含）
     * @param endIndex 结束索引（不包含）
     * @return 截取后的新字符串
     * @throws StringIndexOutOfBoundsException 如果索引越界
     */
    public String substring(String str, int beginIndex, int endIndex) {
        return str.substring(beginIndex, endIndex);
    }
    
    /**
     * 替换字符串中的目标子串
     * 
     * @param str 原字符串
     * @param target 要被替换的子串
     * @param replacement 替换的子串
     * @return 替换后的新字符串
     */
    public String replace(String str, CharSequence target, CharSequence replacement) {
        return str.replace(target, replacement);
    }
    
    /**
     * 检查字符串是否包含指定的子串
     * 
     * @param str 原字符串
     * @param searchStr 要查找的子串
     * @return 如果包含返回true，否则返回false
     */
    public boolean contains(String str, CharSequence searchStr) {
        return str.contains(searchStr);
    }
    
    /**
     * 将字符串转换为大写形式
     * 
     * @param str 原字符串
     * @return 转换后的新字符串
     */
    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
    
    /**
     * 将字符串转换为小写形式
     * 
     * @param str 原字符串
     * @return 转换后的新字符串
     */
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }
    
    /**
     * 去除字符串两端的空白字符
     * 
     * @param str 原字符串
     * @return 去除空白后的新字符串
     */
    public String trim(String str) {
        return str.trim();
    }
    
    /**
     * 获取字符串的长度
     * 
     * @param str 原字符串
     * @return 字符串的长度
     */
    public int length(String str) {
        return str.length();
    }
    
    /**
     * 判断字符串是否为空
     * 
     * @param str 原字符串
     * @return 如果字符串长度为0则返回true，否则返回false
     */
    public boolean isEmpty(String str) {
        return str.isEmpty();
    }
    
    /**
     * 判断两个字符串是否相等（内容相等）
     * 
     * @param str1 第一个字符串
     * @param str2 第二个字符串
     * @return 如果内容相等返回true，否则返回false
     */
    public boolean equals(String str1, String str2) {
        return str1.equals(str2);
    }
    
    /**
     * 判断两个字符串是否相等（忽略大小写）
     * 
     * @param str1 第一个字符串
     * @param str2 第二个字符串
     * @return 如果内容相等（忽略大小写）返回true，否则返回false
     */
    public boolean equalsIgnoreCase(String str1, String str2) {
        return str1.equalsIgnoreCase(str2);
    }
    
    /**
     * 按字典顺序比较两个字符串
     * 
     * @param str1 第一个字符串
     * @param str2 第二个字符串
     * @return 如果str1小于str2返回负数，如果相等返回0，如果str1大于str2返回正数
     */
    public int compareTo(String str1, String str2) {
        return str1.compareTo(str2);
    }
    
    /**
     * 按字典顺序比较两个字符串（忽略大小写）
     * 
     * @param str1 第一个字符串
     * @param str2 第二个字符串
     * @return 如果str1小于str2返回负数，如果相等返回0，如果str1大于str2返回正数
     */
    public int compareToIgnoreCase(String str1, String str2) {
        return str1.compareToIgnoreCase(str2);
    }
    
    /**
     * 查找子串第一次出现的索引位置
     * 
     * @param str 原字符串
     * @param searchStr 要查找的子串
     * @return 子串第一次出现的索引位置，如果未找到返回-1
     */
    public int indexOf(String str, String searchStr) {
        return str.indexOf(searchStr);
    }
    
    /**
     * 从指定位置开始查找子串第一次出现的索引位置
     * 
     * @param str 原字符串
     * @param searchStr 要查找的子串
     * @param fromIndex 开始查找的索引位置
     * @return 子串第一次出现的索引位置，如果未找到返回-1
     */
    public int indexOf(String str, String searchStr, int fromIndex) {
        return str.indexOf(searchStr, fromIndex);
    }
    
    /**
     * 查找子串最后一次出现的索引位置
     * 
     * @param str 原字符串
     * @param searchStr 要查找的子串
     * @return 子串最后一次出现的索引位置，如果未找到返回-1
     */
    public int lastIndexOf(String str, String searchStr) {
        return str.lastIndexOf(searchStr);
    }
    
    /**
     * 判断字符串是否以指定的前缀开始
     * 
     * @param str 原字符串
     * @param prefix 前缀
     * @return 如果以指定前缀开始返回true，否则返回false
     */
    public boolean startsWith(String str, String prefix) {
        return str.startsWith(prefix);
    }
    
    /**
     * 判断字符串是否以指定的后缀结束
     * 
     * @param str 原字符串
     * @param suffix 后缀
     * @return 如果以指定后缀结束返回true，否则返回false
     */
    public boolean endsWith(String str, String suffix) {
        return str.endsWith(suffix);
    }
    
    /**
     * 将字符串分割成字符串数组
     * 
     * @param str 原字符串
     * @param delimiter 分隔符
     * @return 分割后的字符串数组
     */
    public String[] split(String str, String delimiter) {
        return str.split(delimiter);
    }
    
    /**
     * 演示String的不可变性
     * 
     * @param str 原始字符串
     * @return 处理后的新字符串
     */
    public String demonstrateImmutability(String str) {
        // 即使调用了多个方法，原始字符串str也不会改变
        // 每个方法调用都会返回一个新的字符串对象
        String temp = str;
        temp = temp.toUpperCase();
        temp = temp.concat(" - 已处理");
        temp = temp.trim();
        
        // 返回的是新字符串，而不是修改原始字符串
        return temp;
    }
    
    /**
     * 格式化字符串
     * 
     * @param format 格式字符串
     * @param args 格式参数
     * @return 格式化后的字符串
     */
    public String format(String format, Object... args) {
        return String.format(format, args);
    }
}