package com.realz.page.mars;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.realz.base.BasePage;

public class CreateActivityPage extends BasePage {

	public CreateActivityPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// 用户名输入框
	@FindBy(id = "UserAccount")
	private WebElement UserAccount_Element;

	// 密码输入框
	@FindBy(id = "UserPassword")
	private WebElement UserPassword_Element;

	// 语言切换下拉选项
	@FindBy(xpath = ".//*[@id='Login_Language']/option[2]")
	private WebElement Login_Language_Element;

	// 登录按钮
	@FindBy(id = "login_btn")
	private WebElement login_btn_Element;

	// 登录后查看右上方的登录人
	@FindBy(className = "LoginName")
	private WebElement LoginName_Element;

	// 活动计划
	@FindBy(xpath = "//*[@id=\"LAY-system-side-menu\"]/li[2]/a")
	private WebElement activity_plan_element;

	// 活动计划列表
	@FindBy(xpath = "//*[@id=\"LAY-system-side-menu\"]/li[2]/dl/dd[2]/a")
	private WebElement activity_plan_list_element;

	// 活动创建按钮
	@FindBy(xpath = "//*[@id=\"layerDemo\"]/button/label")
	private WebElement create_button_element;

	// 活动主题下拉列表
	@FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[2]/form/div[2]/div[1]/div/div/div/input")
	private WebElement theme_element;

	// 活动主题下拉第一个数据
	@FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[2]/form/div[2]/div[1]/div/div/dl/dd[2]")
	private WebElement theme_1_element;

	// 活动名称输入框
	@FindBy(id = "inputActivityName")
	private WebElement inputActivityName_element;

	// 品类选择 CHO
	@FindBy(xpath = "//*[@id=\"divSegment\"]/div[1]/i")
	private WebElement segment_cho_element;

	// 品类选择 GMFC
	@FindBy(xpath = "//*[@id=\"divSegment\"]/div[2]/i")
	private WebElement segment_gmfc_element;

	// 目的输入框
	@FindBy(id = "txtObjective")
	private WebElement Objective_element;

	// 活动机制输入框
	@FindBy(id = "txtMechanisam")
	private WebElement txtMechanisam_element;

	// 活动开始时间
	@FindBy(id = "txtStartDate")
	private WebElement txtStartDate_element;

	// 活动结束时间
	@FindBy(id = "txtEndDate")
	private WebElement txtEndDate_element;

	// 附件
	@FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[2]/form/div[6]/div/div/div/div[1]/input")
	private WebElement fujian_element;

	// 备注
	@FindBy(id = "txtRemark")
	private WebElement txtRemark_element;

	// 一级门店类型下拉选项
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/form/div/div[1]/div/div/div/input")
	private WebElement channel_element;

	// 一级门店类型下拉中的第一个元素值
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/form/div/div[1]/div/div/dl/dd[2]")
	private WebElement channel_1_element;

	// 一级门店类型下拉中的第二个元素值
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/form/div/div[1]/div/div/dl/dd[3]")
	private WebElement channel_2_element;

	// 一级门店类型下拉中的第三个元素值
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/form/div/div[1]/div/div/dl/dd[4]")
	private WebElement channel_3_element;

	// 一级门店类型下拉中的第四个元素值
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/form/div/div[1]/div/div/dl/dd[5]")
	private WebElement channel_4_element;

	// 一级门店类型下拉中的第五个元素值
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/form/div/div[1]/div/div/dl/dd[6]")
	private WebElement channel_5_element;

	// 一级门店类型下拉中的第六个元素值
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/form/div/div[1]/div/div/dl/dd[7]")
	private WebElement channel_6_element;

	// 一级门店类型下拉中的第七个元素值
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/form/div/div[1]/div/div/dl/dd[8]")
	private WebElement channel_7_element;

	// 一级门店类型下拉中的第八个元素值
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/form/div/div[1]/div/div/dl/dd[9]")
	private WebElement channel_8_element;

	// 一级门店类型下拉中的第九个元素值
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/form/div/div[1]/div/div/dl/dd[10]")
	private WebElement channel_9_element;

	// 二级门店类型下拉选项
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/form/div/div[2]/div/div/div/input")
	private WebElement sub_channel_element;

	// 二级门店类型下拉中的第一个元素值
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/form/div/div[2]/div/div/dl/dd[2]")
	private WebElement sub_channel_1_element;

	// 客户层级下拉列表
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/form/div/div[3]/div/div/div/div/div[1]")
	private WebElement Tier_element;

	// 客户层级下拉列表第一项
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/form/div/div[3]/div/div/div/dl/dd[3]")
	private WebElement Tier_1_element;

	// 客户组增加按钮
	@FindBy(id = "btnSelectCustomerGroup")
	private WebElement customerGroupAdd_element;

	// 客户组增加弹出列表中第一条
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/table/tbody/tr[1]/td[1]/div/div/i")
	private WebElement customerGroupAdd_1_element;

	// 客户组增加弹出列表中【确定】按钮
	@FindBy(id = "btn_Sure")
	private WebElement customerGroupAdd_ok_element;

	// Demond活动编号
	@FindBy(id = "inputDemandCode")
	private WebElement inputDemandCode_element;

	// inputGSV活动增量
	@FindBy(id = "inputGSV")
	private WebElement inputGSV_element;

	// inputGSVWOPromotion 基础销量
	@FindBy(id = "inputGSVWOPromotion")
	private WebElement inputGSVWOPromotion_element;

	// inputGSVWPromotion 活动销量
	@FindBy(id = "inputGSVWPromotion")
	private WebElement inputGSVWPromotion_element;

