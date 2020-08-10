package basic;

/**
 * @author xiayu001
 * @version 1.0
 * @className Transfer
 * @description
 * @date 2019-06-10 17:10
 */
public class Transfer {

    public void change(String input) {
        input = "我已经改变啦";
        System.out.println("调用change方法 input="+input);
    }

    public static void main(String[] args) {
        Transfer transfer = new Transfer();
        //原str为我的老家
        String str = "我的老家";
        System.out.println("原str str="+str);
        //形参:input  实参:str
        transfer.change(str);
        //值传递为将原来的值复制一份给到形参中,对形参进行更改不会影响原参数
        // 引用直接传递引用,形参指向引用,对形参进行更改会影响原参数
        assert (str.equals("我的老家"));
        System.out.println("调用结束 str="+str);

    }
}
