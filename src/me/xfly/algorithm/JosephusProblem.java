package me.xfly.algorithm;


import org.junit.Assert;
import org.junit.Test;

public class JosephusProblem {
    /**
     * 数学法，不容易想出来但是举个例子，画出具体的图出来再逆推就比较好解决
     *
     * @return
     */
    public int lastRemaining(int m, int n) {
        if (m < 1 || n < 1) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        int ans = 0;
        //注意数字下标
        //f(n,m) = [f(n-1,m)+m]%n
        // n 是人数所以要到达
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public int lastRemainingByArray(int m, int n) {
        if (m < 1 || n < 1) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }

        int[] array = new int[n];
        int index = -1, step = 0, count = n;

        //最后一个也要找出它的位置才能返回，所以所有的元素都要标成 -1
        while (count > 0) {
            index++;
            if (index >= n) {
                index = 0;
            }
            if (array[index] == -1) {
                continue;
            }

            step++;
            if(step == m){
                array[index] = -1;
                step = 0;
                count--;
            }

        }
        return index;
    }

    @Test
    public void testNLessThanOne(){
        Assert.assertEquals(lastRemaining(3,0),-1);
    }

    @Test
    public void testMLessThanOne(){
        Assert.assertEquals(lastRemaining(0,3),-1);
    }

    @Test
    public void testBothLessThanOne(){
        Assert.assertEquals(lastRemaining(0,0),-1);
    }


    @Test
    public void testOneElement(){
        Assert.assertEquals(lastRemaining(3,1),0);
    }

    @Test
    public void testMoreThanOne(){
        Assert.assertEquals(lastRemaining(3,5),3);
    }
}
