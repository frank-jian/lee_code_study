package t01_array;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @description: <p>1) 数组的插入、删除、按照下标随机访问操作；2）数组中的数据是int类型的；</p>
 * @author: terui
 * @date: 2019/9/15 9:53 下午
 *
 * TODO: 边界条件要考虑清楚 1）索引位除了不能越界，同时不能为负数
 *
 */
@Data
public class Array {
    private int[] array;
    private int   count;
    private int   capacity;


    public Array(int capacity) {
        this.capacity = capacity;
        this.array = new int[this.capacity];
    }

    public int query(int index) {
        if (index > this.capacity || index < 0) {
            throw new IllegalArgumentException("index out of array");
        }
        return array[index];
    }

    public boolean insert(int index, int value) {
        // 数组已满
        if (this.count == this.capacity) {
            System.out.println("数组已满");
            return false;
        }

        // 位置不合法
        if (index > count || index < 0) {
            System.out.println("位置不合法");
            return false;
        }

        for (int i = count; i > index; --i) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        ++this.count;
        return true;
    }

    public boolean update(int index, int value) {
        int temp = array[index];
        if (temp != 0) {
            array[index] = value;
            return true;
        }
        return false;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }

        for (int i = index; i < capacity - 1; i++) {
            array[i] = array[i + 1];
        }
        this.count--;
        return true;
    }

    public int size() {
        return this.count + 1;
    }

    public int[] list() {
        return this.array;
    }

    public static void main(String[] args) {
        Array array = new Array(10);
        array.insert(0, 1);
        array.insert(1, 2);
        array.insert(1, 3);
        System.out.println(JSON.toJSONString(array.list()));

        System.out.println(array.query(2));
        array.update(2, 33);
        System.out.println(JSON.toJSONString(array.list()));
        array.delete(1);
        System.out.println(JSON.toJSONString(array.list()));
    }
}
