package com.realz;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * selenium 常用的 api 参考地址 :
 * 	https://www.jianshu.com/p/dc1104ea1fa5
 * @author sti1l
 *
 */
public class MyTest {

	// 获取谷歌驱动 - > 父类引用指向子类对象 : WebDirver 是 谷歌,火狐,ie等浏览器驱动 实现的接口
	WebDriver driver = new ChromeDriver();

	@Test
	public void fun() {
		System.err.println("方法执行了");
	}

	/**
	 * 百度搜索
	 */
	// @Test
	public void baiduSearch() {

		// 窗口最大化
		driver.manage().window().maximize();
		// 网页URL
		driver.get("http://baidu.com");

		// 百度输入框
		driver.findElement(By.id("kw")).sendKeys("Realz是什么样的人?");
		// 百度一下搜索按钮
		driver.findElement(By.id("su")).click();
	}

	/**
	 * 常用api演练
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void commonSelenuimApi() throws InterruptedException {

		driver.get("http://baidu.com");
		
		/**
		 * 1. 等待的三种形式
		 */
		// 强制线程休眠
		// 等待3秒
		// Thread.sleep(3000);

		// 隐式等待十秒
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 显示等待十秒
		// new
		// WebDriverWait(driver,10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("kw1")));
		// driver.findElement(By.id("kw")).sendKeys("Realz是什么样的人?");
		
		
		
		
		/**
		 * 2. 元素获取
		 */
		// 通过id 略
		
		// 通过name 获得元素
		//driver.findElement(By.name("wd")).sendKeys("111");
		
		// 通过标签名 注:这个我没测通
		//driver.findElement(By.tagName("body")).sendKeys(Keys.F11);
		
		// 通过xpath 略
		
		// 通过文本
		// driver.findElement(By.linkText("百度首页")).click();
		
		// 通过模糊文本,不需要精确,精确也行.
		// driver.findElement(By.partialLinkText("首页")).click();

		driver.findElement(By.name("wd")).getText();
	}

	/**
	 * 下拉列表
	 * @param args
	 */
	public static void main1(String[] args) {

		WebDriver driver = new ChromeDriver();

		// 携程旅游作为案例
		driver.get("https://www.ctrip.com/?sid=155952&allianceid=4897&ouid=index");

		Select select_J_roomCountList = new Select(driver.findElement(By.id("J_roomCountList")));// 实例化 Select
		/**
		 * 1. 选择 列
		 */
		// 通过为止 从0开始
		select_J_roomCountList.selectByIndex(2);
		// 通过 value
		select_J_roomCountList.selectByValue("1");
		// 通过 内容
		select_J_roomCountList.selectByVisibleText("3间");
		
		
		/**
		 * 2. 取消 列
		 */
		// 取消 列 这个我没测试通, 也没太纠结, 开发用的少. 我们直接选中要选择的就好了.
		// 通过为止 从0开始
		// select_J_roomCountList.deselectByIndex(3);
		// 通过 value
		// select_J_roomCountList.deselectByValue("1");
		// 通过 内容
		// select_J_roomCountList.deselectByVisibleText("3间");
		// 取消全部
		// select_J_roomCountList.deselectAll();
		
		
		/**
		 * 3. 获取列 内容
		 */
		System.err.println("----------------------- 全部列表 --------------------------");
		// 获取全部下拉列表
		List<WebElement> options = select_J_roomCountList.getOptions();
		for (WebElement webElement : options) {
			System.err.println(webElement.getText());
		}
		System.err.println("----------------------- 全部已选中的 --------------------------");
		// 获取全部已选中的
		List<WebElement> allSelectedOptions = select_J_roomCountList.getAllSelectedOptions();
		for (WebElement webElement : allSelectedOptions) {
			System.err.println(webElement.getText());
		}
		System.err.println("----------------------- 第一个选中的 --------------------------");
		// 获取第一个选中的
		WebElement firstSelectedOption = select_J_roomCountList.getFirstSelectedOption();
		System.err.println(firstSelectedOption.getText());

	}
	
	
	/**
	 * 滑动滚动条
	 * @param args
	 */
	public static void main2(String[] args) {
		WebDriver driver = new ChromeDriver();
		// 携程旅游作为案例
		driver.get("https://jqueryui.com/slider/");
		
		driver.switchTo().frame(0);
		
		WebElement nextPageElement = driver.findElement(By.xpath("//*[@id=\"slider\"]"));
		
		Actions actions = new Actions(driver);
		
		actions.dragAndDropBy(nextPageElement, 100, 0).perform();
	}
	
	/**
	 * 八大定位器
	 * @param args
	 */
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		/**
		 * 不同方式获取元素：百度搜索输入框。
		 * 因为目前输入框中的value为空，测试时输出value看不出效果，我们改为输出元素的name属性wd
		 * 如果能正常的输出，则说明，元素定位成功。
		 */
		// 1.id定位
		System.err.println(driver.findElement(By.id("kw")).getAttribute("name"));
		// 2.name定位 		输出元素class属性
		System.err.println(driver.findElement(By.name("wd")).getAttribute("class"));
		// 3.className定位 输出元素name属性
		System.err.println(driver.findElement(By.className("s_ipt")).getAttribute("name"));
		// 4.class定位 	输出元素name属性
		System.err.println(driver.findElement(By.cssSelector("#kw")).getAttribute("name"));
		// 5.xpath定位		输出元素name属性 
		System.err.println(driver.findElement(By.xpath("//*[@id=\"kw\"]")).getAttribute("name"));
		// 6.tagName定位	输出元素name属性 
		System.err.println(driver.findElement(By.tagName("form")).getAttribute("name"));
		
		System.err.println("-----除了第二个是输出的class值，其余的都是name值，说明测试成功-----");
		
		/**
		 * 获取新闻链接
		 * 输出href值
		 */
		// 7.linkText定位
		System.err.println(driver.findElement(By.linkText("新闻")).getAttribute("href"));
		// 7.partialLinkText定位
		System.err.println(driver.findElement(By.partialLinkText("闻")).getAttribute("href"));
		
	}
}
