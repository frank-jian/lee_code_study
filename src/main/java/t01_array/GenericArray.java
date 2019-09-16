package t01_array;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @description: <p></p>
 * @author: terui
 * @date: 2019/9/16 8:05 下午
 */
@Data
public class GenericArray {
    private int[] array;
    private int   size;

    public GenericArray() {
        this.array = new int[10];
        this.size = 0;
    }

    public boolean addFirst(int value) {
        return add(0, value);
    }

    public boolean addLast(int value) {
        return add(this.size, value);
    }

    public boolean add(int index, int value) {
        // 检查索引位是否越界
        checkRange(index);

        // 检查是否需要扩容
        if (this.size == array.length) {
            resize(this.size * 2);
        }

        for (int i = this.size -1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = value;
        this.size++;

        return true;
    }

    public void resize(int capacity) {
        int[] newArray = new int[capacity];
        for (int i = 0; i < this.size; i++) {
            newArray[i] = array[i];
        }
        this.array = newArray;
    }

    public void checkRange(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("非法index");
        }
    }

    public static void main(String[] args) {
        GenericArray array = new GenericArray();
        array.addFirst(1);
        array.addFirst(2);
        array.addFirst(3);
        array.addFirst(4);
        array.addFirst(5);
        array.addFirst(6);
        array.addFirst(7);
        array.addFirst(8);
        array.addFirst(9);
        array.addFirst(10);
        array.addFirst(11);
        array.add(2,9999);
        array.add(2,8888);
        System.out.println(JSON.toJSONString(array.getArray()));
    }

}
