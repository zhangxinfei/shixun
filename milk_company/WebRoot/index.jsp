<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页-index.html</title>
<script type="text/javascript">
	if ((navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i))) {
		location.replace("http://demo1.mycodes.net/qiye/wangluokejigongsi");
	}
</script>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="js/jquery.cycle.all.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
	<header>
	<div class="header">
		<div class="top">
			<div class="top_con">
				<div class="tel">
					<a href="<%=path%>/users/register.jsp" style="color: #FFF5EE">注册</a>
				</div>
				<div class="mail">
					<a href="<%=path%>/users/login.jsp" style="color: #FFF5EE">登录</a>
				</div>

			</div>
		</div>
		<div class="head_bg">
			<div class="head">
				<div class="logo fl">
					<h1>
						<a href="index.html"><img alt="企业网站" src="images/logo.jpg"
							width="205px" height="34px" /></a>
					</h1>
				</div>
				<div class="menu fr">
					<nav>
					<ul>
						<li><a id="menu1" href="<%=path%>/index.jsp">网站首页</a></li>
						<li><a id="menu2" href="<%=path%>/about/about.jsp">企业简介</a></li>
						<li><a id="menu5" href="<%=path%>/news/news.jsp">新闻动态</a></li>
						<li><a id="menu6" href="<%=path%>/products/products.jsp">产品展示</a></li>
						<li><a id="menu7" href="<%=path%>/notice/notice.jsp">企业公告</a></li>
						<li><a id="menu8" href="<%=path%>/contact/contact.jsp">联系我们</a></li>
					</ul>
					<div class="clear"></div>
					</nav>
				</div>
			</div>
		</div>
	</div>
	</header>
	<script type="text/javascript">
		document.getElementById("menu1").className = "a1";
	</script>
	<div class="container index_header">
		<div class="index_banner" id="wrapper">
			<div id="home-slider" class="home-slider">
				<div class="slider-item">
					<img alt="" width="1920px" height="480px" src="images/index1.jpg" />
				</div>
				<div class="slider-item">
					<img alt="" width="1920px" height="480px" src="images/index2.jpg" />
				</div>
				<div class="slider-item">
					<img alt="" width="1920px" height="480px" src="images/index3.jpg" />
				</div>
			</div>
			<div class="design_box">
				<div class="design" id="home-slider-nav">
					<dl class="sel" onMouseOver="banner_hover(0)">
						<dt>设计创意</dt>
						<dd class="design_dd">界面设计是网站的灵魂，是抓住用户眼球的第一要素。良好界面、强大的后台支持。</dd>
					</dl>
					<dl class="design_center" onMouseOver="banner_hover(1)">
						<dt>客户服务</dt>
						<dd class="design_dd">
							为客户提供良好的服务，并考虑客户的实际情况，为客户提供个性化的、最适合您的服务。</dd>
					</dl>
					<dl onMouseOver="banner_hover(2)">
						<dt>执行效率</dt>
						<dd class="design_dd">拒绝拖拉让您放心，做一个按时、高质、高效的行业典范企业。</dd>
					</dl>
					<div class="clear"></div>
				</div>
			</div>
		</div>

		<div class="content">
			<div class="cases">
				<div class="content_title">
					<div class="content_title3">
						<a class="title_ch" href="<%=path%>/about/about.jsp">理念</a> <span
							class="title_en">classy kiss belief</span>
					</div>
				</div>
				<div class="cases_dl" init="false">
					<dl>
						<dt>
							<a href="<%=path%>/about/about.jsp"><img class="img_case" alt="磨房网站"
								src="<%=path%>/images/linian1.jpg" width="380px" height="235px" /></a>
						</dt>
						<dd class="cases_name">专心致志只做酸奶</dd>
						<dd class="cases_int">
							任何所成，都源于一份潜心专注的信念。传承欧洲工匠精神，将所有力量聚焦在酸奶事业上。以匠人之心，成就每一杯酸奶的浓醇美味。以高标准为每一个家庭献上真正意义上的好酸奶。
						</dd>
					</dl>
					<dl class="cases_center">
						<dt>
							<a href="<%=path%>/about/about.jsp"><img class="img_case" alt="欧杰酒业-商城"
								src="<%=path%>/images/linian2.jpg" width="380px" height="235px" /></a>
						</dt>
						<dd class="cases_name">做世界上最好的酸奶</dd>
						<dd class="cases_int">
							在看来，只有高标准严格把控每个环节，才能生产出最好的酸奶。<br />因此，不惜斥巨资整合全产业链，严格筛选原料供应商，与国际百年菌种企业合作，建立国际最先进的酸奶生产线，采用“HACCP+ISO9001”双质量认证体系、自建全程冷链物流，实现原料采购、研发、生产、品控、物流运输及销售等各环节有机高效地整合。
						</dd>
					</dl>
					<dl>
						<dt>
							<a href="<%=path%>/about/about.jsp"><img class="img_case" alt="魔派广告机"
								src="<%=path%>/images/linian3.jpg" width="380px" height="235px" /></a>
						</dt>
						<dd class="cases_name">做世界上最好的酸奶生产企业</dd>
						<dd class="cases_int">
							专注笃行，在前行中付出、收获，更在成就与荣誉之后，担起社会责任，为用户提供最优质的产品与服务。</dd>
					</dl>
					<div class="clear"></div>
				</div>
			</div>
			<div class="news_bg">
				<div class="news">
					<div class="content_title">
						<div class="content_title4">
							<a class="title_ch" href="<%=path%>/news/news.jsp">新闻资讯</a> <span
								class="title_en">News</span>
						</div>
					</div>
					<div class="news_con">
						<div class="news_con_left">
							<dl>
								<dt>
									<div class="news_title fl">
										<a href="<%=path%>/news/news_detail.jsp" target="_blank">【再签】中国建设银行-深圳分行</a>
									</div>
									<div class="news_date fr"></div>
									<div class="clear"></div>
								</dt>
								<dd>
									<a href="<%=path%>/news/news_detail.jsp" target="_blank">
										热烈祝贺网络和建行银行深圳分行再度合作，经过一年多的合作双方配合默契，双方已经进行了多次的合作，前期项目经过深圳分行的
										...</a>
								</dd>
							</dl>
							<dl>
								<dt>
									<div class="news_title fl">
										<a href="/news/2493.html" target="_blank">【签约】深圳市侨商投资管理有限公司</a>
									</div>
									<div class="news_date fr"></div>
									<div class="clear"></div>
								</dt>
								<dd>
									<a href="/news/2493.html" target="_blank">网络和侨商投资合作其企业官网
										公司是由深圳市九泰资本管理有限公司、深圳市侨商投资集团、深圳市福同创新基金、华润集团直 ...</a>
								</dd>
							</dl>
							<dl style="border: none">
								<dt>
									<div class="news_title fl">
										<a href="/news/2492.html" target="_blank">【签约】极致兴通-官网建设</a>
									</div>
									<div class="news_date fr"></div>
									<div class="clear"></div>
								</dt>
								<dd>
									<a href="/news/2492.html" target="_blank">深圳极致兴通科技有限公司是一家专业工业产品的外贸公司，首页效果图已经做出查看http://test30.szfangwei.net/gckj/index.htm
										...</a>
								</dd>
							</dl>
						</div>
						<div class="news_con_right">
							<dl>
								<dt>
									<div class="news_title fl">
										<a href="/news/2491.html" target="_blank">网站建设过程中网页字体的使用规范</a>
									</div>
									<div class="news_date fr"></div>
									<div class="clear"></div>
								</dt>
								<dd>
									<a href="/news/2491.html" target="_blank">字体：文字的外在形式特征。就是文字的风格，是文字的外衣。
										字体的艺术性体现在其完美的外在形式与丰富的内涵之中。 字体是文化的载 ...</a>
								</dd>
							</dl>
							<dl>
								<dt>
									<div class="news_title fl">
										<a href="/news/2490.html" target="_blank">光电行业企业网站规划设计二</a>
									</div>
									<div class="news_date fr"></div>
									<div class="clear"></div>
								</dt>
								<dd>
									<a href="/news/2490.html" target="_blank">七、网站开发与后台设计要求： 1、
										网站配色、结构和整体风格的创意方面要满足我们公司基本的VI要求，将VI和LED照明相结合，整合到 ...</a>
								</dd>
							</dl>
							<dl style="border: none">
								<dt>
									<div class="news_title fl">
										<a href="/news/2489.html" target="_blank">光电行业企业网站规划设计</a>
									</div>
									<div class="news_date fr"></div>
									<div class="clear"></div>
								</dt>
								<dd>
									<a href="/news/2489.html" target="_blank">光电行业企业网站网站规划方案：
										一：关键字： XXXXX产品、网络营销、网络品牌 二：目的： 通过互联网更好的展示我们公司的产品和品牌信息 ...</a>
								</dd>
							</dl>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
			<div class="partners">
				<div class="content_title">
					<div class="content_title2">
						<span class="title_ch">合作伙伴</span> <span class="title_en">partners</span>
					</div>
				</div>
				<div class="partners_table" init="false">
					<ul>
						<li><img alt="建设银行" class="img_partner"
							src="images/picture1.png" width="127px" height="72px" /></li>
						<li><img alt="康辉旅游" class="img_partner"
							src="images/picture2.jpg" width="127px" height="72px" /></li>
						<li><img alt="华侨城酒店" class="img_partner"
							src="images/picture3.jpg" width="127px" height="72px" /></li>
						<li><img alt="华润" class="img_partner"
							src="images/picture4.jpg" width="127px" height="72px" /></li>
						<li><img alt="大台沟矿业" class="img_partner"
							src="images/picture5.jpg" width="127px" height="72px" /></li>
						<li><img alt="国微技术" class="img_partner"
							src="images/picture6.jpg" width="127px" height="72px" /></li>


						<div class="clear"></div>
					</ul>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		<footer>
		<div class="footer2" id="footer">
			<a name="foot"></a>
			<div class="footer_con">
				<div class="footer_dl">
					<dl>
						<dt>
							<a href="<%=path%>/about/about.jsp">企业介绍</a>
						</dt>
						<dd>
							<a href="<%=path%>/about/about.jsp">企业文化</a>
						</dd>
						<dd>
							<a href="<%=path%>/about/about.jsp">品牌故事</a>
						</dd>

						<dd>
							<a href="<%=path%>/avout/about.jsp">企业资质</a>
						</dd>
					</dl>
					<dl>
						<dt>
							<a href="<%=path%>/products/products.jsp">产品展示</a>
						</dt>
						<dd>
							<a href="<%=path%>/products/products.jsp">原态系列</a>
						</dd>
						<dd>
							<a href="<%=path%>/products/products.jsp">活菌系列</a>
						</dd>
						<dd>
							<a href="<%=path%>/products/products.jsp">餐后一小时</a>
						</dd>
						<dd>
							<a href="<%=path%>/products/products.jsp">果粒鲜乳酪</a>
						</dd>
					</dl>
					<dl>
						<dt>
							<a href="<%=path%>/notice/notice.jsp">关于我们</a>
						</dt>
						<dd>
							<a href="<%=path%>/notice/notice.jsp">企业公告</a>
						</dd>
						<dd>
							<a href="<%=path%>/news/news.jsp">新闻资讯</a>
						</dd>

					</dl>
					<dl class="footer_dl2" style="width: 340px;">
						<dt>
							<a href="<%=path%>/contact/contact.jsp">联系我们</a>
						</dt>

						<dd>
							<img src="<%=path%>/images/mail.png" alt="网站建设咨询邮箱" /> <a
								href="mailto:sales@szfangwei.cn">咨询邮箱：sales@szfangwei.cn</a>
						</dd>
						<dd>
							<img src="<%=path%>/images/tel.png" alt="网站建设咨询电话" />咨询热线：0755-8268
							9595
						</dd>
						<dd>
							<img src="<%=path%>/images/weixin.png" alt="网站建设" />微信：网站建设
						</dd>
					</dl>

					<div class="clear"></div>
				</div>
			</div>
		</div>

		</footer>
</body>
</html>