	// inputPreROI 预估投资回报率
	@FindBy(id = "inputPreROI")
	private WebElement inputPreROI_element;

	// inputTEPercentage TE%
	@FindBy(id = "inputTEPercentage")
	private WebElement inputTEPercentage_element;

	// inputCPDPercentage CPD%
	@FindBy(id = "inputCPDPercentage")
	private WebElement inputCPDPercentage_element;

	// inputCPPercentage Coupon%
	@FindBy(id = "inputCPPercentage")
	private WebElement inputCPPercentage_element;

	// 第一个品牌百分比输入框
	@FindBy(xpath = "/html/body/div[1]/div/div/div[4]/div[2]/div/div/div/div[2]/table/tbody/tr[1]/td[2]/div/div/input")
	private WebElement brand_1_element;

	// 保存草稿按钮
	@FindBy(id = "btnDraft")
	private WebElement btnDraft_element;

	// 提交按钮
	@FindBy(id = "btnSubmit")
	private WebElement btnSubmit_element;

	/*************************** 登录 ***********************************/
	// 输入用户名
	public void userAccount_sendkes(String userAccount) {
		this.sendkeys(UserAccount_Element, userAccount);
	}

	// 输入用密码
	public void userPassword_sendkes(String userPassword) {
		this.sendkeys(UserPassword_Element, userPassword);
	}

	// 获取右上角已登录用户名
	public String get_LoginName() {
		return this.getText(LoginName_Element);
	}

	// 点击中文下拉选项
	public void login_Language_cn_click() {
		this.click(Login_Language_Element);
	}

	// 点击登录按钮
	public void login_btn_click() {
		this.click(login_btn_Element);
	}

	/*************************** 创建活动 ***********************************/
	// 点击活动计划列表连接
	public void activity_plan_list_click() {
		this.click(activity_plan_list_element);
	}

	// 点击活动计划连接
	public void activity_plan_click() {
		this.click(activity_plan_element);
	}

	// 点击创建活动
	public void add_activity_click() {
		this.click(create_button_element);
	}

	// 活动主题
	public void theme_click() {
		this.click(theme_element);
	}

	// 选择第一个活动主题
	public void theme_1_click() {
		this.click(theme_1_element);
	}

	// 活动名称输入框内容填充
	public void inputActivityName_sendkeys(String s) {
		this.sendkeys(inputActivityName_element, s);
	}

	// 选择品类CHO
	public void segment_click() {
		this.click(segment_cho_element);
	}

	// 活动目的输入框
	public void inputActivityObjective(String s) {
		this.sendkeys(Objective_element, s);
	}

	// 活动机制输入框
	public void inputActivityMechanisam(String s) {
		this.sendkeys(txtMechanisam_element, s);
	}

	// 活动开始时间
	public void inputActivityStartDate(String s) {
		this.sendkeys(txtStartDate_element, s);
	}

	// 活动结束时间
	public void inputActivityEndDate(String s) {
		this.sendkeys(txtEndDate_element, s);
	}

	// 活动备注
	public void inputActivityRemark(String s) {
		this.sendkeys(txtRemark_element, s);
	}

	// 选择一级门店类型
	public void channel_click() {
		this.click(channel_element);
	}

	// 选择一级门店类型中的MT
	public void channel_1_click() {
		this.click(channel_1_element);
	}

	// 选择二级门店类型
	public void sub_channel_click() {
		this.click(sub_channel_element);
	}

	// 选择二级门店类型中的Hyper
	public void sub_channel_1_click() {
		this.click(sub_channel_1_element);
	}
	
	//选择客户层级
	public void Tier_click() {
		this.click(Tier_element);
	}
	
	//点击第一个客户层级
	public void Tier_1_click() {
		this.click(Tier_1_element);
	}
	
	//点击客户组添加图标
	public void customerGroupAdd_click() {
		this.click(customerGroupAdd_element);
	}
	
	//点击客户组添加弹出页面的【确定】按钮
	public void customerGroupAdd_ok_click() {
		this.click(customerGroupAdd_ok_element);
	}
	
	//输入demand code
	public void inputDemandCode_element(String s) {
		this.sendkeys(inputDemandCode_element, s);
	}
	
	//输入gsv 活动增量
	public void inputGSV_element(String s) {
		this.sendkeys(inputGSV_element, s);
	}
	
	//输入基础销量
	public void inputGSVWOPromotion(String s) {
			this.sendkeys(inputGSVWOPromotion_element, s);
	}
	//输入inputGSVWPromotion_element 活动销量
	public void inputGSVWPromotion(String s) {
			this.sendkeys(inputGSVWPromotion_element, s);
	}
		
	//输入inputPreROI_element 预估投资回报率
	public void inputPreROI(String s) {
			this.sendkeys(inputPreROI_element, s);
	}
	
	//输入inputTEPercentage te%
	public void inputTEPercentage(String s) {
		this.sendkeys(inputTEPercentage_element, s);
	}
		
	//输入inputCPDPercentage CPD%
	public void inputCPDPercentage(String s) {
		this.sendkeys(inputCPDPercentage_element, s);
	}
				
	//输入inputCPPercentage CP%
	public void inputCPPercentage(String s) {
		this.sendkeys(inputCPPercentage_element, s);
	}
				

	
	
	
	//选择客户组第一条数据
	public void customerGroupAdd_1_click() {
		this.click(customerGroupAdd_1_element);
	}
	
	// 点击保存草稿按钮
	public void draft_click() {
		this.click(btnDraft_element);
	}

}
