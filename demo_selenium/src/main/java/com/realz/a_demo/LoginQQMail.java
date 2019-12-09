package com.realz.a_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.realz.util.ConfigUtil;

/**
 * 登陆qq邮箱
 * @author sti1l
 *
 */
public class LoginQQMail {
	
	// 邮箱地址
	private final static String QQ_MAIL_URL = "https://mail.qq.com/";
	// 账号
	public static String ACCOUNT = ConfigUtil.getString("ACCOUNT"); 
	// 密码
	public static String PASSWORD = ConfigUtil.getString("PASSWORD");
	
	// 上面就是定义一些常量的，当然你看到 这里有区别，其实我是把内容抽取到了一个文件里， 然后用一个工具类获取文件中的内容
	// 文件在这里 看到没 就是一个名字=值  至于这个工具类，你只需要知道这么用就行拉。我也可以带你简单看一下，其实很简单
	// 这个先不纠结，你可以把这些用户名直接写在上面， 不抽取 影响不大
	// 来继续
	
	public static void main(String[] args) { // 你会发现我直接运行这个class 这个脚本就启动了 但是刚刚 用户名没拿到 我们看下原因
											// 再次运行试试， 账号拿到了是吧， 就是从那个文件在读取的， 但授权密码过期了，没办法了
		// 这个授权密码 怎么说呢， 我们用第三方软件去登录qq邮箱， 使用的密码和平时直接自己登录是不一样的，需要用绑定的手机号去发短信获取的
		// 后面你感兴趣试一下， 先不纠结
		// 继续，你在听吗 嗯，在的好
		
		WebDriver driver = new ChromeDriver(); // 获取驱动实例，这里可以是谷歌的，火狐的，ie的等
		// 是的 是这里
		// 有没有什么启发？ 我在想说如果需要多个人操作的时候，我调用不同的浏览器输入不同的密码就可以了。
		// 我发现了一个问题 你说的这个
		// 我测试过， 同时跑用例的时候，浏览器即便是一种类型的，他的cookie也不共享， 也是可以的
		// 用到的不多啦， 跑多了， 电脑吃不消的啦 
		// 我如果多个用力一起跑的话，或者多个用力放在两个文件夹里跑，不同文件夹是并行的，但是一个文件夹下不同的是先后的。对吧
		// 对 但是不是文件夹 是class类 我们一个class成为一个用例 我带你看一下 
		
		////还有一个问题，就是比如登陆，可能方法都是一样的，只是穿的值不一样，那么这个时候，我是否要独立出一个逻辑方法，然后另一个方法里面只有测试的数据
		//之前在西门子的时候就是这样做的。
		// 可以是可以的 但是我不推荐这么做你知道为什么吗
		// 耦合的过多未必是好事
		// 我们登陆不占用多少时间的 从测试的角度来说 我们要保证一次操作的 原子
		//对，你说的对，但是有个问题，比如你创建活动，那我可以直接调login方法，而不是还要在吧login方法再写一遍，创建完活动，我要创建masterplan的
		//时候，我可以直接调创建活动的方法。我是想达到这个目的
		// 但是你这些东西一旦一条线断了 整体都断了 我们的测试报告上 体现不出差异
		// 比如你创建活动，那我可以直接调login方法，而不是还要在吧login方法再写一遍，我能做到但是为什么没这么用呢
		// 登陆作为一个测试用例 它的生命周期应该是 登陆上了 确认登陆人是正确的 好 我浏览器关闭 是这个概念 你知道吗
		// 专业的测试 不是想着一味的去提取代码
		// 西门子那帮人 是在乱搞
		// 后期维护 非常困难   但是之前东临说做国外的项目，他们是成熟的框架，就是用力和方法分离，不是方法里面就直接穿用力，用力直接调方法，这样以后比如登陆
		//变动了，只要懂那个方法就行了，而不用一条一条用力的去找，然后改。你说的意思我懂了 这个是方法的提取 我现在给你试
		
		driver.get(QQ_MAIL_URL); // 获取访问地址 // "https://mail.qq.com/";
		
		// 跳转登录frame
		// 这是一个经验， 你们项目里同样遇到这种的我立马知道了
		driver.switchTo().frame("login_frame");
		
		// 获取账号输入框，填账号
		// 重点：给你理解一下这里
		// 这个地方是通过by.name方法-css的一种定位方式去获取元素，就是那个小谢的u是f12下，那个元素的名字吗？
		// 看来你懂一些，之前的工作经验就体现出来了
		// 首先我们看，我们拿到的是web元素这个对象的 实例e_u
		// 我们是通过什么方法拿到的呢？
		// 用驱动的 driver. 找元素方法
		// 那我们看一下这个找元素方法里面是什么样子的？
		// 看到了返回对吧？ 这里我要告诉你一个思想， 我们现在都是应用级别的，不要深究里面的太多东西
		// 我们现在用的 比当初张亮用的要高级 是别人封装好的 更智能的框架 是spring公司搞得 springboot的东西，很方便，你说 你看过张亮的那个框架吗？
		//// 看到过 他就是用的原生的 selenium driver
		// 我们这个是什么 我给你看一下
		// 以前 张亮在开发的时候， 肯定要手动导入jar 什么selenium的 什么driver的 而我们现在完全不需要的
		// 引入一个maven 依赖 全部搞定 简单的说 用别人封装的更上层的方法 好用啊
		// 这个你有疑问回头再问我 我们继续
		// 刚刚你看出来 使用过name属性获取的元素 那么到底为什么这么传参呢
		// 你会看到我们还可以过其他方式 什么 id xpath 什么css等
		// 你再来看 哇 这个什么啊 和这边不一样了啊 
		// 对 有封装了 我们只需要那么一写 达到的效果和这里是一样的
		
		// userAccount_Element 元素定位的方法有很多种，但是我们通过f12，找到到底用哪种定位，是id，还是xpath，还是classname ，
		// 我今天把我的心得告诉你
		// 这是一个重点
		// 你以后这么玩 一本万利
		// 你看好 // *[@id="block1224"]/div[2]/table/tbody/tr[1]/td[1]
		// 看清楚没 这个就是把这个元素的xpath坐标拿到了  嗯，这个我之前知道了。
		// 你看我给你写的活动复制审批的用例
		// 大量的使用了我刚刚的哪种方式 
		// 但是你也发现了我也会使用id name的 那又是为啥
		// 其实用xpath 以后你就会发现了
		// 你看好
		// 我是拷贝的xpath对吧
		// 但是你看我的内容是啥？ //*[@id="kw"]
		// 哇只有一个这个玩意 那说明这个元素只通过id就能定位到 那对不起 我要精简代码 我用id了 哈哈哈哈
		// 现在懂了吗
		// 简单总结下
		// 不管什么元素 copy xpath 如果 只有id可以定位到 就是后面没有那些乱七八糟的 我就id= 不然一律xpath=
		// 有疑问吗 没有，就是xpath定位之前学了，现在忘了，那一大你不知道啥意思了。 我自前西门子的时候，他们交f12下，然后也是和你的一样方法，选选择
		// 那个元素，然后浏览器自动就会找到它所在的位置，然后我们就css定位不断的调试，直到找到那个元素为止。看到xpath那么一大串，头都晕了
		// 哪里需要调试。 很准的这个xpath 真的准 你们项目很少有带name属性 id的 我只用这个 稳稳地定位到。
		// 再掩饰给你看下吧
		WebElement e_u = driver.findElement(By.name("u"));
		e_u.sendKeys(ACCOUNT);
		
		// 等待时间，单位ms
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 获取密码输入框，填密码
		WebElement e_p = driver.findElement(By.name("p"));
		e_p.sendKeys(PASSWORD);
		
		// 获取登录按钮，点击
		WebElement e_login_button = driver.findElement(By.id("login_button"));
		e_login_button.click();
		
		// 关闭浏览器
		// 刚刚你完成了 输入点击了 其实我们也就两个操作最重要
		// 你会看到我用力玩了会关闭这个浏览器 通过 driver.close()这个方法
		// 你有没有一个一位，那浏览器打开时在什么时候
//		//就是在那个驱动调用driver那边打开的
		// 哪里 只给我
		
		driver.close();
		
	}

}
