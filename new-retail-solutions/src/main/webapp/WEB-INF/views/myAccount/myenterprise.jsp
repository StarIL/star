<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>我的企业</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">		
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
		<style type="text/css">
			#enterpriseFirst .leftspan{color: #999;}
			.mui-icon-enterprise{background: url(../images/a_prove2.png);}
			.topspan{color: #333;}
			.mui-pull-right{color: #333;}
			#content{background: #fff; height: 175px;padding: 15px;}
			#content p{text-align: center;color: #333;    font-size: 16px;}
   			#contentlist{display: inline-block;  height: 75px;padding: 10px 5px;display: inline-block;    border-radius: 5px;}		
			.btnlist a{    padding: 5px;color: #fff; width: 100%;display: inline-block;background: #007aff;color: #fff;border-radius: 5px}
			#codetlist{background: #fff;   height: 290px; padding: 15px;}
 			#codetlist .infolist{text-align: center;color: #333;    font-size: 16px;}
 			#codetlist .btnlist a{      padding: 5px;  width: 100%;display: inline-block; background: #007aff; color: #fff;border-radius: 5px;text-align: center}
   			#code{display: inline-block;     border-radius: 5px;}
			.btnlist a{color: #fff; width: 100%;display: inline-block;background: #007aff;color: #fff;border-radius: 5px}
			.uploadingfiles{padding: 4px;}
			.uploadingfiles .leftspan{font-size: 16px;color: #333;}
			.uploadingfiles .rightspan{color: #999; margin-left: 8px;}
			.uploadingfiles .leftp{border-bottom: 1px solid #ccc;font-size: 16px;    height: 26px;line-height: 13px;}
			.Certificateslist{height: 80px;    margin-bottom: 10px;overflow: hidden;}
			.Certificateslist .leftspan{display: inline-block;float: left;    width: 50%; height: 60px; padding: 10px; border: 1px solid #ccc;}	
			.Certificateslist .rightspan{display: inline-block;width: 47%;height: 60px;padding: 10px;float: right;border: 1px solid #ccc;}	
		</style>
	</head>
	<!--注册企业1页面-->
	<body class="mui-fullscreen contenet">
		<div id="myenterprise" class="mui-page-content">
			<input type="hidden" id="hPath" value="${pageContext.request.contextPath}" />
       		 <div id="views" class="mui-views">
	            <div class="mui-view">
	                <div class="mui-pages"></div>
	            </div>
        	</div>    	
        	<div id="enterpriseFirst" class="mui-page">
	           <ul class="mui-table-view mui-table-view-chevron" style="margin-top: 0px;">
               		 <li class="mui-table-view-cell">
	                    <a href="#" class="mui-navigate-right"  v-on:tap="enterprise()"><span class="topspan">聚鲜网络科技（上海）有限公司 </span> <span class="mui-icon-enterprise"><img src=""></span><span class="mui-pull-right"></span></a>
	                </li>
	                <li class="mui-table-view-cell">
	                    <a href="#" class="mui-navigate-right"><span class="leftspan">地址</span><span class="mui-pull-right">上海清扬有限公司</span></a>
	                </li>
	                <li class="mui-table-view-cell">
	                    <a href="#" class="mui-navigate-right" v-on:tap="code()"><span class="leftspan">邮编</span> <span class="mui-pull-right">200000</span></a>
	                </li>
	                <li class="mui-table-view-cell">
	                    <a href="#" class="mui-navigate-right" v-on:tap="fax()"><span class="leftspan">传真</span> <span class="mui-pull-right">021-66882232</span></a>
	                </li>
	                <li class="mui-table-view-cell">
	                    <a href="#" class="mui-navigate-right" v-on:tap="law()"><span class="leftspan">法人</span> <span class="mui-pull-right">李四</span></a>
	                </li>
	                <li class="mui-table-view-cell">
	                    <a href="#"class="mui-navigate-right "v-on:tap="record()"><span class="leftspan">CIQ备案号</span> <span class="mui-pull-right">xxxxxxxxx</span></a>
	                </li>
	                <li class="mui-table-view-cell">
	                    <a href="#" class="mui-navigate-right" v-on:tap='Certificates()'><span class="leftspan">三证合一</span> <span class="mui-pull-right">是</span></a>
	                </li>
           		</ul>           		
           		 <ul class="mui-table-view mui-table-view-chevron">
		                <li class="mui-table-view-cell">
		                    <a href="#" class="mui-navigate-right" v-on:tap='license()'><span class="leftspan">营业执照</span> <span class="mui-pull-right">122111111111</span></a>
		                </li>
		                <li class="mui-table-view-cell">
		                    <a href="#" class="mui-navigate-right" v-on:tap="mechanism()"><span class="leftspan">组织机构代码证</span> <span class="mui-pull-right">XY1111111</span></a>
		                </li>
		                 <li class="mui-table-view-cell">
		                    <a href="#" class="mui-navigate-right" v-on:tap="tax()"><span class="leftspan">税务登记证</span> <span class="mui-pull-right">SS111111</span></a>
		                </li>
		          </ul>   
			</div>
        </div>
         <!--修改CIQ备案号弹框-->
           <div id="modifyrecord" class="mui-popover mui-popover-bottom mui-popover-action ">
			  <div id="content">
			    <p>修改CIQ备案号</p>
    				<input type="text" id="contentlist" placeholder="请输入CIQ备案号"/>	
			     <p class="bottomplist">
				   	<span class="btnlist"><a href="#modifyrecord">保存</a></span>
				  </p>
			    </div> 
			</div>  
			  <!--修改传真弹框-->
			<div id="modifyfax" class="mui-popover mui-popover-bottom mui-popover-action ">
			  <div id="content">
			    <p>修改传真</p>
    				<input type="text" id="contentlist" placeholder="请输入传真"/>	
			     <p class="bottomplist">
				   	<span class="btnlist"><a href="#modifyfax">保存</a></span>
				  </p>
			    </div> 
			</div>     
			
			 <!--修改三证合一弹框-->
			<div id="modifyCertificates" class="mui-popover mui-popover-bottom mui-popover-action ">
			  <div id="content">
			    <p>修改三证合一</p>
    			<div class="Certificateslist">
    				<span class="leftspan">是</span>
    				<span class="rightspan">否</span>
    			</div>
			     <p class="bottomplist">
				   	<span class="btnlist"><a href="#modifyCertificates">保存</a></span>
				  </p>
			    </div> 
			</div>     
			
			
			  <!--修改法人弹框-->
			<div id="modifylaw" class="mui-popover mui-popover-bottom mui-popover-action ">
			  <div id="content">
			    <p>修改法人</p>
    				<input type="text" id="contentlist" placeholder="请输入法人"/>	
			     <p class="bottomplist">
				   	<span class="btnlist"><a href="#modifylaw">保存</a></span>
				  </p>
			    </div> 
			</div>     
			<!--修改企业弹框-->
			<div id="modifyenterprise" class="mui-popover mui-popover-bottom mui-popover-action ">
			  <div id="content">
			    <p>修改企业名称</p>
    				<input type="text" id="contentlist" placeholder="请输企业名称"/>	
			     <p class="bottomplist">
				   	<span class="btnlist"><a href="#modifyenterprise">保存</a></span>
				  </p>
			    </div> 
			</div>     
			  <!--修改邮编弹框-->
			<div id="modifycode" class="mui-popover mui-popover-bottom mui-popover-action ">
			  <div id="content">
			    <p>修改邮编</p>
    				<input type="text" id="contentlist" placeholder="请输邮编"/>	
			     <p class="bottomplist">
				   	<span class="btnlist"><a href="#modifycode">保存</a></span>
				  </p>
			    </div> 
			</div>     
			  <!--修改税务弹框-->
			<div id="modifyBureau" class="mui-popover mui-popover-bottom mui-popover-action ">
			  <div id="codetlist">
			    <p class="infolist">修改税务登记证</p>
    			<input type="text" id="code" placeholder="请输入证号"/>	
    			<div class="uploadingfiles">
    				<p class="leftp"><span class="leftspan">文件</span> <span class="rightspan">xxxxxxxxxx.pdf</span></p>
    				<p class="leftp"><span class="leftspan">拍照</span></p>
    				<p class="leftp"><span class="leftspan">相册</span></p>
    				<p class="leftp"><span class="leftspan">其他文件</span></p>
    			</div>
			     <p class="bottomplist">
				   	<span class="btnlist"><a href="#modifyBureau">保存</a></span>
				  </p>
			    </div> 
			</div>  
			  <!--修改营业执照弹框-->
			<div id="modifyicense" class="mui-popover mui-popover-bottom mui-popover-action ">
			  <div id="codetlist">
			    <p class="infolist">修改营业执照</p>
    			<input type="text" id="code" placeholder="请输入证号"/>	
    			<div class="uploadingfiles">
    				<p class="leftp"><span class="leftspan">文件</span> <span class="rightspan">xxxxxxxxxx.pdf</span></p>
    				<p class="leftp"><span class="leftspan">拍照</span></p>
    				<p class="leftp"><span class="leftspan">相册</span></p>
    				<p class="leftp"><span class="leftspan">其他文件</span></p>
    			</div>
			     <p class="bottomplist">
				   	<span class="btnlist"><a href="#modifyicense">保存</a></span>
				  </p>
			    </div> 
			</div>     
			  <!--修改组织机构弹框-->
			<div id="modifyorganization" class="mui-popover mui-popover-bottom mui-popover-action ">
			  <div id="codetlist">
			    <p class="infolist">修改组织机构代码证</p>
    			<input type="text" id="code" placeholder="请输入证号"/>	
    			<div class="uploadingfiles">
    				<p class="leftp"><span class="leftspan">文件</span> <span class="rightspan">xxxxxxxxxx.pdf</span></p>
    				<p class="leftp"><span class="leftspan">拍照</span></p>
    				<p class="leftp"><span class="leftspan">相册</span></p>
    				<p class="leftp"><span class="leftspan">其他文件</span></p>
    			</div>
			     <p class="bottomplist">
				   	<span class="btnlist"><a href="#modifyorganization">保存</a></span>
				  </p>
			    </div> 
			</div>     
			
		</div>
		
	</body>
	<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/mui.min.js"></script>
	<script src="${pageContext.request.contextPath}/plugins/mui.view.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/myAccount/myenterprise.js"></script>
</html>
